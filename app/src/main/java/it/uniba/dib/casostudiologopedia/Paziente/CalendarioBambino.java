package it.uniba.dib.casostudiologopedia.Paziente;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

import it.uniba.dib.casostudiologopedia.R;

public class CalendarioBambino extends AppCompatActivity {
    private Calendar cal;
    private CalendarView op;
    private TextView text;
    private FirebaseDatabase db;
    DatabaseReference ref;
    private int Anno;
    private int Mese;
    private int Giorno;
    private String note;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendario);
        Calendar cal=Calendar.getInstance();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        FirebaseApp.initializeApp(CalendarioBambino.this);
        db=FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini").child(DatiBambino.getEmail());
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child("Appuntamento").exists()){
                    Anno=snapshot.child("Appuntamento").child("Anno").getValue(Integer.class);
                    Giorno=snapshot.child("Appuntamento").child("Giorno").getValue(Integer.class);
                    Mese=snapshot.child("Appuntamento").child("Mese").getValue(Integer.class);
                    note=snapshot.child("Appuntamento").child("Note").getValue(String.class);
                    switch(Mese){
                        case 1:{
                            cal.set(Calendar.MONTH,Calendar.JANUARY);
                            break;
                        }
                        case 2:{
                            cal.set(Calendar.MONTH,Calendar.FEBRUARY);
                            break;
                        }
                        case 3:{
                            cal.set(Calendar.MONTH,Calendar.MARCH);
                            break;
                        }
                        case 4:{
                            cal.set(Calendar.MONTH,Calendar.APRIL);
                            break;
                        }
                        case 5:{
                            cal.set(Calendar.MONTH,Calendar.MAY);
                            break;
                        }
                        case 6:{
                            cal.set(Calendar.MONTH,Calendar.JUNE);
                            break;
                        }
                        case 7:{
                            cal.set(Calendar.MONTH,Calendar.JULY);
                            break;
                        }
                        case 8:{
                            cal.set(Calendar.MONTH,Calendar.AUGUST);
                            break;
                        }
                        case 9:{
                            cal.set(Calendar.MONTH,Calendar.SEPTEMBER);
                            break;
                        }
                        case 10:{
                            cal.set(Calendar.MONTH,Calendar.OCTOBER);
                            break;
                        }
                        case 11:{
                            cal.set(Calendar.MONTH,Calendar.NOVEMBER);
                            break;
                        }
                        case 12:{
                            cal.set(Calendar.MONTH,Calendar.DECEMBER);
                            break;
                        }

                    }

                    cal.set(Calendar.DAY_OF_MONTH,Giorno);
                    cal.set(Calendar.YEAR,Anno);
                    op=(CalendarView)findViewById(R.id.calendarView);
                    op.setDate(cal.getTimeInMillis(),true,true);
                    text=(TextView) findViewById(R.id.textView);
                    text.setText(note);
                    Toast.makeText(CalendarioBambino.this, Anno+"-"+Mese+"-"+Giorno, Toast.LENGTH_SHORT).show();
                }
                else{
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(CalendarioBambino.this);
                    builder1.setMessage(new StringBuilder().append("Non è stato ancora fissato nessun appuntamento"));
                    builder1.setCancelable(true);
                    builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) {startActivity(new Intent(CalendarioBambino.this, mainBambino.class));}});
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(CalendarioBambino.this,mainBambino.class)) ;// close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}
