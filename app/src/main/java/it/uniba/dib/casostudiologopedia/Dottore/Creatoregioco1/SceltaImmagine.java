package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.R;

public class SceltaImmagine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltaimmagine);



    }
    public void immaginescelta1(View v){
     DatiIntent.setimage(R.drawable.cane);
     Intent intent=new Intent(SceltaImmagine.this, creaesercizio1.class);
        startActivity(intent);
    }
    public void immaginescelta2(View v){

        DatiIntent.setimage(R.drawable.albero);
        Intent intent=new Intent(SceltaImmagine.this, creaesercizio1.class);
        startActivity(intent);
    }
    public void immaginescelta3(View v){
        DatiIntent.setimage(R.drawable.coniglio);
        Intent intent=new Intent(SceltaImmagine.this, creaesercizio1.class);

        startActivity(intent);
    }
    public void immaginescelta4(View v){
        DatiIntent.setimage(R.drawable.casa);
        Intent intent=new Intent(SceltaImmagine.this, creaesercizio1.class);

        startActivity(intent);
    }
}