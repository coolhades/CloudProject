package com.hades.mylibrary.cloud.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.NormalBaseActivity;
import com.hades.mylibrary.base.ui.customview.IndicatorManager;
import com.hades.mylibrary.cloud.ui.mvp.fragment.VideoPageCourseListFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VideoCacheActivity extends NormalBaseActivity {

    ImageButton back;
    TextView title;
    MagicIndicator indicator;
    ViewPager viewPager;

    List<Fragment> fragmentList;
    private static final String[] CHANNELS = new String[]{"已下载", "下载中"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_cache);
        init(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        title = (TextView) findViewById(R.id.head_title);
        back = (ImageButton) findViewById(R.id.back);
        indicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        IndicatorManager.initMagicIndicator(this, indicator, viewPager, mDataList);

        //加载viewpager的view
        fragmentList = new ArrayList<>();
        fragmentList.add(new VideoPageCourseListFragment());
        fragmentList.add(new VideoPageCourseListFragment());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
}
