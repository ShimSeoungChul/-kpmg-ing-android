package com.example.kpmgtest.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CmmnUtil {
    //private static String URL = "http://49.247.215.15:8080";
    private static String URL = "http://49.247.215.15:8080";
    public static  final String IMAGE_INFO_GET = URL + "/images/getImageInfo";
    public static  final String HELLO_WORLD = URL + "/helloWorld";
    public static  final String IMAGE_INFO_UPDATE = URL + "/images/updateImageInfo";
    public static  final String OCR_INFO_GET = URL + "/ocr/getOcrInfo";
    public static final String USER_POINT_GET = URL + "/users";

    public static String POST(String url, String jsonStr) throws Exception {
        /**
         * http://ourcstory.tistory.com/51
         */
        // OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String PUT(String url, String jsonStr) throws Exception {
        /**
         * http://ourcstory.tistory.com/51
         */
        // OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .put(body)
                .build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static String GET(String url) throws Exception {
        /**
         * http://ourcstory.tistory.com/51
         */
        // OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static String hashMapToJsonString(HashMap<String, String> map){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }


}
