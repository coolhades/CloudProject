package com.hades.mylibrary.cloud.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bokecc.sdk.mobile.download.Downloader;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.base.NormalBaseFragment;
import com.hades.mylibrary.base.ui.base.adapter.CommonAdapter;
import com.hades.mylibrary.base.ui.base.viewholder.BaseViewHolder;
import com.hades.mylibrary.cloud.videocache.DataSet;
import com.hades.mylibrary.cloud.videocache.DownloadInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownLoadFinshFragment extends NormalBaseFragment {

    LRecyclerView lRecyclerView;
    private List<DownloadInfo> downloadingInfos;

    public DownLoadFinshFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_down_load_finsh, container, false);
        init(view, savedInstanceState);
        return view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        lRecyclerView = (LRecyclerView) view.findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        lRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {
        //获取已下载完成视频信息
        downloadingInfos = new ArrayList<>();
        List<DownloadInfo> downloadInfos = DataSet.getDownloadInfos();//数据库取记录
        for (DownloadInfo downloadInfo : downloadInfos) {

            if (downloadInfo.getStatus() == Downloader.FINISH) {
                continue;
            }
            downloadingInfos.add(downloadInfo);
        }
        //传入adapter显示
        lRecyclerView.setAdapter(new CommonAdapter<DownloadInfo>(getContext(), R.layout.item_downloadvideo, downloadInfos) {

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, DownloadInfo downloadInfo, int position) {
                //绑定数据
            }
        });

    }

    @Override
    protected void initEvent() {

    }
}
