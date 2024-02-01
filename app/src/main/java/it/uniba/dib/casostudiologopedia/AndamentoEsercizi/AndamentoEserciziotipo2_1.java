package it.uniba.dib.casostudiologopedia.AndamentoEsercizi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

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

import it.uniba.dib.casostudiologopedia.Paziente.CorrezionexBambino;
import it.uniba.dib.casostudiologopedia.Paziente.DatiBambino;
import it.uniba.dib.casostudiologopedia.R;


public class AndamentoEserciziotipo2_1 extends AppCompatActivity {
    private String stringa;
    private String parola1="";
    private String parola2="";
    private String parola3="";
    private ImageView image;
    private TextView parola_1;
    private TextView parola_2;
    private TextView parola_3;
   private  FirebaseDatabase db;
 private DatabaseReference ref;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andamentoeserciziobambino2);
        FirebaseApp.initializeApp(AndamentoEserciziotipo2_1.this);
db=FirebaseDatabase.getInstance();
ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Ripetizione").child("Gioco1");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        image=(ImageView)findViewById(R.id.imageView28);
        parola_1=(TextView)findViewById(R.id.aiuto1);
        parola_2=(TextView)findViewById(R.id.aiuto2);
        parola_3=(TextView)findViewById(R.id.aiuto3);
        stringa=snapshot.child("Stringa").getValue(String.class);
        if(snapshot.child("Correzione").exists()){
            if(snapshot.child("Correzione").getValue(Integer.class)==1){
                image.setImageResource(R.drawable.tru_fotor_bg_remover_20240116221432);
            }
            else{
                image.setImageResource(R.drawable.true_and_false_option_green_red_check_mark_vector_31048492_fotor_bg_remover_20240116221459);
            }
int k=0;
            for(int i=0;i<stringa.length();i++){
                if(stringa.charAt(i)>64 && stringa.charAt(i)<91){
                    k++;
                }
                switch(k){
                    case 1:{
                        parola1+=stringa.charAt(i);
                        break;
                    }
                    case 2:{
                        parola2+=stringa.charAt(i);
                        break;
                    }
                    case 3:{
                        parola3+=stringa.charAt(i);
                        break;
                    }
                }
            }
            parola_1.setText(parola1);
            parola_2.setText(parola2);
            parola_3.setText(parola3);
        }

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(AndamentoEserciziotipo2_1.this, CorrezionexBambino.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
