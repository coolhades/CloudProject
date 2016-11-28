package cn.ezreal.AMPrivateProject;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hades.corelib.AmFactory;
import com.hades.corelib.MAPTYPE;
import com.hades.mylibrary.cloud.ui.fragment.CourseFragment;
import com.hades.mylibrary.cloud.ui.fragment.HomeFragment;
import com.hades.mylibrary.cloud.ui.fragment.MyCenterFragment;
import com.hades.mylibrary.cloud.videocache.DataSet;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionYes;

import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

/**
 * 创建时间 16/10/17
 * auther Hades
 **/
public class MainActivity extends AppCompatActivity {

    BottomNavigationBar navigationBar;
    private int CAPTURE_PHOTO_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();

        DataSet.init(this);//视频下载数据库


    }



    protected void initView() {
        navigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        setDefaultFragment();
    }

    CourseFragment courseFragment;
    HomeFragment homeFragment;
    MyCenterFragment myCenterFragment;



    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = (HomeFragment) AmFactory.getInstance().create("homefragment", MAPTYPE.VIEWMAP);
        transaction.replace(R.id.container, homeFragment);
        transaction.commit();
    }


    protected void initData() {
        navigationBar
                .setMode(MODE_FIXED)
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
//                .setInActiveColor("#FDF5F5") //未选中图标及文字颜色
//                .setBarBackgroundColor("#FFAC00")//选中图标及文字颜色
                .setActiveColor("#FFAC00") // finxed模式下为选中图标颜色，
                .addItem(new BottomNavigationItem(R.mipmap.logo, R.string.home))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.course))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.mine))
                .initialise();
    }


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
                if (null == courseFragment) {
                    homeFragment = (HomeFragment) AmFactory.getInstance().create("homefragment", MAPTYPE.VIEWMAP);
                } else {

                }
                f = homeFragment;
                ft.replace(R.id.container, f);
                break;
            case 1:
                if (null == courseFragment) {
                    courseFragment = (CourseFragment) AmFactory.getInstance().create("coursefragment", MAPTYPE.VIEWMAP);
                } else {

                }
                f = courseFragment;
                ft.replace(R.id.container, f);
                break;
            case 2:
                if (null == myCenterFragment){
                    myCenterFragment = (MyCenterFragment) AmFactory.getInstance().create("mycenterfragment", MAPTYPE.VIEWMAP);
                }
                f = myCenterFragment;
                ft.replace(R.id.container, f);

        }
        ft.commitAllowingStateLoss();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        AndPermission.onRequestPermissionsResult(MainActivity.this, requestCode, permissions, grantResults);
    }

    @PermissionYes(1)
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 调用系统相机
        MainActivity.this.startActivity(intent);
    }
}