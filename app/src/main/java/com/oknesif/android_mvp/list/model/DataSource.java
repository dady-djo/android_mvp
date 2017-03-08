package com.oknesif.android_mvp.list.model;

import com.oknesif.android_mvp.list.objects.Entity;

import java.util.List;

public interface DataSource {

    void getEntities(DataSourceCallback callback);

    interface DataSourceCallback {

        void onSuccess(List<Entity> list);

        void onError(String errorCode);
    }
}
