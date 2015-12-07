package com.oknesif.android_mvp.inject;

import android.app.Application;

import roboguice.RoboGuice;

/**
 * Created by dvaletin on 07.12.15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        RoboGuice.setUseAnnotationDatabases(false);
        super.onCreate();
    }

}
