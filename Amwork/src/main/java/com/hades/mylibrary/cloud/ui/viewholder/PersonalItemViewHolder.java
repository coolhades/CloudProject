package com.hades.mylibrary.cloud.ui.viewholder;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.cloud.bean.BannerBean;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
* 创建时间 2016/11/21
* auther Hades
* 描述   个人中心Recyclerview item
 *根据showcode跳转页面
**/
public class PersonalItemViewHolder extends RootViewHolder {

    RecyclerView recyclerview;
    CommonAdapter adapter;

    List<BannerBean> categoryList;
    GridLayoutParamsBean layoutParamsBean;
    GridLayoutManager.LayoutParams params;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();

    public PersonalItemViewHolder(View itemView) {
        super(itemView);
        categoryList = new ArrayList<>();

    }

    @Override
    public void setConfig(String config, Context context) {

    }

    @Override
    public void setData(String object, final Context context) {

    }

    @Override
    protected void initview(View view) {


    }


}
