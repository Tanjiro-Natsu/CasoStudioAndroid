package it.uniba.dib.casostudiologopedia.EserciziTipo3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

import it.uniba.dib.casostudiologopedia.Paziente.DatiBambino;
import it.uniba.dib.casostudiologopedia.Paziente.Mappa;
import it.uniba.dib.casostudiologopedia.R;

public class Autunno3 extends AppCompatActivity {

    private TextToSpeech texttospeech;
    private Dialog dialog;
    private  Dialog dialog1;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private String audio;
    private int image1;
    private int image2;
    private int correzione;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(Autunno3.this);
        setContentView(R.layout.inverno3);
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Riconoscimento").child("Gioco3");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                correzione=snapshot.child("correzione").getValue(Integer.class);
                audio=snapshot.child("audio").getValue().toString();
                ImageView view1=(ImageView)findViewById(R.id.imageViewok);
                view1.setImageResource(snapshot.child("image1").getValue(Integer.class));
                ImageView view2=(ImageView)findViewById(R.id.imageView13);
                view2.setImageResource(snapshot.child("image2").getValue(Integer.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dialog=new Dialog(Autunno3.this);

        dialog.setContentView(R.layout.vittoria);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ImageView button=dialog.findViewById(R.id.imageView26);

        dialog1=new Dialog(Autunno3.this);

        dialog1.setContentView(R.layout.sconfitaa);
        dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ImageView button1=dialog1.findViewById(R.id.imageView14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Autunno3.this, Mappa.class));
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Autunno3.this, Mappa.class));
            }
        });
        texttospeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int language=texttospeech.setLanguage(Locale.ITALIAN);
                }
            }
        });

        Button bt1=(Button)findViewById(R.id.button11);
        Button bt2=(Button)findViewById(R.id.button12);

        final DatabaseReference fer=db.getReference("App/Bambini").child(DatiBambino.getEmail());
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correzione==1){

                    dialog.show();

                    fer.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.child("Punteggio").exists()){
                                int a=snapshot.child("Punteggio").getValue(Integer.class);
                                a+=500;
                                fer.child("Punteggio").setValue(a);
                            }
                            else{

                                fer.child("Punteggio").setValue(500);
                            }
                            fer.child("Mappa").child("Tappa9").setValue(1);
                            fer.child("Giochi").child("Riconoscimento").child("Gioco3").child("Valutazione").setValue(1);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
                else{
                    fer.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.child("Punteggio").exists()){
                                int a=snapshot.child("Punteggio").getValue(Integer.class);
                                a+=100;
                                fer.child("Punteggio").setValue(a);
                            }
                            else{

                                fer.child("Punteggio").setValue(100);
                            }
                            fer.child("Mappa").child("Tappa9").setValue(1);
                            fer.child("Giochi").child("Riconoscimento").child("Gioco3").child("Valutazione").setValue(2);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    dialog1.show();
                }


            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correzione==2){
                    fer.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.child("Punteggio").exists()){
                                int a=snapshot.child("Punteggio").getValue(Integer.class);
                                a+=500;
                                fer.child("Punteggio").setValue(a);
                            }
                            else{

                                fer.child("Punteggio").setValue(500);
                            }
                            fer.child("Mappa").child("Tappa9").setValue(1);
                            fer.child("Giochi").child("Riconoscimento").child("Gioco3").child("Valutazione").setValue(1);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    dialog.show();
                }
                else{
                    fer.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.child("Punteggio").exists()){
                                int a=snapshot.child("Punteggio").getValue(Integer.class);
                                a+=100;
                                fer.child("Punteggio").setValue(a);
                            }
                            else{

                                fer.child("Punteggio").setValue(100);
                            }
                            fer.child("Mappa").child("Tappa9").setValue(1);
                            fer.child("Giochi").child("Riconoscimento").child("Gioco3").child("Valutazione").setValue(2);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    dialog1.show();
                }

            }
        });

    }
    public void avanti(View v){
        int speech=texttospeech.speak(audio,texttospeech.QUEUE_FLUSH,null);
    }



}