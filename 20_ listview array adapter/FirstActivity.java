package com.example.my;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity{

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        listView = findViewById(R.id.listViewId);
        final String[] countryName =getResources().getStringArray(R.array.country_name);
                                                            //   present             //followed layout   //set in which view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(FirstActivity.this, R.layout.sample_view, R.id.textViewId,countryName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryName[i];
                Toast.makeText(FirstActivity.this,value+" "+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

}