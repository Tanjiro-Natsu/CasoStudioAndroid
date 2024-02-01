package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import it.uniba.dib.casostudiologopedia.DatiGioco3;
import it.uniba.dib.casostudiologopedia.R;

public class SceltaImmagini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceglimmagine3);


    }
    public void immaginescelta11(View v){
        switch(DatiGioco3.getCounterimage1()){
            case 1:{
               DatiGioco3.setImmagine1(R.drawable.cane);
            break;}
            case 2:{
                DatiGioco3.setImmagine2(R.drawable.cane);
                break;}}
        startActivity(new Intent(SceltaImmagini.this, creagioco3.class));
    }
    public void immaginescelta21(View v){

        switch(DatiGioco3.getCounterimage1()){
            case 1:{
                DatiGioco3.setImmagine1(R.drawable.albero);
                break;}
            case 2:{
                DatiGioco3.setImmagine2(R.drawable.albero);
                break;}}
        startActivity(new Intent(SceltaImmagini.this, creagioco3.class));
    }
    public void immaginescelta31(View v){
        switch(DatiGioco3.getCounterimage1()){
            case 1:{
                DatiGioco3.setImmagine1(R.drawable.casa);
                break;}
            case 2:{
                DatiGioco3.setImmagine2(R.drawable.casa);
                break;}}
        startActivity(new Intent(SceltaImmagini.this, creagioco3.class));
    }
    public void immaginescelta41(View v){
        switch(DatiGioco3.getCounterimage1()){
            case 1:{
                DatiGioco3.setImmagine1(R.drawable.coniglio);
                break;}
            case 2:{
                DatiGioco3.setImmagine2(R.drawable.coniglio);
                break;}}
        startActivity(new Intent(SceltaImmagini.this, creagioco3.class));
    }
}