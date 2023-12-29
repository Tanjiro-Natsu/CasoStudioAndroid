package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AutumnColor2 extends AppCompatActivity {
    private static boolean correctAnswer=false;
    public static boolean getresult(){
        return correctAnswer;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autumncolor2);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View w){
                correctAnswer=true;
                startActivity(new Intent(AutumnColor2.this,AutumnColor3.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View w){
                startActivity(new Intent(AutumnColor2.this,AutumnColor3.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View w){
                startActivity(new Intent(AutumnColor2.this,AutumnColor3.class));
            }
        });

    }
}
