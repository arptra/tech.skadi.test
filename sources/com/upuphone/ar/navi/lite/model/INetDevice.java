package com.upuphone.ar.navi.lite.model;

import com.upuphone.xr.interconnect.entity.StarryNetMessage;

public interface INetDevice {
    void onMessageReceive(StarryNetMessage starryNetMessage);
}
