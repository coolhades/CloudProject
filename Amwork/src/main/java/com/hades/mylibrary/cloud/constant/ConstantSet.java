package com.hades.mylibrary.cloud.constant;


import com.hades.mylibrary.cloud.bean.User;

import java.util.Map;


/**
 * Created by jiuzheyange on 2016/8/12.
 */

/*
"App.Switch.Course.MaskInfo": "1",
        "App.Switch.Teacher.Show": "1",
        "App.Switch.Course.Evaluate.Show": "1",
        "App.Switch.PGC.Show": "1",
        "App.Switch.MyOrder.Show": "1",
        "App.Switch.Third-Party.Login": "1"*/
public class ConstantSet {
    public static String getDomainAddress = "http://api.auto-mooc.com/";
    public static String homeAddress;
    public static String MD5Header = "mooc";

    // CC视频帐号信息 账户信息  加密账号
    public static String CC_Account_id = "EB85B37C4546E6A4";
    public static String CC_Account_Key = "SsJifp5ht0KJUzgiEGACUrpVNYLdaAkR";

    // CC视频帐号信息 账户信息 非加密账号
    public static String CC_Account_NO_id = "1C1C1C9EEB01D75E";
    public static String CC_Account_NO_Key = "RRjzwvSvJbLRB3z81zrwAjPt9wLv29N8";


    /**
     * 微信支付渠道
     */
    public static final String CHANNEL_WECHAT = "wx";
    /**
     * 支付支付渠道
     */
    public static final String CHANNEL_ALIPAY = "alipay";

    public static String sharedImageUrl="http://img1.auto-mooc.com/general/img/29/14/B3/29B114A0B3E346EB93147E40CE3C0345.png";
    public static String keyWord; //搜索key

    public static User user;
    public static Map<String, String> confiMap;

}
