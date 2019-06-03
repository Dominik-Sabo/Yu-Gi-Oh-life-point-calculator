package com.sabo.dominik.yu_gi_ohlifepointcalculator;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;
import java.util.Locale;


public class PagerAdapter extends FragmentStatePagerAdapter {


    private static final int NUM_PAGES = 2;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return PlayerFragment.newInstance(MainActivity.getPlayer1Name());
            case 1:
                return Player2Fragment.newInstance(MainActivity.getPlayer2Name());
            default: return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position) {
            case 0:
                return MainActivity.getPlayer1Name();
            case 1:
                return MainActivity.getPlayer2Name();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}
