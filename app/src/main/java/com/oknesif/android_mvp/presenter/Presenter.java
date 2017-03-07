package com.oknesif.android_mvp.presenter;

import com.oknesif.android_mvp.view.MainView;

public interface Presenter {

    void onAttach(MainView view);

    void onResume();

    void onPause();

    void onDetach();
}
