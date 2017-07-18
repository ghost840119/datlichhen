package com.example.ghost840119.datlichhen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.ghost840119.datlichhen.fragments.FragmentsListFrend;
import com.example.ghost840119.datlichhen.fragments.FragmentsListEven;

/**
 * Created by ghost840119 on 6/9/2017.
 */

public class PagerApdater extends FragmentStatePagerAdapter {
    private int intNumberTab;

    public PagerApdater(FragmentManager fm, int intNumberTab) {
        super(fm);
        this.intNumberTab = intNumberTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentsListEven tabEvent = new FragmentsListEven();
                return tabEvent;
            case 1:
                FragmentsListFrend tabFriend = new FragmentsListFrend();
                return tabFriend;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return intNumberTab;
    }
}
