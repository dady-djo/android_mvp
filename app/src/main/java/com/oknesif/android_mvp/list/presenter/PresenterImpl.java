package com.oknesif.android_mvp.list.presenter;

import com.oknesif.android_mvp.list.model.Interactor;
import com.oknesif.android_mvp.list.model.ModelAdapterImpl;
import com.oknesif.android_mvp.list.objects.Entity;
import com.oknesif.android_mvp.list.router.Router;
import com.oknesif.android_mvp.list.view.MainView;
import com.oknesif.android_mvp.list.view.MainViewStub;
import com.oknesif.android_mvp.list.view.OnEntityClickListener;

import java.util.List;

public class PresenterImpl implements Presenter, OnEntityClickListener, Interactor.DataSubscriber {

    private final Interactor interactor;
    private final Router router;
    private MainView view;

    public PresenterImpl(Interactor interactor, Router router) {
        this.interactor = interactor;
        this.router = router;
    }

    @Override
    public void onAttach(MainView view) {
        this.view = view;
        initView();
        queryData();
    }

    @Override
    public void onDetach() {
        view = new MainViewStub();
    }

    private void initView() {
        view.initTextViews();
        view.initList(this);
        view.setTitle(interactor.getTitle());
    }

    private void queryData() {
        interactor.queryData();
        view.showProgress(true);
    }

    @Override
    public void onResume() {
        interactor.subscribe(this);
    }

    @Override
    public void onPause() {
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
