package com.oknesif.android_mvp.model;


import com.oknesif.android_mvp.objects.Entity;

import java.util.List;

public interface Interactor {

    void subscribe(DataSubscriber subscriber);

    void unsubscribe(DataSubscriber subscriber);

    void queryData();

    void setSelectedEntity(int entity);

    String getTitle();

    public interface DataSubscriber {
        public void onDataChanged(List<Entity> entity, int selectedEntityId);
    }
}
