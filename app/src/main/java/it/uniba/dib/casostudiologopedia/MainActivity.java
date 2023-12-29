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
    public void autumnword(View v){
        startActivity(new Intent(MainActivity.this,Autum1word.class));
    }
    public void winterword(View v){
        startActivity(new Intent(MainActivity.this, Winte1Word.class));
    }
    public void summerword(View v){
        startActivity(new Intent(MainActivity.this,Summer1Word.class));
    }
    public void summercolor(View v){
        startActivity(new Intent(MainActivity.this,SummerColor1.class));
    }
    public void wintercolor(View v){
        startActivity(new Intent(MainActivity.this,WinterColor1.class));
    }
    public void autumncolor(View v){
        startActivity(new Intent(MainActivity.this,AutumnColor1.class));
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
}