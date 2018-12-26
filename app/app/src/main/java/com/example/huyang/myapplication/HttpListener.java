package com.example.huyang.myapplication;

public interface HttpListener {
    void onSuccess(JsonData jsonData);
    void onFailure(int failure_code, String message);
}
