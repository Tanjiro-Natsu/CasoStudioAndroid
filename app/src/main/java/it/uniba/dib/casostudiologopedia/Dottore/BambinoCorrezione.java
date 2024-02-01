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
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.corretteroinverno1;
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.correttoreautunno1;
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.correttoreestate1;
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.correzioneautunno2;
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.correzioneestate2;
import it.uniba.dib.casostudiologopedia.Dottore.Correttori.correzioneinverno2;
import it.uniba.dib.casostudiologopedia.R;

public class BambinoCorrezione extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bambinocorrezione);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(DatiIntent.getNome());
        Button bt1=(Button)findViewById(R.id.button190);
        Button bt2=(Button)findViewById(R.id.button191);
        Button bt3=(Button)findViewById(R.id.button192);
        Button bt4=(Button)findViewById(R.id.button193);
        Button bt5=(Button)findViewById(R.id.button194);
        Button bt6=(Button)findViewById(R.id.button195);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, corretteroinverno1.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, correttoreestate1.class);

                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, correttoreautunno1.class);
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, correzioneinverno2.class);
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, correzioneestate2.class);
                startActivity(intent);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BambinoCorrezione.this, correzioneautunno2.class);
                startActivity(intent);
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(BambinoCorrezione.this,ListaBimbiCorrezione.class)) ;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
