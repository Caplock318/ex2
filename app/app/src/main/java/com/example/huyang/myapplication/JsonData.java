package com.example.huyang.myapplication;

import org.json.JSONArray;

public class JsonData {
    JSONArray data;
    int state;
    String receiptMessage;

    public JsonData(JSONArray data, int code, String message){
        this.state = code;
        this.data = data;
        this.receiptMessage = message;
    }

    public JsonData(int code, String message){
        this.state = code;
        this.receiptMessage = message;
    }
    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReceiptMessage() {
        return receiptMessage;
    }

    public void setReceiptMessage(String receiptMessage) {
        this.receiptMessage = receiptMessage;
    }

}
