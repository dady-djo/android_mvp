package com.oknesif.android_mvp.service;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.oknesif.android_mvp.objects.Profile;

/**
 * Created by dvaletin on 17.12.15.
 */
public class MockedBackendServiceImpl implements IBackendService {


    private IConfigurationService configurationService;
    private int portNumber;

    @AssistedInject
    public MockedBackendServiceImpl(@Assisted("number_2") int otherNumber, @Assisted("number_1") int portNumber, IConfigurationService configurationService) {
        this.configurationService = configurationService;
        this.portNumber = portNumber + otherNumber;
    }

    @Override
    public Profile getUserProfile(long userId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Profile someProfile = new Profile();
        someProfile.id = userId;
        someProfile.firstName = configurationService.getServerUrl();
        someProfile.lastName = String.valueOf(portNumber);
        return someProfile;
    }
}
