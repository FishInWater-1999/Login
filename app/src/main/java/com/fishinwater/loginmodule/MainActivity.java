package com.fishinwater.loginmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("lsth", "s");
        bundle.putString("a", "b");


        ARouter.getInstance()
                .build("/login/login")
                .withString("login-url", "log in")
                .withString("resist-url", "resist in")
                .withBundle("bundle", bundle)
                .navigation();
    }

}
