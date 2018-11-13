package com.example.huyang.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter {

    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList;

    public FragmentAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
        this.fragmentManager = fragmentManager;
    }

    public void showFragment(int index) {
        for (Fragment fragment : fragmentList) {
            fragmentManager.beginTransaction().hide(fragment).commit();
        }
        fragmentManager.beginTransaction().show(fragmentList.get(index)).commit();
    }
}
