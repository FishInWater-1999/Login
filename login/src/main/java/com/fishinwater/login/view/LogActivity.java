package com.fishinwater.login.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fishinwater.login.R;
import com.fishinwater.login.fragment.LoginFragment;
import com.fishinwater.login.view.IBaseLogActivity;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

@Route(path = "/login/login")
public class LogActivity extends AppCompatActivity implements IBaseLogActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        replaceFragment(new LoginFragment());
        getLoginUrl();
        getParams();

    }

    @Override
    public void replaceFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment)
                .commit();
    }

    @Override
    public String getLoginUrl() {
        Log.d("test", getIntent().getExtras().getString("login-url"));
        return getIntent().getExtras().getString("login-url");
    }

    @Override
    public String getResistUrl() {
        return getIntent().getExtras().getString("resist-url");
    }

    @Override
    public Map<String, String> getParams() {
        Bundle bundle = getIntent().getBundleExtra("bundle");
        Map<String , String> map = new HashMap<>();
        for (String key : bundle.keySet()) {
            map.put(key, (String) bundle.get(key));
            Log.d("test", (String) bundle.get(key));
        }
        return map;
    }
}
