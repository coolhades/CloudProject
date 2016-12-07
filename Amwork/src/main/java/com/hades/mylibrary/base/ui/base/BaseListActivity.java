package com.hades.mylibrary.base.ui.base;

import android.os.Bundle;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.constant.ApiCollection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseListActivity extends NormalBaseActivity {

    protected LRecyclerView lRecyclerView;
    protected LRecyclerViewAdapter lRecyclerViewAdapter;
    protected CommonAdapter commonAdapter;
    protected DataManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lrecyclerview_ly);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        lRecyclerView = (LRecyclerView) findViewById(R.id.recyclerview);
    }


    protected void setManager(DataManager manager){
        this.manager = manager;
    }

    //获取信息 子类根据需求获取
    protected void fetchData(){
        Call<RootDataBean> g = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.getList.class).getlist("id");
        g.enqueue(new Callback<RootDataBean>() {
            @Override
            public void onResponse(Call<RootDataBean> call, Response<RootDataBean> response) {
                if (response.body().status == 1){
                    if (manager == null) {
                        ToastUtils.showShortToast(BaseListActivity.this, R.string.ERROR_UNIVERSAL_SETTING);
                        return;
                    }
                    manager.fetchData(GsonUtils.getInstance().toJson(response.body().data ));
                }
            }

            @Override
            public void onFailure(Call<RootDataBean> call, Throwable t) {

            }
        });
    }



}
