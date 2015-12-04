package com.oknesif.android_mvp.presenter;

import android.os.Bundle;

import com.oknesif.android_mvp.model.AdapterDataModel;
import com.oknesif.android_mvp.model.DataManager;
import com.oknesif.android_mvp.model.OnDataManagerCallback;
import com.oknesif.android_mvp.objects.Entity;
import com.oknesif.android_mvp.view.OnEntityClickListener;
import com.oknesif.android_mvp.view.ViewModel;

import java.util.List;

public class PresenterImpl implements Presenter, OnEntityClickListener {

    private ViewModel viewModel;
    private DataManager dataManager;

    private AdapterDataModel adapterDataModel;

    public PresenterImpl(ViewModel model, DataManager manager) {
        this.viewModel = model;
        this.dataManager = manager;
    }

    @Override
    public void onCreate(Bundle bundle) {
        adapterDataModel = new AdapterDataModel();
        viewModel.initTextViews();
        viewModel.initList(adapterDataModel, this);
        viewModel.setTitle(dataManager.getSomeString());
        loadData();
    }

    private void loadData() {
        dataManager.getEntities(new OnDataManagerCallback<Entity>() {
            @Override
            public void onSuccess(List<Entity> list) {
                adapterDataModel.setEntities(list);
                viewModel.updateList();
            }

            @Override
            public void onError(String errorCode) {
                viewModel.openNextPage();
            }
        });
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onClick(int position) {
        String string = adapterDataModel.getTitleOnPosition(position);
        viewModel.setTitle(string);
    }
}
