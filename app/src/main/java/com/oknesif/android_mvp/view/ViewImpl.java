package com.oknesif.android_mvp.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.oknesif.android_mvp.R;
import com.oknesif.android_mvp.model.ModelAdapter;

public class ViewImpl implements View {

    private android.view.View rootView;
    private TextView someTextView;
    private RecyclerAdapter adapter;

    private Activity activity;

    public ViewImpl(Activity activity, android.view.View rootView) {
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
    public void initList(OnEntityClickListener listener) {
        RecyclerView recycler = (RecyclerView) rootView.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        adapter = new RecyclerAdapter(listener);
        recycler.setAdapter(adapter);
    }


    @Override
    public void openNextPage() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void showData(final ModelAdapter modelAdapter) {
        adapter.setData(modelAdapter);
    }
}
