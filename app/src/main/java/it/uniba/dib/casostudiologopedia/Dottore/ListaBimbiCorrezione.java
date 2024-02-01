package it.uniba.dib.casostudiologopedia.Dottore;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.R;

public class ListaBimbiCorrezione extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference ref;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listabambini);
        LinearLayout layout = (LinearLayout) findViewById(R.id.ciao);
        FirebaseApp.initializeApp(ListaBimbiCorrezione.this);
        ArrayList<String> lista=new ArrayList<>();
        ArrayList<String> email=new ArrayList<>();
        FirebaseDatabase db= FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("App/Bambini");
        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int l=0;
                for(DataSnapshot ds :snapshot.getChildren()){
                    email.add(ds.getKey().toString());
                    String n1=ds.child("Cognome").getValue().toString();
                    String n2= ds.child("Nome").getValue().toString();
                    lista.add(n1+" "+n2);
                    l++;
                }
                int k=lista.size();
                MaterialButton[]bt=new MaterialButton[k];
                for(int i=0;i<k;i++){
                    bt[i]=new MaterialButton(new ContextThemeWrapper(ListaBimbiCorrezione.this, com.google.android.material.R.style.Widget_MaterialComponents_Button_OutlinedButton), null, com.google.android.material.R.style.Widget_MaterialComponents_Button_OutlinedButton);
                    bt[i].setTextColor(Color.WHITE);
                    bt[i].setBackgroundColor(Color.TRANSPARENT);
                    bt[i].setStrokeColor(ColorStateList.valueOf(Color.WHITE));
                    bt[i].setText(lista.get(i));
                    final int t=i;
                    bt[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(ListaBimbiCorrezione.this,BambinoCorrezione.class);
                            DatiIntent.setNome(bt[t].getText().toString());
                            DatiIntent.setEmail(email.get(t));
                            startActivity(intent);
                        }
                    });
                    layout.addView(bt[i]);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(ListaBimbiCorrezione.this,mainLogopedista.class)) ;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
