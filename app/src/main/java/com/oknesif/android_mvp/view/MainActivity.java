package com.oknesif.android_mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.DataManagerImpl;
import com.oknesif.android_mvp.model.DataManager;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterImpl;

public class MainActivity extends AppCompatActivity {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewModel viewModel = new ViewModelImpl(this, findViewById(R.id.root_view));
        DataManager dataManager = new DataManagerImpl();
        presenter = new PresenterImpl(viewModel, dataManager);
        presenter.onCreate(savedInstanceState);
    }
}
