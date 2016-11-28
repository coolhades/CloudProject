package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.view.HostRecyclerView;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;




/**
* 创建时间 2016/11/10
* auther Hades
* 描述  课程view
**/
public class CourseListView extends HostRecyclerView {
    private Context mContext;
    private LRecyclerView lRecyclerView;
    private HomeAdapter adapter;
    private LRecyclerViewAdapter mLRecyclerViewAdapter;


    public CourseListView(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public View getView() {
        return super.getView();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.lrecyclerview;
    }
    @Override
    protected Context getContext() {
        return mContext;
    }
    @Override
    protected void initView(View view) {
        lRecyclerView = (LRecyclerView) view.findViewById(R.id.recyclerview);
    }

    @Override
    protected void initData() {
//        testbean = GsonUtils.getInstance().fromJson(rootbeanToJson(), TestBean.class);
//        adapter = new HomeAdapter(testbean.getData(), mContext);
//        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
//        lRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
//        lRecyclerView.setAdapter(mLRecyclerViewAdapter);


    }

    @Override
    protected void initEvent() {

    }


}
