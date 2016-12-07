package com.hades.mylibrary.cloud.ui.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.data.ACache;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.SPUtils;
import com.hades.mylibrary.cloud.bean.User;
import com.hades.mylibrary.cloud.ui.mvp.fragment.LoginFragment;
import com.hades.mylibrary.cloud.ui.mvp.fragment.ResigterFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class LoginAndRegisterActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;
    LoginFragment loginFragment;
    ResigterFragment resigterFragment;

    TextView loginBt;
    TextView registerBt;
    ImageView back;

    SPUtils spUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister_ly);

        if (ACache.get(this).getAsString("user") != null && !ACache.get(this).getAsString("user").equalsIgnoreCase("")){
            //已登录
            User user = GsonUtils.getInstance().fromJson(ACache.get(this).getAsString("user"), User.class);
            if (user != null){
                startActivity(new Intent(this, ChooseConpanyActivity.class));
                this.finish();
            }
        }


//        //查看是否存在登录信息 【包括平台信息】
//        if (spUtils.contains("user_id")){
//            User user = GsonUtils.getInstance().fromJson(ACache.get(this, "loginInfo")
//                    .getAsJSONObject("user").toString(), User.class);
//            if (null != user){
//                //缓存驱动
//                DbController.getInstance().initCache(this, user.getUid());
//
//                //获取用户信息 登录并进入之前的平台
//            }
//        }


        initView();
        initData();
        initEvent();

        EventBus.getDefault().register(this);
    }


    protected void initView() {

        loginBt = (TextView) findViewById(R.id.login_bt);
        registerBt = (TextView) findViewById(R.id.register_bt);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        loginFragment = new LoginFragment();
        resigterFragment = new ResigterFragment();

        transaction.replace(R.id.fragment_layout, loginFragment).commit();
        back = (ImageView) findViewById(R.id.btn_back);

    }

    protected void initData() {

    }


    protected void initEvent() {

        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_layout, loginFragment).commit();
                registerBt.setTextColor(Color.parseColor("#333333"));
                loginBt.setTextColor(Color.parseColor("#FFFFFF"));
                registerBt.setBackgroundColor(Color.parseColor("#00000000"));
                loginBt.setBackgroundResource(R.drawable.tv_dialog_bg);
            }
        });


        registerBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment_layout, resigterFragment).commit();
                loginBt.setTextColor(Color.parseColor("#333333"));
                registerBt.setTextColor(Color.parseColor("#FFFFFF"));
                loginBt.setBackgroundColor(Color.parseColor("#00000000"));
                registerBt.setBackgroundResource(R.drawable.tv_dialog_bg);

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginAndRegisterActivity.this.finish();
            }
        });

    }


    @Subscribe(priority = 2)
    public void onLoginSuccess(Boolean isSuccess){
        if (isSuccess){
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
