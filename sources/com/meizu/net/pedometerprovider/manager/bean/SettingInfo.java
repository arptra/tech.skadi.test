package com.meizu.net.pedometerprovider.manager.bean;

public class SettingInfo {
    private boolean mPedoFunctionOn;
    private boolean mPushNotificationOn;

    public boolean isPedoFunctionOn() {
        return this.mPedoFunctionOn;
    }

    public boolean isPushNotificationOn() {
        return this.mPushNotificationOn;
    }

    public void setPedoFunctionOn(boolean z) {
        this.mPedoFunctionOn = z;
    }

    public void setPushNotificationOn(boolean z) {
        this.mPushNotificationOn = z;
    }
}
