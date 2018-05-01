package com.example.cdoherty.mvpdagger.View;

import android.util.Log;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;

import java.util.ArrayList;

public class AdapterPresenter implements IAdapterPresenter {

    private ArrayList<Item> items = new ArrayList<>();
    private IAdapterView adapterView;
    public final String TAG = this.getClass().getSimpleName();

    public AdapterPresenter(IAdapterView adapterView) {
        this.adapterView = adapterView;
    }

    @Override
    public void bindRowAtPosition(int position, RowView rowView) {
        Item item = items.get(position);
        rowView.setOwnerName(item.getOwner().getDisplayName());
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: " + items.size());
        return items.size();
    }

    //todo get list of ob
}
