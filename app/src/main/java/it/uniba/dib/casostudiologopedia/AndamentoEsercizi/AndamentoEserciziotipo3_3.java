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

public class AndamentoEserciziotipo3_3 extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView correzione;
    private TextView text;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andamentoeserciziobambino3);
        FirebaseApp.initializeApp(AndamentoEserciziotipo3_3.this);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Riconoscimento").child("Gioco3");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                image1=(ImageView)findViewById(R.id.imageView27);
                image2=(ImageView)findViewById(R.id.imageView271);
                correzione=(ImageView)findViewById(R.id.imageView28);
                text=(TextView)findViewById(R.id.aiuto3);
                image1.setImageResource(snapshot.child("image1").getValue(Integer.class));
                image2.setImageResource(snapshot.child("image2").getValue(Integer.class));
                text.setText(snapshot.child("audio").getValue(String.class));
                if(snapshot.child("Valutazione").exists()){
                    if(snapshot.child("Valutazione").getValue(Integer.class)==1){
                        correzione.setImageResource(R.drawable.tru_fotor_bg_remover_20240116221432);
                    }
                    else{
                        correzione.setImageResource(R.drawable.true_and_false_option_green_red_check_mark_vector_31048492_fotor_bg_remover_20240116221459);
                    }}
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(AndamentoEserciziotipo3_3.this, CorrezionexBambino.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
