package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.R;

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
            Intent intent=new Intent(sceltaiuto.this, creaesercizio1.class);

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
                    }

            startActivity(intent);
        }
    });
}

    }
 }
