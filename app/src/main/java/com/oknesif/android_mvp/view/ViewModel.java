package com.oknesif.android_mvp.view;

import com.oknesif.android_mvp.model.AdapterDataModel;

public interface ViewModel {

    void setTitle(String title);

    void initTextViews();

    void initList(AdapterDataModel adapterDataModel, OnEntityClickListener listener);

    void updateList();

    void openNextPage();
}
