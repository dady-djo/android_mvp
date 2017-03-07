package com.oknesif.android_mvp.model;

import com.oknesif.android_mvp.objects.Entity;

import java.util.List;

public class ModelAdapterImpl implements ModelAdapter {

    private final List<Entity> entities;
    private final int selectedEntityId;

    public ModelAdapterImpl(List<Entity> entities, int selectedEntityId) {
        this.entities = entities;
        this.selectedEntityId = selectedEntityId;
    }

    @Override
    public int getSize() {
        return entities.size();
    }

    @Override
    public String getLabel(int position) {
        return "name=" + getEntity(position).getName() + ", age=" + getEntity(position).getAge();
    }

    @Override
    public boolean isSelected(int position) {
        return getEntity(position).getId() == selectedEntityId;
    }

    @Override
    public int getId(int position) {
        return getEntity(position).getId();
    }

    private Entity getEntity(int position) {
        return entities.get(position);
    }
}