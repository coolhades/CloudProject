package com.hades.libamtest;

import com.hades.libam.ui.interf.IRootView;

/**
 * Created by Hades on 16/10/17.
 */

public interface testView<T> extends IRootView {

    //扩展方法 更新UI  传回JavaBean View负责更新UI
    void loadData(T data);

}
