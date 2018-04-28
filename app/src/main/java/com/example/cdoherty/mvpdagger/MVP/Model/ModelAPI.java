package com.example.cdoherty.mvpdagger.MVP.Model;

import android.content.Context;
import android.util.Log;

import com.example.cdoherty.mvpdagger.Data.Model.Model.SOAnswersResponse;
import com.example.cdoherty.mvpdagger.Data.Model.Remote.SOService;
import com.example.cdoherty.mvpdagger.MVP.Interactor.APIListener;
import com.example.cdoherty.mvpdagger.MVP.Interactor.InteractorImpl;
import com.example.cdoherty.mvpdagger.MVP.Presenter.APIPresenter;


import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cdoherty on 28/03/2018.
 */

public class ModelAPI implements InteractorImpl {

    private static final String TAG = ModelAPI.class.getSimpleName();
    private SOService mService;
    private Context context;
    private APIListener apiListener;

    @Inject
    public ModelAPI(Context context, SOService soService) {
        mService = soService;
        this.context = context;
    }

    @Override
    public void loadFromAPI() {
        mService.getAnswers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SOAnswersResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SOAnswersResponse response) {
                        apiListener.updateResponse(response.getItems());
                    }
                });
    }

    @Override
    public void isContextNull() {
        if (context != null) Log.d(TAG, "isContextNull: nope");
    }

    @Override
    public void setListener(APIListener apiListener) {
        this.apiListener = apiListener;

    }

}
