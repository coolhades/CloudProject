package com.hades.mylibrary.cloud.ui.mvp.presenter;


import android.content.Context;
import android.content.Intent;

import com.hades.mylibrary.base.data.ACache;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.base.utils.Md5Utils;
import com.hades.mylibrary.cloud.bean.User;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.ui.mvp.model.RegisterModel;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Hades on 2016/11/15.
 */

public class RegistPresenter extends BasePresenter<ILoadData, RegisterModel> {

    Context mContext;
    public RegistPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void start() {

    }

    public void regist(final String account, final String pwd, final String vcode) {
        Call<RootDataBean<User>> regist = RetrofitManager.getInstance().getDefaultRetrofit().create(ApiCollection.RegistApi.class)
                .regist(account, pwd, "161025", vcode, Md5Utils.md5("moocuserregister" + account + pwd));
        regist.enqueue(new Callback<RootDataBean<User>>() {
            @Override
            public void onResponse(Call<RootDataBean<User>> call, Response<RootDataBean<User>> response) {
                if (response.body().status == 1) {
                    mView.onInitData(GsonUtils.getInstance().toJson(response.body().data));
                    ACache.get(mContext).put("user", GsonUtils.getInstance().toJson(response.body().data) );
                    Intent i = new Intent();
                    i.setAction("ChooseConpanyActivity");
                    mContext.startActivity(i);
                    EventBus.getDefault().post(true);//跳转
                }
            }

            @Override
            public void onFailure(Call<RootDataBean<User>> call, Throwable t) {

            }
        });

    }

    //获取验证码
    public void FetchCode(String s) {
        Call<RootDataBean<String>> getCode = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.FetchCodeApi.class).getCode(s, Md5Utils.md5("moocmainsendcode" + s));
        getCode.enqueue(new Callback<RootDataBean<String>>() {
            @Override
            public void onResponse(Call<RootDataBean<String>> call, Response<RootDataBean<String>> response) {

            }

            @Override
            public void onFailure(Call<RootDataBean<String>> call, Throwable t) {

            }
        });
    }
}
