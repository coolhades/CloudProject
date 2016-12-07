package cn.ezreal.AMPrivateProject;

import android.app.Application;

import com.hades.corelib.AmFactory;
import com.hades.mylibrary.base.factory.LayoutInflaterFactory;
import com.hades.mylibrary.base.factory.TransactionFactory;
import com.hades.mylibrary.base.net.HttpClientManager;
import com.hades.mylibrary.base.net.RetrofitManager;
import com.hades.mylibrary.cloud.utils.CCdrmServerManager;
import com.hades.mylibrary.cloud.utils.VolleyRequestManager;
import com.socks.library.KLog;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import cn.jpush.android.api.JPushInterface;


/**
 * Created by Hades on 2016/10/24.
 */

public class MyApplication extends Application {


    @Override
    public void onTerminate() {
        CCdrmServerManager.getInstance().stopDrmServer();
        super.onTerminate();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG, "Hades");
//        分享组件
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        Config.DEBUG = true;
        UMShareAPI.get(this);


        HttpClientManager.getInstance().initClient(getApplicationContext());//初始化默认client
        //设置Retrofit
        RetrofitManager.getInstance().bindHttpClient(HttpClientManager.getInstance().getmOkHttpClient());
        VolleyRequestManager.getInstance().initReuestQueue(getApplicationContext());
        //cc 配置
        CCdrmServerManager.getInstance().initDrmServer();
        CCdrmServerManager.getInstance().setCC_Account_id(getString(R.string.CC_ENCRYPT_ID), getString(R.string.CC_ENCRYPT_KEY));//加密
        CCdrmServerManager.getInstance().setCC_Account_NO_id(getString(R.string.CC_ID), getString(R.string.CC_KEY));//非加密

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

        //xml
        LayoutInflaterFactory.getInstance()
                .registLayoutId("AMHomeCategory", String.valueOf(R.layout.recycler_catory_ly))
                .registLayoutId("AMRecommendCourse", String.valueOf(R.layout.recycler_course_ly))
                .registLayoutId("AMRecommendTeacher", String.valueOf(R.layout.recycler_teacher_ly))
                .registLayoutId("teacherlist", String.valueOf(R.layout.recycler_teacherlist_ly))
                .registLayoutId("AMPrefectureList", String.valueOf(R.layout.recycler_prefecturelist_ly))
                .registLayoutId("AMCourseCategory", String.valueOf(R.layout.item_recycler_sortcontent_conten))
                .registLayoutId("AMBanner", String.valueOf(R.layout.item_recycler_banner));


//      启动Activity等页面
        //与服务端约定的 pushcode
        TransactionFactory.getInstance()
                .registTransactionCode("choosecompany", "ChooseConpanyActivity")
                .registTransactionCode("main", "MainActivity")
                .registTransactionCode("coursedetail", "CourseDetailActivity")
                .registTransactionCode("click", "CourseDetailActivity")
                //注册两个Activity 公共组件内使用了action启动app中的页面
                .registTransactionCode("ChoosePlatForm", "cn.ezreal.AMPrivateProject.ChoosePlatForm")
                .registTransactionCode("MainActivity", "cn.ezreal.AMPrivateProject.MainActivity");


    }

}
