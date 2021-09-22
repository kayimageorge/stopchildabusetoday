package com.example.stopchildabusetoday;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);


        getSupportActionBar().setTitle("Videos about Child Abuse");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VideoView videoView=findViewById(R.id.video);

        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.message));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
}