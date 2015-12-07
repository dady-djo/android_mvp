package com.oknesif.android_mvp.presenter;

import com.oknesif.android_mvp.view.ViewModel;

/**
 * Created by dvaletin on 07.12.15.
 */
public interface PresenterFactory {
    Presenter create(ViewModel viewModel);
}
