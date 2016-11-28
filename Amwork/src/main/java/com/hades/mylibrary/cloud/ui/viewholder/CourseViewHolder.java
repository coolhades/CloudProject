package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;
import com.hades.mylibrary.cloud.adapter.CourseAdapter;
import com.hades.mylibrary.cloud.bean.Lesson;
import com.hades.mylibrary.cloud.bean.Lessonblock;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
 * Created by Hades on 2016/11/3.
 * Course模块 包含课程、老师等
 */

public class CourseViewHolder extends RootViewHolder {


    RecyclerView recyclerview;
    List<Lessonblock> data;
    CourseAdapter adapter;
    GridLayoutManager.LayoutParams params;

    GridLayoutParamsBean layoutParamsBean;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();

    public CourseViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setConfig(String config, Context context) {

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
//        new CommonAdapter<Lesson>(context, R.layout.course_item, data.get(0).getItem()
        recyclerview.setAdapter(new CommonAdapter<Lesson>(context, R.layout.course_item, data.get(0).getItem()) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return resizeLayoutParams.initParams(context, data.get(0).getItem().size(), layoutParamsBean, ParamsType.ONLY_PIC);
            }

            @Override
            protected void convert(BaseViewHolder holder, Lesson lesson, int position) {
                TextView textView = (TextView) itemView.findViewById(R.id.text1);
                ImageView imageView = (ImageView) itemView.findViewById(R.id.imge);
                textView.setText(lesson.getTitle());
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                list.get(position).setActioncode("coursedetail");
//                HandleTransaction.getInstance().handleTransaction(list.get(position), mContext, new Bundle());
                    }
                });
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
