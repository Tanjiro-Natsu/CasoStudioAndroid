package it.uniba.dib.casostudiologopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import it.uniba.dib.casostudiologopedia.Dottore.LoginLogopedista;
import it.uniba.dib.casostudiologopedia.Dottore.mainLogopedista;
import it.uniba.dib.casostudiologopedia.Paziente.LoginBambino;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Bambino(View v){
        startActivity(new Intent(MainActivity.this, LoginBambino.class));
    }
    public void Logopedista(View v){
        startActivity(new Intent(MainActivity.this, LoginLogopedista.class));
    }
    public void Diretto(View v){
        startActivity(new Intent(MainActivity.this, mainLogopedista.class));
    }

    }




