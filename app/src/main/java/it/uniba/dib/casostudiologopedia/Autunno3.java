package it.uniba.dib.casostudiologopedia;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Autunno3 extends AppCompatActivity {
    TextToSpeech texttospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autunno3);
        ImageView view1=(ImageView)findViewById(R.id.imageViewok);
        view1.setImageResource(DatiGioco3.getImmagine1());
        ImageView view2=(ImageView)findViewById(R.id.imageView13);
        view2.setImageResource(DatiGioco3.getImmagine2());
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

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DatiGioco3.getStringa1().equals(bt1.getText())){

                }
                else{
                    Dialog dialog = new Dialog(Autunno3.this);
                    dialog.getWindow();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.sconfitta);
                    dialog.setCancelable(true);
                    Button btdialog1=(Button)findViewById(R.id.k1);
                    btdialog1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Autunno3.this,MainActivity.class));
                        }
                    });
                    dialog.show();
                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DatiGioco3.getStringa1().equals(bt2.getText())){

                }
                else{
                    Dialog dialog = new Dialog(Autunno3.this);
                    dialog.getWindow();
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.sconfitta);
                    dialog.setCancelable(true);
                    Button btdialog1=(Button)findViewById(R.id.k1);
                    btdialog1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(Autunno3.this,MainActivity.class));
                        }
                    });
                    dialog.show();
                }

            }
        });

    }
    public void avanti(View v){
        int speech=texttospeech.speak(DatiGioco3.getsound1(),texttospeech.QUEUE_FLUSH,null);
    }


}