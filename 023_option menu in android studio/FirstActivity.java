package com.example.my;

import androidx.annotation.NonNull;
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

public class FirstActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    @Override
    //fetch menu_layout xml file in java file
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.settingId)
        {
            Toast.makeText(FirstActivity.this, "Setting is selected",Toast.LENGTH_SHORT).show();
            return true; // method return boolean value
        }
        else if(item.getItemId() == R.id.shareId)
        {
            Toast.makeText(FirstActivity.this,"Share is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.feedbackId)
        {
            Toast.makeText(FirstActivity.this,"Feedback is selected",Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.aboutUsId)
        {
            Toast.makeText(FirstActivity.this,"About us is selected",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}