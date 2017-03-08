package com.oknesif.android_mvp.list.model;

public interface ModelAdapter {

    int getSize();

    String getLabel(int position);

    boolean isSelected(int position);

    int getId(int position);

    String getButtonText(int position);
}
