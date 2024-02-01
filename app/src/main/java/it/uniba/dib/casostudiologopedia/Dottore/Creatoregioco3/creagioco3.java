package it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import it.uniba.dib.casostudiologopedia.DatiGioco3;
import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.Dottore.BambinoCrea;
import it.uniba.dib.casostudiologopedia.Dottore.Creatoregioco2.SceltaAudio;
import it.uniba.dib.casostudiologopedia.R;

public class creagioco3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.creagioco3);


    }

public void ok(View w){

    Intent intent=new Intent(creagioco3.this, BambinoCrea.class);

    startActivity(intent);
}
    public void imag1(View w){
        DatiGioco3.setvaluecounterimage1(1);
        startActivity(new Intent(creagioco3.this,SceltaImmagini.class));
    }
    public void imag2(View w){
        DatiGioco3.setvaluecounterimage1(2);
        startActivity(new Intent(creagioco3.this,SceltaImmagini.class));
    }
    public void rispostacorretta(View w){

        startActivity(new Intent(creagioco3.this, SceltaRisposte.class));
    }

    public void audio(View w){
        startActivity(new Intent(creagioco3.this, SceltaAudio.class));
    }
    public void crea(View w){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(new StringBuilder().append("Creare il gioco numero ").append(DatiGioco3.getcounter()+1).append(" ?"));
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Si",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                            DatiGioco3.setcounter();
                        Map<String,Object> map=new HashMap<>();
                        FirebaseDatabase db= FirebaseDatabase.getInstance();
                        DatabaseReference ref=db.getReference("App/Bambini").child(DatiIntent.getEmail()).child("Giochi").child("Riconoscimento");
                      map.put("image1",DatiGioco3.getImmagine1());
                        map.put("image2",DatiGioco3.getImmagine2());
                        map.put("audio",DatiGioco3.getsound1());
                        map.put("correzione",DatiGioco3.getcorrezione());
                        ref.child("Gioco"+DatiGioco3.getcounter()).setValue(map);
                        String tappa ="Tappa"+DatiGioco3.getcounter()+6;
                        DatabaseReference ref1=db.getReference("App/Bambini").child(DatiIntent.getEmail());
                        ref1.child("Mappa").child(tappa).setValue(0);
                        Toast.makeText(creagioco3.this, "Gioco creato!", Toast.LENGTH_SHORT).show();
                        if(DatiGioco3.getcounter()==3){
                            DatiGioco3.setvaluecounter(0);
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