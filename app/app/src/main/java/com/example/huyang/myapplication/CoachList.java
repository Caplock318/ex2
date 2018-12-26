package com.example.huyang.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoachList extends AppCompatActivity implements HttpListener {

    private RecyclerView mRecyclerView;
    private  Coach coach;
    private List<Coach> mDataList ;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coach_list);
        initView();
        initData();

    }




    private void initView() {
        //找到这个Listview
        mRecyclerView = (RecyclerView) findViewById(R.id.main_recylist);
        //设置线性管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    /**
     * 初始化数据
     */
    private void initData() {

        NetComm netComm = new NetComm("http://192.168.2.129:8000/coach_list", "POST",CoachList.this);
        netComm.execute(getRequestBody());
        mDataList = coach.getCoachList();

        /*
        设置适配器
         */
        myAdapter = new MyAdapter(mDataList);
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onSuccess(JsonData jsonData) {
        coach.setCoachList(coach.coachList,jsonData.getData());
    }

    @Override
    public void onFailure(int failure_code, String failure_data) {
        ToastMessage.showToast(this,
                "登录失败");
    }

    public static RequestBody getRequestBody() {
        RequestBody requestBody;
        requestBody = new FormBody.Builder()
                .add("course", "Run class")
                .build();
        return requestBody;
    }
}
