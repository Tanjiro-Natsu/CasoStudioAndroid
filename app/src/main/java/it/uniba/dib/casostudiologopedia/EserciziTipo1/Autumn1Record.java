package it.uniba.dib.casostudiologopedia.EserciziTipo1;

import android.Manifest;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import it.uniba.dib.casostudiologopedia.Paziente.DatiBambino;
import it.uniba.dib.casostudiologopedia.Paziente.Mappa;
import it.uniba.dib.casostudiologopedia.R;
import it.uniba.dib.casostudiologopedia.Dottore.record;

public class Autumn1Record extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static File fileName = null;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private String aiuto1;
    private String aiuto2;
    private String aiuto3;
    private int image;

    TextToSpeech texttospeech;
    private Button recordButton = null;
    private MediaRecorder recorder = null;



    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    Dialog dialog1;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) finish();

    }

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void startRecording() {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        recorder.setOutputFile(getpathfile());
        record.setRecord1(fileName);


        try {
            recorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        recorder.start();
    }

    private void stopRecording() {
        recorder.stop();
        recorder.release();
        recorder = null;
    }




    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);




        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        texttospeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int language=texttospeech.setLanguage(Locale.ITALIAN);
                }
            }
        });

        setContentView(R.layout.autumnrecord1);
        FirebaseApp.initializeApp(Autumn1Record.this);
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Denominazione").child("Gioco3");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child("aiuto_1").exists()){
                    aiuto1=snapshot.child("aiuto_1").getValue().toString();
                }
                else{
                    aiuto1=" ";
                }
                if(snapshot.child("aiuto_2").exists()){
                    aiuto2=snapshot.child("aiuto_2").getValue().toString();
                }
                else{
                    aiuto2=" ";
                }
                if(snapshot.child("aiuto_3").exists()){
                    aiuto3=snapshot.child("aiuto_3").getValue().toString();
                }
                else{
                    aiuto3=" ";
                }
                ImageView view1=(ImageView)findViewById(R.id.imageViewok);
                ImageView view=(ImageView)findViewById(R.id.imageView99);
                view.setImageResource((snapshot.child("image").getValue(Integer.class)));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dialog1=new Dialog(Autumn1Record.this);

        dialog1.setContentView(R.layout.completatto);
        dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ImageView button1=dialog1.findViewById(R.id.imageView14);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Autumn1Record.this, Mappa.class));
            }
        });
        recordButton =(Button)findViewById(R.id.record1winter);
        recordButton.setOnClickListener(new View.OnClickListener() {
            boolean mStartRecording = true;
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    recordButton.setText("Registrando...");
                } else {
                    recordButton.setText("Inizia Registrazione");
                    FirebaseApp.initializeApp(Autumn1Record.this);
                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference storageRef = storage.getReference();
                    StorageReference imageRef = storageRef.child(DatiBambino.getEmail()+"/Registrazioni/Denominazione/autunnorecord1.3gpp");
                    Uri audio = Uri.fromFile(new File(getpathfile()));
                    UploadTask uploadTask = imageRef.putFile(audio);
                    record.setRecord(fileName);
                    DatabaseReference ref1=db.getReference("App/Bambini").child(DatiBambino.getEmail());
                    ref1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.child("Punteggio").exists()){
                                int a=snapshot.child("Punteggio").getValue(Integer.class);
                                a+=100;
                                ref1.child("Punteggio").setValue(a);
                            }
                            else{

                                ref1.child("Punteggio").setValue(100);
                            }
                            ref1.child("Mappa").child("Tappa3").setValue(1);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    dialog1.show();
                }
                mStartRecording = !mStartRecording;
            }
        });
    }


    @Override
    public void onStop() {
        super.onStop();
        if (recorder != null) {
            recorder.release();
            recorder = null;
        }


    }
    public void avanti(View v){
        int speech=texttospeech.speak(aiuto1,texttospeech.QUEUE_FLUSH,null);
    }
    public void avanti1(View v){
        int speech=texttospeech.speak(aiuto2,texttospeech.QUEUE_FLUSH,null);
    }
    public void avanti2(View v){
        int speech=texttospeech.speak(aiuto3,texttospeech.QUEUE_FLUSH,null);
    }
    public void back(View v){
        startActivity(new Intent(Autumn1Record.this, Mappa.class));
    }
    public String getpathfile(){
        ContextWrapper cw=new ContextWrapper(getApplicationContext());
        File recording=cw.getExternalFilesDir(Environment.DIRECTORY_RECORDINGS);
        fileName=new File(recording,"autunnorecord1"+".3gpp");
        return fileName.getPath();
    }
}
