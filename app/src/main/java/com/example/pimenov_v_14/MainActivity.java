package com.example.pimenov_v_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    boolean isStarted;
    float startX, startY;
    static int MIN_DISTANCE = 150;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tableTextView);
        tv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                float dx = event.getX() - startX;
                float dy = event.getY() - startY;
                if(calcDist(dx, dy) >= MIN_DISTANCE) {
                    int angle = calcAngle(dx, dy);
                    if(angle>=0 && angle<=45 || angle>=315 && angle<=360) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
                startX = startY = 0;
                break;
            default:
                startX = startY = 0;
        }

        return true;
    }

    private int calcAngle(float dx, float dy) {
        return (int) ((Math.atan2(dy, dx) + Math.PI)*180/Math.PI + 180) % 360;
    }

    private double calcDist(float dx, float dy) {
        return Math.sqrt(dx*dx+dy*dy);
    }
}