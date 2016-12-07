package com.hades.mylibrary.cloud.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.data.ACache;
import com.hades.mylibrary.base.factory.TransactionFactory;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.LoadImgUtils;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.base.ui.customview.CircularImage;
import com.hades.mylibrary.cloud.bean.CompanyListBean;
import com.hades.mylibrary.cloud.constant.ApiCollection;
import com.socks.library.KLog;

import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChooseConpanyActivity extends Activity {

    RecyclerView recyclerView;
    List<CompanyListBean> datalist;
    FancyButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseplatform_ly);

        init();
    }

    private void init() {
        if (null != ACache.get(this).getAsString("user_tag") && !ACache.get(this).getAsString("user_tag").equalsIgnoreCase("")){
            RetrofitManager.getInstance().setBaseUrl(ACache.get(this).getAsString("user_tag"));
            //跳转平台
            Intent i = new Intent();
            //app注册的action
            i.setAction(TransactionFactory.getInstance().setTargetName("MainActivity"));
            ChooseConpanyActivity.this.startActivity(i);
            ChooseConpanyActivity.this.finish();
        }

        recyclerView = (RecyclerView) findViewById(R.id.company_list);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        button = (FancyButton) findViewById(R.id.button);

        initData();
        initEvent();
    }

    private void initEvent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //弹出弹窗
                AlertDialog dialog = new AlertDialog.Builder(ChooseConpanyActivity.this).setTitle(R.string.NOTIFY_DIALOG_TITLE)
                        .setNegativeButton(R.string.NO, null).setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //跳转公共平台
                                Intent i = new Intent();
                                i.setAction(TransactionFactory.getInstance().setTargetName("MainActivity"));
                                ChooseConpanyActivity.this.startActivity(i);
                                ChooseConpanyActivity.this.finish();
                                ACache.get(ChooseConpanyActivity.this).put("user_tag", RetrofitManager.getInstance().getmBaseUrl());
                            }
                        })
                        .setMessage(R.string.NOTIFY_CHOOSEPLATFORM_MESSAGE).create();
                dialog.show();
            }
        });
    }

    private void initData() {
        Call<RootDataBean<List<CompanyListBean>>> getCompanyList = RetrofitManager.getInstance().getDefaultRetrofit("http://www.ab-auto-mooc.com/api/default/")
                .create(ApiCollection.GetUserCompanyList.class)
                .getCampanyList("ZHUTEST01");
        getCompanyList.enqueue(new Callback<RootDataBean<List<CompanyListBean>>>() {
            @Override
            public void onResponse(Call<RootDataBean<List<CompanyListBean>>> call, Response<RootDataBean<List<CompanyListBean>>> response) {
                Log.d("TAG-Login", GsonUtils.getInstance().toJson(response.body()));
                datalist = response.body().data;

                initAdapter();
            }

            @Override
            public void onFailure(Call<RootDataBean<List<CompanyListBean>>> call, Throwable t) {

            }
        });
    }

    private void initAdapter() {
        recyclerView.setAdapter(new CommonAdapter<CompanyListBean>(this, R.layout.item_recycler_chooseplatform_content, datalist) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, final CompanyListBean companyListBean, int position) {
                CircularImage image = holder.getView(R.id.headimage);
                TextView title = holder.getView(R.id.company_name);
                TextView desc = holder.getView(R.id.desc);
                TextView course = holder.getView(R.id.course);
                TextView teacher = holder.getView(R.id.teacher);
                TextView time = holder.getView(R.id.createtime);

                LoadImgUtils.loadUserHeader(mContext, companyListBean.getCompany_logo(), image);
                title.setText(companyListBean.getCompany_name());
                desc.setText(companyListBean.getCompany_desc());
                course.setText(R.string.TV_COURSE + companyListBean.getCourse_count());
                teacher.setText(R.string.TV_TEACHER + companyListBean.getTeacher_count());
                time.setText(companyListBean.getCreate_time());


                LinearLayout list_item = holder.getView(R.id.recyclerview_item);
                list_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RetrofitManager.getInstance().setBaseUrl(companyListBean.getCompany_domain());
                        KLog.json(RetrofitManager.getInstance().getmBaseUrl());

                        ACache.get(ChooseConpanyActivity.this).put("user_tag", RetrofitManager.getInstance().getmBaseUrl());

                        Intent i = new Intent();
                        i.setAction(TransactionFactory.getInstance().setTargetName("MainActivity"));
                        mContext.startActivity(i);
                        ChooseConpanyActivity.this.finish();

//                        companyListBean.setActioncode("main");
//                        RetrofitManager.getInstance().setBaseUrl(companyListBean.getCompany_domain());
//                        HandleTransaction.getInstance().handleTransaction(companyListBean, mContext, new Bundle());
                    }
                });
            }


        });
    }
}
