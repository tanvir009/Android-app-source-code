package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.imageViewId);
        textView = findViewById(R.id.textViewId);

        //adding back button to the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            String countryName = bundle.getString("name");
            showDetails(countryName);
        }
    }

    //back button listener
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void showDetails(String countryName)
    {
        if(countryName.equals("bangladesh"))
        {
            imageView.setImageResource(R.drawable.dhaka);
            textView.setText(R.string.bangladesh_text);
        }
        else if(countryName.equals("india"))
        {
            imageView.setImageResource(R.drawable.delhi);
            textView.setText(R.string.india_text);
        }
        else if(countryName.equals("pakistan"))
        {
            imageView.setImageResource(R.drawable.badshahi_mosque);
            textView.setText(R.string.pakistan_text);
        }
    }
}