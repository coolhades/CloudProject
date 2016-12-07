package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.BannerImageLoader;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.base.ui.customview.banner.Banner;
import com.hades.mylibrary.base.ui.customview.banner.BannerConfig;
import com.hades.mylibrary.base.ui.customview.banner.Transformer;
import com.hades.mylibrary.base.ui.customview.banner.listener.OnBannerClickListener;
import com.hades.mylibrary.cloud.bean.AMBanner;
import com.hades.mylibrary.cloud.bean.BannerBean;
import com.hades.mylibrary.cloud.ui.mvp.activity.CourseDetailActivity;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hades on 2016/11/3.
 */

public class BannerViewHolder extends RootViewHolder {

    List<BannerBean> listBanner;
    List<String> images;
    Banner banner;
    //config
    Map<String, String> configmap;


    public BannerViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    protected void initview(View view) {
        banner = (Banner) view.findViewById(R.id.cbanner);

    }

    @Override
    public void setConfig(String config, final Context context) {
        //解析为Map
        configmap = GsonUtils.getInstance().fromJson(config, new TypeToken<Map<String,String>>(){}.getType());
        KLog.json(GsonUtils.getInstance().toJson(configmap));
        if (configmap.containsKey("autoScrollTimeInterval")){
            //设置轮播时间
            banner.setDelayTime(Integer.valueOf(configmap.get("autoScrollTimeInterval")) );
        }
        if (configmap.containsKey("autoScroll")){
            //设置自动轮播，默认为true
            if (configmap.get("autoScroll").equalsIgnoreCase("1")) {
                banner.isAutoPlay(true);
            }else {
                banner.isAutoPlay(false);
            }
        }

        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Accordion);
        //设置标题集合（当banner样式有显示title时）
//        view_banner.setBannerTitles(Arrays.asList(titles));


        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setIndicatorSize(40,40);


        //banner设置方法全部调用完毕时最后调用
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent i = new Intent(context, CourseDetailActivity.class);
                context.startActivity(i);


            }
        });
        banner.start();
    }

    @Override
    public void setData(String data, final Context context) {
        Log.d("TAG-BannerBean", data);
        AMBanner banner = GsonUtils.getInstance().fromJson(data, AMBanner.class);
        listBanner = banner.list;
        images = new ArrayList<>();
        for (int i = 0; i < listBanner.size(); i++) {
           images.add(listBanner.get(i).getImg());
        }
    }



}
