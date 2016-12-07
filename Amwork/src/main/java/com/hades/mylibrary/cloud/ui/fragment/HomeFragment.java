package com.hades.mylibrary.cloud.ui.fragment;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.pojo.BaseBean;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.ui.activity.SearchActivity;
import com.hades.mylibrary.cloud.videocache.VideoDownLoadManager;
import com.hades.mylibrary.cloud.videocache.VideoDownLoadService;
import com.socks.library.KLog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    LRecyclerView recyclerview;
    HomeAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;
    LinearLayout search_layout;

    public HomeFragment() {
        // Required item_errorsetting_ly public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstaneState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_ly, container, false);
        initView(v);
        initData();

        return v;
    }

    private void initView(View v) {
        recyclerview = (LRecyclerView) v.findViewById(R.id.recyclerview);
        recyclerview.setRefreshProgressStyle(ProgressStyle.BallClipRotate);
        search_layout = (LinearLayout) v.findViewById(R.id.search_layout);
        bindServers();
    }

    private void initData() {
        final Call<RootDataBean> getdata = RetrofitManager.getInstance().getDefaultRetrofit()
                .create(ApiCollection.GetHomeData.class).getHomeData("");
        getdata.enqueue(new Callback<RootDataBean>() {
            @Override
            public void onResponse(Call<RootDataBean> call, Response<RootDataBean> response) {
                if (response.body().status == 1) {
                    List<BaseBean> list = GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(response.body().data), new TypeToken<List<BaseBean>>() {
                    }.getType());
                    KLog.json(GsonUtils.getInstance().toJson(list));
                    adapter = new HomeAdapter(list, getContext());
                    mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
                    GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
                    recyclerview.setLayoutManager(manager);
                    recyclerview.setAdapter(mLRecyclerViewAdapter);
                } else {
                    ToastUtils.showShortToast(getContext(), response.body().message);
                }
            }

            @Override
            public void onFailure(Call<RootDataBean> call, Throwable t) {
                Log.d("TAG-Home", "Error" + t.getMessage());
            }
        });

        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchActivity.class));
                //开始下载
                VideoDownLoadManager.getInstance().startDownLoad(getContext(), binder, "9A5717A2DDB39B909C33DC5901307461",
                        "9A5717A2DDB39B909C33DC5901307461", "encrypt");
            }
        });
    }

    //测试
    private VideoDownLoadService.DownloadBinder binder;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("service disconnected", name + "");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (VideoDownLoadService.DownloadBinder) service;
        }
    };
    private Intent service;

    void bindServers() {
        service = new Intent(getContext(), VideoDownLoadService.class);
        getContext().bindService(service, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (serviceConnection != null) {
            getContext().unbindService(serviceConnection);
        }
    }
}
