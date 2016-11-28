package com.hades.mylibrary.cloud.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
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
import com.hades.mylibrary.base.projectutils.log.KLog;
import com.hades.mylibrary.base.ui.base.pojo.BaseBean;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.utils.ToastUtils;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.ui.activity.SearchActivity;

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
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstaneState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.homeview_fragment, container, false);
        initView(v);
        initData();

        return v;
    }

    private void initView(View v) {
        recyclerview = (LRecyclerView) v.findViewById(R.id.recyclerview);
        recyclerview.setRefreshProgressStyle(ProgressStyle.BallClipRotate);
        search_layout = (LinearLayout) v.findViewById(R.id.search_layout);
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
                }else {
                    ToastUtils.showShortToast(getContext(), response.body().message);
                }
            }

            @Override
            public void onFailure(Call<RootDataBean> call, Throwable t) {
                Log.d("TAG-Home", "Error"+t.getMessage());
            }
        });

        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SearchActivity.class));
            }
        });
    }


}
