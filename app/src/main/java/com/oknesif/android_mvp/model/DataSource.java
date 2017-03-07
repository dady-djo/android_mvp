package com.oknesif.android_mvp.model;

import com.oknesif.android_mvp.objects.Entity;

import java.util.List;

public interface DataSource {

    void getEntities(DataSourceCallback callback);

    interface DataSourceCallback {

        void onSuccess(List<Entity> list);

        void onError(String errorCode);
    }
}
