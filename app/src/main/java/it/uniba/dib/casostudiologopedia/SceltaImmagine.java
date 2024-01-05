package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SceltaImmagine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltaimmagine);


    }
    public void immaginescelta1(View v){
        switch(DatiIntent.getcounter()){
            case 0:{
                DatiIntent.setimage(R.drawable.cane);
                break;}
            case 1:{
                DatiIntent.setimage1(R.drawable.cane);
                break;}
            case 2:{
                DatiIntent.setimage2(R.drawable.cane);
                break;}
        }
        startActivity(new Intent(SceltaImmagine.this, creaesercizio1.class));
    }
    public void immaginescelta2(View v){

        switch(DatiIntent.getcounter()){
            case 0:{
            DatiIntent.setimage(R.drawable.albero);
            break;}
        case 1:{
            DatiIntent.setimage1(R.drawable.albero);
            break;}
        case 2:{
            DatiIntent.setimage2(R.drawable.albero);
            break;}}
        startActivity(new Intent(SceltaImmagine.this, creaesercizio1.class));
    }
    public void immaginescelta3(View v){
        switch(DatiIntent.getcounter()){ case 0:{
            DatiIntent.setimage(R.drawable.casa);
            break;}
        case 1:{
            DatiIntent.setimage1(R.drawable.casa);
            break;}
        case 2:{
            DatiIntent.setimage2(R.drawable.casa);
            break;}}
        startActivity(new Intent(SceltaImmagine.this, creaesercizio1.class));
    }
    public void immaginescelta4(View v){
        switch(DatiIntent.getcounter()){
            case 0:{
            DatiIntent.setimage(R.drawable.coniglio);
            break;}
        case 1:{
            DatiIntent.setimage1(R.drawable.coniglio);
            break;}
        case 2:{
            DatiIntent.setimage2(R.drawable.coniglio);
            break;}}
        startActivity(new Intent(SceltaImmagine.this, creaesercizio1.class));
    }
}