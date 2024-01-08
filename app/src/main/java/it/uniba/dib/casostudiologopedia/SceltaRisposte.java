package it.uniba.dib.casostudiologopedia;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

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
            buttoni[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch(DatiGioco3.getcounter()){
                        case 0:{

                            DatiGioco3.setStringa1(buttoni[a].getText().toString());

                        break;}
                        case 1:{
                                    DatiGioco3.setStringa1_1(buttoni[a].getText().toString());

                            break;}
                        case 2:{
                                    DatiGioco3.setStringa1_2(buttoni[a].getText().toString());

                            break;}}

                    startActivity(new Intent(SceltaRisposte.this,creagioco3.class));
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


}
