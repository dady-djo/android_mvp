package com.oknesif.android_mvp.presenter;

import android.os.Bundle;

import com.oknesif.android_mvp.model.Interactor;
import com.oknesif.android_mvp.model.ModelAdapterImpl;
import com.oknesif.android_mvp.objects.Entity;
import com.oknesif.android_mvp.router.Router;
import com.oknesif.android_mvp.view.OnEntityClickListener;
import com.oknesif.android_mvp.view.View;

import java.util.List;

public class PresenterImpl implements Presenter, OnEntityClickListener, Interactor.DataSubscriber {

    private View view;
    private Interactor interactor;
    private final Router router;

    public PresenterImpl(View model, Interactor interactor, Router router) {
        this.view = model;
        this.interactor = interactor;
        this.router = router;
    }

    @Override
    public void onCreate(Bundle bundle) {
        view.initTextViews();
        view.initList(this);
        view.setTitle(interactor.getTitle());

        interactor.queryData();
        view.showProgress(true);
    }

    @Override
    public void handleOnResume() {
        interactor.subscribe(this);
    }

    @Override
    public void handleOnPause() {
        interactor.unsubscribe(this);
    }

    @Override
    public void onDataChanged(List<Entity> entities, int selectedEntityId) {
        view.showData(new ModelAdapterImpl(entities, selectedEntityId));
        view.showProgress(false);
    }


    @Override
    public void onClick(int entryId) {
        interactor.setSelectedEntity(entryId);
    }
}
