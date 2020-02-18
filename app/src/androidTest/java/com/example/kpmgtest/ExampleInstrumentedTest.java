package com.example.kpmgtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.kpmgtest.async.GetImageInfo;
import com.example.kpmgtest.common.CmmnUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.kpmgtest", appContext.getPackageName());
    }

    @Test
    public void getImageInfo(){
//        //이미지 서버에 전달하기
//        HashMap<String, String> requestParam = new HashMap<>();
//        //drawble 이미지 bitmap으로 변경
//        Drawable drawable = getClass().getResources().getDrawable(R.drawable.peach);
//        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
//        String bitmapToString="";
//
//        //비트맵을 String 형태로 변환
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
//        byte[] byteArray = stream.toByteArray();
//        bitmapToString = Base64.encodeToString(byteArray, Base64.DEFAULT);
//
//        requestParam.put("image",bitmapToString);//요청에 이미지 추가
//        requestParam.put("id","test"); //요청에 사용자 아이디 추가
//
//        //요청을 전달할 ascyntask 실행
//        new GetImageInfo().execute(CmmnUtil.IMAGE_INFO_GET,requestParam);

    }

    @Test
    public void hello(){

    }




}
