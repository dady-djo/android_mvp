package com.oknesif.android_mvp.view;

import com.oknesif.android_mvp.model.ModelAdapter;

public interface View {

    void setTitle(String title);

    void initTextViews();

    void initList(OnEntityClickListener listener);

    void openNextPage();

    void showData(ModelAdapter modelAdapter);
}
