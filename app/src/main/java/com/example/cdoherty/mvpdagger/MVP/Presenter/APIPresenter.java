package com.example.cdoherty.mvpdagger.MVP.Presenter;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;
import com.example.cdoherty.mvpdagger.MVP.Interactor.APIListener;
import com.example.cdoherty.mvpdagger.MVP.Interactor.InteractorImpl;
import com.example.cdoherty.mvpdagger.MVP.Interactor.ViewListener;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by cdoherty on 30/03/2018.
 */

public class APIPresenter implements APIListener {

    private InteractorImpl interactor;
    private ViewListener viewListener;

    @Inject
    APIPresenter(InteractorImpl interactor, ViewListener viewListener) {
        this.interactor = interactor;
        this.viewListener = viewListener;
        interactor.setListener(this);
    }

    public void loadList(){
        interactor.loadFromAPI();
        interactor.isContextNull();
    }

    @Override
    public void updateResponse(ArrayList<Item> response) {
        viewListener.updateUI(response);
    }
}
