package com.automooc.bizsimpledemo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.automooc.bizsimpledemo.bizbase.BaseSortView;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
* 创建时间 2016/12/7
* auther Hades
* 描述
 * 组合控件，一个view包含了一个Recyclerview 用来处理排序的控件
**/
public class BizSortView extends BaseSortView {

    public BizSortView(Context context, int layout_id, List<String> title, ViewGroup group) {
        super(context, layout_id, title, group);
        layoutParamsBean = new GridLayoutParamsBean(context);
        layoutParamsBean.setSpancount(5);
        layoutParamsBean.setLeft(1);
        layoutParamsBean.setTop(0);
        layoutParamsBean.setRight(1);
        layoutParamsBean.setButtom(0);
    }

    @Override
    protected void initEvent() {

    }
    GridLayoutParamsBean layoutParamsBean;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();
    @Override
    protected void initData() {
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CommonAdapter<String>(context, layout_id, mData) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return resizeLayoutParams.initParams(context, 2, layoutParamsBean, ParamsType.CONTAINS_OTHER);
            }

            @Override
            protected void convert(BaseViewHolder holder, final String s, final int position) {
                TextView title = holder.getView(R.id.title);
                title.setText(s);
                title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onSortListener.OnClickSort(view, s, position);
                    }
                });
            }

        };

        recyclerView.setAdapter(adapter);

    }


}
