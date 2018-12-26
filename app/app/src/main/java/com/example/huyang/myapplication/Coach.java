package com.example.huyang.myapplication;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String coachName;
    private String coachTel;
    private String url;
    private int coachNum;
    public ArrayList<Coach> coachList;

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachTel() {
        return coachTel;
    }

    public void setCoachTel(String coachTel) {
        this.coachTel = coachTel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCoachNum() {
        return coachNum;
    }

    public void setCoachNum(int coachNum) {
        this.coachNum = coachNum;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }


    /**
     * json array: {"data":[{"name": "", "telNo": "", "url": ""}, {}, {}], "code": , "error_msg": ""}
     * @param coachList
     * @param jsonArray
     */
    public void setCoachList(List<Coach> coachList, JSONArray jsonArray) {
        try {
            this.setCoachNum(jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                Coach coach = new Coach();
                coach.setCoachName(jsonObject1.getString("name"));
                coach.setCoachTel(jsonObject1.getString("telNo"));
                coach.setUrl(jsonObject1.getString("url"));
                this.coachList.add(coach);
            }
        }catch(JSONException e){
            e.printStackTrace();

            }


        }

}

