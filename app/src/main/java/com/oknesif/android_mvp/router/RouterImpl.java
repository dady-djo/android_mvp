package com.oknesif.android_mvp.router;

import android.app.Activity;
import android.content.Intent;

import com.oknesif.android_mvp.view.MainActivity;

public class RouterImpl implements Router {

    private final Activity activity;

    public RouterImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void openNextPage() {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }
}
