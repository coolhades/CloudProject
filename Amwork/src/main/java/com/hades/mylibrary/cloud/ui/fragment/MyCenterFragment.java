package com.hades.mylibrary.cloud.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.pojo.BaseBean;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;

import java.util.List;

import static com.hades.mylibrary.R.id.recyclerview;


/**
 * A simple {@link Fragment} subclass.
 * 个人中心
 */
public class MyCenterFragment extends Fragment {

    LRecyclerView mine_recycler;
    LRecyclerViewAdapter lRecyclerViewAdapter;
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
        mine_recycler = (LRecyclerView) mView.findViewById(recyclerview);
//        mineAdapter = new HomeAdapter(datalist, getContext());
    }


    private void initData() {
//        mineAdapter = new HomeAdapter(list, getContext());
//        lRecyclerViewAdapter = new LRecyclerViewAdapter(mineAdapter);
//        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
//        mine_recycler.setLayoutManager(manager);
//        mine_recycler.setAdapter(lRecyclerViewAdapter);
    }



}
