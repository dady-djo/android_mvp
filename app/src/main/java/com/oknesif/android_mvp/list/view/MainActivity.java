package com.oknesif.android_mvp.list.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.list.model.DataSourceImpl;
import com.oknesif.android_mvp.list.model.Interactor;
import com.oknesif.android_mvp.list.model.InteractorImpl;
import com.oknesif.android_mvp.list.presenter.Presenter;
import com.oknesif.android_mvp.list.presenter.PresenterImpl;
import com.oknesif.android_mvp.list.router.Router;
import com.oknesif.android_mvp.list.router.RouterImpl;

public class MainActivity extends AppCompatActivity {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainView view = new MainViewImpl(findViewById(R.id.root_view));
        Interactor interactor = new InteractorImpl(new DataSourceImpl());
        Router router = new RouterImpl(this);
        presenter = new PresenterImpl(interactor, router);

        presenter.onAttach(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }
}
