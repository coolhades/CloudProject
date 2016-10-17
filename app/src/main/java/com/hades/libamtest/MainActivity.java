package com.hades.libamtest;

import android.widget.TextView;

import com.hades.libam.ui.activity.BaseActivity;
import com.hades.libam.utils.GsonUtils;
/**
* 创建时间 16/10/17
* auther Hades
* 描述  方法执行顺序：initView onLoadPresenter initData initEvent
 *     必须实现 xxxView 接口 保证Presenter可以attachView
 *
 *     使用流程：
 *     View：创建view接口并继承 IRootView  泛型注入 支持任意对象回调
 *     只负责UI绘制、更新、触发事件
 *     Presenter：创建Presenter 并继承BasePresenter<view, model> 只负责调度 没有过多逻辑
 *     1、加载数据：优先缓存，最后请求网络
 *     2、缓存数据：持久化、内存缓存
 *
 *     Model：创建model 并继承IRootModel   接口注入  支持数据直接回调给Presenter
**/
public class MainActivity extends BaseActivity<testPresenter>
        implements testView {

    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected testPresenter onLoadPresenter() {
        return new testPresenter();
    }

    @Override
    protected void initView() {
        //初始化view
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void initData() {
        //初始化数据 调用Presenter方法
        mPresenter.initData();
    }

    @Override
    protected void initEvent() {
        //设置监听事件

    }

    //testView
    @Override
    public void loadData(Object data) {
        textView.setText(GsonUtils.getInstance().toJson(data));
    }
}
