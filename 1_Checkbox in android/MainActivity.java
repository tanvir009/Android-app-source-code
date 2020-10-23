package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox milkCheckBox, sugarCheckBox, waterCheckBox;
    private  Button showButton;
    private TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milkCheckBox = findViewById(R.id.milk_text);
        sugarCheckBox = findViewById(R.id.sugar_text);
        waterCheckBox = findViewById(R.id.water_text);

        showButton = findViewById(R.id.showButtonId);
        resultTextView = findViewById(R.id.resultTextViewId);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();

                if(milkCheckBox.isChecked())
                {
                    String value = milkCheckBox.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(sugarCheckBox.isChecked())
                {
                    String value = sugarCheckBox.getText().toString();
                    stringBuilder.append(value+" ");
                }
                if(waterCheckBox.isChecked())
                {
                    String value = waterCheckBox.getText().toString();
                    stringBuilder.append(value+" ");
                }
                stringBuilder.append("is ordered"+"\n");
                resultTextView.setText(stringBuilder);
            }
        });
    }
}