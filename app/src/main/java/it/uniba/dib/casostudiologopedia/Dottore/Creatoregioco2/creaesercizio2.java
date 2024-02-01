package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.Dottore.BambinoCrea;
import it.uniba.dib.casostudiologopedia.Dottore.ChooseWord;
import it.uniba.dib.casostudiologopedia.R;

public class creaesercizio2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creatoregioco2);
        FirebaseApp.initializeApp(creaesercizio2.this);

    }
    public void scegliparole(View v){

        startActivity(new Intent(creaesercizio2.this, ChooseWord.class));
    }
    public void back(View v){
        Intent intent=new Intent(creaesercizio2.this, BambinoCrea.class);
        startActivity(intent);
    }
    public void refresh(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(new StringBuilder().append("Creare il gioco numero ").append(DatiIntent.getcounter1()).append(" ?"));

        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Map<String,Object> map=new HashMap<>();
                        FirebaseDatabase db= FirebaseDatabase.getInstance();
                        DatabaseReference ref=db.getReference("App/Bambini").child(DatiIntent.getEmail()).child("Giochi").child("Ripetizione");
                       map.put("Stringa",DatiIntent.getgioco2());
                        ref.child("Gioco"+DatiIntent.getcounter1()).setValue(map);
                        String tappa ="Tappa"+DatiIntent.getcounter1()+3;
                        DatabaseReference ref1=db.getReference("App/Bambini").child(DatiIntent.getEmail());
                        ref1.child("Mappa").child(tappa).setValue(0);
                        DatiIntent.setcountet1();
                        Toast.makeText(creaesercizio2.this, "Gioco creato!", Toast.LENGTH_SHORT).show();
                        if(DatiIntent.getcounter1()==4){
                            DatiIntent.setcountet1value(1);
                        }
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}