package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.pm.OpenRemoteStarryNetAppCode;

public interface OpenRemoteStarryNetAppCallback {
    void onFail(@OpenRemoteStarryNetAppCode int i);

    void onSuccess();
}
