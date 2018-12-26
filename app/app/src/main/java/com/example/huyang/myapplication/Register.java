package com.example.huyang.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Register extends AppCompatActivity implements HttpListener{


    private ImageButton imbutton;
    public String jsonData;
    public String url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        imbutton = (ImageButton) findViewById(R.id.imageButton3);
        imbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this , activity_test2.class);
                startActivity(i);
            }
        });
        Button bt;

        bt = (Button) findViewById(R.id.button4);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                EditText temp_username, temp_password;
                temp_username = (EditText) findViewById(R.id.editText3);
                temp_password = (EditText) findViewById(R.id.editText4);
                User user = new User(temp_username.getText().toString(), temp_password.getText().toString());



                   NetComm userTask = new NetComm("http://192.168.2.129:8000/register", "POST", Register.this);
                   userTask.execute(getRequestBody(user));



            }
        });


    }
    public static RequestBody getRequestBody(User user) {
        RequestBody requestBody;
        requestBody = new FormBody.Builder()
                .add("email", user.getEmail())
                .add("password", user.getPassword())
                .build();
        return requestBody;
    }

    public void onSuccess(JsonData jsonData) {

        ToastMessage.showToast(this, jsonData.getReceiptMessage());
        this.finish();
    }

    @Override
    public void onFailure(int failure_code, String failure_data) {
        ToastMessage.showToast(this,
               "登录失败");
    }
    /*//解析json
    private void parseJSON(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            int code = jsonObject.getInt("code");
            String data = jsonObject.getString("data");
            JSONObject jsonObject1 = new JSONObject(data);
            String username = jsonObject1.getString("username");
            String email = jsonObject1.getString("email");

            // Picasso
            // VideoView
            //
            //  视频源vgfame.top:8000/stream_video
        } catch (JSONException e) {

        }
    }
    */
}
