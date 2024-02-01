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

public class Andamentoeserciziotipo1_3 extends AppCompatActivity {
    private ImageView image1;
    private ImageView correzzione;
    private TextView aiuto1;
    private TextView aiuto2;
    private TextView aiuto3;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andamentoeserciziobambino);
        FirebaseApp.initializeApp(Andamentoeserciziotipo1_3.this);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Denominazione").child("Gioco3");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                image1=(ImageView) findViewById(R.id.imageView27);
                correzzione=(ImageView) findViewById(R.id.imageView28);
                aiuto1=(TextView) findViewById(R.id.aiuto1);
                aiuto2=(TextView) findViewById(R.id.aiuto2);
                aiuto3=(TextView) findViewById(R.id.aiuto3);
                image1.setImageResource(snapshot.child("image").getValue(Integer.class));
                if(snapshot.child("aiuto_1").exists()){
                    aiuto1.setText(snapshot.child("aiuto_1").getValue(String.class));
                }
                if(snapshot.child("aiuto_2").exists()){
                    aiuto2.setText(snapshot.child("aiuto_2").getValue(String.class));
                }
                if(snapshot.child("aiuto_3").exists()){
                    aiuto3.setText(snapshot.child("aiuto_3").getValue(String.class));
                }
                if(snapshot.child("Correzione").exists()){
                    if(snapshot.child("Correzione").getValue(Integer.class)==1){
                        correzzione.setImageResource(R.drawable.tru_fotor_bg_remover_20240116221432);
                    }
                    else{
                        correzzione.setImageResource(R.drawable.true_and_false_option_green_red_check_mark_vector_31048492_fotor_bg_remover_20240116221459);
                    }
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
            startActivity(new Intent(Andamentoeserciziotipo1_3.this, CorrezionexBambino.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
