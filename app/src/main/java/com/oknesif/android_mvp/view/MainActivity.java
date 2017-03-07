package com.oknesif.android_mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.DataSourceImpl;
import com.oknesif.android_mvp.model.Interactor;
import com.oknesif.android_mvp.model.InteractorImpl;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterImpl;
import com.oknesif.android_mvp.router.Router;
import com.oknesif.android_mvp.router.RouterImpl;

public class MainActivity extends AppCompatActivity {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = new ViewImpl(findViewById(R.id.root_view));
        Interactor interactor = new InteractorImpl(new DataSourceImpl());
        Router router = new RouterImpl(this);
        presenter = new PresenterImpl(view, interactor, router);

        presenter.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.handleOnResume();
    }

    @Override
    protected void onPause() {
        presenter.handleOnPause();
        super.onPause();
    }
}
