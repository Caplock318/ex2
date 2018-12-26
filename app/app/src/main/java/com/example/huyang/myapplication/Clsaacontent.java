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
     private Button butn1,butn10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_content);

        butn10=(Button) findViewById(R.id.button_show_video);
        butn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Clsaacontent.this , Videoshow.class);
                startActivity(i1);
            }
        });

        imbutton4 = (ImageButton) findViewById(R.id.imageButton4);
        imbutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(Clsaacontent.this , activity_test2.class);
                startActivity(i2);
            }
        });

        butn1=(Button) findViewById(R.id.button_coa_info);
        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Clsaacontent.this , CoachList.class);
                startActivity(i3);
            }
        });
//        butn1 = (Button) findViewById(R.id.button7);
//        butn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Clsaacontent.this , CoachList.class);
//                startActivity(i);
//            }
//        });
    }



}
