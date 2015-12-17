package com.oknesif.android_mvp.inject;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.oknesif.android_mvp.BuildConfig;
import com.oknesif.android_mvp.model.DataManager;
import com.oknesif.android_mvp.model.DataManagerImpl;
import com.oknesif.android_mvp.objects.Entity;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterFactory;
import com.oknesif.android_mvp.presenter.PresenterImpl;
import com.oknesif.android_mvp.service.IBackendService;
import com.oknesif.android_mvp.service.IBackendServiceFabrick;
import com.oknesif.android_mvp.service.IConfigurationService;
import com.oknesif.android_mvp.service.MockedBackendServiceImpl;
import com.oknesif.android_mvp.service.MockedConfigurationServiceImpl;
import com.oknesif.android_mvp.service.ProductionBackendServiceImpl;

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

        binder.bind(IConfigurationService.class).to(MockedConfigurationServiceImpl.class);

        binder.install(new FactoryModuleBuilder()
                .implement(IBackendService.class, MockedBackendServiceImpl.class)
                .build(IBackendServiceFabrick.class));
    }
}
