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

import static com.hades.mylibrary.R.id.recyclerview;


/**
 * Created by jiuzheyange on 2016/8/18.
 */
public class CourseView {
    Context mContext;
    View mView;
    LRecyclerView lRecyclerView;
    HomeAdapter adapter;
    LRecyclerViewAdapter mLRecyclerViewAdapter;

    TestBean testbean;

    public CourseView(Context mContext) {
        this.mContext = mContext;
    }

    public View getView() {
        mView = View.inflate(mContext, R.layout.lrecyclerview_ly, null);
        initView();
        initData();
        initEvent();


        return mView;
    }

    private void initView() {
        lRecyclerView = (LRecyclerView) mView.findViewById(recyclerview);

    }


    private void initData() {
        testbean = GsonUtils.getInstance().fromJson(rootbeanToJson(), TestBean.class);

        Log.d("TAG-Data", GsonUtils.getInstance().toJson(testbean.getData()) );
        adapter = new HomeAdapter(testbean.getData(), mContext);
        mLRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        lRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        lRecyclerView.setAdapter(mLRecyclerViewAdapter);

    }

    public String rootbeanToJson() {
        String jsonresult = "";//定义返回字符串
        JSONObject object = new JSONObject();//创建一个总的对象，这个对象对整个json串
        try {
            JSONArray jsonarray = new JSONArray();//json数组，里面包含的内容为pet的所有对象

            JSONObject jsonObj = new JSONObject();//RootBean对象，json形式
            jsonObj.put("blocktype", "view_banner");//向pet对象里面添加值

            JSONArray child = new JSONArray();
            for (int i1 = 0; i1 < 3; i1++) {
                JSONObject childobj = new JSONObject();
                childobj.put("title", "chach");
                childobj.put("img", "http://p3.so.qhimg.com/t01d2ff6e8d5193adb7.jpg");
                childobj.put("actioncode", "click");
                child.put(childobj);
            }
            jsonObj.put("blockdata", child);
            jsonObj.put("blockconfig", new JSONObject());
            // 把每个数据当作一对象添加到数组里
//            jsonarray.put(jsonObj);


            JSONObject catogery = new JSONObject();//RootBean对象，json形式
            catogery.put("blocktype", "catory");//向pet对象里面添加值
            JSONArray child2 = new JSONArray();
            for (int i1 = 0; i1 < 8; i1++) {
                JSONObject childobj = new JSONObject();
                childobj.put("title", "测试数据");
                child2.put(childobj);
            }
            catogery.put("blockdata", child2);
            catogery.put("blockconfig", new JSONObject());
            // 把每个数据当作一对象添加到数组里
//            jsonarray.put(catogery);


            JSONObject course = new JSONObject();//RootBean对象，json形式
            course.put("blocktype", "course");//向pet对象里面添加值
            JSONArray child3 = new JSONArray();
            JSONObject childobj = new JSONObject();
            childobj.put("lable", "测试ascacasc数据");
            //创建lessen item
            JSONArray a = new JSONArray();
            for (int k = 0; k < 8; k++) {
                JSONObject o = new JSONObject();
                o.put("title", "课程名");
                a.put(o);
            }
            childobj.put("item", a);
            child3.put(childobj);
            course.put("blockdata", child3);
            course.put("blockconfig", new JSONObject());
            jsonarray.put(course);



            JSONObject teacher = new JSONObject();//RootBean对象，json形式
            teacher.put("blocktype", "teacher");//向pet对象里面添加值
            JSONArray child4 = new JSONArray();
            JSONObject childtec = new JSONObject();
            childtec.put("lable", "teachernamehcshcuahc");
            //创建lessen item
            JSONArray b = new JSONArray();
            for (int k = 0; k < 4; k++) {
                JSONObject o = new JSONObject();
                o.put("title", "老师名");
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


    private void initEvent() {
    }

}
