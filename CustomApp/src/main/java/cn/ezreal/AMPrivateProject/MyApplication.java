package cn.ezreal.AMPrivateProject;

import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;
import com.hades.corelib.AmFactory;
import com.hades.mylibrary.base.factory.LayoutInflaterFactory;
import com.hades.mylibrary.base.factory.TransactionFactory;
import com.hades.mylibrary.base.net.HttpClientManager;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.base.projectutils.log.KLog;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Hades on 2016/10/24.
 */

public class MyApplication extends Application {


    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy(Context context) {
        MyApplication app = (MyApplication) context.getApplicationContext();
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }


    @Override
    public void onTerminate() {
        CCdrmServerManager.getInstance().stopDrmServer();
        super.onTerminate();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG, "Hades");

        HttpClientManager.getInstance().initClient(getApplicationContext());//初始化默认client
        //设置Retrofit
        RetrofitManager.getInstance().bindHttpClient(HttpClientManager.getInstance().getmOkHttpClient());

//        HttpClientManager.getInstance().initClient(new OkHttpClient());//初始化自定义Client
//        RootRequest.mBaseUrl = ""; //初始化基准域名  两步完成网络框架初始化 可以继承RootRequest进行API编写了
//        RootDataBean<T> 封装了response格式 统一约定 status为int 返回data为Object对象，具体Javabean

        //cc 配置
        CCdrmServerManager.getInstance().initDrmServer();
        CCdrmServerManager.getInstance().setCC_Account_id("EB85B37C4546E6A4", "SsJifp5ht0KJUzgiEGACUrpVNYLdaAkR");//加密
        CCdrmServerManager.getInstance().setCC_Account_NO_id("1C1C1C9EEB01D75E", "RRjzwvSvJbLRB3z81zrwAjPt9wLv29N8");//非加密


        JPushInterface.init(this);

        //工厂类 使用了反射创建对象 可以考虑创建一个配置文件
        AmFactory.getInstance()
                //com.hades.mylibrary.cloud 公共组件 app可以针对这些组件覆盖替换
                //ViewHolder
                .regist("AMBanner", "com.hades.mylibrary.cloud.ui.viewholder.BannerViewHolder")
                .regist("AMRecommendCourse", "com.hades.mylibrary.cloud.ui.viewholder.CourseViewHolder")
                .regist("AMHomeCategory", "com.hades.mylibrary.cloud.ui.viewholder.CatoryViewHolder")
                .regist("AMRecommendTeacher", "com.hades.mylibrary.cloud.ui.viewholder.TeacherViewHolder")
                .regist("teacherlist", "com.hades.mylibrary.cloud.ui.viewholder.TeacherListViewHolder")
                .regist("AMPrefectureList", "com.hades.mylibrary.cloud.ui.viewholder.PrefectureListViewHolder")
                .regist("AMCourseCategory", "com.hades.mylibrary.cloud.ui.viewholder.AMCourseCategory")
                .regist("announce", "com.hades.mylibrary.cloud.ui.viewholder.AnnounceViewHolder");

        //fragment
        AmFactory.getInstance()
                .registView("coursefragment", "com.hades.mylibrary.cloud.ui.fragment.CourseFragment")
                .registView("mycenterfragment", "com.hades.mylibrary.cloud.ui.fragment.MyCenterFragment")
                .registView("homefragment", "com.hades.mylibrary.cloud.ui.fragment.HomeFragment");


        LayoutInflaterFactory.getInstance()
                .registLayoutId("AMHomeCategory", String.valueOf(R.layout.catory_viewholder))
                .registLayoutId("AMRecommendCourse", String.valueOf(R.layout.course_viewholder))
                .registLayoutId("AMRecommendTeacher", String.valueOf(R.layout.teacher_viewholder))
                .registLayoutId("teacherlist", String.valueOf(R.layout.teacherlist_viewholder))
                .registLayoutId("AMPrefectureList", String.valueOf(R.layout.prefecturelist_viewholder))
                .registLayoutId("AMCourseCategory", String.valueOf(R.layout.type_listview_item))
                .registLayoutId("AMBanner", String.valueOf(R.layout.banner_viewholder));


//      原理是通过设置intent的action【 关联类名】来启动
        TransactionFactory.getInstance()
                .registTransactionCode("choosecompany", "ChooseConpanyActivity")
                .registTransactionCode("main", "MainActivity")
                .registTransactionCode("coursedetail", "CourseDetailActivity")
                .registTransactionCode("click", "CourseDetailActivity");


    }

}
