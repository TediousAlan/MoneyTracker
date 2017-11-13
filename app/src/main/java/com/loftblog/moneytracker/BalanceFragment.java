package com.loftblog.moneytracker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by macbook on 13.11.17.
 */

public class BalanceFragment extends android.support.v4.app.Fragment {

    public static final int TYPE_BALANCE = 2;
    private static final String KEY_TYPE = "TYPE";

    public static BalanceFragment createBalanceFragment(int type) {
        BalanceFragment fragment = new BalanceFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BalanceFragment.KEY_TYPE, BalanceFragment.TYPE_BALANCE);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance, container, false);
        return view;
    }

}



