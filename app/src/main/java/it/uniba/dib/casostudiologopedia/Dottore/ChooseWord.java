package it.uniba.dib.casostudiologopedia.Dottore;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco2.creaesercizio2;
import it.uniba.dib.casostudiologopedia.R;

public class ChooseWord extends AppCompatActivity {
    private int buttoncounter=0;

    private  String stringa1;
    private String stringa2;
    private String stringa3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseword);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void ok(){

                DatiIntent.setgioco2(new StringBuilder().append(stringa1).append(stringa2).append(stringa3).toString());

Intent intent=new Intent(ChooseWord.this, creaesercizio2.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
if(id==R.id.item){
    ok();
}
        return true;
    }
}
