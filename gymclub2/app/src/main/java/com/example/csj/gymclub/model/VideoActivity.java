package com.example.csj.gymclub.model;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.danikula.videocache.HttpProxyCacheServer;
import com.example.csj.gymclub.util.App;
import com.example.csj.gymclub.R;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent = getIntent();
        String title= intent.getStringExtra("title");
        String url=intent.getStringExtra("url");
        Uri uri = Uri.parse( url );

        ImageButton imageButton= (ImageButton) findViewById(R.id.videoRetuenButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView textView=(TextView)findViewById(R.id.videoTitle);
        textView.setText(title);
        videoView = (VideoView)this.findViewById(R.id.videoView );
        //设置视频控制器
        HttpProxyCacheServer proxy = App.getProxy(this);
        String proxyUrl = proxy.getProxyUrl(url);

        videoView.setMediaController(new MediaController(this));
        //播放完成回调

        videoView.setVideoPath(proxyUrl);
        //设置视频路径
        //videoView.setVideoURI(uri);
        //开始播放视频
        videoView.start();
        videoView.requestFocus();

    }



}
