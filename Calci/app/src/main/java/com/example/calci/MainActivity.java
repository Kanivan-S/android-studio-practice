package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static String expr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Button button0 =(Button) findViewById(R.id.button0);
       Button button1 = findViewById(R.id.button1);
       Button button2 = findViewById(R.id.button2);
       Button button3 = findViewById(R.id.button3);
       Button button4 = findViewById(R.id.button4);
       Button button5 = findViewById(R.id.button5);
       Button button6 = findViewById(R.id.button6);
       Button button7 = findViewById(R.id.button7);
       Button button8 = findViewById(R.id.button8);
       Button button9 = findViewById(R.id.button9);
       Button buttonplus=findViewById(R.id.buttonplus);
       Button buttonminus=findViewById(R.id.buttonminus);
       Button buttondiv=findViewById(R.id.buttondiv);
       Button buttonmul=findViewById(R.id.buttonmul);
       Button buttondot=findViewById(R.id.buttondot);
       Button buttoneql=findViewById(R.id.buttoneql);
       Button buttonlbrac=findViewById(R.id.buttonlbrac);
       Button buttonrbrac=findViewById(R.id.buttonrbrac);
       Button buttonclr=findViewById(R.id.buttonclr);
        Button buttonac=findViewById(R.id.buttonac);
        buttoneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Context context  = Context.enter();
                    context.setOptimizationLevel(-1);
                    Scriptable scriptable = context.initStandardObjects();
                    String finalResult =  context.evaluateString(scriptable,expr,"Javascript",1,null).toString();
                    Log.d("ExpressionResult", "Result: " + finalResult);
                    EditText ansbox=findViewById(R.id.ansbox);
                    ansbox.setText(finalResult);

                }
                catch (Exception e){
                    Log.e("Error #$#", e.toString());
                    EditText ansbox=findViewById(R.id.ansbox);
                    ansbox.setText("Error");
                }
                finally {
                    // Exit the JavaScript context

                    Context.exit();

                }
            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "+" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr =expr.length()>=2?expr.substring(0,expr.length()-1):"";
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr ="";
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "-" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "*" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "/" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonlbrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "(" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttonrbrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += ")" ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "." ;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
       button0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               expr += "" + 0;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
           }
       });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        expr += "" + 1;
        EditText box=findViewById(R.id.exprbox);
        box.setText(expr);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 2;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 3;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 4;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 5;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 6;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 7;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 8;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr += "" + 9;
                EditText box=findViewById(R.id.exprbox);
                box.setText(expr);
            }
        });
    }
}