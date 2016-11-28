package com.hades.mylibrary.base.ui.base.pojo;

/**
* 创建时间 2016/11/17
* auther Hades
* 描述  showCode: 约定了展现组件的code
 *      pushCode
**/
public class CodeInfoBean {
    /**
     * showCode : banner
     * pushCode : courseDetial
     * pushData :
     */

    private String showCode;
    private String pushCode;
    private String pushData;

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    public String getPushCode() {
        return pushCode;
    }

    public void setPushCode(String pushCode) {
        this.pushCode = pushCode;
    }

    public String getPushData() {
        return pushData;
    }

    public void setPushData(String pushData) {
        this.pushData = pushData;
    }
}
