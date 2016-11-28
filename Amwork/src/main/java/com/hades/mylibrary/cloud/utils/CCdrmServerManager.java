package com.hades.mylibrary.cloud.utils;

import com.bokecc.sdk.mobile.drm.DRMServer;

/**
 * Created by Hades on 2016/11/18.
 */
public class CCdrmServerManager {


    private DRMServer drmServer;

    private int drmServerPort;



    // CC视频帐号信息 账户信息  加密账号
    public  String CC_Account_id ;
    public  String CC_Account_Key ;


    // CC视频帐号信息 账户信息 非加密账号
    public  String CC_Account_NO_id ;
    public  String CC_Account_NO_Key;


    public String getCC_Account_id() {
        return CC_Account_id;
    }

    public void setCC_Account_id(String CC_Account_id, String CC_Account_Key) {
        this.CC_Account_id = CC_Account_id;
        this.CC_Account_Key = CC_Account_Key;
    }

    public String getCC_Account_Key() {
        return CC_Account_Key;
    }

    public String getCC_Account_NO_id() {
        return CC_Account_NO_id;
    }

    public void setCC_Account_NO_id(String CC_Account_NO_id, String CC_Account_NO_Key) {
        this.CC_Account_NO_id = CC_Account_NO_id;
        this.CC_Account_NO_Key = CC_Account_NO_Key;
    }

    public String getCC_Account_NO_Key() {
        return CC_Account_NO_Key;
    }


    public int getDrmServerPort() {
        return drmServerPort;
    }

    public void setDrmServerPort(int drmServerPort) {
        this.drmServerPort = drmServerPort;
    }

    public DRMServer getDRMServer() {
        return drmServer;
    }

    public static CCdrmServerManager getInstance() {
        return Instance.instance;
    }


    private CCdrmServerManager() {

    }

    public void stopDrmServer() {
        if (drmServer != null) {
            drmServer.stop();
        }
    }

    public void initDrmServer() {
        //cc加密
        // 启动DRMServer
        drmServer = new DRMServer();
        drmServer.start();
        setDrmServerPort(drmServer.getPort());
    }

    private static class Instance {
        private static CCdrmServerManager instance = new CCdrmServerManager();
    }


}
