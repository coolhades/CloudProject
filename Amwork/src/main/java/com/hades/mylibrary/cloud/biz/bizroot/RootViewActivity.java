package com.hades.mylibrary.cloud.biz.bizroot;

import android.app.Activity;
import android.os.Bundle;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.cloud.biz.bizbase.BizSimpleOper;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;

public class RootViewActivity extends Activity {

    protected LRecyclerView lRecyclerView;
    protected BizSimpleOper simpleOper;
    protected CommonAdapter adapter;
    protected LRecyclerViewAdapter lRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
