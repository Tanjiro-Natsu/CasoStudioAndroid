package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco3;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.DatiGioco3;
import it.uniba.dib.casostudiologopedia.R;

public class SceltaRisposte extends AppCompatActivity {
    private int buttoncounter=0;
    private int buttoncounter1=0;
    private int buttoncounter2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltascelte);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Integer [] lista={R.id.button1,R.id.button2};
        RadioButton [] buttoni=new RadioButton[2];
        for(int i=0;i<2;i++){
            buttoni[i]=(RadioButton)findViewById(lista[i]);
            final int a=i;
            if(i==0){ buttoni[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                            DatiGioco3.setcorrezione(1);

                    startActivity(new Intent(SceltaRisposte.this, creagioco3.class));
                }
            });}
            else{
                if(i==1){ buttoni[i].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                                DatiGioco3.setcorrezione(2);
                        startActivity(new Intent(SceltaRisposte.this,creagioco3.class));
                    }
                });
            }
        }
    }}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


}
