package com.hades.mylibrary.cloud.biz.bizbase;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by Hades on 2016/12/2.
 */
public class BizSortView extends BaseSortView {

    public BizSortView(Context context, int layout_id, List<String> title, ViewGroup group) {
        super(context, layout_id, title, group);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CommonAdapter<String>(context, layout_id, mData) {
            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, final String s, final int position) {
                TextView title = holder.getView(R.id.title);
                title.setText(s);
                title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onSortListener.OnClickSort(view, s, position);
                    }
                });
            }

        };

        recyclerView.setAdapter(adapter);

    }


}
