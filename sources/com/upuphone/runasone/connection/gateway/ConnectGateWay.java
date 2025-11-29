package com.upuphone.runasone.connection.gateway;

import com.upuphone.runasone.connection.gateway.IGateWay;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.runasone.service.StarrynetApiImpl;
import com.upuphone.starrynet.api.bean.StDevice;

public class ConnectGateWay implements IGateWay {
    private StarrynetApiImpl starrynetApi = StarrynetApiImpl.getInstance();

    public int connect(StarryDevice starryDevice, int i) {
        StDevice starryDevice2 = starryDevice.getStarryDevice();
        return starryDevice2 != null ? this.starrynetApi.connect(starryDevice2, i) ? ConnectErrorCode.CONNECT_NORMAL : ConnectErrorCode.CONNECT_STARRYNET_INACTIVE : ConnectErrorCode.CONNECT_STDEVICE_NULL;
    }

    public int disconnect(StarryDevice starryDevice, int i) {
        StDevice starryDevice2 = starryDevice.getStarryDevice();
        return starryDevice2 != null ? this.starrynetApi.disconnect(starryDevice2, i) ? ConnectErrorCode.CONNECT_NORMAL : ConnectErrorCode.CONNECT_STARRYNET_INACTIVE : ConnectErrorCode.CONNECT_STDEVICE_NULL;
    }

    public void release() {
    }

    public void setOnGateWayStateChanged(IGateWay.OnGateWayStateChanged onGateWayStateChanged) {
        this.starrynetApi.addConnectCallback(onGateWayStateChanged);
    }
}
