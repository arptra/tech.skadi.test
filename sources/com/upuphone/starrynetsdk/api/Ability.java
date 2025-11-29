package com.upuphone.starrynetsdk.api;

import com.upuphone.hub.Hub;

public abstract class Ability implements Sentry {
    private boolean isEnable;

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
