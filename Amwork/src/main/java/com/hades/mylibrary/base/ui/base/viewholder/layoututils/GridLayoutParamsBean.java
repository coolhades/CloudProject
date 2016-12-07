package com.hades.mylibrary.base.ui.base.viewholder.layoututils;

import android.content.Context;

/**
* 创建时间 2016/11/11
* auther Hades
* 描述   ora: 布局方式 暂时无用
 *      spanCount:控制列数【强制控制，在行数多、item数量不够情况下回留空】
 *      其它：padding【适用于只包含图片控件的情况，其余建议使用addItemDecoration，除非要求所有item都有padding】
 * 对外提供设置dp值，内部保存转换为px值，便于params设置
**/
public class GridLayoutParamsBean {
    int ora;
    int spancount;
    int left;
    int top;
    int right;
    int buttom;

    Context context;
    public GridLayoutParamsBean(Context context) {
        this.context = context;
    }

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public int getSpancount() {
        return spancount;
    }

    public void setSpancount(int spancount) {
        this.spancount = spancount;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getButtom() {
        return buttom;
    }

    public void setButtom(int buttom) {
        this.buttom = buttom;
    }
}
