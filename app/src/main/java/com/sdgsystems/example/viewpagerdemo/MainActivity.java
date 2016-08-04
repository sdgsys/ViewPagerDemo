package com.sdgsystems.example.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements DemoFragment.OnFragmentInteractionListener {

    private ViewPager mPager;
    private List<DemoData> mDemoData = new ArrayList<DemoData>();
    private DemoFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new DemoFragmentAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);

        mPager.setAdapter(mAdapter);

        mDemoData.add(new DemoData("Item1", "First item", 1.5));
        mDemoData.add(new DemoData("Item2", "Second item", 2.5));
        mDemoData.add(new DemoData("Item3", "Third item", 5.2));
        mDemoData.add(new DemoData("Item4", "Fourth item", 5.1));
        mDemoData.add(new DemoData("Item5", "Fifth item", 3.8));
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFragmentInteraction(int currentDataPosition) {

    }

    @Override
    public void onFragmentChanged(DemoFragment demoFragment) {
        Log.d("ViewPagerDemo", "Current fragment is now: " + demoFragment.getData().name);
    }

    private class DemoFragmentAdapter extends FragmentPagerAdapter {
        public DemoFragmentAdapter(FragmentManager fm) {
            super(fm); // super tracks this
        }

        @Override
        public Fragment getItem(int position) {
            return DemoFragment.newInstance(mDemoData.get(position));
        }

        @Override
        public int getCount() {
            return mDemoData.size();
        }
    }
}
