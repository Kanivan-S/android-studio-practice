


package com.example.simple_calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Date;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {
    private HashMap<String,String> store;
    private static String  currentdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        store=new HashMap<String,String>();
        CalendarView cal=findViewById(R.id.calendarView);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                currentdate=""+year+"-"+month+"-"+dayOfMonth;
                updateeve(currentdate);
            }
        });

        Button btn=(Button)findViewById(R.id.addbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ev=findViewById(R.id.editTextText);
                if(currentdate!=null  && store.get(currentdate)!=null ){
                    store.put(currentdate,ev.getText().toString());
                    ev.setText("");
                }
                else{
                    store.put(currentdate,ev.getText().toString());
                    ev.setText("");
                }

            }
        });

    }
    public void updateeve(String  cd){
        TextView tvseve=findViewById(R.id.opstatus);
        tvseve.setText(cd);
        if(cd!=null && store.get(cd)==null){
            tvseve.setText("No events available!");
            tvseve.setTextColor(Color.BLUE);
        }
        else{
            if(cd==null){
                tvseve.setText("Choose date");
                tvseve.setTextColor(Color.RED);
            }
            else{
                tvseve.setText(store.get(cd));
                tvseve.setTextColor(Color.GREEN);
            }
        }
    }
}