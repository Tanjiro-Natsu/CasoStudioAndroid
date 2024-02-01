package it.uniba.dib.casostudiologopedia.Paziente;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.R;

public class SchedaEsercizioTipo2 extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.andamentoeserciziobambino2);
        String ok=getIntent().getExtras().getString("testo").toString();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(ok);
        TextView text1=(TextView) findViewById(R.id.aiuto1);
        TextView text2=(TextView) findViewById(R.id.aiuto2);
        TextView text3=(TextView) findViewById(R.id.aiuto3);
        /*text1.setText();
        text2.setText();
        text3.setText();*/
ImageView view=(ImageView) findViewById(R.id.imageView28);
//view.setImageResource();

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
