package com.oknesif.mvptest.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.oknesif.mvptest.R;
import com.oknesif.mvptest.model.AdapterDataModel;

public class ViewModelImpl implements ViewModel {

    private View rootView;
    private TextView someTextView;
    private RecyclerAdapter adapter;

    private Activity activity;

    public ViewModelImpl(Activity activity, View rootView) {
        this.activity = activity;
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
    public void initList(AdapterDataModel adapterDataModel, OnEntityClickListener listener) {
        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new RecyclerAdapter(adapterDataModel, listener);
        recycler.setAdapter(adapter);
    }

    @Override
    public void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openNextPage() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
