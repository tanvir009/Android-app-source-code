package com.example.my;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity{

    private ListView listView;
    private String[] countryName;
    int [] flags = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan, R.drawable.bahrain,
                R.drawable.bangladesh,R.drawable.bhutan, R.drawable.china, R.drawable.india,
                R.drawable.japan, R.drawable.nepal, R.drawable.pakistan,R.drawable.srilanka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        countryName = getResources().getStringArray(R.array.country_name);
        listView = findViewById(R.id.listViewId);
        CustomAdapter adapter = new CustomAdapter(this, countryName,flags);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryName[i];
                Toast.makeText(FirstActivity.this, value,Toast.LENGTH_SHORT).show();
            }
        });
    }

}