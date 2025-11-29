package com.upuphone.starrynetsdk.api;

import com.upuphone.hub.Hub;

public class ListenerManager implements Sentry {
    private volatile boolean isEnable;

    public boolean isEnable() {
        return this.isEnable;
    }

    public void onInstalled(Hub hub) {
        this.isEnable = true;
    }

    public void onUninstalled() {
        this.isEnable = false;
    }
}
