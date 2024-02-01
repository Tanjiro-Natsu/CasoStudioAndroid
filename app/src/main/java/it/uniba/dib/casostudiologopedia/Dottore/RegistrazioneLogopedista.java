package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import it.uniba.dib.casostudiologopedia.R;

public class RegistrazioneLogopedista extends AppCompatActivity {

    private Map<String,String> map=new HashMap<>();
    private EditText email=null;
    private EditText password=null;
    private EditText confirm;
    private String Email;
    private String Password;
    private String Confirm;
    private FirebaseDatabase db;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signuplogopedista);
        email=(EditText)findViewById(R.id.signup_email);
        password=(EditText)findViewById(R.id.signup_password);
        confirm=(EditText)findViewById(R.id.signup_confirm);
        FirebaseApp.initializeApp(RegistrazioneLogopedista.this);
        db= FirebaseDatabase.getInstance();
        ref=db.getReference("App/Logopedista/Credenziali");
        Button signup=(Button)findViewById(R.id.signup_button);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !email.getText().toString().contains("@gmail.com") || !email.getText().toString().contains("@libero.it") || !email.getText().toString().contains("@hotmail.com") || !email.getText().toString().contains("@virgilio.it")){
                    Toast.makeText(RegistrazioneLogopedista.this, "Formato Email non valido", Toast.LENGTH_SHORT).show();
                }
                else{
                Email=email.getText().toString();
                String []d=Email.split("\\.");
                String EmailFirebase=null;
                for(int i=0;i<d.length;i++){
                    if(i==0){
                        EmailFirebase=d[i];}
                    else{
                        EmailFirebase+=d[i];
                    }
                }
                Password=password.getText().toString();
                Confirm=confirm.getText().toString();
                final String container=EmailFirebase;


                if(!Password.equals(Confirm)){
                    Toast.makeText(RegistrazioneLogopedista.this,"Le Password non combaciano",Toast.LENGTH_LONG).show();
                    email.setText("");
                    password.setText("");
                    confirm.setText("");
                }
                else {
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if( !dataSnapshot.hasChild(container)){
                                map.put("Password",Password);
                                ref.child(container).setValue(map);
                                Toast.makeText(RegistrazioneLogopedista.this, "Registrazione Avvenuta con successo", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegistrazioneLogopedista.this,LoginLogopedista.class));
                            }
                            else{
                                Toast.makeText(RegistrazioneLogopedista.this,"Email gia in uso",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });


                }

            }}
        });

    }
public void back(View v){
        startActivity(new Intent(RegistrazioneLogopedista.this,LoginLogopedista.class));
}}

