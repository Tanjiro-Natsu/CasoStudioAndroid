package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco1.creaesercizio1;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco2.creaesercizio2;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco3.creagioco3;
import it.uniba.dib.casostudiologopedia.R;

public class BambinoCrea extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bambinocrea);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(DatiIntent.getNome());
        Button bt1=(Button)findViewById(R.id.button190);
        Button bt2=(Button)findViewById(R.id.button191);
        Button bt3=(Button)findViewById(R.id.button192);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCrea.this, creaesercizio1.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCrea.this, creaesercizio2.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCrea.this, creagioco3.class);
                startActivity(intent);
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(BambinoCrea.this,ListaBimbiCrea.class)) ;// close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}

