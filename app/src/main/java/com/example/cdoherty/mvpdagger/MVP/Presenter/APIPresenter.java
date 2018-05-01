package com.example.cdoherty.mvpdagger.MVP.Presenter;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;
import com.example.cdoherty.mvpdagger.MVP.Interactor.APIListener;
import com.example.cdoherty.mvpdagger.MVP.Interactor.InteractorImpl;
import com.example.cdoherty.mvpdagger.MVP.Interactor.ViewListener;
import com.example.cdoherty.mvpdagger.MVP.Model.ModelAPI;
import com.example.cdoherty.mvpdagger.View.IAdapterPresenter;
import com.example.cdoherty.mvpdagger.View.RowView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by cdoherty on 30/03/2018.
 */

public class APIPresenter implements APIListener {

    private ViewListener viewListener;

    @Inject
    ModelAPI modelAPI;

    public APIPresenter(ViewListener viewListener) {
        this.viewListener = viewListener;
        modelAPI.setListener(this);
    }



    public void loadList() {
        modelAPI.loadFromAPI();
        modelAPI.isContextNull();
    }

    @Override
    public void updateResponse(ArrayList<Item> response) {
        viewListener.updateUI(response);
    }

}
