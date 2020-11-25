package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bangladeshButton, indiaButton,pakistanButton;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bangladeshButton = findViewById(R.id.bangladeshButtonId);
        indiaButton = findViewById(R.id.indiaButtonId);
        pakistanButton = findViewById(R.id.pakistanButtonId);

        bangladeshButton.setOnClickListener(this);
        indiaButton.setOnClickListener(this);
        pakistanButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.bangladeshButtonId)
        {
            intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("name","bangladesh");
            startActivity(intent);
        }
        if(view.getId() == R.id.indiaButtonId)
        {
            intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("name","india");
            startActivity(intent);
        }
        if(view.getId() == R.id.pakistanButtonId)
        {
            intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("name", "pakistan");
            startActivity(intent);
        }
    }

}