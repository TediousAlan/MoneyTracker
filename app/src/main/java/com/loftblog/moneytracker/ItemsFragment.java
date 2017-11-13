package com.loftblog.moneytracker;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ItemsFragment extends android.support.v4.app.Fragment {

    public static final int TYPE_EXPENSE = 0;
    public static final int TYPE_INCOME = 1;
    private static final int TYPE_UNKNOWN = -1;
    private static final String KEY_TYPE = "TYPE";

    private int type = TYPE_EXPENSE;


    public static ItemsFragment createItemsFragment(int type) {
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ItemsFragment.KEY_TYPE, ItemsFragment.TYPE_EXPENSE);
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
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new ItemsAdapter());

        type = getArguments().getInt(KEY_TYPE, TYPE_UNKNOWN);
        if (type == TYPE_UNKNOWN) {
            throw new IllegalStateException("Unknown Fragment Type");
        }

    }
}
