package com.oknesif.mvptest.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.oknesif.mvptest.R;
import com.oknesif.mvptest.model.DataManagerImpl;
import com.oknesif.mvptest.model.DataManager;
import com.oknesif.mvptest.presenter.Presenter;
import com.oknesif.mvptest.presenter.PresenterImpl;

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
