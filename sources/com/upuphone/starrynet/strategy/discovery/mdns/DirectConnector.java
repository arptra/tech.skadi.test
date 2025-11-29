package com.upuphone.starrynet.strategy.discovery.mdns;

import com.upuphone.starrynet.api.IDirectConnectCallBack;
import com.upuphone.starrynet.api.bean.DiscoveryFilter;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.strategy.StarryNetData;

public final class DirectConnector {
    private static DirectConnector directConnector = new DirectConnector();
    private IDirectConnectCallBack callBack;
    private MdnsStarryNetDiscovery discovery = new MdnsStarryNetDiscovery();

    private DirectConnector() {
    }

    public static synchronized DirectConnector getInstance() {
        DirectConnector directConnector2;
        synchronized (DirectConnector.class) {
            directConnector2 = directConnector;
        }
        return directConnector2;
    }

    private void init() {
        StDevice ownDevice = StarryNetData.getInstance().getOwnDevice();
        if (ownDevice.getTerminalType() == 3) {
            this.discovery.startDiscovery((DiscoveryFilter) null);
        } else if (ownDevice.getTerminalType() == 7) {
            this.discovery.startCast();
        }
    }

    public void connect(StDevice stDevice) {
        IDirectConnectCallBack iDirectConnectCallBack = this.callBack;
        if (iDirectConnectCallBack != null) {
            iDirectConnectCallBack.connect(stDevice);
        }
    }

    public void createServer(int i) {
        IDirectConnectCallBack iDirectConnectCallBack = this.callBack;
        if (iDirectConnectCallBack != null) {
            iDirectConnectCallBack.createServer(i);
        }
    }

    public void setCallBack(IDirectConnectCallBack iDirectConnectCallBack) {
        init();
        this.callBack = iDirectConnectCallBack;
    }
}
