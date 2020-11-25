package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView strawberryImageView, orangeImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strawberryImageView = findViewById(R.id.strawberryImageViewId);
        orangeImageView = findViewById(R.id.orangeImageViewId);

        strawberryImageView.setOnClickListener(this);
        orangeImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.strawberryImageViewId)
        {
            strawberryImageView.setVisibility(View.GONE);
            orangeImageView.setVisibility(View.VISIBLE);
        }
        else if(view.getId() == R.id.orangeImageViewId)
        {
            orangeImageView.setVisibility(View.GONE);
            strawberryImageView.setVisibility(View.VISIBLE);
        }
    }
}