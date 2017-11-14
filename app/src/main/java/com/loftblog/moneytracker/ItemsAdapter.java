package com.loftblog.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by macbook on 02.11.17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private List<Item> items = Collections.emptyList();


    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return items.size();

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = items.get(position);
        holder.bind(item);
    }


    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;


        ItemViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
        }

        void bind(Item item) {
            name.setText(item.name);
            price.setText(String.valueOf(item.price + "\u20BD"));

        }
    }
}
