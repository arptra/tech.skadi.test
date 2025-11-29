package com.upuphone.runasone.channel.virtual;

import com.upuphone.runasone.device.StarryDevice;

public interface IBridgeConnectCallback {
    void onBleBridgeConnected(StarryDevice starryDevice);

    void onBleBridgeDisconnected(StarryDevice starryDevice);

    void onP2PBridgeConnected(StarryDevice starryDevice);

    void onP2PBridgeDisconnected(StarryDevice starryDevice);
}
