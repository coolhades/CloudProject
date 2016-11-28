package com.hades.mylibrary.cloud.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.cloud.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hades on 2016/11/7.
 */

public class CatoryAdapter extends RecyclerView.Adapter<CatoryAdapter.CatoryItemViewHolder> {
    LayoutInflater layoutInflater;
    Context mContext;
    List<BannerBean> list;

    public CatoryAdapter(Context context, List datas) {
        this.list = new ArrayList<>();
        this.mContext = context;
        this.list.addAll(datas);
        layoutInflater = LayoutInflater.from(context);

    }


    @Override
    public CatoryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CatoryItemViewHolder(layoutInflater.inflate(R.layout.catory_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CatoryItemViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class CatoryItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public CatoryItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.lable);
        }
    }
}
