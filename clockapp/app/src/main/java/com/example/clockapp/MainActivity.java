package com.example.clockapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import  android.widget.TimePicker;
import android.os.Bundle;
import  android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Calendar selectedTime;
    private boolean iniflag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button) findViewById(R.id.button);
        selectedTime = Calendar.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker tp = findViewById(R.id.gettime);

                if (selectedTime != null) {
                    int hour = tp.getHour();
                    int minute =tp.getMinute();
                    selectedTime.set(Calendar.HOUR_OF_DAY, hour);
                    selectedTime.set(Calendar.MINUTE, minute);
                    selectedTime.set(Calendar.SECOND, 0);
                    selectedTime.set(Calendar.MILLISECOND, 0);
                    iniflag=true;
                } else {
                    Log.e("MainActivity", "selectedTime is null");
                }
            }
        });

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                checkTime();
                handler.postDelayed(this, 1000); // Check every second
            }
        }, 1000);
    }
    private void checkTime(){
        TextView tv=findViewById(R.id.textView2);
        if(selectedTime!=null && iniflag) {
            Calendar currentTime=Calendar.getInstance();
            if(currentTime.after(selectedTime) ){
                tv.setText("Alarm ringing");
                tv.setTextColor(Color.GREEN);
            }
            else{
                long timeDifferenceMillis = selectedTime.getTimeInMillis() - currentTime.getTimeInMillis();
                long secondsRemaining = timeDifferenceMillis / 1000;
                long hours = secondsRemaining / 3600;
                long minutes = (secondsRemaining % 3600) / 60;
                long seconds = secondsRemaining % 60;
                String remainingTime = String.format("Time remaining: %02d:%02d:%02d", hours, minutes, seconds);
                tv.setText(remainingTime);
                tv.setTextColor(Color.RED);
            }
        }
        else {
            tv.setText("Set the alarm");
            tv.setTextColor(Color.BLUE);
        }
    }
}