package com.example.playvideotest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button play = (Button)findViewById(R.id.play);
        Button pause = (Button)findViewById(R.id.pause);
        Button replay = (Button)findViewById(R.id.replay);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        videoView = (VideoView)findViewById(R.id.video_view);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.amazing));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play:
                videoView.start();
                break;
            case R.id.pause:
                videoView.pause();
                break;
            case R.id.replay:
                videoView.resume();
                break;
            default:
        }
    }
}
