package com.meizu.net.pedometerprovider.manager.bean;

public class SettInfo {
    public static final int BOOL_FALSE = 0;
    public static final int BOOL_TRUE = 1;
    private boolean shutcatAdd;
    private String uid;

    public String getUid() {
        return this.uid;
    }

    public boolean isShutcatAdd() {
        return this.shutcatAdd;
    }

    public void setShutcatAdd(boolean z) {
        this.shutcatAdd = z;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
