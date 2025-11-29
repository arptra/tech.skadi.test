package com.upuphone.xr.interconnect.entity;

import java.util.List;

public class SyncStarryNetAppRes {
    private boolean isUseBle = false;
    private String mIconZipPath;
    private List<StarryNetApp> mStarryNetAppList;
    private String mStarryNetAppVersion;

    public String getIconZipPath() {
        return this.mIconZipPath;
    }

    public List<StarryNetApp> getStarryNetAppList() {
        return this.mStarryNetAppList;
    }

    public String getStarryNetAppVersion() {
        return this.mStarryNetAppVersion;
    }

    public boolean isUseBle() {
        return this.isUseBle;
    }

    public void setIconZipPath(String str) {
        this.mIconZipPath = str;
    }

    public void setStarryNetAppList(List<StarryNetApp> list) {
        this.mStarryNetAppList = list;
    }

    public void setStarryNetAppVersion(String str) {
        this.mStarryNetAppVersion = str;
    }

    public void setUseBle(boolean z) {
        this.isUseBle = z;
    }

    public String toString() {
        return "SyncStarryNetAppInfo{, mStarryNetAppVersion='" + this.mStarryNetAppVersion + '\'' + ", mIconZipPath='" + this.mIconZipPath + '\'' + ", mStarryNetAppList=" + this.mStarryNetAppList + '}';
    }
}
