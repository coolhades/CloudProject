package com.hades.mylibrary.cloud.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.log.logtag.ToastTag;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.ToaUtils;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.hades.mylibrary.cloud.constant.ConstantSet;
import com.hades.mylibrary.cloud.utils.SaveUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        
        SaveUser save=new SaveUser(this);
        ConstantSet.user=(save.getData("userFile","user"));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getMain();
                    Thread.sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //  设置基准域名地址 获取一些配置信息
    public void getMain(){

        Call<RootDataBean<String>> getDomain = RetrofitManager.getInstance().getDefaultRetrofit(ConstantSet.getDomainAddress)
                .create(ApiCollection.GetDomain.class).getDomain("am");
        getDomain.enqueue(new Callback<RootDataBean<String>>() {
            @Override
            public void onResponse(Call<RootDataBean<String>> call, Response<RootDataBean<String>> response) {
                if (response.body().status == 1) {
                    String data = response.body().data;
                    ConstantSet.homeAddress = "http://" + data + "/";
                    //设置BaseUrl 才能正常使用
                    Log.i("TAGTAG", ConstantSet.homeAddress);
                    RetrofitManager.getInstance().setBaseUrl(ConstantSet.homeAddress);
                    Login();
                }
            }

            @Override
            public void onFailure(Call<RootDataBean<String>> call, Throwable t) {
                ToaUtils.showTextToast(ToastTag.TAG_ERROR, StartupActivity.this);
            }
        });
    }

    //获取环境配置
    private void Login() {
        Intent i = new Intent(this, LoginAndRegisterActivity.class);
        startActivity(i);
        this.finish();
    }


}
