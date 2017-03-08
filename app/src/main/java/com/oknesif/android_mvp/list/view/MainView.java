package com.oknesif.android_mvp.list.view;

import com.oknesif.android_mvp.list.model.ModelAdapter;

public interface MainView {

    void setTitle(String title);

    void initViews(OnItemClickListener listener);

    void showData(ModelAdapter modelAdapter);

    void showProgress(boolean show);
}
