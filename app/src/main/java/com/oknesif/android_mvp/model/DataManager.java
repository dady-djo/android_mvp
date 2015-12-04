package com.oknesif.android_mvp.model;

public interface DataManager<T> {

    void getEntities(OnDataManagerCallback<T> callback);

    String getSomeString();
}
