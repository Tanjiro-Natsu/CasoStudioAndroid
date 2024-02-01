package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import it.uniba.dib.casostudiologopedia.R;

public class Graduatorie extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punteggio);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        LinearLayout layer=(LinearLayout)findViewById(R.id.ciao);
        EditText text=new EditText(Graduatorie.this);
        text.setText("          Nome               Punteggio");
        text.setTextColor(Color.WHITE);
        text.setTextSize(24);
        layer.addView(text);
        FirebaseApp.initializeApp(Graduatorie.this);
        ArrayList<String> lista=new ArrayList<>();
        ArrayList<Integer> punteggio=new ArrayList<>();
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini");
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int l=0;
                for(DataSnapshot ds :snapshot.getChildren()){
                    String n1=ds.child("Cognome").getValue().toString();
                    String n2= ds.child("Nome").getValue().toString();
                    punteggio.add(ds.child("Punteggio").getValue(Integer.class));
                    lista.add(n1+" "+n2);
                    l++;
                }
                int k=lista.size();
                for(int i=0;i<l;i++){
                    int max=punteggio.get(i);
                    for(int t=i;t<l;t++){
                        if(punteggio.get(t)>max){
                            max=punteggio.get(t);
                            int numero=max;
                            punteggio.set(t,punteggio.get(i));
                            punteggio.set(i,numero);
                            String nome=lista.get(i);
                            lista.set(i,lista.get(t));
                            lista.set(t,nome);
                        }

                }}
                MaterialButton[]bt=new MaterialButton[k];
                for(int i=0;i<k;i++){
                    bt[i]=new MaterialButton(new ContextThemeWrapper(Graduatorie.this, com.google.android.material.R.style.Widget_MaterialComponents_Button_OutlinedButton), null, com.google.android.material.R.style.Widget_MaterialComponents_Button_OutlinedButton);
                    bt[i].setTextColor(Color.WHITE);
                    bt[i].setBackgroundColor(Color.TRANSPARENT);
                    bt[i].setStrokeColor(ColorStateList.valueOf(Color.WHITE));
                    bt[i].setText(lista.get(i)+"                       "+punteggio.get(i));
                    layer.addView(bt[i]);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(Graduatorie.this,mainLogopedista.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
