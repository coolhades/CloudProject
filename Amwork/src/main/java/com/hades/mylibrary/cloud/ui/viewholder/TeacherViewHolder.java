package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.pojo.BlockConfig;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;
import com.hades.mylibrary.cloud.bean.Lesson;
import com.hades.mylibrary.cloud.bean.Lessonblock;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
 * Created by Hades on 2016/11/3.
 */

public class TeacherViewHolder extends RootViewHolder {


    RecyclerView recyclerview;
    List<Lessonblock> data;

    private BlockConfig blockconfig;

    GridLayoutParamsBean layoutParamsBean;
    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();


    public TeacherViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setData(String object, final Context context) {
        data = GsonUtils.getInstance().fromJson(object, new TypeToken<List<Lessonblock>>() {
        }.getType());
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(manager);

        recyclerview.setAdapter(new CommonAdapter<Lesson>(context,
                R.layout.item_recycler_catorycontent, data.get(0).getItem()) {
            @Override
            protected GridLayoutManager.LayoutParams  setLayoutParams() {
                return resizeLayoutParams.initParams(context, data.get(0).getItem().size(),
                        layoutParamsBean, ParamsType.CONTAINS_OTHER);
            }

            @Override
            protected void convert(BaseViewHolder holder, Lesson lesson, int position) {
                ImageView view = holder.getView(R.id.imge);
                view.setImageResource(R.mipmap.ic_universal_launcher);
                TextView textView = holder.getView(R.id.lable);
                textView.setText(lesson.getTitle());


                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("TAG-click", "点击事件");

                    }
                });
            }

        });

    }

    @Override
    protected void initview(View view) {
        recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview_holder);

    }

    @Override
    public void setConfig(String config, Context context) {
        layoutParamsBean = new GridLayoutParamsBean(context);
        layoutParamsBean.setSpancount(4);
        layoutParamsBean.setLeft(-1);
        layoutParamsBean.setTop(-1);
        layoutParamsBean.setRight(-1);
        layoutParamsBean.setButtom(-1);
    }
}
