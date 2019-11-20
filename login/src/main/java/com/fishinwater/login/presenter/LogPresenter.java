package com.fishinwater.login.presenter;

import com.fishinwater.login.fragment.IOnResultListener;
import com.fishinwater.login.model.IBaseLog;

import java.util.Map;

/**
 * @author fishinwater-1999
 * @version 2019-11-12
 */
public class LogPresenter extends BasePresenter<IOnResultListener> {

    private IBaseLog logViewModel;

    public LogPresenter(IBaseLog logViewModel) {
        this.logViewModel = logViewModel;
    }

    @Override
    public void resister(String url, Map<String, String> params, IOnResultListener resultListener) {
        logViewModel.resist(url, params, resultListener);
    }

    @Override
    public void login(String url, Map<String, String> params, IOnResultListener resultListener) {
        logViewModel.login(url, params, resultListener);
    }

}
