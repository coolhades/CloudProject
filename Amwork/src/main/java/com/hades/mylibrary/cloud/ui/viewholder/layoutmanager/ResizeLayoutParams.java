package com.hades.mylibrary.cloud.ui.viewholder.layoutmanager;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;

import com.hades.mylibrary.base.projectutils.ScreenUtils;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ParamsType;

/**
 * 创建时间 2016/11/11
 * auther Hades
 * 描述   用来覆盖LayoutManager的onLayoutChild方法，根据item、列数及
 **/

public class ResizeLayoutParams {

    Params newParams;

    public ResizeLayoutParams() {

    }

    public GridLayoutManager.LayoutParams initParams(Context context, int size, GridLayoutParamsBean layoutParamsBean, int type) {
        if (newParams == null) {
            //默认实现
            return getOraginalParams(context, size, layoutParamsBean, type);
        }
        return newParams.getParams();
    }

    public void setOnParams(Params p){
        this.newParams = p;
    }

    public Params getNewParams() {
        return newParams;
    }

    //单例副作用
//    public void setNewParams() {
//        this.newParams = null;
//    }

    /**
     * 创建时间 2016/11/11
     * auther Hades
     * 描述 size 数据源的size
     * @param size 数据源的size
     *             @param layoutParamsBean 封装了padding 参数【默认为dp】
     *                                     @param type 处理了单独图片和其他情况
     * type 0：默认实现的params 一种是只有一张图片【图片有比例要求】，
     *      1：另一种是图片底下带文字【wrap_content】
     **/
    private GridLayoutManager.LayoutParams getOraginalParams(Context context, int size, GridLayoutParamsBean layoutParamsBean, int type) {
        int width = ScreenUtils.getPhoneScreenWidth(context);
        Log.d("TAG-ScreenWidth", "ScreenWidth="+width);
        // 计算Item的宽度
        int itemWidth;
        int itemHeight;
        //处理单独一个item情况
        if (size == 1) {
            itemWidth = width;
        } else {
            itemWidth = width / layoutParamsBean.getSpancount();
            //params.setMargins 会自动重新计算itemwidth 因此不需要减掉layoutParamsBean设置的padding了
//                    - (layoutParamsBean.getLeft() + layoutParamsBean.getRight());
            Log.d("TAG-SpaceWidth", "SpaceWidth="+layoutParamsBean.getLeft());
            Log.d("TAG-ItemWidth", "ItemWidth="+itemWidth);
        }
        if (type == ParamsType.ONLY_PIC) {
            itemHeight = (itemWidth / 16) * 9;
        }else {
            itemHeight = GridLayoutManager.LayoutParams.WRAP_CONTENT;
        }
        GridLayoutManager.LayoutParams params = new GridLayoutManager.LayoutParams(itemWidth, itemHeight);
        params.setMargins(layoutParamsBean.getLeft(), layoutParamsBean.getTop(), layoutParamsBean.getRight(), layoutParamsBean.getButtom());
        return params;
    }


    public interface Params{
        GridLayoutManager.LayoutParams getParams();
    }
}
