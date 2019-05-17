package com.example.swipeview;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        setSupportActionBar(toolbar);
        myAdap myAdapter = new myAdap(getSupportFragmentManager());
        myAdapter.add(new One(), "One");
        myAdapter.add(new Two(), "Two");
        myAdapter.add(new Three(), "Three");
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.setBackgroundColor(Color.CYAN);
                        toolbar.setBackgroundColor(Color.CYAN);
                        break;
                    case 1:
                        tabLayout.setBackgroundColor(Color.BLACK);
                        toolbar.setBackgroundColor(Color.BLACK);
                        tabLayout.setTabTextColors(Color.WHITE, Color.YELLOW);
                        toolbar.setTitleTextColor(Color.WHITE);
                        break;
                    case 2:
                        tabLayout.setBackgroundColor(Color.RED);
                        toolbar.setBackgroundColor(Color.RED);
                        break;


                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}

class myAdap extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragList = new ArrayList<>();
    ArrayList<String> fragmenttitle = new ArrayList<>();

    public myAdap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return fragList.get(i);
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void add(Fragment fr, String str) {
        fragList.add(fr);
        fragmenttitle.add(str);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitle.get(position);
    }
}
