package com.oknesif.mvptest.view;

import com.oknesif.mvptest.model.AdapterDataModel;

public interface ViewModel {

    void setTitle(String title);

    void initTextViews();

    void initList(AdapterDataModel adapterDataModel, OnEntityClickListener listener);

    void updateList();

    void openNextPage();
}
