package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import it.uniba.dib.casostudiologopedia.R;

public class creaesercizio1 extends AppCompatActivity {


private String aiuto1;
    private String aiuto2;
    private String aiuto3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(creaesercizio1.this);
        setContentView(R.layout.creatoreeserciziotipo1);
        Button aiuto1=(Button)findViewById(R.id.button11);
        Button aiuto2=(Button)findViewById(R.id.button12);
        Button aiuto3=(Button)findViewById(R.id.button14);

        aiuto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(1);
                Intent intent=new Intent(creaesercizio1.this,sceltaiuto.class);

                startActivity(intent);
            }
    });
        aiuto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(2);
                Intent intent=new Intent(creaesercizio1.this,sceltaiuto.class);

                startActivity(intent);
            }
        });
        aiuto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatiIntent.setaiuto(3);
                Intent intent=new Intent(creaesercizio1.this,sceltaiuto.class);

                startActivity(intent);
            }
        });
    }
    public void pick(View v){
        Intent intent=new Intent(creaesercizio1.this,SceltaImmagine.class);

        startActivity(intent);
    }
    public void Annulla(View v){
        Intent intent=new Intent(creaesercizio1.this, BambinoCrea.class);

        startActivity(intent);
    }

    public void crea(View v) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(new StringBuilder().append("Creare il gioco numero ").append(DatiIntent.getcounter()+1).append(" ?"));
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        DatiIntent.setcountet();
                        Map<String,Object> map=new HashMap<>();
                        FirebaseDatabase db= FirebaseDatabase.getInstance();

                        DatabaseReference ref=db.getReference("App/Bambini").child(DatiIntent.getEmail()).child("Giochi").child("Denominazione");
                        if(DatiIntent.getText()!=null){
                            map.put("aiuto_1",DatiIntent.getText());
                        }
                        if(DatiIntent.getText1()!=null){
                            map.put("aiuto_2",DatiIntent.getText1());
                        }
                        if(DatiIntent.getText2()!=null){
                            map.put("aiuto_3",DatiIntent.getText2());
                        }
                        map.put("image",DatiIntent.getImage());
                        ref.child("Gioco"+DatiIntent.getcounter()).setValue(map);
                        DatabaseReference ref1=db.getReference("App/Bambini").child(DatiIntent.getEmail());
                        String tappa ="Tappa"+DatiIntent.getcounter();
ref1.child("Mappa").child(tappa).setValue(0);
                        Toast.makeText(creaesercizio1.this, "Gioco creato!", Toast.LENGTH_SHORT).show();
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
