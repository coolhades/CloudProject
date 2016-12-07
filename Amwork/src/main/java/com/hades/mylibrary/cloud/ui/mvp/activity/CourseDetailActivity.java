package com.hades.mylibrary.cloud.ui.mvp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.ToaUtils;
import com.hades.mylibrary.base.ui.customview.IndicatorManager;
import com.hades.mylibrary.base.ui.mvp.activity.BaseActivity;
import com.hades.mylibrary.cloud.adapter.CoursePagerAdapter;
import com.hades.mylibrary.cloud.ui.mvp.presenter.CourseDetailPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ICollectionStatus;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;
import com.hades.mylibrary.cloud.ui.views.CourseIntroduceListView;
import com.hades.mylibrary.cloud.ui.views.CourseIntroduceView;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CourseDetailActivity extends BaseActivity<CourseDetailPresenter> implements ILoadData {

    ImageView back;
    TextView videoTitle;
    ImageView collectIv;
    ImageView videoImg;
    MagicIndicator magicIndicator;
    ViewPager videoViewpager;

    List<View> lists;
    CoursePagerAdapter adapter;
    private static final String[] CHANNELS = new String[]{"简介", "目录"};
    private List<String> mDataList = Arrays.asList(CHANNELS);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_coursedetail_ly);
        init(savedInstanceState);//父类初始化
    }

    //初始化Presenter
    @Override
    protected CourseDetailPresenter onLoadPresenter() {
        return new CourseDetailPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        videoViewpager = (ViewPager) findViewById(R.id.video_viewpager);
        magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        back = (ImageView) findViewById(R.id.btn_back);
        collectIv = (ImageView) findViewById(R.id.btn_collect);
        videoTitle = (TextView) findViewById(R.id.video_title);


        lists = new ArrayList<>();
        lists.add(new CourseIntroduceView(this).getView());
        lists.add(new CourseIntroduceListView(this).getView());
        adapter = new CoursePagerAdapter(lists, this);
        videoViewpager.setAdapter(adapter);
        videoViewpager.setOffscreenPageLimit(2);


        IndicatorManager.initMagicIndicator(this, magicIndicator, videoViewpager, mDataList);
    }

    //调用Presenter 加载数据
    @Override
    protected void initData() {
        mPresenter.onFetchData();
    }

    @Override
    protected void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourseDetailActivity.this.finish();
            }
        });

        collectIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.setCollect(new ICollectionStatus() {
                    //状态回调
                    @Override
                    public void onCollectionStatusChanged(Boolean isCollect) {
                        if (isCollect){

                        }else {

                        }
                    }
                });
            }
        });

    }


    //presenter回调初始化数据
    @Override
    public void onInitData(String data) {
        ToaUtils.showTextToast(data, this);

    }



}
