package com.example.swipeview;


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
