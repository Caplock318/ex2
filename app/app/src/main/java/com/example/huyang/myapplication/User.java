package com.example.huyang.myapplication;

import org.litepal.crud.LitePalSupport;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class User extends LitePalSupport {
    String email;
    String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
