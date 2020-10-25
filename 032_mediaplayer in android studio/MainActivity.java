package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton PlayButton, PauseButton;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton = findViewById(R.id.playButtonId);
        PauseButton = findViewById(R.id.pauseButtonId);

        mediaPlayer = MediaPlayer.create(this, R.raw.dhoom1);

        PlayButton.setOnClickListener(this);
        PauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.playButtonId)
        {
            if(mediaPlayer != null)
            {
                mediaPlayer.start();
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this,"song played "+duration,Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId() == R.id.pauseButtonId)
        {
            if(mediaPlayer != null)
            {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "song paused", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}