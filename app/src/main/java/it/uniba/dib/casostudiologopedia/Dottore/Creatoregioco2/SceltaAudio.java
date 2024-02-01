package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco2;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;

import it.uniba.dib.casostudiologopedia.DatiGioco3;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco3.creagioco3;
import it.uniba.dib.casostudiologopedia.R;

public class SceltaAudio extends AppCompatActivity {
    private int buttoncounter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltaaudio);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Integer [] lista={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18};
        RadioButton[] buttoni=new RadioButton[18];
        for(int i=0;i<18;i++){
            buttoni[i]=(RadioButton)findViewById(lista[i]);
            final int a=i;
            buttoni[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                                    DatiGioco3.setsound1(buttoni[a].getText().toString());
                    startActivity(new Intent(SceltaAudio.this, creagioco3.class));
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }

}
