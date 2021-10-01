package com.app.tabdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tab_layout;
    ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab_layout = findViewById(R.id.tab_layout);
        view_pager = findViewById(R.id.view_pager);
        /*FragmentManager fm = getSupportFragmentManager();
        view_pager.setAdapter(new MyAdapter(fm));*/
        view_pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tab_layout.setupWithViewPager(view_pager);
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chat";
                case 1:
                    return "Status";
                case 2:
                    return "Call";
            }
            return null;
            // return super.getPageTitle(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new ChatFragment();
            }
            if(position == 1){
                return new StatusFragment();
            }
            if(position == 2){
                return new CallingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}