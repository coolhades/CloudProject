package com.hades.mylibrary.base.ui.base.viewholder;

/**
 * Created by Hades on 2016/11/11.
 */

public interface BaseItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(BaseViewHolder holder, T t, int position);


}
