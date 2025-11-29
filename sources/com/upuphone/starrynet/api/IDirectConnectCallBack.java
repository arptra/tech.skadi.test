package com.upuphone.starrynet.api;

import com.upuphone.starrynet.api.bean.StDevice;

public interface IDirectConnectCallBack {
    void connect(StDevice stDevice);

    void createServer(int i);
}
