package com.hades.libam.video;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Hades on 16/10/11.
 * 1、注入 surfaceView
 * 2、设置holdercallback后initHolder
 * 3、创建PlayerManager对象
 */

public class SurfaceViewManager {

    //    -1 未初始化 0已销毁 1：surfaceCreated可以绑定player
    public static int HOLDERSTATUS = -1;


    private SurfaceViewManager() {
    }

    public static SurfaceViewManager getInstance(){
        return SingtonInstance.instance;
    }

    private static class SingtonInstance{
        public static SurfaceViewManager instance = new SurfaceViewManager();
    }


    SurfaceView surfaceView; //依赖注入
    SurfaceHolder surfaceHolder; //
    SurfaceHolderCallBack mHolderCallBack; //

    //设置回调监听
    public void setHolderCallBack(SurfaceHolderCallBack holderCallBack){
        if (null != holderCallBack){
            mHolderCallBack = holderCallBack;
        }
    }

    //注入view
    public void setSurfaceView(SurfaceView view){
        if (view!= null){
            surfaceView = view;
        }
    }

    public SurfaceHolder getHolder(){
        if (surfaceView != null) {
            surfaceHolder = surfaceView.getHolder();
            return surfaceHolder;
        }else return null;
    }
/**
* 创建时间 2016/10/20
* auther Hades
* 描述  设置callback 才能初始化
**/
    public void initHolder(){
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (null == mHolderCallBack)
                {
                    return;
                }
                HOLDERSTATUS = 1;
                mHolderCallBack.onSurfaceViewCreated(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (null == mHolderCallBack)
                {
                    return;
                }
                mHolderCallBack.onsurfaceChanged(holder, format, width, height);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (null == mHolderCallBack)
                {
                    return;
                }
                HOLDERSTATUS = 0;
                mHolderCallBack.onsurfaceDestroyed(holder);
            }
        });

        // surfaceHolder.setFixedSize(320, 220);//显示的分辨率,不设置为视频默认
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//Surface类型

    }
}
