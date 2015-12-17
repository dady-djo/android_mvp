package com.oknesif.android_mvp.service;

import com.oknesif.android_mvp.objects.Profile;

import bolts.Task;

/**
 * Created by dvaletin on 17.12.15.
 */
public interface IBackendService {

//    Task<Profile> getUserProfileAsync(long userId);
    Profile getUserProfile(long userId);
}
