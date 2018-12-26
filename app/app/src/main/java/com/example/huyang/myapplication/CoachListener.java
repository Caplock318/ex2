package com.example.huyang.myapplication;

public interface CoachListener {
    void onFailure();
    void onSuccess(Coach coach, JsonData jsonData);
}
