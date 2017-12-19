package com.example.ashi.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t4,t5;
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t4= (TextView) findViewById(R.id.t4);
        t5= (TextView) findViewById(R.id.t5);
        b3= (Button) findViewById(R.id.b3);
        final Intent i=getIntent();
        double bmi=i.getDoubleExtra("bmi",0.0);
        t4.setText("B.M.I =    " + String.valueOf(bmi));
        if(bmi<16.0)
        {
            t5.setText("B.M.I STATUS     Severe thinness");
        }
        if(bmi>=16.0&&bmi<17.0)
        {
            t5.setText("B.M.I STATUS     moderate thinness");
        }
        if(bmi>=17.0&&bmi<18.5)
        {
            t5.setText("B.M.I STATUS     mild thinness");
        }
        if(bmi>=18.5&&bmi<25.0)
        {
            t5.setText("B.M.I STATUS     normal");
        }
        if(bmi>=25.0&&bmi<30.0)
        {
            t5.setText("B.M.I STATUS     overweight");
        }
        if(bmi>=30.0&&bmi<35.0)
        {
            t5.setText("B.M.I STATUS     obese class 1");
        }
        if(bmi>=35.0&&bmi<40.0)
        {
            t5.setText("B.M.I STATUS     obese class 2");
        }
        if(bmi>=40.0)
        {
            t5.setText("B.M.I STATUS    obese class 3");
        }
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
