package com.example.huyang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.tauth.UiError;

public class layout extends AppCompatActivity implements HttpListener ,QQLogin.QQLoginListener{
    QQLogin qqLogin;

    private ImageButton imbutton;
    private Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        qqLogin = new QQLogin("1107957445",this,this);
        ImageButton textView_create_back = findViewById(R.id.imageButton2);
        textView_create_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout.this, activity_test2.class);
                startActivity(intent);
            }
        });

        Button imageView_qq = findViewById(R.id.button_qq);
        imageView_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qqLogin.launchQQLogin(layout.this);
            }
        });

        imbutton = (ImageButton) findViewById(R.id.imageButton2);
        imbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(layout.this, activity_test2.class);
                startActivity(i);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(layout.this, Register.class);
                startActivity(i);
            }
        });
        Button bt;

        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText temp_username, temp_password;
                temp_username = (EditText) findViewById(R.id.editText);
                temp_password = (EditText) findViewById(R.id.editText2);

               // String temp_json = "{'user_data':[{'email': '" + temp_username + "', 'password': '" + temp_password + "']}";
                User user = new User(temp_username.getText().toString(), temp_password.getText().toString());



                NetComm userTask = new NetComm("http://192.168.2.129:8000/login",
                        "POST", layout.this);
                userTask.execute(getRequestBody(user));


            }


        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        qqLogin.registerResultListener(requestCode, resultCode, data);
    }

    @Override
    public void onQQLoginSuccess(JSONObject jsonObject) {
        ToastUtil.showToast(this, "登陆成功！");
        Intent intent = new Intent(layout.this, activity_test2.class);
        startActivity(intent);
        layout.this.finish();
    }
    @Override
    public void onQQLoginCancel() {
        ToastUtil.showToast(this, "取消登陆！");
    }

    @Override
    public void onQQLoginError(UiError uiError) {
        ToastUtil.showToast(this, "登陆失败！");
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

    public static RequestBody getRequestBody(User user) {
        RequestBody requestBody;
        requestBody = new FormBody.Builder()
                .add("email", user.getEmail())
                .add("password", user.getPassword())
                .build();
        return requestBody;
    }
}