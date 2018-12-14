package com.example.asus.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> datas = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initDatas();
        initViews();
    }

    private void initDatas() {
        for(int i=1;i<=30;i++){
            datas.add("test"+(i+1));
        }
    }

    private void findViews() {
        tabLayout = findViewById(R.id.TabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private void initViews() {
        for (String tab : datas) {
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }
        for (int i = 0; i < 30; i++) {
            fragments.add(DataFragment.newInstance(i));
        }
        tabLayout.addOnTabSelectedListener(this);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), datas, fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
