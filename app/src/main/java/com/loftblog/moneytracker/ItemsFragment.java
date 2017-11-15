package com.loftblog.moneytracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loftblog.moneytracker.api.Api;

import java.io.IOException;
import java.util.List;

import static android.app.Activity.RESULT_OK;
public class ItemsFragment extends Fragment {


    private static final String KEY_TYPE = "TYPE";
    private static final int LOADER_ITEMS = 0;
    private String type = Item.TYPE_UNKNOWN;
    private ItemsAdapter adapter;
    private Api api;

    public static ItemsFragment createItemsFragment(String type) {
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.KEY_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getArguments().getString(KEY_TYPE, Item.TYPE_UNKNOWN);

        if (type.equals(Item.TYPE_UNKNOWN)) {
            throw new IllegalStateException("Unknown Fragment Type");
        }

        adapter = new ItemsAdapter();
        api = ((App) getActivity().getApplication()).getApi();
    }

    @Override
    @Nullable

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.fab_add_item);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                intent.putExtra(AddActivity.EXTRA_TYPE, type);
                startActivityForResult(intent, AddActivity.RC_ADD_ITEM);
            }
        });

        loadItems();
    }

    private void loadItems() {
        getLoaderManager().initLoader(LOADER_ITEMS, null, new LoaderManager.LoaderCallbacks<List<Item>>() {

            @Override
            public Loader<List<Item>> onCreateLoader(int id, Bundle args) {
                return new AsyncTaskLoader<List<Item>>(getContext()) {
                    @Override
                    public List<Item> loadInBackground() {
                        try {
                            List<Item> items = api.items(type).execute().body();
                            return items;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                };
            }


            public void onLoadFinished(Loader<List<Item>> loader, List<Item> items) {
                if (items == null) {
                    showError("Произошла ошибка");
                } else {
                    adapter.setItems(items);
                }
            }

            @Override
            public void onLoaderReset(Loader<List<Item>> loader) {

            }
        }).forceLoad();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AddActivity.RC_ADD_ITEM && resultCode == RESULT_OK) {
            Item item = (Item) data.getSerializableExtra(AddActivity.RESULT_ITEM);
            Toast toast = Toast.makeText(getContext(), item.name, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}

