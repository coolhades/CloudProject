package com.hades.mylibrary.cloud.ui.mvp.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.reflect.TypeToken;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.base.ui.base.BaseListActivity;
import com.hades.mylibrary.base.ui.base.DataManager;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.cloud.bean.MyClass;

import java.util.List;

/**
 * Created by Hades on 2016/11/21.
 * 通用列表
 * 根据 启动时获取到的pushcode 请求不同的数据 加载不同布局
 *
 */
public class PersonalCourseActivity extends BaseListActivity {

    List<MyClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        setManager(new DataManager() {
            @Override
            public void fetchData(String d) {
                initRecycler(d);
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    private void initRecycler(String data){
        //根据具体需求获取数据
        list = GsonUtils.getInstance().fromJson(data, new TypeToken<List<MyClass>>(){}.getType() );
        commonAdapter = new CommonAdapter<MyClass>(this, R.layout.activity_personalcourse2_ly, list) {

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, MyClass myClass, int position) {
                //绑定数据

            }
        };

        GridLayoutManager manager = new GridLayoutManager(this, 1);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        lRecyclerView.setLayoutManager(manager);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(commonAdapter);
        lRecyclerView.setAdapter(lRecyclerViewAdapter);
    }


}
