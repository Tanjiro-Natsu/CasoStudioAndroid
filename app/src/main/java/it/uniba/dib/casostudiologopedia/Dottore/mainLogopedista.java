package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.R;

public class mainLogopedista extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlogopedista);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
    }
    public void crea(View v){startActivity(new Intent(mainLogopedista.this,ListaBimbiCrea.class));}
  public void correzione(View v ){startActivity(new Intent(mainLogopedista.this,ListaBimbiCorrezione.class));}
   public void punteggio(View v){startActivity(new Intent(mainLogopedista.this,Graduatorie.class));}
    public void calendario(View v){startActivity(new Intent(mainLogopedista.this, ListaBimbi.class));}
    public void registra(View v){startActivity(new Intent(mainLogopedista.this, RegistraPaziente.class));}
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(mainLogopedista.this,LoginLogopedista.class)) ;// close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
