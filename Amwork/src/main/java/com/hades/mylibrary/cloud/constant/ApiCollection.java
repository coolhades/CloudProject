package com.hades.mylibrary.cloud.constant;


import com.hades.mylibrary.base.ui.base.pojo.RootDataBean;
import com.hades.mylibrary.cloud.bean.CompanyListBean;
import com.hades.mylibrary.cloud.bean.MyClass;
import com.hades.mylibrary.cloud.bean.MyCollect;
import com.hades.mylibrary.cloud.bean.MyExam;
import com.hades.mylibrary.cloud.bean.MyOrder;
import com.hades.mylibrary.cloud.bean.SearchLessonCenter;
import com.hades.mylibrary.cloud.bean.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 创建时间 2016/11/15
 * auther Hades
 * 描述  Api接口
 **/
public class ApiCollection {

    //获取基准域名
    public interface GetDomain {
        @FormUrlEncoded
        @POST("main/getdomain")
        Call<RootDataBean<String>> getDomain(@Field("name") String s
        );
    }


    //登录接口
    public interface LoginApi {
        @FormUrlEncoded
        @POST("user/login")
        Call<RootDataBean<User>> login(@Field("account") String account,
                                       @Field("passwd") String passwd
        );
    }

    //注册接口
    public interface RegistApi {
        @FormUrlEncoded
        @POST("user/register")
        Call<RootDataBean<User>> regist(@Field("account") String account,
                                        @Field("passwd") String passwd,
                                        @Field("ver") String ver,
                                        @Field("vcode") String vcode,
                                        @Field("okey") String Md5Code);//Md5加密String
    }

    //获取验证码
    public interface FetchCodeApi {
        @FormUrlEncoded
        @POST("main/sendcode")
        Call<RootDataBean<String>> getCode(@Field("mobile") String mobile,
                                           @Field("okey") String Md5Code);

    }

    //渠道列表
    public interface GetUserCompanyList {
        @FormUrlEncoded
        @POST("getcompanylist")
        Call<RootDataBean<List<CompanyListBean>>> getCampanyList(@Field("user_id") String user_id);
    }


    //主页信息 空的map
    public interface GetHomeData {
        @FormUrlEncoded
        @POST("main/gethome")
        Call<RootDataBean> getHomeData(@Field("id") String id);
    }

    //我加入的课程班级
    public interface GetMyClass {
        @FormUrlEncoded
        @POST("user/getmycourse")
        Call<RootDataBean<List<MyClass>>> getMyClass(@Field("user_id") String user_id);
    }


    public interface GetCollection {
        @FormUrlEncoded
        @POST("user/getmyfollowcourse")
        Call<RootDataBean<List<MyCollect>>> getMyCollection(@Field("user_id") String user_id);
    }

    public interface GetMyExam {
        @FormUrlEncoded
        @POST("user/getmyexam")
        Call<RootDataBean<MyExam>> getMyExam(@Field("user_id") String user_id);
    }

    public interface GetMyQuestion {
        @FormUrlEncoded
        @POST("user/getmyquestions")
        Call<RootDataBean<MyExam>> getMyQuestion(@Field("user_id") String user_id);
    }

    public interface GetMyOrder {
        @FormUrlEncoded
        @POST("user/getuserorderlist")
        Call<RootDataBean<MyOrder>> getMyOrder(@Field("user_id") String user_id,
                                               @Field("okey") String key);
//        map.put("okey", Md5Utils.md5("moocgetUserOrderList" + ConstantSet.user.getUid() ));//设置班级
    }

    //公告
    public interface GetNotice {
        @FormUrlEncoded
        @POST("main/getnotice")
        Call<RootDataBean<MyExam>> getMyQuestion(@Field("some") String user_id);
    }


    public interface setCollection {
        @FormUrlEncoded
        @POST("actions/follow")
        Call<ResponseBody> getCollection(@Field("user_id") String user_id);
    }

    public interface searchCourse {
        @FormUrlEncoded
        @POST("course/search")
        Call<RootDataBean<SearchLessonCenter>> getSearch(@Field("keyword") String key,
                                                         @Field("tag") String tag,
                                                         @Field("page") String page,
                                                         @Field("pagesize") String pagesize,
                                                         @Field("order_type") String order_type,
                                                         @Field("order_sort") String order_sort);
    }

}
