package com.upuphone.datatrack.sdk.bean;

import androidx.annotation.Keep;

@Keep
public class UploadPolicyBean {
    private int cacheCapacity;
    private int interval;
    private int mobileQuota;
    private int neartimeInterval;
    private boolean onCharge;
    private boolean onReconnect;
    private boolean onStart;

    public int getCacheCapacity() {
        return this.cacheCapacity;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getMobileQuota() {
        return this.mobileQuota;
    }

    public int getNeartimeInterval() {
        return this.neartimeInterval;
    }

    public boolean getOnCharge() {
        return this.onCharge;
    }

    public boolean getOnReconnect() {
        return this.onReconnect;
    }

    public boolean getOnStart() {
        return this.onStart;
    }

    public void setCacheCapacity(int i) {
        this.cacheCapacity = i;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public void setMobileQuota(int i) {
        this.mobileQuota = i;
    }

    public void setNeartimeInterval(int i) {
        this.neartimeInterval = i;
    }

    public void setOnCharge(boolean z) {
        this.onCharge = z;
    }

    public void setOnReconnect(boolean z) {
        this.onReconnect = z;
    }

    public void setOnStart(boolean z) {
        this.onStart = z;
    }
}
