package com.example.advice;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TourCollectionAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TourCollectionAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
           return new Healthyfood();
        } else if (position == 1) {
            return new Traning();
        } else {
            return new BodyCare();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.Bodycare);
        } else if (position == 1) {
            return mContext.getString(R.string.Traning);
        } else {
            return mContext.getString(R.string.Healthyfood);
        }
    }
}