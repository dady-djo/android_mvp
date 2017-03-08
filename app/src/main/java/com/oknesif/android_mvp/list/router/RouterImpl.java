package com.oknesif.android_mvp.list.router;

import android.app.Activity;

import com.oknesif.android_mvp.details.DetailsActiviy;

public class RouterImpl implements Router {

    private final Activity activity;

    public RouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void openDetails(int itemId) {
        DetailsActiviy.start(activity);
    }
}
