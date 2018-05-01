package com.example.cdoherty.mvpdagger;

import android.app.Application;

import com.example.cdoherty.mvpdagger.Component.DaggerMyComponent;
import com.example.cdoherty.mvpdagger.Component.MyComponent;
import com.example.cdoherty.mvpdagger.Module.APIModule;

/**
 * Created by cdoherty on 21/03/2018.
 */

public class MyApplication extends Application {

    MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyComponent
                .builder()
                .aPIModule(new APIModule(this))
                .build();
    }

    public MyComponent getComponent() {
        return component;
    }


}
