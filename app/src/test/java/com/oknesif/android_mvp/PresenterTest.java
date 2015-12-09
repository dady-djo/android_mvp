package com.oknesif.android_mvp;

import android.os.Bundle;

import com.oknesif.android_mvp.model.AdapterDataModel;
import com.oknesif.android_mvp.model.DataManager;
import com.oknesif.android_mvp.model.OnDataManagerCallback;
import com.oknesif.android_mvp.objects.Entity;
import com.oknesif.android_mvp.presenter.Presenter;
import com.oknesif.android_mvp.presenter.PresenterImpl;
import com.oknesif.android_mvp.view.OnEntityClickListener;
import com.oknesif.android_mvp.view.ViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Presenter tests
 */
public class PresenterTest {

    private static List<Entity> ENTITIES = Collections.singletonList(new Entity("title", 0));

    @Mock
    private ViewModel mViewModel;

    @Mock
    private DataManager mDataManager;

    @Mock
    private Bundle mBundle;

    @Captor
    private ArgumentCaptor<AdapterDataModel> mAdapterDataModelArgumentCaptor;

    @Captor
    private ArgumentCaptor<OnDataManagerCallback<Entity>> mOnDataManagerCallbackArgumentCaptor;

    private Presenter mPresenter;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new PresenterImpl(mViewModel, mDataManager);

        when(mDataManager.getSomeString()).thenReturn("something");
    }

    @Test
    public void onCreateTest() {
        mPresenter.onCreate(mBundle);

        // Testing that methods are invoked
        verify(mViewModel).initTextViews();
        verify(mViewModel).initList(mAdapterDataModelArgumentCaptor.capture(), eq((OnEntityClickListener) mPresenter));

        AdapterDataModel adapterDataModel = mAdapterDataModelArgumentCaptor.getValue();

        verify(mViewModel).setTitle("something");
        verify(mDataManager).getEntities(mOnDataManagerCallbackArgumentCaptor.capture());

        // Testing onSuccess callback
        mOnDataManagerCallbackArgumentCaptor.getValue().onSuccess(ENTITIES);
        assertThat(adapterDataModel.getEntities(), is(ENTITIES));
        verify(mViewModel).updateList();

        // Testing onError callback
        mOnDataManagerCallbackArgumentCaptor.getValue().onError("");
        verify(mViewModel).openNextPage();

        // Testing onClick method
        ((OnEntityClickListener) mPresenter).onClick(0);
        verify(mViewModel).setTitle("title");
    }

    @Test
    public void onPauseTest() {
        mPresenter.onPause();

        // Testing that zero interaction are invoked on mocks objects
        verifyZeroInteractions(mDataManager);
        verifyZeroInteractions(mViewModel);
    }
}
