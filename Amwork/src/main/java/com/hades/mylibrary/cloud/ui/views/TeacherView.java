package com.hades.mylibrary.cloud.ui.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.hades.mylibrary.R;
import com.hades.mylibrary.base.projectutils.GsonUtils;
import com.hades.mylibrary.cloud.adapter.HomeAdapter;
import com.hades.mylibrary.cloud.bean.TestBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by jiuzheyange on 2016/8/18.
 */
//
public class TeacherView {
    Context mContext;
    View mView;
    LRecyclerView lRecyclerView;
    HomeAdapter adapter;
    LRecyclerViewAdapter mLRecyclerViewAdapter;

    TestBean testbean;


    public TeacherView(Context mContext) {
        this.mContext = mContext;
    }

    public View getView() {
        mView = View.inflate(mContext, R.layout.lrecyclerview, null);
        initView();
//        initData();
        initEvent();


        return mView;
    }

    private void initView() {
        lRecyclerView = (LRecyclerView) mView.findViewById(R.id.recyclerview);

    }


    private void initData() {

        testbean = GsonUtils.getInstance().fromJson(rootbeanToJson(), TestBean.class);

        Log.d("TAG-Data", GsonUtils.getInstance().toJson(testbean.getData()));
        adapter = new HomeAdapter(testbean.getData(), mContext);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        lRecyclerView.setAdapter(mLRecyclerViewAdapter);

    }


    private void initEvent() {

    }


    public String rootbeanToJson() {
        String jsonresult = "";//定义返回字符串
        JSONObject object = new JSONObject();//创建一个总的对象，这个对象对整个json串
        try {
            JSONArray jsonarray = new JSONArray();//json数组，里面包含的内容为pet的所有对象


            JSONObject teacher = new JSONObject();//RootBean对象，json形式
            teacher.put("blocktype", "teacherlist");//向pet对象里面添加值
            JSONArray child4 = new JSONArray();
            JSONObject childtec = new JSONObject();
            childtec.put("lable", "teachernamehcshcuahc");
            //创建lessen item
            JSONArray b = new JSONArray();
            for (int k = 0; k < 4; k++) {
                JSONObject o = new JSONObject();
                o.put("teacher_name", "老师名");
                o.put("introduction", "简介");
                o.put("course_num", "2");
                b.put(o);
            }
            childtec.put("item", b);
            child4.put(childtec);
            teacher.put("blockdata", child4);
            teacher.put("blockconfig", new JSONObject());

            // 把每个数据当作一对象添加到数组里
            jsonarray.put(teacher);


            object.put("data", jsonarray);//向总对象里面添加包含pet的数组
            jsonresult = object.toString();//生成返回字符串
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonresult;
    }


}
