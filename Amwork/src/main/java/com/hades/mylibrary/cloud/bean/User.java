package com.hades.mylibrary.cloud.bean;

import com.hades.mylibrary.base.ui.base.transaction.TransactionBean;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.annotation.Unique;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by jiuzheyange on 2016/8/12.
 */
@Table("user_model")
public class User extends TransactionBean{
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    @Unique
    @NotNull
    String uid;
    @NotNull
    String nickname;
    @NotNull
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
