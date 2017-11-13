package com.loftblog.moneytracker;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by macbook on 13.11.17.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private final static int PAGE_EXPENSES = 0;
    private final static int PAGE_INCOMES = 1;
    private final static int PAGE_BALANCE = 2;

    private String[] titles;

    public MainPagerAdapter(FragmentManager fm, Resources resources) {
        super(fm);

        titles = resources.getStringArray(R.array.tabs_titles);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_EXPENSES:
                return ItemsFragment.createItemsFragment(ItemsFragment.TYPE_EXPENSE);

            case PAGE_INCOMES:
                return ItemsFragment.createItemsFragment(ItemsFragment.TYPE_INCOME);

            case PAGE_BALANCE:
                return null;
            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
