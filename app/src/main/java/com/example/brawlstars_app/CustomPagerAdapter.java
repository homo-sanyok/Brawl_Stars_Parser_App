package com.example.brawlstars_app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

//Адаптер фрагментов для PageView
public class CustomPagerAdapter extends FragmentPagerAdapter {

    public CustomPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount(){
        return 2;
    }

    @Override
    public Fragment getItem(int pos){
        switch (pos){
            case 0:
                return  new FirstFragment();
            case 1:
                return new SecondFragment();
        }
        return null;
    }
}