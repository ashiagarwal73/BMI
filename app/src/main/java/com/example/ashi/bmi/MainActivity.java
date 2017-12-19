package com.example.ashi.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.color.holo_blue_light;
import static android.R.color.holo_green_light;
import static android.R.color.holo_red_light;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    RadioGroup rg,rg2;
    double w,h;
    RelativeLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        b1=(Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.button);
        rg= (RadioGroup) findViewById(R.id.rg);
        rg2= (RadioGroup) findViewById(R.id.rg2);
        ll= (RelativeLayout) findViewById(R.id.ll);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.optionsmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(this, "color changed", Toast.LENGTH_SHORT).show();
                ll.setBackgroundColor(Color.GREEN);
                break;
            case R.id.i2:
                Toast.makeText(this, "Color changed....", Toast.LENGTH_SHORT).show();
                ll.setBackgroundColor(Color.BLUE);
                break;
            case R.id.i3:
                Toast.makeText(this, "color changed", Toast.LENGTH_SHORT).show();
                ll.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.i4:
                Toast.makeText(this, "Color changed....", Toast.LENGTH_SHORT).show();
                ll.setBackgroundColor(Color.WHITE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void click(View v)
    {
        w = Double.parseDouble(e1.getText().toString());
        h =Double.parseDouble(e2.getText().toString())/100;
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton rb = (RadioButton) findViewById(i);
                String s = rb.getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton rb=(RadioButton)findViewById(i);
                String s= rb.getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        if(rg.getCheckedRadioButtonId()==R.id.pounds)
            {
                w = w/2.2046;
            }
        if(rg2.getCheckedRadioButtonId()==R.id.feet)
            {
                h =(h/3.28)*100;
            }
        double bmi=w/(h*h);
        Intent i=new Intent(MainActivity.this,SecondActivity.class);
        i.putExtra("bmi",bmi);
        //Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel:123"));
        startActivity(i);
    }
    public void clickMe(View v)
    {
        e1.setText("");
        e2.setText("");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
        b.setTitle("ALERT");
        b.setMessage("Do you really want to exit");
        b.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "ok pressed", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
            }
        });
        b.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "cancelled alert", Toast.LENGTH_SHORT).show();
            }
        });
        b.show();
    }
}
