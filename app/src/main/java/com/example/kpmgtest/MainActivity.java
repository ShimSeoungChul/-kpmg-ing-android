package com.example.kpmgtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.kpmgtest.async.GetImageInfo;
import com.example.kpmgtest.async.GetOcrInfo;
import com.example.kpmgtest.async.GetUserPoint;
import com.example.kpmgtest.async.UpdateImageInfo;
import com.example.kpmgtest.common.CmmnUtil;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void getImageInfo(View view){
        //이미지 서버에 전달하기
        HashMap<String, String> requestParam = new HashMap<>();
        //drawble 이미지 bitmap으로 변경
        Drawable drawable = getResources().getDrawable(R.drawable.peach,null);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        String bitmapToString="";

        //비트맵을 String 형태로 변환
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
        byte[] byteArray = stream.toByteArray();
        bitmapToString = Base64.encodeToString(byteArray, Base64.DEFAULT);

        requestParam.put("stringImage",bitmapToString);//요청에 이미지 추가
        requestParam.put("userNm","test"); //요청에 사용자 아이디 추가

        Log.e(tag,CmmnUtil.IMAGE_INFO_GET);

        //요청을 전달할 ascyntask 실행
        new GetImageInfo().execute(CmmnUtil.IMAGE_INFO_GET,requestParam);
    }

    public void UpdateImageInfo(View view){
        HashMap<String, String> requestParam = new HashMap<>();
        requestParam.put("fileId","8e2c5e4c2729493f82e8c5bd2aa7089e653");
        requestParam.put("imageName","testtesttest");

        //요청을 전달할 ascyntask 실행
        new UpdateImageInfo().execute(CmmnUtil.IMAGE_INFO_UPDATE,requestParam);
    }

    public void getOcrInfo(View view){
        //이미지 서버에 전달하기
        HashMap<String, String> requestParam = new HashMap<>();
        //drawble 이미지 bitmap으로 변경
        Drawable drawable = getResources().getDrawable(R.drawable.oc1,null);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        String bitmapToString="";

        //비트맵을 String 형태로 변환
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, stream);
        byte[] byteArray = stream.toByteArray();
        bitmapToString = Base64.encodeToString(byteArray, Base64.DEFAULT);

        requestParam.put("stringImage",bitmapToString);//요청에 이미지 추가
        requestParam.put("userNm","test"); //요청에 사용자 아이디 추가

        Log.e(tag,CmmnUtil.OCR_INFO_GET);

        //요청을 전달할 ascyntask 실행
        new GetOcrInfo().execute(CmmnUtil.OCR_INFO_GET,requestParam);
    }

    //사용자의 현재 포인트 가져오기
    public void getUserPoint(View view) {
        //요청을 전달할 ascyntask 실행
        new GetUserPoint().execute(CmmnUtil.USER_POINT_GET+"/test");
    }
}
