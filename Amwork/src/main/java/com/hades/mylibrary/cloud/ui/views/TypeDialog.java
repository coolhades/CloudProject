package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.dialog.BaseDialog;
import com.hades.mylibrary.cloud.adapter.TypeDialogListAdapter;

/**
 * Created by Hades on 2016/11/25.
 * 搜索结果页面的Dialog
 */

public class TypeDialog extends BaseDialog{

    ListView type_dialog_listview;
    ImageView type_dialog_close;
    TypeDialogListAdapter adapter;


    public TypeDialog(Context context) {
        super(context);
    }

    public TypeDialog(Context context, int mstyle) {
        super(context, mstyle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.type_dialog;
    }

    @Override
    protected void initView() {
        type_dialog_close = (ImageView) findViewById(R.id.type_dialog_close);
        type_dialog_listview = (ListView) findViewById(R.id.type_dialog_listview);

    }

    @Override
    protected void initData() {
        fetchData();
    }


    @Override
    protected void initEvent() {
        type_dialog_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                colseDialog();
            }
        });
    }

    private void fetchData() {

    }


}
