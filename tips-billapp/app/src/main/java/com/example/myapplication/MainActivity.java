package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar skbar=  findViewById(R.id.seekBar2);
        TextView tippercent= findViewById(R.id.tippercent);
        TextView statusbox=findViewById(R.id.status);
        TextView tipamtbox=findViewById(R.id.tipamtbox);
        TextView totalamtbox=findViewById(R.id.totalamtbox);
        EditText billamtstr= (EditText) findViewById(R.id.billamtinput);


        skbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String val=""+progress;
                Log.i("TAG",val);
                tippercent.setText(val+"%");
                if(billamtstr.getText().toString().isEmpty()){
                    statusbox.setText("billamout empty");
                    statusbox.setTextColor(Color.RED);
                }
                else{
                    float billamt= Float.parseFloat(billamtstr.getText().toString());
                    float tipamtval=billamt*((float)progress/100);
                    float totalamtval=billamt+tipamtval;
                    String tipans=""+tipamtval;
                    String totalans=""+totalamtval;
                    tipamtbox.setText(tipans);
                    totalamtbox.setText(totalans);
                    statusbox.setText(" ");
                }


            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }




}