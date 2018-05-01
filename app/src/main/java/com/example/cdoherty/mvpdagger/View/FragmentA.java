package com.example.cdoherty.mvpdagger.View;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.cdoherty.mvpdagger.Data.Model.Model.Item;
import com.example.cdoherty.mvpdagger.MVP.Interactor.ViewListener;
import com.example.cdoherty.mvpdagger.MVP.Presenter.APIPresenter;
import com.example.cdoherty.mvpdagger.MyApplication;
import com.example.cdoherty.mvpdagger.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by cdoherty on 21/03/2018.
 */

public class FragmentA extends Fragment implements ViewListener {
    public static final String TAG = FragmentA.class.getSimpleName();
    private APIPresenter presenter;
    private ArrayList<Item> responses = new ArrayList<>();
    private ItemListAdapter adapter;
    @BindView(R.id.recycler_items)
    RecyclerView recyclerView;

    @OnClick(R.id.button)
    void getText() {
        load();
    }

    private void load() {
        presenter.loadList();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new APIPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);
        prepareRecyclerAdapter();
        return view;
    }

    @Override
    public void updateUI(ArrayList<Item> response) {
//        adapter.setItems(response);
        //todo whys the adapter calling get count twice??
    }

    private void prepareRecyclerAdapter() {
        adapter = new ItemListAdapter();
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

    }
}
