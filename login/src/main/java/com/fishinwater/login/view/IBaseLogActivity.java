package com.fishinwater.login.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Map;

/**
 * @author fishinwater-1999
 * @version 2019-11-12
 */
public interface IBaseLogActivity {

    /**
     * 切换当前碎片
     * @param fragment
     */
    void replaceFragment(@NonNull Fragment fragment);

    String getLoginUrl();

    String getResistUrl();

    Map<String, String> getParams();

}
