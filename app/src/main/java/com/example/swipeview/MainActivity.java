package com.example.swipeview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {

    ActionBar actionBar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.vp);
        actionBar = getSupportActionBar();
        viewPager.setAdapter(new myAdap(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {


            }
        });
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab t1 = actionBar.newTab();
        t1.setText("TabOne");
        t1.setTabListener(this);

        ActionBar.Tab t2 = actionBar.newTab();
        t2.setText("TabTwo");
        t2.setTabListener(this);

        ActionBar.Tab t3 = actionBar.newTab();
        t3.setText("TabThree");
        t3.setTabListener(this);

        actionBar.addTab(t1);
        actionBar.addTab(t2);
        actionBar.addTab(t3);


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}

class myAdap extends FragmentStatePagerAdapter {

    public myAdap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        if (i == 0)
            fragment = new One();
        if (i == 1)
            fragment = new Two();
        if (i == 2)
            fragment = new Three();
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
