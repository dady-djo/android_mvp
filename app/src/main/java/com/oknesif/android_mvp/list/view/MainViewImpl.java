package com.oknesif.android_mvp.list.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.list.model.ModelAdapter;

public class MainViewImpl implements MainView {

    private android.view.View rootView;
    private TextView someTextView;
    private RecyclerAdapter adapter;

    public MainViewImpl(android.view.View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void setTitle(String title) {
        someTextView.setText(title);
    }

    @Override
    public void initViews(OnItemClickListener listener) {
        someTextView = (TextView) rootView.findViewById(R.id.txt_some);
        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new RecyclerAdapter(listener);
        recycler.setAdapter(adapter);
    }

    @Override
    public void showData(final ModelAdapter modelAdapter) {
        adapter.setData(modelAdapter);
    }

    @Override
    public void showProgress(boolean show) {
        rootView.findViewById(R.id.progress).setVisibility(show ? android.view.View.VISIBLE : android.view.View.GONE);
    }
}
