package it.uniba.dib.casostudiologopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void prova(View v){
        startActivity(new Intent(MainActivity.this,creaesercizio1.class));
    }
    public void WinterRecord(View v){
        startActivity(new Intent(MainActivity.this,Winter1Record.class));
    }
    public void SummerRecord(View v){
        startActivity(new Intent(MainActivity.this,Summer1Record.class));
    }
    public void AutumnRecord(View v){
        startActivity(new Intent(MainActivity.this,Autumn1Record.class));
    }
    public void word(View v){
        startActivity(new Intent(MainActivity.this,creaesercizio2.class));
    }
    public void k1(View v){
        startActivity(new Intent(MainActivity.this,Inverno2.class));
    }
    public void k2(View v){
        startActivity(new Intent(MainActivity.this,Estate2.class));
    }
    public void k3(View v){
        startActivity(new Intent(MainActivity.this,Autunno2.class));
    }


}