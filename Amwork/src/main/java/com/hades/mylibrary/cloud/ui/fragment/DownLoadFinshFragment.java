package com.hades.mylibrary.cloud.ui.fragment;


import android.content.ServiceConnection;
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
import com.hades.mylibrary.cloud.dbmodel.DownLoadInfo;
import com.hades.mylibrary.cloud.videocache.VideoDbSet;
import com.hades.mylibrary.cloud.videocache.VideoDownLoadService;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownLoadFinshFragment extends NormalBaseFragment {

    LRecyclerView lRecyclerView;
    private List<DownLoadInfo> downloadingInfos;
    private VideoDownLoadService.DownloadBinder binder;
    private ServiceConnection serviceConnection;

    public DownLoadFinshFragment() {
        // Required item_errorsetting_ly public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_downloaded_ly, container, false);
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
        List<DownLoadInfo> downloadInfos = VideoDbSet.getDownloadInfos();//数据库取记录
        for (DownLoadInfo downloadInfo : downloadInfos) {

            if (downloadInfo.getStatus() != Downloader.FINISH) {
                continue;//继续下次循环
            }
            downloadingInfos.add(downloadInfo);
        }
        //传入adapter显示
        lRecyclerView.setAdapter(new CommonAdapter<DownLoadInfo>(getContext(), R.layout.item_downloadvideo, downloadInfos) {

            @Override
            protected GridLayoutManager.LayoutParams setLayoutParams() {
                return null;
            }

            @Override
            protected void convert(BaseViewHolder holder, DownLoadInfo downloadInfo, int position) {
                //绑定数据
            }
        });

    }

    @Override
    protected void initEvent() {

    }
}
