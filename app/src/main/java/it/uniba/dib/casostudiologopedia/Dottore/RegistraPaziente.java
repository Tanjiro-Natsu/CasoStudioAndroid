package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import it.uniba.dib.casostudiologopedia.MainActivity;
import it.uniba.dib.casostudiologopedia.R;

public class RegistraPaziente extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;
    EditText email;
    EditText nome;
    EditText cognome;
    EditText eta;
    EditText password;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazionebambini);
        FirebaseApp.initializeApp(RegistraPaziente.this);
        db= FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini");
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        email=(EditText)findViewById(R.id.email);
        nome=(EditText)findViewById(R.id.nome);
        cognome=(EditText)findViewById(R.id.cognome);
        eta=(EditText)findViewById(R.id.eta);
        password=(EditText)findViewById(R.id.password);
        Button signup=(Button)findViewById(R.id.signup_button);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().contains("@gmail.com") || email.getText().toString().contains("@libero.it") || email.getText().toString().contains("@hotmail.com") || email.getText().toString().contains("@virgilio.it")){
                    String EmailFireBase = null;
                    String[] d = email.getText().toString().split("\\.");
                    String EmailFirebase = null;
                    for (int i = 0; i < d.length; i++) {
                        if (i == 0) {
                            EmailFirebase = d[i];
                        } else {
                            EmailFirebase += d[i];
                        }
                    }
                    final String container = EmailFirebase;
                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (!dataSnapshot.hasChild(container)) {
                                Map<String, String> map = new HashMap<>();
                                map.put("Password", password.getText().toString());
                                map.put("Nome", nome.getText().toString());
                                map.put("Cognome", cognome.getText().toString());
                                map.put("eta", eta.getText().toString());
                                ref.child(container).setValue(map);
                                ref.child(container).child("Punteggio").setValue(0);
                                email.setText("");
                                nome.setText("");
                                cognome.setText("");
                                eta.setText("");
                                password.setText("");
                                Toast.makeText(RegistraPaziente.this, "Paziente registrato correttamente", Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(RegistraPaziente.this, "Email gia in uso", Toast.LENGTH_LONG).show();
                            }
                        }

                    });

                }
                else{
                    Toast.makeText(RegistraPaziente.this, "Formato Email non valido", Toast.LENGTH_SHORT).show();
            }}
        } );



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(RegistraPaziente.this, mainLogopedista.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }


}
