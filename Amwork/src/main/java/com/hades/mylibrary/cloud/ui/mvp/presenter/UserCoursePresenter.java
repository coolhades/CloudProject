package com.hades.mylibrary.cloud.ui.mvp.presenter;

import android.content.Context;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.mvp.presenter.BasePresenter;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.bean.MyClass;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.ui.mvp.model.BaseModel;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hades on 2016/11/28.
 */

public class UserCoursePresenter extends BasePresenter<ILoadData, BaseModel> {
    Context mContext;

    public UserCoursePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void start() {

    }

    public void fetchCourseData(){
        //从model中获取数据
        Call<RootDataBean<List<MyClass>>> getData = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.GetMyClass.class).getMyClass("user_id");
        getData.enqueue(new Callback<RootDataBean<List<MyClass>>>() {
            @Override
            public void onResponse(Call<RootDataBean<List<MyClass>>> call, Response<RootDataBean<List<MyClass>>> response) {
                if (response.body().status == 1) {
                    mView.onInitData(GsonUtils.getInstance().toJson(response.body().data) );
                }else {
                    ToastUtils.showShortToast(mContext, R.string.ERROR_UNIVERSAL_NET);
                }
            }

            @Override
            public void onFailure(Call<RootDataBean<List<MyClass>>> call, Throwable t) {
                ToastUtils.showShortToast(mContext, R.string.ERROR_UNIVERSAL_NET);
            }
        });
    }


}
