package com.example.mohini.tablayoutdemo.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.mohini.tablayoutdemo.R;

import java.util.ArrayList;
import java.util.List;

import Fragments.OneFragment;
import Fragments.ThreeFragment;
import Fragments.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpIDS();
    }

    private void setUpIDS(){

        toolbar = findViewById(R.id.toolbarInMainActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewPagerInMainActivity);
        tabLayout = (TabLayout) findViewById(R.id.tabInMainActivity);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void  setUpViewPager(ViewPager viewPager){

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "One");
        adapter.addFragment(new TwoFragment(), "Two");
        adapter.addFragment(new ThreeFragment(), "Three");
        viewPager.setAdapter(adapter);
    }

    // Adapter class for view pager
    class ViewPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fm, String title) {
            mFragmentList.add(fm);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }
    }
}
