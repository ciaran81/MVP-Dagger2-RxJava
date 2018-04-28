package com.example.cdoherty.mvpdagger.Component;

import com.example.cdoherty.mvpdagger.ActivityMain;
import com.example.cdoherty.mvpdagger.MVP.Model.ModelAPI;
import com.example.cdoherty.mvpdagger.MVP.Presenter.APIPresenter;
import com.example.cdoherty.mvpdagger.Module.APIModule;
import com.example.cdoherty.mvpdagger.Module.PresenterModule;
import com.example.cdoherty.mvpdagger.View.FragmentA;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cdoherty on 21/03/2018.
 */

@Singleton
@Component(modules = {APIModule.class, PresenterModule.class})
public interface MyComponent {
    void inject(FragmentA fragmentA);
    void inject(ActivityMain activityMain);
    void inject(ModelAPI modelAPI);
    void inject(APIPresenter apiPresenter);
}
