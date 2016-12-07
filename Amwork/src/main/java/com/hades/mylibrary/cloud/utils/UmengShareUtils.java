package com.hades.mylibrary.cloud.utils;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * Created by Hades on 2016/12/7.
 */

public class UmengShareUtils {

    /**
    * 创建时间 2016/12/7
    * auther Hades
    * 描述
     * @param umShareListener 分享回调做一些后续提醒和处理
    **/
    public static void doShare(Activity activity, SHARE_MEDIA platform, String title, String imageUrl,
                               String content, String targetUrl, UMShareListener umShareListener){
        UMImage image = new UMImage(activity, imageUrl);//网络图片
        new ShareAction(activity)
                .setPlatform(platform)
                .withTitle(title)
                .withMedia(image)
                .withText(content)
                .withTargetUrl(targetUrl)
                .setCallback(umShareListener)
                .share();
    }
}
