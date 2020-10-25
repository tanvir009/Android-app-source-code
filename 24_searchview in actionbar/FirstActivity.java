package com.example.my;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //to set title
        this.setTitle("country name");

        listView = findViewById(R.id.listViewId);
        String[] countryName =getResources().getStringArray(R.array.country_name);
        //   present             //followed layout   //set in which view
        adapter = new ArrayAdapter<>(FirstActivity.this, R.layout.sample_view, R.id.textViewId,countryName);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    //clickable listview item
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String value = adapter.getItem(i);
        Toast.makeText(FirstActivity.this,value,Toast.LENGTH_SHORT).show();
    }

    //search view on action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);

        MenuItem menuItem = menu.findItem(R.id.searchViewId);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}