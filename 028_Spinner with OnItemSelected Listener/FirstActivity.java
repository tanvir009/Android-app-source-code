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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity{

    private Spinner spinner;
    String[] countryNames;
    String[] population;
    int [] flags = {R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan, R.drawable.bahrain,
            R.drawable.bangladesh,R.drawable.bhutan, R.drawable.china, R.drawable.india,
            R.drawable.japan, R.drawable.nepal, R.drawable.pakistan,R.drawable.srilanka};
    //to solve the start toast problem
    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        countryNames = getResources().getStringArray(R.array.country_name);
        population = getResources().getStringArray(R.array.population);

        spinner = findViewById(R.id.spinnerId);
        CustomAdapter customAdapter = new CustomAdapter(this, flags, countryNames, population);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                //to solve the start toast problem
                if(isFirstSelection == true)
                {
                    isFirstSelection = false;
                }
                else
                    Toast.makeText(getApplicationContext(), countryNames[i]+"is selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}