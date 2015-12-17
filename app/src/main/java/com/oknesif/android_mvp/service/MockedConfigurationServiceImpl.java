package com.oknesif.android_mvp.service;

import com.google.inject.Inject;

/**
 * Created by dvaletin on 17.12.15.
 */
public class MockedConfigurationServiceImpl implements IConfigurationService {


    @Inject
    public  MockedConfigurationServiceImpl() {}


    @Override
    public String getServerUrl() {
        return "My server";
    }
}
