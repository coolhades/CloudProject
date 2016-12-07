package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.ExpandableListView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.view.HostRecyclerView;
import com.hades.mylibrary.cloud.adapter.CourseIntroduceListAdapter;
import com.hades.mylibrary.cloud.bean.JieBean;
import com.hades.mylibrary.cloud.bean.ZhangBean;

import java.util.ArrayList;
import java.util.List;


/**
* 创建时间 2016/11/10
* auther Hades
* 描述  课程view
**/
public class CourseIntroduceListView extends HostRecyclerView {
    private Context mContext;
    ExpandableListView expand_listview;
    List<ZhangBean> parentLists;
    List<List<JieBean>>  childLists;
    List<ZhangBean> zhangBeanList;

    CourseIntroduceListAdapter adapter;


    public CourseIntroduceListView(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public View getView() {
        return super.getView();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_courseintroducelist_ly;
    }
    @Override
    protected Context getContext() {
        return mContext;
    }
    @Override
    protected void initView(View view) {
        expand_listview = (ExpandableListView) view.findViewById(R.id.expand_listview);
    }

    @Override
    protected void initData() {
        expand_listview.setGroupIndicator(null);
        parentLists=new ArrayList<>();
        childLists=new  ArrayList<>();
        parentLists=zhangBeanList;

//        for(int i=0;i<parentLists.size();i++)
//        {
//            childLists.add(zhangBeanList.get(i).getChild());
//        }
//
//        if(parentLists!=null&&parentLists.size()>0) {
//            adapter = new CourseIntroduceListAdapter(mContext, parentLists, childLists);
//            expand_listview.setAdapter(adapter);
//            for (int i = 0; i < parentLists.size(); i++) {
//                expand_listview.expandGroup(i);
//            }
//        }

    }

    @Override
    protected void initEvent() {

    }



}
