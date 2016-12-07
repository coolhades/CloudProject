package com.hades.mylibrary.cloud.biz.bizbase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.GridLayoutParamsBean;
import com.hades.mylibrary.cloud.ui.viewholder.layoutmanager.ResizeLayoutParams;

import java.util.List;

/**
 * Created by Hades on 2016/12/2.
 * 排序通用组件
 * 必须先将title绑定到sortKey上
 * 传入titleList
 * 点击事件触发排序
 */
public abstract class BaseSortView {
    protected View mView;
    protected Context context;
    LayoutInflater layoutInflater;
    protected int layout_id;
    protected List<String> mData;
    protected List<String> mSortKey;

    protected RecyclerView recyclerView;
    protected CommonAdapter adapter;
    protected OnSortListener onSortListener;
    protected ViewGroup mParent;
    protected GridLayoutParamsBean layoutParamsBean;
    protected ResizeLayoutParams resizeLayoutParams = new ResizeLayoutParams();

    /**
     * 创建时间 2016/12/2
     * auther Hades
     * 描述 layout_id item布局id
     **/
    public BaseSortView(Context context, int layout_id, List<String> title, ViewGroup parent) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.layout_id = layout_id;
        this.mData = title;
        this.mParent = parent;
    }

    public View getView() {
        mView = layoutInflater.inflate(layout_id, mParent, false);
        initView();
        initData();
        initEvent();
        Log.d("TAG", "view 创建了");
        return mView;
    }

    //子类实现适配器 及绑定
    protected abstract void initEvent();

    protected abstract void initData();

    private void initView() {
        recyclerView = (RecyclerView) mView.findViewById(R.id.sort_list);
    }

    public interface OnSortListener {
        void OnClickSort(View view, String s, int position);
    }

    public void setOnSortListener(OnSortListener l) {
        if (l != null) {
            onSortListener = l;
        }
    }
}
