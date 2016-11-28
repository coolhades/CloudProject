package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ILayoutParams;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;
import com.hades.mylibrary.cloud.adapter.CourseAdapter;
import com.hades.mylibrary.cloud.bean.Lessonblock;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
 * Created by Hades on 2016/11/3.
 * 名师详情页 课程列表
 */

public class TeacherCourseViewHolder extends RootViewHolder {


    RecyclerView recyclerview;
    List<Lessonblock> data;
    CourseAdapter adapter;
    GridLayoutManager.LayoutParams params;

    GridLayoutParamsBean layoutParamsBean;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();

    public TeacherCourseViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setConfig(String rootBean, Context context) {
        super.setConfig(rootBean, context);
    }

    @Override
    public void setData(String object, final Context context) {
        data = GsonUtils.getInstance().fromJson(object, new TypeToken<List<Lessonblock>>() {
        }.getType());

        //HORIZONTAL的情况下 spanCount控制行数 相反控制列数
        GridLayoutManager manager = new GridLayoutManager(context, 2);//2列
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(manager);
        adapter = new CourseAdapter(context, data.get(0).getItem());
        recyclerview.setAdapter(adapter);
        adapter.setOnLayoutParams(new ILayoutParams() {
            @Override
            public GridLayoutManager.LayoutParams getLayoutParams() {
                return resizeLayoutParams.initParams(context, data.get(0).getItem().size(), layoutParamsBean, ParamsType.ONLY_PIC);
            }
        });

    }

    @Override
    protected void initview(View view) {
        recyclerview = (RecyclerView) itemView.findViewById(R.id.recycler_holder);
        layoutParamsBean = new GridLayoutParamsBean();
        layoutParamsBean.setSpancount(2);
        layoutParamsBean.setLeft(10);
        layoutParamsBean.setTop(10);
        layoutParamsBean.setRight(10);
        layoutParamsBean.setButtom(10);

    }
}
