package it.uniba.dib.casostudiologopedia.Paziente;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ScrollView;
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

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.EserciziTipo1.Autumn1Record;
import it.uniba.dib.casostudiologopedia.EserciziTipo1.Summer1Record;
import it.uniba.dib.casostudiologopedia.EserciziTipo1.Winter1Record;
import it.uniba.dib.casostudiologopedia.EserciziTipo2.Autunno2;
import it.uniba.dib.casostudiologopedia.EserciziTipo2.Estate2;
import it.uniba.dib.casostudiologopedia.EserciziTipo2.Inverno2;
import it.uniba.dib.casostudiologopedia.EserciziTipo3.Autunno3;
import it.uniba.dib.casostudiologopedia.EserciziTipo3.Estate3;
import it.uniba.dib.casostudiologopedia.EserciziTipo3.Inverno3;
import it.uniba.dib.casostudiologopedia.R;

public class Mappa extends AppCompatActivity {
    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private ImageButton bt4;
    private ImageButton bt5;
    private ImageButton bt6;
    private ImageButton bt7;
    private ImageButton bt8;
    private ImageButton bt9;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        switch(DatiIntent.getMappa()){
            case 1:{
                setContentView(R.layout.mappa1);
                break;
            }
            case 2:{
                setContentView(R.layout.mappa2);
                break;
            }
            case 3:{
                setContentView(R.layout.mappa3);
                break;
            }
            case 4:{
                setContentView(R.layout.mappa5);
                break;
            }
        }
        FirebaseApp.initializeApp(Mappa.this);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini").child(DatiBambino.getEmail());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bt1=(ImageButton)findViewById(R.id.imageButton1);
                bt2=(ImageButton)findViewById(R.id.imageButton2);
                bt3=(ImageButton)findViewById(R.id.imageButton3);
                bt4=(ImageButton)findViewById(R.id.imageButton4);
                bt5=(ImageButton)findViewById(R.id.imageButton5);
                bt6=(ImageButton)findViewById(R.id.imageButton6);
                bt7=(ImageButton)findViewById(R.id.imageButton7);
                bt8=(ImageButton)findViewById(R.id.imageButton8);
                bt9=(ImageButton)findViewById(R.id.imageButton9);
                if(snapshot.child("Mappa").child("Tappa1").getValue(Integer.class)==1){
                    bt1.setImageResource(R.drawable.redbutton);
                    bt1.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt1.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Winter1Record.class));});
                }



                if(snapshot.child("Mappa").child("Tappa2").exists()){
                    bt2.setImageResource(R.drawable.redbutton);
                    bt2.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt2.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Summer1Record.class));});
                }



                if(snapshot.child("Mappa").child("Tappa3").exists()){
                    bt3.setImageResource(R.drawable.redbutton);
                    bt3.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt3.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Autumn1Record.class));});
                }



                if(snapshot.child("Mappa").child("Tappa4").exists()){
                    bt4.setImageResource(R.drawable.redbutton);
                    bt4.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt4.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Inverno2.class));});
                }



                if(snapshot.child("Mappa").child("Tappa5").exists()){
                    bt5.setImageResource(R.drawable.redbutton);
                    bt5.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt5.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Estate2.class));});
                }



                if(snapshot.child("Mappa").child("Tappa6").exists()){
                    bt6.setImageResource(R.drawable.redbutton);
                    bt6.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt6.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Autunno2.class));});
                }



                if(snapshot.child("Mappa").child("Tappa7").exists()){
                    bt7.setImageResource(R.drawable.redbutton);
                    bt7.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt7.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Inverno3.class));});
                }


                if(snapshot.child("Mappa").child("Tappa8").exists()){
                    bt8.setImageResource(R.drawable.redbutton);
                    bt8.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt8.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Estate3.class));});
                }

                if(snapshot.child("Mappa").child("Tappa9").exists()){
                    bt9.setImageResource(R.drawable.redbutton);
                    bt9.setOnClickListener(v->{;Toast.makeText(Mappa.this, "Gioco completato!", Toast.LENGTH_SHORT).show();});
                }
                else{
                    bt9.setOnClickListener(v->{startActivity(new Intent(Mappa.this, Autunno3.class));});
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
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scrollView));
        scrollview.post(new Runnable() {
            @Override
            public void run() {
                scrollview.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(Mappa.this,SceltaMappa.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
