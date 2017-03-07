package com.oknesif.android_mvp.model;

public interface ModelAdapter {

    int getSize();

    String getLabel(int position);

    boolean isSelected(int position);

    int getId(int position);
}
