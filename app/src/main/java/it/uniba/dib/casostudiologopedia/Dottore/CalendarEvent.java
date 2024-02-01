package it.uniba.dib.casostudiologopedia.Dottore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import it.uniba.dib.casostudiologopedia.DatiIntent;
import it.uniba.dib.casostudiologopedia.R;

public class CalendarEvent extends AppCompatActivity {
    private Dialog dialog;
    private String data;
    private FirebaseDatabase db;
    private DatabaseReference ref;
    private int Day;
    private int Mounth;
    private int Year;
    EditText text;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        TextView t1=(TextView) findViewById(R.id.NomeBambino);
        TextView t2=(TextView) findViewById(R.id.Eta);
        text=(EditText)findViewById(R.id.editTextText2);
        FirebaseApp.initializeApp(CalendarEvent.this);
        db= FirebaseDatabase.getInstance();
        ref=db.getReference("App/Bambini").child(DatiIntent.getEmail()).child("Appuntamento");
        t1.setText(DatiIntent.getNome());
        t2.setText(DatiIntent.getEta());
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Button bt=(Button)findViewById(R.id.button23);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(CalendarEvent.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                               Day=dayOfMonth;
                               Mounth=monthOfYear+1;
                               Year=year;
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.MONTH,Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH,23);
        cal.set(Calendar.YEAR,2024);

    }
    public void AddCalendarEvent(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Calendar Event");
        startActivity(i);
    }

    public void crea(View v){
        ref.child("Giorno").setValue(Day);
        ref.child("Mese").setValue(Mounth);
        ref.child("Anno").setValue(Year);
        ref.child("Note").setValue(text.getText().toString());
        Toast.makeText(this, "Appuntamento Creato", Toast.LENGTH_SHORT).show();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(CalendarEvent.this,mainLogopedista.class)) ;// close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.k1,menu);
        return true;
    }
}