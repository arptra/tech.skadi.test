package com.upuphone.runasone.uupcast.api;

import com.upuphone.hub.annotation.Callback;
import com.upuphone.hub.annotation.Hub;
import com.upuphone.runasone.device.StarryDevice;

@Hub
public interface IVirtualDeviceUupCast {
    int enableCameraByType(int i);

    int enableMicByType(int i);

    int registerVirtualCamera(int i);

    int registerVirtualMic(int i);

    int registerVirtualModem(int i);

    int setSinkEventCallback(@Callback IVirtualDeviceEventListener iVirtualDeviceEventListener);

    int setSourceEventCallback(@Callback IVirtualDeviceEventListener iVirtualDeviceEventListener);

    int startSinkServer(StarryDevice starryDevice);

    int startSourceClient();

    int stopSinkServer();

    int stopSourceClient();

    int unregisterVirtualCamera(int i);

    int unregisterVirtualMic(int i);

    int unregisterVirtualModem(int i);

    int unsetSinkEventCallback();

    int unsetSourceEventCallback();
}
