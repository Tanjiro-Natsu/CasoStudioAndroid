package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class creagioco3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creagioco3);


    }

public void ok(View w){


        startActivity(new Intent(creagioco3.this,MainActivity.class));
}
    public void imag1(View w){
        DatiGioco3.setvaluecounterimage1(1);
        startActivity(new Intent(creagioco3.this,SceltaImmagini.class));
    }
    public void imag2(View w){
        DatiGioco3.setvaluecounterimage1(2);
        startActivity(new Intent(creagioco3.this,SceltaImmagini.class));
    }
    public void rispostacorretta(View w){

        startActivity(new Intent(creagioco3.this,SceltaRisposte.class));
    }

    public void audio(View w){
        startActivity(new Intent(creagioco3.this,SceltaAudio.class));
    }
    public void crea(View w){
        if(DatiGioco3.getcounter()<3){
            DatiGioco3.setcounter();
        }
        else{
            DatiGioco3.setvaluecounter(0);
        }
        if(DatiGioco3.getCountersound()<3){
            DatiGioco3.setcountersound();
        }
        else{
            DatiGioco3.setvaluecounterssound(0);
        }
        if(DatiGioco3.getcounterimage()<3){
            DatiGioco3.setcounterimage();
        }
        else{
            DatiGioco3.setvaluecounterimage(0);
        }
        startActivity(new Intent(creagioco3.this,creagioco3.class));
    }

}