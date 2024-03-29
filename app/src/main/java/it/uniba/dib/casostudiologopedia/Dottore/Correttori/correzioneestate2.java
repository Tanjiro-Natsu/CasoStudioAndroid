package it.uniba.dib.casostudiologopedia.Dottore.Correttori;

import android.content.ContextWrapper;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.Dottore.BambinoCorrezione;
import it.uniba.dib.casostudiologopedia.R;

public class correzioneestate2 extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correzioneestate2);
        FirebaseApp.initializeApp(correzioneestate2.this);
        Button bt=(Button)findViewById(R.id.button15);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp=new MediaPlayer();
                try{
                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference storageRef = storage.getReference();
                    StorageReference islandRef = storageRef.child(DatiIntent.getEmail()).child("Registrazioni/Ripetizione/estaterecord2.3gpp");
                    ContextWrapper cw=new ContextWrapper(getApplicationContext());
                    File recording=cw.getExternalFilesDir(Environment.DIRECTORY_RECORDINGS);
                    File LocalFile = new File(recording,"estaterecord2"+".3gpp");
                    islandRef.getFile(LocalFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(cw, "Bravo", Toast.LENGTH_SHORT).show();
                            try{
                                mp.setDataSource(LocalFile.getPath());
                                mp.prepare();
                                mp.start();}
                            catch(Exception ee){}
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(cw, "Il bambino non ha ancora svolto l'esercizio", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mp.setDataSource(LocalFile.getPath());
                    mp.prepare();
                    mp.start();}
                catch(Exception e){}
            }
        });


    }

    public void corretto(View v){
        Toast.makeText(this,"Correzione Avvenuta",Toast.LENGTH_SHORT).show();
        FirebaseApp.initializeApp(correzioneestate2.this);
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref1=db.getReference("App/Bambini").child(DatiIntent.getEmail());
        ref1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.child("Punteggio").exists()){
                    int a=snapshot.child("Punteggio").getValue(Integer.class);
                    a+=400;
                    ref1.child("Punteggio").setValue(a);
                }
                else{

                    ref1.child("Punteggio").setValue(400);
                }
                ref1.child("Giochi").child("Ripetizione").child("Gioco2").child("Correzione").setValue(1);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    public void errato(View v){
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref1=db.getReference("App/Bambini").child(DatiIntent.getEmail());
        ref1.child("Giochi").child("Ripetizione").child("Gioco2").child("Correzione").setValue(2);
        Toast.makeText(this,"Correzione Avvenuta",Toast.LENGTH_SHORT).show();


    }
    public void back(View v){startActivity(new Intent(correzioneestate2.this, BambinoCorrezione.class));}
}