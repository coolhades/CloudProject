package com.hades.mylibrary.cloud.ui.viewholder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.projectutils.LoadImgUtils;
import com.hades.mylibrary.base.ui.base.viewholder.RootViewHolder;
import com.hades.mylibrary.cloud.bean.AMCourseCategoryBean;

/**
 * Created by Hades on 2016/11/28.
 */

public class AMCourseCategory extends RootViewHolder {

    ImageView img;
    TextView title_text;//title
    TextView renqi_text;
    TextView keshi_text;
    TextView price_text;
    AMCourseCategoryBean bean;
    public AMCourseCategory(View itemView) {
        super(itemView);
    }


    @Override
    protected void initview(View view) {
        img = (ImageView) view.findViewById(R.id.img);
        title_text = (TextView) view.findViewById(R.id.title_text);
        renqi_text = (TextView) view.findViewById(R.id.renqi_text);
        keshi_text = (TextView) view.findViewById(R.id.keshi_text);
        price_text = (TextView) view.findViewById(R.id.price_text);
    }

    @Override
    public void setConfig(String config, Context context) {

    }

    @Override
    public void setData(String data, Context context) {
        Log.d("AMCourseCategory",data);
        bean = GsonUtils.getInstance().fromJson(data, AMCourseCategoryBean.class);
        AMCourseCategoryBean.InfoBean infoBean = bean.getInfo();
        LoadImgUtils.loadBanner(context, infoBean.getCourse_album(), img);
        title_text.setText(infoBean.getCourse_name());
        renqi_text.setText(infoBean.getNum_visit());
        keshi_text.setText(infoBean.getNum_hour());
        price_text.setText(infoBean.getPrice());
    }
}
