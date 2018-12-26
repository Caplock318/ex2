package com.example.huyang.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpConnect {
    public static Response postMyMessage(String url, RequestBody requestBody)throws IOException

    {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return client.newCall(request).execute();
    }

    public static Response getMyMessage(String url) throws IOException{
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();
    }


    public static  JsonData transResponseData(String responseData) throws JSONException{
        JSONObject jsonObject = new JSONObject(responseData);
        JSONArray jsonArray = new JSONArray();
        JsonData jsondata = new JsonData(jsonArray,200,"" );
        jsondata.data = jsonObject.getJSONArray("data");
        jsondata.state = jsonObject.getInt("code");
        jsondata.receiptMessage = jsonObject.getString("message");
        return jsondata;
    }


}
