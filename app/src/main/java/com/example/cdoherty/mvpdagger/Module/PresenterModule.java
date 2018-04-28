package com.example.cdoherty.mvpdagger.Module;

import com.example.cdoherty.mvpdagger.MVP.Interactor.ViewListener;
import com.example.cdoherty.mvpdagger.MyApplication;
import com.example.cdoherty.mvpdagger.View.FragmentA;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cdoherty on 30/03/2018.
 */
@Module
public class PresenterModule {

    private MyApplication myApplication;

    public PresenterModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    ViewListener providesViewListener() {
        return new FragmentA();
    }
}
