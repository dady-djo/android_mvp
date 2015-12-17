package com.oknesif.android_mvp.service;

import com.google.inject.assistedinject.Assisted;

/**
 * Created by dvaletin on 17.12.15.
 */
public interface IBackendServiceFabrick {
    IBackendService create(@Assisted("number_1") int portNumber, @Assisted("number_2") int otherNumber);
}
