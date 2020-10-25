package com.example.my;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.textViewId);

        Bundle bundle = getIntent().getExtras();
        //to check if bundle is free or not
        if(bundle != null)
        {
            String value = bundle.getString("tag");
            textView.setText(value);
        }
    }
}