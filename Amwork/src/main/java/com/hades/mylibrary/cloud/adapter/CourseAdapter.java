package com.hades.mylibrary.cloud.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.viewholder.layoututils.ILayoutParams;
import com.hades.mylibrary.cloud.bean.Lesson;

import java.util.List;

/**
 * 创建时间 2016/11/10
 * auther Hades
 * 描述
 **/

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CatoryItemViewHolder> {
    LayoutInflater layoutInflater;
    Context mContext;
    List<Lesson> list;
    //    int mColumn;
    GridLayoutManager.LayoutParams layoutParams;
    ILayoutParams mILayoutParams;
    int mOration;

    public CourseAdapter(Context context, List datas) {
        this.mContext = context;
        this.list = datas;
        layoutInflater = LayoutInflater.from(context);

    }

    public void setOnLayoutParams(ILayoutParams iLayoutParams) {
        if (iLayoutParams != null) {
            mILayoutParams = iLayoutParams;
        }
    }

    @Override
    public CatoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recycler_course_content, parent, false);
        if (mILayoutParams != null)
            view.setLayoutParams(mILayoutParams.getLayoutParams());
        CatoryItemViewHolder holder = new CatoryItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CatoryItemViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                list.get(position).setActioncode("coursedetail");
//                HandleTransaction.getInstance().handleTransaction(list.get(position), mContext, new Bundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class CatoryItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public CatoryItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text1);
            imageView = (ImageView) itemView.findViewById(R.id.imge);
        }
    }


}
