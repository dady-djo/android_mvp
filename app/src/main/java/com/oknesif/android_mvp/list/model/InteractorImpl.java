package com.oknesif.android_mvp.list.model;

import com.oknesif.android_mvp.list.objects.Entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InteractorImpl implements Interactor {

    private final DataSource dataSource;
    private List<DataSubscriber> subscribers;
    private List<Entity> entities;
    private int selectedEntityId = -1;

    public InteractorImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.subscribers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void subscribe(DataSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(DataSubscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void queryData() {
        dataSource.getEntities(new DataSource.DataSourceCallback() {

            @Override
            public void onSuccess(List<Entity> entities) {
                InteractorImpl.this.entities = entities;
                fireEntriesChanged();
            }

            @Override
            public void onError(String errorCode) {

            }
        });
    }

    private void fireEntriesChanged() {
        for (DataSubscriber subscriber : subscribers) {
            subscriber.onDataChanged(entities, selectedEntityId);
        }
    }

    public void setSelectedEntity(int entityId) {
        selectedEntityId = entityId;
        fireEntriesChanged();
    }

    @Override
    public String getTitle() {
        return "Some Title";
    }

}
