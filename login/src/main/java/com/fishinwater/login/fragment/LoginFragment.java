package com.fishinwater.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fishinwater.login.R;
import com.fishinwater.login.model.LogViewModel;
import com.fishinwater.login.presenter.IBasePresenter;
import com.fishinwater.login.presenter.LogPresenter;
import com.fishinwater.login.view.IBaseLogActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fishinwater-1999
 */
public class LoginFragment extends BaseFragment implements IOnResultListener {

    private IBaseLogActivity mContext;

    EditText mAccountEdit;

    EditText mPasswordEdit;

    private LogViewModel mLogViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        iniView(view);
        return view;
    }

    private void iniView(View view) {
        mAccountEdit = view.findViewById(R.id.user_account);
        mPasswordEdit = view.findViewById(R.id.user_password);
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        view.findViewById(R.id.resist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.replaceFragment(new ResistFragment());
            }
        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mLogViewModel == null) {
            mLogViewModel = new LogViewModel();
        }
    }

    public void login() {
        //getPresenter().login(mContext.getLoginUrl() ,mContext.getParams() , this);
        Log.d(TAG, mContext.getLoginUrl());
        Log.d(TAG, mContext.getResistUrl());
        //mPasswordEdit.setText(mContext.getResistUrl());
    }

    @Override
    public IOnResultListener createView() {
        return this;
    }

    @Override
    public IBasePresenter createProsenter() {
        if (mLogViewModel == null) {
            mLogViewModel = new LogViewModel();
        }
        return new LogPresenter(mLogViewModel);
    }

    @Override
    public void onSucceed(String response) {
        Log.d(TAG,"onSucceed");
        Toast.makeText(getActivity(), response, Toast.LENGTH_LONG).show();
        getActivity().finish();
    }

    @Override
    public void onFailed(Exception error) {
        Toast.makeText(getActivity(), "onFailed" + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNameWrong() {
        Toast.makeText(getActivity(), "onNameWrong", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPasswordWrong() {
        Toast.makeText(getActivity(), "onPasswordWrong", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        onDetach();
        super.onDestroy();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof IBaseLogActivity) {
            Log.d(TAG, "onAttach - 1");
            mContext = (IBaseLogActivity) context;
        }
        Log.d(TAG, "onAttach - 2");
    }
}
