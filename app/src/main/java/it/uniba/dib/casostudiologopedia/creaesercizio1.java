package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class creaesercizio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatoreeserciziotipo1);
        Button aiuto1=(Button)findViewById(R.id.button11);
        Button aiuto2=(Button)findViewById(R.id.button12);
        Button aiuto3=(Button)findViewById(R.id.button14);
        if(DatiIntent.getaiuto()==0){
           aiuto1.setEnabled(true);
        }

        if(DatiIntent.getaiuto()==0){
            aiuto2.setEnabled(false);

        }
        else{
            aiuto2.setEnabled(true);
        }
        if(DatiIntent.getaiuto()==2 || DatiIntent.getaiuto()==3){
            aiuto3.setEnabled(true);
        }
        else{
            aiuto3.setEnabled(false);
        }
        aiuto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(1);
                startActivity(new Intent(creaesercizio1.this,sceltaiuto.class));
            }
    });
        aiuto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(2);
                startActivity(new Intent(creaesercizio1.this,sceltaiuto.class));
            }
        });
        aiuto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(3);
                startActivity(new Intent(creaesercizio1.this,sceltaiuto.class));
            }
        });
    }
    public void pick(View v){
        startActivity(new Intent(creaesercizio1.this,SceltaImmagine.class));
    }
    public void Annulla(View v){
        startActivity(new Intent(creaesercizio1.this, MainActivity.class));
    }

    public void crea(View v){

        DatiIntent.setcountet();
        if(DatiIntent.getcounter()==3){
            DatiIntent.setvaluecounter(0);
            DatiIntent.setaiuto(0);
            DatiIntent.settext(" ");
            DatiIntent.settext1(" ");
            DatiIntent.settext2(" ");
            DatiIntent.settext_1(" ");
            DatiIntent.settext1_1(" ");
            DatiIntent.settext2_1(" ");
            DatiIntent.settext_2(" ");
            DatiIntent.setText1_2(" ");
            DatiIntent.setText2_2(" ");
        }
        DatiIntent.setaiuto(0);
        startActivity(new Intent(creaesercizio1.this, creaesercizio1.class));
    }
}
