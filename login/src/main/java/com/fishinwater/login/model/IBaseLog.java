package com.fishinwater.login.model;

import com.fishinwater.login.fragment.IOnResultListener;

import java.util.Map;

/**
 * @author fishinwater-1999
 * @version 2019-11-12
 */
public interface IBaseLog {

    void login(String url, Map<String, String> params, IOnResultListener logResultListener);

    void resist(String url, Map<String, String> params, IOnResultListener logResultListener);

}
