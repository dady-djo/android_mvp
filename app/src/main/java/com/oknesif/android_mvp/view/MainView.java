package com.oknesif.android_mvp.view;

import com.oknesif.android_mvp.model.ModelAdapter;

public interface MainView {

    void setTitle(String title);

    void initTextViews();

    void initList(OnEntityClickListener listener);

    void showData(ModelAdapter modelAdapter);

    void showProgress(boolean show);
}
