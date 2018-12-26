package com.example.huyang.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;

import okhttp3.RequestBody;

public class NetComm extends AsyncTask<RequestBody, Integer, JsonData> {

    private HttpListener listener;
    private String url;
    private String method;

    public NetComm(String url, String method, HttpListener listener) {
        this.url = url;
        this.listener = listener;
        this.method = method;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }



    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate();
    }

    @Override
    protected JsonData doInBackground(RequestBody... requestBodies) {
        try {
            String temp;
            if (method == "POST") {
                temp = HttpConnect.postMyMessage(url, requestBodies[0]).body().string();
            } else if(method == "GET"){
                temp = HttpConnect.getMyMessage(url).body().string();
            }else
                return new JsonData(404, getErrorMessage("非法请求！"));
            //Log.d("Test", "doInBackground: " + jsonData);
            if (!temp.isEmpty()) {
                return HttpConnect.transResponseData(temp);
            } else {
                return new JsonData(404, getErrorMessage("无法连接服务器，请重试"));
            }
        } catch (SocketTimeoutException e) {
            return new JsonData(404, getErrorMessage("无法连接服务器，请重试"));
        }
        catch (IOException e) {
            return new JsonData(404, getErrorMessage("无法正常接收数据，请重试"));
        }catch(JSONException e){
            return new JsonData(404, getErrorMessage("无法正常解析数据，请重试"));
        }
    }

    @Override
    protected void onPostExecute(JsonData jsonData) {
        if (jsonData.getState() == 200) {
            listener.onSuccess(jsonData);
        }else{
            listener.onFailure(jsonData.getState(), jsonData.getReceiptMessage());
        }
    }
    private String getErrorMessage(String error_msg) {
        return "error:" + error_msg;
        //return "{\"error_msg\": \"" + error_msg +"\"}";
    }
}
