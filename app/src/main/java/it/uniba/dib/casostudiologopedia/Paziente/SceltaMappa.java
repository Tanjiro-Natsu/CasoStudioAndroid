package it.uniba.dib.casostudiologopedia.Paziente;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.R;

public class SceltaMappa extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceglimappa);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void immaginescelta1(View w){
        DatiIntent.setMappa(1);
        startActivity(new Intent(SceltaMappa.this,Mappa.class));
    }
    public void immaginescelta2(View w){
        DatiIntent.setMappa(2);
        startActivity(new Intent(SceltaMappa.this,Mappa.class));
    }
    public void immaginescelta3(View w){
        DatiIntent.setMappa(3);
        startActivity(new Intent(SceltaMappa.this,Mappa.class));
    }
    public void immaginescelta4(View w){
        DatiIntent.setMappa(4);
        startActivity(new Intent(SceltaMappa.this,Mappa.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(SceltaMappa.this,mainBambino.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }

}
