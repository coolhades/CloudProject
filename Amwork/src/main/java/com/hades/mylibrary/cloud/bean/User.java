package com.hades.mylibrary.cloud.bean;

import com.hades.mylibrary.base.ui.base.transaction.TransactionBean;

/**
 * Created by jiuzheyange on 2016/8/12.
 */
public class User extends TransactionBean{
    String uid;
    String nickname;
    String avatar;

    public User(String uid, String nickname, String avatar) {
        this.uid = uid;
        this.nickname = nickname;
        this.avatar = avatar;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
