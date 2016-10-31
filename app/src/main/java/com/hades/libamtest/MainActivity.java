package com.hades.libamtest;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hades.libam.ui.activity.BaseActivity;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionYes;

import butterknife.ButterKnife;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;


/**
 * 创建时间 16/10/17
 * auther Hades
 * 描述  方法执行顺序：initView onLoadPresenter initData initEvent
 * 必须实现 xxxView 接口 保证Presenter可以attachView
 * <p>
 * 使用流程：
 * View：创建view接口并继承 IRootView  泛型注入 支持任意对象回调
 * 只负责UI绘制、更新、触发事件
 * Presenter：创建Presenter 并继承BasePresenter<view, model> 只负责调度 没有过多逻辑
 * 1、加载数据：优先缓存，最后请求网络
 * 2、缓存数据：持久化、内存缓存
 * <p>
 * Model：创建model 并继承IRootModel   接口注入  支持数据直接回调给Presenter
 **/
public class MainActivity extends BaseActivity<testPresenter>
        implements testView {

    BottomNavigationBar navigationBar;
    private int CAPTURE_PHOTO_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

//    TextView textView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected testPresenter onLoadPresenter() {
        return new testPresenter();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        navigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        setDefaultFragment();
    }

    BlankFragment fragment;
    BlankFragment2 fragment2;


    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        fragment = new BlankFragment();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    protected void initData() {
        //初始化数据 调用Presenter方法
        mPresenter.initData();
        navigationBar
                .setMode(MODE_FIXED)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
//                .setInActiveColor("#FDF5F5") //未选中图标及文字颜色
//                .setBarBackgroundColor("#FFAC00")//选中图标及文字颜色
                .setActiveColor("#FFAC00") // finxed模式下为选中图标颜色，
                .addItem(new BottomNavigationItem(R.mipmap.logo, "Home"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Books"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Music"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Movies & TV"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "Games"))
                .initialise();
    }


    @Override
    protected void initEvent() {
        //设置监听事件
        navigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                chooseTab(position);
//                AndPermission.with(MainActivity.this)
//                        .requestCode(1)
//                        .permission(Manifest.permission.CAMERA)
//                        .send();


            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void chooseTab(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f;
        switch (position) {
            case 0:
                if (null == fragment) {
                    fragment = new BlankFragment();
                } else {

                }
                f = fragment;
                ft.replace(R.id.container, f);
                break;
            case 1:
                if (null == fragment2) {
                    fragment2 = new BlankFragment2();
                } else {

                }
                f = fragment2;
                ft.replace(R.id.container, f);
                break;

        }
        ft.commitAllowingStateLoss();

    }

    //testView
    @Override
    public void loadData(Object data) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AndPermission.onRequestPermissionsResult(MainActivity.this, requestCode, permissions, grantResults);
    }

    @PermissionYes(1)
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 调用系统相机
        MainActivity.this.startActivity(intent);
    }
}
