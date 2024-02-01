package it.uniba.dib.casostudiologopedia.Paziente;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import it.uniba.dib.casostudiologopedia.MainActivity;
import it.uniba.dib.casostudiologopedia.R;


public class LoginBambino extends AppCompatActivity {


FirebaseDatabase db;
DatabaseReference ref;
EditText email;
EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginbambino);
        email=(EditText)findViewById(R.id.login_email);
        password=(EditText)findViewById(R.id.login_password);
        FirebaseApp.initializeApp(LoginBambino.this);
        db= FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini");
        Button login=(Button)findViewById(R.id.salva);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String []d=email.getText().toString().split("\\.");
                        String EmailFirebase=null;
                        for(int i=0;i<d.length;i++){
                            if(i==0){
                                EmailFirebase=d[i];}
                            else{
                                EmailFirebase+=d[i];
                            }
                        }
                        if( dataSnapshot.hasChild(EmailFirebase)){
                            String pass=password.getText().toString();
                        if(pass.equals(dataSnapshot.child(EmailFirebase+"/Password").getValue().toString())){
                            DatiBambino.setEmail(EmailFirebase);
                            startActivity(new Intent(LoginBambino.this,mainBambino.class));
                        }
                        else{Toast.makeText(LoginBambino.this,"Password Sbagliata",Toast.LENGTH_LONG).show();
                        email.setText("");
                        password.setText("");}}
                        else{
                            Toast.makeText(LoginBambino.this,"Email sbagliata",Toast.LENGTH_LONG).show();
                            email.setText("");
                            password.setText("");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        // ...
                    }
                });

            }
        });
    }
    public void back (View w ){
        startActivity(new Intent(LoginBambino.this, MainActivity.class));
    }
}