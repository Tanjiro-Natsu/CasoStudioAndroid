package it.uniba.dib.casostudiologopedia;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Summer1Record extends AppCompatActivity {

    private static final String LOG_TAG = "AudioRecordTest";
    String dateTime = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss aa", Locale.getDefault()).format(new Date());
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static String fileName = null;
    TextToSpeech texttospeech;
    private Button recordButton = null;
    private MediaRecorder recorder = null;
    private String nome;
    private String nome2;
    private String nome3;
    private MediaPlayer player = null;

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
        recorder.setOutputFile(fileName);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

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

        // Record to the external cache directory for visibility
        fileName = getExternalCacheDir().getAbsolutePath();
        fileName += new StringBuilder().append("/audiorecordtest ").append(dateTime).append(".3gp").toString();

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
        texttospeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    int language=texttospeech.setLanguage(Locale.ITALIAN);
                }
            }
        });

        setContentView(R.layout.summerecord1);
        ImageView view=(ImageView)findViewById(R.id.imageView);
            view.setImageResource(DatiIntent.getImage1());
            nome=DatiIntent.getText_1();
        nome2=DatiIntent.getText1_1();
        nome3=DatiIntent.getText2_1();
        recordButton =(Button)findViewById(R.id.record1winter);
        recordButton.setOnClickListener(new View.OnClickListener() {
            boolean mStartRecording = true;
            public void onClick(View v) {
                onRecord(mStartRecording);
                if (mStartRecording) {
                    recordButton.setText("Registrando...");
                } else {
                    recordButton.setText("Inizia Registrazione");
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
        int speech=texttospeech.speak(nome,texttospeech.QUEUE_FLUSH,null);
    }
    public void avanti1(View v){
        int speech=texttospeech.speak(nome2,texttospeech.QUEUE_FLUSH,null);
    }
    public void avanti2(View v){
        int speech=texttospeech.speak(nome3,texttospeech.QUEUE_FLUSH,null);
    }
    public void back(View v){
        startActivity(new Intent(Summer1Record.this,MainActivity.class));
    }
}
