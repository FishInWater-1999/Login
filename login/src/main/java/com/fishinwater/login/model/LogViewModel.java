package com.fishinwater.login.model;

import androidx.lifecycle.ViewModel;

import com.fishinwater.login.fragment.IOnResultListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.Map;

import okhttp3.Call;

/**
 * @author fishinwater-1999
 * @version 2019-11-12
 */
public class LogViewModel extends ViewModel implements IBaseLog {

    private final String TAG = "LogViewModel";

    @Override
    public void login(String url, Map<String, String> params, final IOnResultListener logResultListener) {
        PostFormBuilder builder = OkHttpUtils
                .post()
                .url(url);
                for (String paramName : params.keySet()) {
                        builder.addParams(paramName, params.get(paramName));
                }
        builder.build()
            .execute( new StringCallback(){

                @Override
                public void onError(Call call, Exception e, int id) {
                    logResultListener.onFailed(e);
                }

                @Override
                public void onResponse(String response, int id) {
                    logResultListener.onSucceed(response);
                }
            });
    }

    @Override
    public void resist(String url, Map<String, String> params, final IOnResultListener logResultListener) {
        PostFormBuilder builder = OkHttpUtils
                .post()
                .url(url);
        for (String paramName : params.keySet()) {
            builder.addParams(paramName, params.get(paramName));
        }
        builder.build()
            .execute( new StringCallback(){

                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onResponse(String response, int id) {
                    logResultListener.onSucceed(response);
                }
            });
    }

}
