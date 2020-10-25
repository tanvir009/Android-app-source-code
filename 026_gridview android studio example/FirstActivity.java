package com.example.my;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity{

    int [] flags = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan, R.drawable.bahrain,
            R.drawable.bangladesh,R.drawable.bhutan, R.drawable.china, R.drawable.india,
            R.drawable.japan, R.drawable.nepal, R.drawable.pakistan,R.drawable.srilanka};
    String[] countryNames;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        countryNames = getResources().getStringArray(R.array.country_name);
        gridView = findViewById(R.id.gridViewId);

        CustomAdapter adapter = new CustomAdapter(this, countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryNames[i];
                Toast.makeText(FirstActivity.this, value+" is selected",Toast.LENGTH_SHORT).show();
            }
        });
    }
}