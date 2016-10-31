package com.hades.libam.video;

import android.view.SurfaceHolder;

/**
 * Created by Hades on 2016/10/20.
 */

public interface SurfaceHolderCallBack {
    void onSurfaceViewCreated(SurfaceHolder holder);
    void onsurfaceChanged(SurfaceHolder holder, int format, int width, int height);
    void onsurfaceDestroyed(SurfaceHolder holder);


}
