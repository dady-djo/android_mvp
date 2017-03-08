package com.oknesif.android_mvp.list.presenter;

import com.oknesif.android_mvp.list.view.MainView;

public interface Presenter {

    void onAttach(MainView view);

    void onResume();

    void onPause();

    void onDetach();
}
