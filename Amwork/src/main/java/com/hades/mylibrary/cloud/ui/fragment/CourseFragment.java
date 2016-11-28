package com.hades.mylibrary.cloud.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hades.mylibrary.R;
import com.hades.mylibrary.base.ui.customview.IndicatorManager;
import com.hades.mylibrary.cloud.adapter.CoursePagerAdapter;
import com.hades.mylibrary.cloud.ui.views.CourseListView;
import com.hades.mylibrary.cloud.ui.views.PagerPrefectureList;
import com.hades.mylibrary.cloud.ui.views.TeacherView;

import net.lucode.hackware.magicindicator.MagicIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {

    List<View> lists;
    CoursePagerAdapter adapter;
    ImageButton back;
    MagicIndicator magicIndicator;
    ViewPager viewpager;
    TextView title;

    public CourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        initView(view);
        initData();
        initEvent();
        return view;
    }

    private void initView(View view) {

        back = (ImageButton) view.findViewById(R.id.back);
        magicIndicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        title = (TextView) view.findViewById(R.id.head_title);

        back.setVisibility(View.INVISIBLE);
        title.setText(R.string.course);

    }

    private void initData() {
        lists = new ArrayList<>();

        lists.add(new CourseListView(getActivity()).getView());
        lists.add(new TeacherView(getActivity()).getView());
        lists.add(new PagerPrefectureList(getActivity()).getView());

        adapter = new CoursePagerAdapter(lists, getContext());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(2);


        IndicatorManager.initMagicIndicator(getContext(),magicIndicator, viewpager, mDataList);

    }

    private void initEvent() {
    }

    private static final String[] CHANNELS = new String[]{"课程", "名师", "专区"};
    private List<String> mDataList = Arrays.asList(CHANNELS);

}
