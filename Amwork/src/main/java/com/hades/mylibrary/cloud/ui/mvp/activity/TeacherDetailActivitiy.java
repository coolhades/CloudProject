package com.hades.mylibrary.cloud.ui.mvp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.mvp.activity.BaseActivity;
import com.hades.mylibrary.cloud.ui.mvp.presenter.DetailPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import net.lucode.hackware.magicindicator.MagicIndicator;

/**
* 创建时间 2016/11/21
* auther Hades
* 描述   教师详情页 课程列表
**/
public class TeacherDetailActivitiy extends BaseActivity<DetailPresenter> implements ILoadData{

    MagicIndicator magicIndicator;
    ViewPager viewpager;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherdetail_ly);
    }

    @Override
    protected DetailPresenter onLoadPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        back = (ImageView) findViewById(R.id.back_iv);
        magicIndicator = (MagicIndicator)findViewById(R.id.magic_indicator);
    }

    @Override
    protected void initData() {
        //PagerCourseList

    }

    @Override
    protected void initEvent() {

    }

    //初始化数据
    @Override
    public void onInitData(String data) {

    }
}
