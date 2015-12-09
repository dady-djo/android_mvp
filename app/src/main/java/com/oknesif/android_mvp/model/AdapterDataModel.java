package com.oknesif.android_mvp.model;

import android.support.annotation.VisibleForTesting;

import com.oknesif.android_mvp.objects.Entity;

import java.util.List;

public class AdapterDataModel {

    private List<Entity> entities;

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }


    public int getSize() {
        return entities.size();
    }

    public String getTitleOnPosition(int position) {
        return entities.get(position).getTitle();
    }

    @VisibleForTesting
    public List<Entity> getEntities() {
        return entities;
    }
}
