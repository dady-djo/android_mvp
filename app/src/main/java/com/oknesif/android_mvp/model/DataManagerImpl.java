package com.oknesif.android_mvp.model;

import com.oknesif.android_mvp.objects.Entity;

import java.util.ArrayList;
import java.util.List;

public class DataManagerImpl implements DataManager<Entity> {

    @Override
    public void getEntities(final OnDataManagerCallback<Entity> callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                    List<Entity> entities = new ArrayList<>();
                    entities.add(new Entity("First", 2));
                    entities.add(new Entity("Second", 3));
                    entities.add(new Entity("Third", 2));
                    entities.add(new Entity("Fourth", 2));
                    entities.add(new Entity("Firth", 2));

                    if (callback != null) {
                        callback.onSuccess(entities);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }

    @Override
    public String getSomeString() {
        return "Test String";
    }
}
