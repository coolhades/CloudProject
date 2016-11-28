package com.hades.mylibrary.cloud.ui.mvp.presenter;


import android.content.Context;
import android.content.Intent;

import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.log.KLog;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.cloud.bean.User;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.ui.mvp.model.LoginModel;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hades on 2016/11/14.
 */

public class LoginPresenter extends BasePresenter<ILoadData, LoginModel> {

    Context mContext;

    public LoginPresenter(Context mContext) {
        this.mContext = mContext;
    }

    public void Login(final String account, final String passwd) {
        Call<RootDataBean<User>> login = RetrofitManager.getInstance().getDefaultRetrofit().create(ApiCollection.LoginApi.class)
                .login(account, passwd);
        login.enqueue(new Callback<RootDataBean<User>>() {
            @Override
            public void onResponse(Call<RootDataBean<User>> call, Response<RootDataBean<User>> response) {
//                用户信息保存本地 此处需要修改
                KLog.json(GsonUtils.getInstance().toJson(response) );
                User user = response.body().data;
                ConstantSet.user = user;

                Intent i = new Intent();
                i.setAction("ChooseConpanyActivity");
                mContext.startActivity(i);
                EventBus.getDefault().post(true);//关闭登录Activity

            }

            @Override
            public void onFailure(Call<RootDataBean<User>> call, Throwable t) {

            }
        });
    }

    @Override
    public void start() {

    }

}
