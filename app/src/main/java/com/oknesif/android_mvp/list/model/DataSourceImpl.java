package com.oknesif.android_mvp.list.model;

import android.os.AsyncTask;

import com.oknesif.android_mvp.list.objects.Entity;

import java.util.ArrayList;
import java.util.List;

public class DataSourceImpl implements DataSource {

    @Override
    public void getEntities(final DataSourceCallback callback) {

        new AsyncTask<Void, Void, List<Entity>>() {
            @Override
            protected List<Entity> doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);

                    List<Entity> entities = new ArrayList<>();
                    entities.add(new Entity(1001, "First", 2));
                    entities.add(new Entity(1002, "Second", 3));
                    entities.add(new Entity(1003, "Third", 2));
                    entities.add(new Entity(1004, "Fourth", 2));
                    entities.add(new Entity(1005, "Firth", 2));

                    return entities;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(List<Entity> entities) {
                if (entities == null) {
                    callback.onError("No entities!");
                } else {
                    callback.onSuccess(entities);
                }
            }
        }.execute();
    }

}
