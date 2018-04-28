package com.example.cdoherty.mvpdagger.MVP.Interactor;

import com.example.cdoherty.mvpdagger.MVP.Presenter.APIPresenter; /**
 * Created by cdoherty on 30/03/2018.
 */

public interface InteractorImpl {
    void loadFromAPI();
    void isContextNull();

    void setListener(APIListener apiListener);
}

