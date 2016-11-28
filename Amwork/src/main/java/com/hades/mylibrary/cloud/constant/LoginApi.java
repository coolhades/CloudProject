package com.hades.mylibrary.cloud.constant;


import com.hades.mylibrary.base.net.RootRequest;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;

import com.hades.mylibrary.cloud.bean.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * Created by Hades on 16/10/9.
 */

public class LoginApi extends RootRequest {


    private ApiStore mApiStore;

    public LoginApi() {
        super();
        mApiStore = mRetrofit.create(ApiStore.class);
    }

    public void login(String account, String passwd, RootRequest.ApiCallback callback) {
        //返回的response
        Call<RootDataBean<User>> call = ((ApiStore) mApiStore).login(account, passwd);
        call.enqueue(new RetrofitCallback<RootDataBean<User>>(callback));

    }

    //登录接口
    public interface ApiStore {
        @FormUrlEncoded
        @POST("user/login")
        Call<RootDataBean<User>> login(@Field("account") String account,
                                       @Field("passwd") String passwd
        );
    }

}
