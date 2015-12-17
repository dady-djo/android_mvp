package com.oknesif.android_mvp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.inject.RoboAppCompatActivity;
import com.oknesif.android_mvp.objects.Profile;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterFactory;
import com.oknesif.android_mvp.service.IBackendService;
import com.oknesif.android_mvp.service.IBackendServiceFabrick;
import com.oknesif.android_mvp.service.IConfigurationService;
import com.oknesif.android_mvp.service.MockedBackendServiceImpl;

import roboguice.RoboGuice;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboAppCompatActivity {


    Presenter presenter;
    @InjectView(R.id.root_view)
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewModel viewModel = new ViewModelImpl(this, rootView);
        presenter = RoboGuice.getInjector(this).getInstance(PresenterFactory.class).create(viewModel);
        presenter.onCreate(savedInstanceState);

        IBackendService service = RoboGuice.getInjector(this).getInstance(IBackendServiceFabrick.class).create(2020, 1);
        Profile user = service.getUserProfile(100L);
        Log.d("Injector", user.firstName);
    }
}
