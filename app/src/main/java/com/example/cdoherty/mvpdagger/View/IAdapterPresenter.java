package com.example.cdoherty.mvpdagger.View;

public interface IAdapterPresenter {
    void bindRowAtPosition(int position, RowView rowView);

    int getCount();
}
