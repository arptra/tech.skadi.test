package com.upuphone.ar.navi.lite.base;

import java.io.Serializable;

public class AccountInfoBean implements Serializable {
    private String id = "";
    private String mzUid = "";
    private String nickname = "";
    private String phone = "";

    public String getId() {
        return this.id;
    }

    public String getMzUid() {
        return this.mzUid;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMzUid(String str) {
        this.mzUid = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String toString() {
        return "AccountInfoBean{id='" + this.id + '\'' + ", mzUid='" + this.mzUid + '\'' + ", nickname='" + this.nickname + '\'' + ", phone='" + this.phone + '\'' + '}';
    }
}
