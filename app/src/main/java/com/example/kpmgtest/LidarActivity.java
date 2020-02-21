package com.example.kpmgtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.kpmgtest.async.GetLidarVideo;
import com.example.kpmgtest.common.CmmnUtil;

public class LidarActivity extends AppCompatActivity {

    private static final int VIDEOFILE_REQUEST = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lidar);


    }


    public void makeLidarVideo(View view) {
        new GetLidarVideo().execute(CmmnUtil.Lidar_Video_GET+"/test");
    }
}
