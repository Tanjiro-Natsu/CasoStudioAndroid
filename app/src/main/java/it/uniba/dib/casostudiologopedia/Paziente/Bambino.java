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

import it.uniba.dib.casostudiologopedia.Dottore.ListaBimbi;
import it.uniba.dib.casostudiologopedia.R;

public class Bambino extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bambino);
        String ok=getIntent().getExtras().getString("nome");
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(ok);
       Button bt1=(Button)findViewById(R.id.button190);
        Button bt2=(Button)findViewById(R.id.button191);
        Button bt3=(Button)findViewById(R.id.button192);
        Button bt4=(Button)findViewById(R.id.button193);
        Button bt5=(Button)findViewById(R.id.button194);
        Button bt6=(Button)findViewById(R.id.button195);
        Button bt7=(Button)findViewById(R.id.button196);
        Button bt8=(Button)findViewById(R.id.button197);
        Button bt9=(Button)findViewById(R.id.button198);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo1.class);
                intent.putExtra("testo",bt1.getText());
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo1.class);
                intent.putExtra("testo",bt2.getText());
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo1.class);
                intent.putExtra("testo",bt3.getText());
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo2.class);
                intent.putExtra("testo",bt4.getText());
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo2.class);
                intent.putExtra("testo",bt5.getText());
                startActivity(intent);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo2.class);
                intent.putExtra("testo",bt6.getText());
                startActivity(intent);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo3.class);
                intent.putExtra("testo",bt7.getText());
                startActivity(intent);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo3.class);
                intent.putExtra("testo",bt8.getText());
                startActivity(intent);
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Bambino.this, SchedaEsercizioTipo3.class);
                intent.putExtra("testo",bt9.getText());
                startActivity(intent);
            }
        });

    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(Bambino.this, ListaBimbi.class)) ;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
