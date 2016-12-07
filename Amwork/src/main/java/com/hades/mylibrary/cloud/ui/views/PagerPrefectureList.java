package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.bean.TestBean;



/**
 * Created by Hades on 16/9/21.
 */
public class PagerPrefectureList {
    Context mContext;
    View mView;
    LRecyclerView lRecyclerView;
    HomeAdapter adapter;
    LRecyclerViewAdapter mLRecyclerViewAdapter;

    TestBean testbean;


    public PagerPrefectureList(Context mContext) {
        this.mContext = mContext;
    }

    public View getView() {
        mView = View.inflate(mContext, R.layout.lrecyclerview_ly, null);//复用ListView
        initView();
//        initData();
        initEvent();


        return mView;
    }

    private void initView() {
        lRecyclerView = (LRecyclerView) mView.findViewById(R.id.recyclerview);
    }


    private void initData() {
        Log.d("TAG-Data", GsonUtils.getInstance().toJson(testbean.getData()));
        adapter = new HomeAdapter(testbean.getData(), mContext);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        lRecyclerView.setAdapter(mLRecyclerViewAdapter);

    }


    private void initEvent() {

    }

}
