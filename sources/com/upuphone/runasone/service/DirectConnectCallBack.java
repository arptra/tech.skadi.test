package com.upuphone.runasone.service;

import com.upuphone.runasone.channel.linker.websocket.server.WsServer;
import com.upuphone.runasone.connection.LanDirectConnector;
import com.upuphone.starrynet.api.IDirectConnectCallBack;
import com.upuphone.starrynet.api.bean.StDevice;

public class DirectConnectCallBack implements IDirectConnectCallBack {
    public void connect(StDevice stDevice) {
        LanDirectConnector.getInstance().finishConnectGc(stDevice);
    }

    public void createServer(int i) {
        WsServer.getInstance().init(i);
    }
}
