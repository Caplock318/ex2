package com.example.huyang.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.MediaController;



public class Videoshow extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_show);

        VideoView runvideo=(VideoView)this.findViewById(R.id.videoView);
        runvideo.setMediaController(new MediaController(this));
        Uri uri = Uri.parse("http://vgfame.top:8000/stream_video");

        runvideo.setVideoURI(uri);

        runvideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ToastUtil.showToast(Videoshow.this, "教程结束啦！");
            }
        });
        runvideo.start();
    }

}
