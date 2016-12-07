package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.bean.TestBean;


/**
 * Created by jiuzheyange on 2016/8/18.
 */
public class PagerCourseList {
    Context mContext;
    View mView;
    LRecyclerView lRecyclerView;
    HomeAdapter adapter;
    LRecyclerViewAdapter mLRecyclerViewAdapter;

    TestBean testbean;

    public PagerCourseList(Context mContext) {
        this.mContext = mContext;
    }

    public View getView() {
        mView = View.inflate(mContext, R.layout.lrecyclerview_ly, null);
        initView();
        initData();
        initEvent();

        return mView;
    }

    private void initView() {
        lRecyclerView = (LRecyclerView) mView.findViewById(R.id.recyclerview);

    }


    private void initData() {


        adapter = new HomeAdapter(testbean.getData(), mContext);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        lRecyclerView.setAdapter(mLRecyclerViewAdapter);

    }




    private void initEvent() {
    }

}
