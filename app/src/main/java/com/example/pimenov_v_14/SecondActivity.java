package com.example.pimenov_v_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView num1;
    TextView num2;
    TextView num3;
    TextView num4;
    TextView num5;
    TextView num6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        num1 = (TextView) findViewById(R.id.number1);
        num2 = (TextView) findViewById(R.id.number2);
        num3 = (TextView) findViewById(R.id.number3);
        num4 = (TextView) findViewById(R.id.number4);
        num5 = (TextView) findViewById(R.id.number5);
        num6 = (TextView) findViewById(R.id.number6);

        setNum(num1);
        setNum(num2);
        setNum(num3);
        setNum(num4);
        setNum(num5);
        setNum(num6);
    }

    private void setNum(TextView tv) {
        tv.setText(String.valueOf((int) (Math.random()*900+100)));
    }
}