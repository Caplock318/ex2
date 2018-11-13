package com.example.huyang.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.*;
import android.widget.TextView;
import android.widget.*;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private FragmentAdapter fragmentAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentAdapter.showFragment(1);
                    break;

                case R.id.navigation_dashboard:
                    fragmentAdapter.showFragment(0);
                    break;
                case R.id.navigation_notifications:
                    fragmentAdapter.showFragment(2);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);




        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_class));
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_recommend));
        fragmentList.add(getSupportFragmentManager().findFragmentById(R.id.fragment_selfmessage));
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragmentList);
        fragmentAdapter.showFragment(1);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
