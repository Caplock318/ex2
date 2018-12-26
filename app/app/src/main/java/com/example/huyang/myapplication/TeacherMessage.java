package com.example.huyang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class TeacherMessage extends AppCompatActivity{

    private ImageButton imbutton;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_message);

        imbutton = (ImageButton) findViewById(R.id.imageButton);
        imbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeacherMessage.this , Clsaacontent.class);
                startActivity(i);
            }
        });
    }
}
