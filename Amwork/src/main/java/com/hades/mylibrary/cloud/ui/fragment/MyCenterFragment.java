package com.hades.mylibrary.cloud.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.pojo.BaseBean;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * 个人中心
 */
public class MyCenterFragment extends Fragment {

    LRecyclerView mine_recycler;
    HomeAdapter mineAdapter;
    View mView;
    List<BaseBean> datalist;

    public MyCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.lrecyclerview, container, false);
        initView();
        initData();
        return mView;
    }

    private void initView() {
        mine_recycler = (LRecyclerView) mView.findViewById(R.id.mine_recycler);
//        mineAdapter = new HomeAdapter(datalist, getContext());
    }


    private void initData() {

    }



}
