package com.example.huyang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Clsaacontent extends AppCompatActivity {

     private ImageButton imbutton4;
     private Button butn1;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_content);

        imbutton4 = (ImageButton) findViewById(R.id.imageButton4);
        imbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Clsaacontent.this , MainActivity.class);
                startActivity(i);
            }
        });

        butn1 = (Button) findViewById(R.id.button7);
        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Clsaacontent.this , TeacherMessage.class);
                startActivity(i);
            }
        });
    }



}
