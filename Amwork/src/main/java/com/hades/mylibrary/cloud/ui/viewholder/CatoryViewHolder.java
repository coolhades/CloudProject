package com.hades.mylibrary.cloud.ui.viewholder;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;
import com.hades.mylibrary.cloud.adapter.diliver.SpaceItemDecoration;
import com.hades.mylibrary.cloud.bean.BannerBean;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hades on 2016/11/3.
 */

public class CatoryViewHolder extends RootViewHolder {

    RecyclerView recyclerview;
    CommonAdapter adapter;

    List<BannerBean> categoryList;
    GridLayoutParamsBean layoutParamsBean;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();

    public CatoryViewHolder(View itemView) {
        super(itemView);
        categoryList = new ArrayList<>();

    }

    @Override
    public void setConfig(String config, Context context) {

    }

    @Override
    public void setData(String data, final Context context) {
//      object.getBlockdata 此处进行json解析
        categoryList = GsonUtils.getInstance().fromJson(data, new TypeToken<List<BannerBean>>() {
        }.getType());

        GridLayoutManager manager = new GridLayoutManager(context, 4);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        recyclerview.addItemDecoration(new SpaceItemDecoration(1, 4, 2));//水平情况有问题
        adapter = new CommonAdapter<BannerBean>(context, R.layout.catory_item, categoryList) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return resizeLayoutParams.initParams(context, categoryList.size(), layoutParamsBean, ParamsType.CONTAINS_OTHER);
            }

            @Override
            protected void convert(BaseViewHolder holder, BannerBean banner, int position) {

            }
        };
        recyclerview.setAdapter(adapter);
    }

    @Override
    protected void initview(View view) {
        recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview_catory);
        layoutParamsBean = new GridLayoutParamsBean();
//        layoutParamsBean.setOra(GridLayoutManager.HORIZONTAL);
        layoutParamsBean.setSpancount(4);
        layoutParamsBean.setLeft(1);
        layoutParamsBean.setTop(1);
        layoutParamsBean.setRight(1);
        layoutParamsBean.setButtom(1);
    }


}
