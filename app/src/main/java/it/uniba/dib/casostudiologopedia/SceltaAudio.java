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
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SceltaAudio extends AppCompatActivity {
    private int buttoncounter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltaaudio);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Integer [] lista={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18};
        RadioButton[] buttoni=new RadioButton[18];
        for(int i=0;i<18;i++){
            buttoni[i]=(RadioButton)findViewById(lista[i]);
            final int a=i;
            buttoni[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                            switch(DatiGioco3.getCountersound()){
                                case 0:{
                                    DatiGioco3.setsound1(buttoni[a].getText().toString());
                                    break;
                                }
                                case 1:{
                                    DatiGioco3.setSound2(buttoni[a].getText().toString());
                                    break;
                                }
                                case 2:{
                                    DatiGioco3.setSound3(buttoni[a].getText().toString());

                                    break;
                                }
                            }
                }
            });
        }
    }

    public void ok(){

        startActivity(new Intent(SceltaAudio.this,creagioco3.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.item){
            ok();
        }
        return true;
    }
}
