package com.hades.mylibrary.cloud.bean;

import com.hades.mylibrary.base.ui.base.pojo.CodeInfoBean;

/**
 * Created by jiuzheyange on 2016/8/13.
 */
public class BannerBean {
    String title;
    String img;
    CodeInfoBean codeInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public CodeInfoBean getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(CodeInfoBean codeInfo) {
        this.codeInfo = codeInfo;
    }
}
