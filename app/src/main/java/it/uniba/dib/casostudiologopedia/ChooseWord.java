package it.uniba.dib.casostudiologopedia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChooseWord extends AppCompatActivity {
    private int buttoncounter=0;

    private  String stringa1;private String stringa2;
    private String stringa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseword);
        Integer [] lista={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18};
       RadioButton [] buttoni=new RadioButton[18];
       for(int i=0;i<18;i++){
           buttoni[i]=(RadioButton)findViewById(lista[i]);
           final int a=i;
           buttoni[i].setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                   switch(buttoncounter){
                       case 0:{
                           stringa1= buttoni[a].getText().toString();
                           break;
                       }
                       case 1:{
                           stringa2= buttoni[a].getText().toString();
                           break;
                       }
                       case 2:{
                           stringa3= buttoni[a].getText().toString();

                           break;
                       }
                   }

                   buttoncounter++;
               }
           });
       }
    }

    public void ok(View w){
        switch(DatiIntent.getcounter1()){
            case 1:{
                DatiIntent.setgioco2(stringa1+"  "+stringa2+"   "+stringa3);
                break;
            }
            case 2:{
                DatiIntent.setgioco21(stringa1+"  "+stringa2+"   "+stringa3);
                break;
            }
            case 3:{
                DatiIntent.setgioco22(stringa1+"  "+stringa2+"   "+stringa3);
                break;
            }
        }

        startActivity(new Intent(ChooseWord.this,creaesercizio2.class));
    }
}
