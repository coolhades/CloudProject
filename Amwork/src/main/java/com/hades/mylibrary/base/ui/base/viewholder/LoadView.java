package com.hades.mylibrary.base.ui.base.viewholder;

import android.content.Context;

import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.pojo.BaseBean;

/**
 * Created by Hades on 2016/11/3.
 * Recyclerview中的adapter，data 绑定 view
 */
public class LoadView {

    private static LoadView ourInstance = new LoadView();

    public static LoadView getInstance() {
        return ourInstance;
    }

    private LoadView() {
    }

    /**
    * 创建时间 2016/11/8
    * auther Hades
    * 描述  holder 所有holder的基类
     *     BaseBean 封装了基本数据类型
    **/
    public void loadView(RootViewHolder holder, BaseBean bean, Context context) {
        //传入json
        //此处需要还原Json后重新解析，因为Gson是强映射，有类型擦除问题
        holder.setData(GsonUtils.getInstance().toJson(bean.getBlockData()), context);
        holder.setConfig(GsonUtils.getInstance().toJson(bean.getBlockConfig()), context);
    }
}
