package com.hades.mylibrary.cloud.ui.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.mvp.fragment.BaseFragment;
import com.hades.mylibrary.cloud.adapter.ExpandableAdapter;
import com.hades.mylibrary.cloud.bean.JieBean;
import com.hades.mylibrary.cloud.bean.ResultVideo;
import com.hades.mylibrary.cloud.bean.ZhangBean;
import com.hades.mylibrary.cloud.ui.mvp.presenter.VideoPageCourseListPresenter;
import com.hades.mylibrary.cloud.ui.mvp.view.ILoadData;

import java.util.List;

/**
 * Created by Hades on 2016/11/16.
 */

public class VideoPageCourseListFragment extends BaseFragment<VideoPageCourseListPresenter> implements ILoadData{

    View mView;
    ExpandableListView expandableListView;
    ExpandableAdapter adapter;
    List<ZhangBean> parentLists;
    List<List<JieBean>>  childLists;
    List<ZhangBean> zhangBeanList;
    ResultVideo resultVideo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(getContext()).inflate(R.layout.video_list_fragment, container, false);
        init(mView, savedInstanceState);
        return mView;
    }

    @Override
    protected VideoPageCourseListPresenter onLoadPresenter() {
        return new VideoPageCourseListPresenter();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        expandableListView = new ExpandableListView(getContext());
        expandableListView= (ExpandableListView) mView.findViewById(R.id.view1_listview);
        expandableListView.setGroupIndicator(null);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                adapter.setSelectedPosition(i);
                adapter.notifyDataSetChanged();
                //获取视频信息


                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                return false;
            }
        });
    }

    @Override
    public void onInitData(String data) {

    }
}
