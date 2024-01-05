package it.uniba.dib.casostudiologopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sceltaiuto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sceltafrase);
Button bt1=(Button)findViewById(R.id.button1);
        Button bt2=(Button)findViewById(R.id.button2);
        Button bt3=(Button)findViewById(R.id.button3);
        Button bt4=(Button)findViewById(R.id.button4);
        Button bt5=(Button)findViewById(R.id.button5);
        Button bt6=(Button)findViewById(R.id.button6);
        Button bt7=(Button)findViewById(R.id.button7);
        Button bt8=(Button)findViewById(R.id.button8);
        Button bt9=(Button)findViewById(R.id.button9);
        Button bt10=(Button)findViewById(R.id.button10);
        Button bt11=(Button)findViewById(R.id.button11);
        Button bt12=(Button)findViewById(R.id.button12);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt1.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt1.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt1.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt1.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt1.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt1.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt1.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt1.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt1.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt2.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt2.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt2.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt2.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt2.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt2.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt2.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt2.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt2.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt3.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt3.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt3.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt3.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt3.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt3.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt3.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt3.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt3.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt4.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt4.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt4.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt4.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt4.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt4.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt4.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt4.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt4.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt5.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt5.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt5.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt5.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt5.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt5.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt5.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt5.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt5.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt6.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt6.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt6.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt6.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt6.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt6.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt6.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt6.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt6.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt7.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt7.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt7.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt7.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt7.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt7.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt7.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt7.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt7.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt8.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt8.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt8.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt8.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt8.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt8.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt8.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt8.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt8.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt9.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt9.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt9.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt9.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt9.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt9.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt9.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt9.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt9.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt10.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt10.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt10.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt10.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt10.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt10.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt10.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt10.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt10.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext(bt11.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1(bt11.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2(bt11.getText().toString());
                                break;
                            }
                        }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt11.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt11.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt11.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt11.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt11.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt11.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
        bt12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(DatiIntent.getcounter()){
                    case 0:{
                switch (DatiIntent.getaiuto()){
                    case 1:{
                        DatiIntent.settext(bt12.getText().toString());
                        break;
                    }
                    case 2:{
                        DatiIntent.settext1(bt12.getText().toString());
                        break;
                    }
                    case 3:{
                        DatiIntent.settext2(bt12.getText().toString());
                        break;
                    }
                }break;}
                    case 1:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_1(bt12.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.settext1_1(bt12.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.settext2_1(bt12.getText().toString());
                                break;
                            }
                        }break;}
                    case 2:{
                        switch (DatiIntent.getaiuto()){
                            case 1:{
                                DatiIntent.settext_2(bt12.getText().toString());
                                break;
                            }
                            case 2:{
                                DatiIntent.setText1_2(bt12.getText().toString());
                                break;
                            }
                            case 3:{
                                DatiIntent.setText2_2(bt12.getText().toString());
                                break;
                            }
                        }break;}
                }
                startActivity(new Intent(sceltaiuto.this, creaesercizio1.class));
            }
        });
    }}
