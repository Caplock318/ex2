package com.example.huyang.myapplication;

import org.litepal.crud.LitePalSupport;

public class Course extends LitePalSupport {
    private String url;
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
