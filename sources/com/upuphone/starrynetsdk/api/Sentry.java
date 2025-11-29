package com.upuphone.starrynetsdk.api;

import com.upuphone.hub.Hub;

public interface Sentry {
    void onInstalled(Hub hub);

    void onUninstalled();
}
