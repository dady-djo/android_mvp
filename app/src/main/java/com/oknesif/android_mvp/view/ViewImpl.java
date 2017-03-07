package com.oknesif.android_mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.ModelAdapter;

public class ViewImpl implements View {

    private android.view.View rootView;
    private TextView someTextView;
    private RecyclerAdapter adapter;

    public ViewImpl(android.view.View rootView) {
        this.rootView = rootView;
    }

    @Override
    public void setTitle(String title) {
        someTextView.setText(title);
    }

    @Override
    public void initTextViews() {
        someTextView = (TextView) rootView.findViewById(R.id.txt_some);
    }

    @Override
    public void initList(OnEntityClickListener listener) {
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
        rootView.findViewById(R.id.progress).setVisibility(show? android.view.View.VISIBLE: android.view.View.GONE);
    }
}
