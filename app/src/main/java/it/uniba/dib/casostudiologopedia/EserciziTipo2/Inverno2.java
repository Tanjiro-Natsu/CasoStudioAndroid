package it.uniba.dib.casostudiologopedia.EserciziTipo2;

import android.Manifest;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


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

public class Inverno2 extends AppCompatActivity {
    TextToSpeech texttospeech;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private String audio;
    SpeechRecognizer speechRecognizer;
    private String verifica=null;
    private static final String LOG_TAG = "AudioRecordTest";
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static File fileName = null;
    private Button recordButton = null;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1;
    private MediaRecorder recorder = null;

    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
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
        record.setRecordgioco2(fileName);


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


Dialog dialog;
    Dialog dialog1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(Inverno2.this);
        setContentView(R.layout.gioco2inverno);
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini").child(DatiBambino.getEmail()).child("Giochi").child("Ripetizione").child("Gioco1");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                audio=snapshot.child("Stringa").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        dialog=new Dialog(Inverno2.this);

        dialog.setContentView(R.layout.vittoria);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ImageView button=dialog.findViewById(R.id.imageView26);

        dialog1=new Dialog(Inverno2.this);

        dialog1.setContentView(R.layout.completatto);
        dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        ImageView button1=dialog1.findViewById(R.id.imageView14);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Inverno2.this, Mappa.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Inverno2.this, Mappa.class));
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
        recordButton =(Button)findViewById(R.id.record1winter);
        recordButton.setOnClickListener(new View.OnClickListener() {
            boolean mStartRecording = true;
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    recordButton.setText("Registrando...");

                } else {
                    recordButton.setText("Inizia Registrazione");
                    FirebaseApp.initializeApp(Inverno2.this);
                    FirebaseStorage storage = FirebaseStorage.getInstance();
                    StorageReference storageRef = storage.getReference();
                    StorageReference imageRef = storageRef.child(DatiBambino.getEmail()+"/Registrazioni/Ripetizione/invernorecord2.3gpp");
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
                            ref1.child("Mappa").child("Tappa4").setValue(1);
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
    public void riproduci(View v){

        int speech=texttospeech.speak(audio,texttospeech.QUEUE_FLUSH,null);
    }
    public void back(View v){
        startActivity(new Intent(Inverno2.this, Mappa.class));
    }
    @Override
    public void onStop() {
        super.onStop();
        if (recorder != null) {
            recorder.release();
            recorder = null;
        }


    }
    public String getpathfile(){
        ContextWrapper cw=new ContextWrapper(getApplicationContext());
        File recording=cw.getExternalFilesDir(Environment.DIRECTORY_RECORDINGS);
        fileName=new File(recording,"invernorecord2"+".3gpp");
        return fileName.getPath();
    }

     }