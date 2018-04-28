package com.example.cdoherty.mvpdagger.Module;

import com.example.cdoherty.mvpdagger.Data.Model.Remote.ApiUtils;
import com.example.cdoherty.mvpdagger.Data.Model.Remote.SOService;
import com.example.cdoherty.mvpdagger.MVP.Interactor.InteractorImpl;
import com.example.cdoherty.mvpdagger.MVP.Model.ModelAPI;
import com.example.cdoherty.mvpdagger.MyApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cdoherty on 28/03/2018.
 */

@Module
public class APIModule {
    private MyApplication myApplication;

    public APIModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Provides
    public InteractorImpl providesInteractor(){
        SOService mService = ApiUtils.getSOService();
        return new ModelAPI(myApplication.getApplicationContext(), mService);
    }
}
