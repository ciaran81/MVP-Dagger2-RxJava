package com.example.cdoherty.mvpdagger.MVP.Interactor;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;

import java.util.ArrayList;
import java.util.List;

public interface ViewListener {
    void updateUI(ArrayList<Item> response);
}
