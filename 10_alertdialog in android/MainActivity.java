package com.example.my;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button exitBUtton;
    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitBUtton = findViewById(R.id.buttonId);
        exitBUtton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        //for setting title
        alertDialogBuilder.setTitle(R.string.title_text);

        //for setting message
        alertDialogBuilder.setMessage(R.string.message_text);

        //for setting icon
        alertDialogBuilder.setIcon(R.drawable.question);

        //prevent to click outside of alert dialogue
        alertDialogBuilder.setCancelable(false);

        //set positive button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //exit
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"You click on no",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel(); // remaining same position.
            }
        });

        alertDialogBuilder.setNeutralButton("cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You clicked on cancle",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}