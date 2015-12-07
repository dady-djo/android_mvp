package com.oknesif.android_mvp.inject;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.oknesif.android_mvp.model.DataManager;
import com.oknesif.android_mvp.model.DataManagerImpl;
import com.oknesif.android_mvp.objects.Entity;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterFactory;
import com.oknesif.android_mvp.presenter.PresenterImpl;

/**
 * Created by dvaletin on 07.12.15.
 */
public class AppModule implements Module {
    @Override
    public void configure(Binder binder) {
        binder.bind(new TypeLiteral<DataManager<Entity>>() {
        }).to(DataManagerImpl.class);
        binder.install(new FactoryModuleBuilder()
                .implement(Presenter.class, PresenterImpl.class)
                .build(PresenterFactory.class));
    }
}
