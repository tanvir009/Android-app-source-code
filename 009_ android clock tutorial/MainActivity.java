package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextClock textClock;
    private AnalogClock analogClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock = findViewById(R.id.textClockId);
        analogClock = findViewById(R.id.analogClockId);

        textClock.setOnClickListener(this);
        analogClock.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            if(view.getId() == R.id.textClockId)
            {
                Toast.makeText(MainActivity.this,"text clock",Toast.LENGTH_SHORT).show();
            }
            else if(view.getId() == R.id.analogClockId)
            {
                Toast.makeText(MainActivity.this,"anlog clock",Toast.LENGTH_SHORT).show();
            }
    }
}