package com.hades.mylibrary.base.projectutils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hades.mylibrary.R;

/**
 * Created by jiuzheyange on 2016/8/15.
 */
public class LoadImgUtils {
    public static void loadUserHeader(Context mContext, String url, ImageView img)
    {
        Glide.with(mContext)
                .load(url)
                .error(0)//load失敗的Drawable
                .placeholder(R.mipmap.userheader)//loading時候的Drawable
                .dontAnimate() //去掉淡入淡出
                // .animate()//設置load完的動畫
//                .centerCrop()//中心切圖, 會填滿
                .fitCenter()//中心fit, 以原本圖片的長寬為主
                .into(img);
    }

    public static void loadBanner(Context mContext,String url, ImageView img)
    {
        Glide.with(mContext)
                .load(url)
                .error(0)//load失敗的Drawable
                .placeholder(0)//loading時候的Drawable
                .dontAnimate() //去掉淡入淡出
                // .animate()//設置load完的動畫
//                .centerCrop()//中心切圖, 會填滿
                .fitCenter()//中心fit, 以原本圖片的長寬為主
                .into(img);
    }



}
