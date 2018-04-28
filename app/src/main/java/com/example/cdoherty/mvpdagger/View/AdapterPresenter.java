package com.example.cdoherty.mvpdagger.View;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;

import java.util.ArrayList;

public class AdapterPresenter implements IAdapterPresenter {

    private ArrayList<Item> items;

    public AdapterPresenter() {
    }

    @Override
    public void bindRowAtPosition(int position, RowView rowView) {
        Item item = items.get(position);
        rowView.setOwnerName(item.getOwner().getDisplayName());
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
