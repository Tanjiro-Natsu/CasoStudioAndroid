package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class sceltaiuto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltafrase);
int [] bottoni={R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11};
RadioButton []radioButton=new RadioButton[11];
for(int k=0;k<11;k++){
    radioButton[k]=(RadioButton)findViewById(bottoni[k]);
    final int i=k;
    radioButton[k].setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            switch(DatiIntent.getcounter()){
                case 0:{
                    switch (DatiIntent.getaiuto()){
                        case 1:{
                            DatiIntent.settext(radioButton[i].getText().toString());
                            break;
                        }
                        case 2:{
                            DatiIntent.settext1(radioButton[i].getText().toString());
                            break;
                        }
                        case 3:{
                            DatiIntent.settext2(radioButton[i].getText().toString());
                            break;
                        }
                    }break;}
                case 1:{
                    switch (DatiIntent.getaiuto()){
                        case 1:{
                            DatiIntent.settext_1(radioButton[i].getText().toString());
                            break;
                        }
                        case 2:{
                            DatiIntent.settext1_1(radioButton[i].getText().toString());
                            break;
                        }
                        case 3:{
                            DatiIntent.settext2_1(radioButton[i].getText().toString());
                            break;
                        }
                    }break;}
                case 2:{
                    switch (DatiIntent.getaiuto()){
                        case 1:{
                            DatiIntent.settext_2(radioButton[i].getText().toString());
                            break;
                        }
                        case 2:{
                            DatiIntent.setText1_2(radioButton[i].getText().toString());
                            break;
                        }
                        case 3:{
                            DatiIntent.setText2_2(radioButton[i].getText().toString());
                            break;
                        }
                    }break;}
            }
            startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
        }
    });
}

    }
 }
