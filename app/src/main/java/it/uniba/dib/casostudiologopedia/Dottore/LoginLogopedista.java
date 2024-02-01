package it.uniba.dib.casostudiologopedia.Dottore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import it.uniba.dib.casostudiologopedia.MainActivity;
import it.uniba.dib.casostudiologopedia.R;


public class LoginLogopedista extends AppCompatActivity {


    FirebaseDatabase db;
    DatabaseReference ref;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlogopedista);
        email=(EditText)findViewById(R.id.login_email);
        password=(EditText)findViewById(R.id.login_password);
        FirebaseApp.initializeApp(LoginLogopedista.this);
        db= FirebaseDatabase.getInstance();
        ref=db.getReference("App/Logopedista/Credenziali");
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
                            String pass="{Password="+password.getText().toString()+"}";
                            if(pass.equals(dataSnapshot.child(EmailFirebase).getValue().toString())){
                                startActivity(new Intent(LoginLogopedista.this,mainLogopedista.class));
                            }
                            else{Toast.makeText(LoginLogopedista.this,"Password Sbagliata",Toast.LENGTH_LONG).show();}}
                        else{
                            Toast.makeText(LoginLogopedista.this,"Email sbagliata",Toast.LENGTH_LONG).show();
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
    public void back(View v){
        startActivity(new Intent(LoginLogopedista.this, MainActivity.class));
    }
    public void registra(View v){
        startActivity(new Intent(LoginLogopedista.this,RegistrazioneLogopedista.class));
    }
}