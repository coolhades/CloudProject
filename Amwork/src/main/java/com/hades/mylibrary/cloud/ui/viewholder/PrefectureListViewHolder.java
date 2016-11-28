package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.cloud.bean.TeacherList;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
 * Created by Hades on 2016/11/3.
 */

public class PrefectureListViewHolder extends RootViewHolder {


    RecyclerView recyclerview;
    List<TeacherList> data;



    ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();


    public PrefectureListViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setData(String object, final Context context) {
        data = GsonUtils.getInstance().fromJson(object, new TypeToken<List<TeacherList>>() {
        }.getType());

        Log.d("TAG-TeacherList", GsonUtils.getInstance().toJson(data) );
        GridLayoutManager manager = new GridLayoutManager(context, 1);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);

        recyclerview.setAdapter(new CommonAdapter<TeacherList.ItemBean>(context,
                R.layout.teacherlist_item, data.get(0).getItem()) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                GridLayoutManager.LayoutParams params = new GridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                return params;
            }

            @Override
            protected void convert(BaseViewHolder holder, TeacherList.ItemBean itemBean, int position) {
                TextView textView = holder.getView(R.id.name);
                textView.setText(itemBean.getTeacher_name());
                TextView textView1 = holder.getView(R.id.content_tv);
                textView1.setText(itemBean.getIntroduction());
            }


        });

    }

    @Override
    protected void initview(View view) {
        recyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview_holder);
    }

    @Override
    public void setConfig(String config, Context context) {

    }
}
