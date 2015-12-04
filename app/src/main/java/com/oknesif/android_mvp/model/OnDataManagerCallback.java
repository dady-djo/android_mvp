package com.oknesif.android_mvp.model;

import java.util.List;

public interface OnDataManagerCallback<T> {

    void onSuccess(List<T> list);

    void onError(String errorCode);
}
