package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    String myText = "<h1>This is heading 1</h1>\n"+
                    "<h2>This is heading 2</h2>\n"+
                    "<h3>This is heading 3</h3>\n"+
                    "<p><u>This is an underline</u></p>\n"+
                    "<p><b>This is a bold</b></p>\n"+
                    "<p><i>This is an italic</i></p>\n"+
                    "programming language order list\n"+
                    "<ol>\n"+
                    "<li>C</li>\n"+
                    "<li>C++</li>\n"+
                    "<li>Java</li>\n"+
                    "</ol>\n\n"+
                    "(a+b)<sup>2</sup> = a<sup>2</sup> + 2ab + b<sup>2</sup>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewId);
        textView.setText(Html.fromHtml(myText));
    }
}