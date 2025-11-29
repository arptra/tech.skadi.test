package com.upuphone.xr.interconnect.entity;

import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;

public class LaunchAppParam {
    private String appId;
    @OpenRemoteStarryNetAppCode
    private int code;
    private String menuId;
    private String requestId;
    private boolean success;

    public LaunchAppParam(String str, String str2, String str3) {
        this.appId = str;
        this.menuId = str2;
        this.requestId = str3;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getCode() {
        return this.code;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMenuId(String str) {
        this.menuId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
