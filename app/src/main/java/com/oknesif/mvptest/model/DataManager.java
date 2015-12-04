package com.oknesif.mvptest.model;

public interface DataManager<T> {

    void getEntities(OnDataManagerCallback<T> callback);

    String getSomeString();
}
