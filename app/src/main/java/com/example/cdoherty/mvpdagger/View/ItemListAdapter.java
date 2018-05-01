package com.example.cdoherty.mvpdagger.View;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;
import com.example.cdoherty.mvpdagger.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemAdaptedHolder>
        implements IAdapterView {

    private ArrayList<Item> items;
    private static final String TAG = ItemListAdapter.class.getSimpleName();
    private AdapterPresenter adapterPresenter;

    public ItemListAdapter() {
        this.adapterPresenter = new AdapterPresenter(this);
    }

    @Override
    public ItemAdaptedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemAdaptedHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdaptedHolder holder, int position) {
        adapterPresenter.bindRowAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        return adapterPresenter.getCount();
    }

    public void setItems(ArrayList<Item> items) {
        updateItemList(items);
    }

    private synchronized void updateItemList(ArrayList<Item> items) {
        try {
            this.items = items;
        } finally {
            notifyDataSetChanged();
        }
    }


    class ItemAdaptedHolder extends RecyclerView.ViewHolder implements RowView {

        TextView ownerTextView;

        private ItemAdaptedHolder(View itemView) {
            super(itemView);
            ownerTextView = itemView.findViewById(R.id.item_text);
        }


        @Override
        public void setOwnerName(String name) {
            ownerTextView.setText(name);
        }
    }
}
