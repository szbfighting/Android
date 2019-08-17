package com.example.playaudiotest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.szb);
        Button play = (Button)findViewById(R.id.play);
        Button pause = (Button)findViewById(R.id.pause);
        Button stop = (Button)findViewById(R.id.stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                mediaPlayer.start();
                break;
            case R.id.pause:
                mediaPlayer.pause();
                break;
            case R.id.stop:
                mediaPlayer.reset();
                mediaPlayer = MediaPlayer.create(this,R.raw.szb);
                Toast.makeText(this, "定位至开头", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
