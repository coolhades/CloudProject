package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.view.HostRecyclerView;
import com.hades.mylibrary.cloud.ui.mvp.activity.VideoActivity;


/**
* 创建时间 2016/11/10
* auther Hades
* 描述  课程view
**/
public class CourseIntroduceView extends HostRecyclerView {
    private Context mContext;
    TextView jion_lesson;


    public CourseIntroduceView(Context mContext) {
        this.mContext = mContext;
    }
    @Override
    public View getView() {
        return super.getView();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.viewpager_courseintroduce_ly;
    }
    @Override
    protected Context getContext() {
        return mContext;
    }
    @Override
    protected void initView(View view) {
        jion_lesson = (TextView) view.findViewById(R.id.jion_lesson);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        jion_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, VideoActivity.class);
                mContext.startActivity(i);
            }
        });
    }



}
