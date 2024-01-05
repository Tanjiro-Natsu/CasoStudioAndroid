package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class creaesercizio2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatoregioco2);


    }
    public void scegliparole(View v){
        if(DatiIntent.getcounter1()==3){
            DatiIntent.setcountet1value(0);
        }
        else{
        DatiIntent.setcountet1();}
        startActivity(new Intent(creaesercizio2.this, ChooseWord.class));
    }
    public void back(View v){
        startActivity(new Intent(creaesercizio2.this, MainActivity.class));
    }
    public void refresh(View v){
        startActivity(new Intent(creaesercizio2.this, creaesercizio2.class));
    }
}