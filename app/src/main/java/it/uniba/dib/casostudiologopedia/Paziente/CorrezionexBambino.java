package it.uniba.dib.casostudiologopedia.Paziente;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.AndamentoEserciziotipo2_1;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.AndamentoEserciziotipo2_2;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.AndamentoEserciziotipo2_3;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.AndamentoEserciziotipo3_1;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.Andamentoeserciziotipo1_1;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.Andamentoeserciziotipo1_2;
import it.uniba.dib.casostudiologopedia.AndamentoEsercizi.Andamentoeserciziotipo1_3;
import it.uniba.dib.casostudiologopedia.R;

public class CorrezionexBambino extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andamentoesercizibimbo);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button bt1=(Button)findViewById(R.id.button190);
        Button bt2=(Button)findViewById(R.id.button191);
        Button bt3=(Button)findViewById(R.id.button192);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CorrezionexBambino.this, Andamentoeserciziotipo1_1.class));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CorrezionexBambino.this, Andamentoeserciziotipo1_2.class));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CorrezionexBambino.this, Andamentoeserciziotipo1_3.class));
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(CorrezionexBambino.this, mainBambino.class)) ;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }

    public void k1(View v){startActivity(new Intent(CorrezionexBambino.this, AndamentoEserciziotipo2_1.class));}
    public void k2(View v){startActivity(new Intent(CorrezionexBambino.this, AndamentoEserciziotipo2_2.class));}
    public void k3(View v){startActivity(new Intent(CorrezionexBambino.this, AndamentoEserciziotipo2_3.class));}
    public void k4(View v){startActivity(new Intent(CorrezionexBambino.this, AndamentoEserciziotipo3_1.class));}
}
