package com.upuphone.runasone.connection.gateway;

import com.upuphone.runasone.device.StarryDevice;

public interface IGateWay {

    public interface OnGateWayStateChanged {
        void onApConnected(StarryDevice starryDevice, String str);

        void onApCreated(int i);

        void onApDisconnected(StarryDevice starryDevice);

        void onApRemoved();

        void onBleConnected(StarryDevice starryDevice);

        void onBleDisconnected(StarryDevice starryDevice);

        void onBleServerConnected(StarryDevice starryDevice);

        void onBleServerDisconnected(StarryDevice starryDevice);

        void onConnected(int i, StarryDevice starryDevice) {
        }

        void onDisconnected(int i, StarryDevice starryDevice) {
        }

        void onLanDisconnected(StarryDevice starryDevice);

        void onLanGcConnected(int i, String str, StarryDevice starryDevice);

        void onLanGoConnected(StarryDevice starryDevice);

        void onP2pGcConnected(int i, String str, StarryDevice starryDevice);

        void onP2pGcDisconnected(StarryDevice starryDevice);

        void onP2pGoConnected(StarryDevice starryDevice);

        void onP2pGoCreated(int i, String str);

        void onP2pGoDisconnected(StarryDevice starryDevice);

        void onP2pGoRemoved();

        void onSppClientConnected(StarryDevice starryDevice);

        void onSppClientDisconnected(StarryDevice starryDevice);

        void onSppServerConnected(StarryDevice starryDevice);

        void onSppServerDisconnected(StarryDevice starryDevice);

        void onStaConnected(int i, String str, StarryDevice starryDevice);

        void onStaDisconnected(StarryDevice starryDevice);

        void reportOwnDevice(StarryDevice starryDevice);
    }

    int connect(StarryDevice starryDevice, int i);

    int disconnect(StarryDevice starryDevice, int i);

    void release();

    void setOnGateWayStateChanged(OnGateWayStateChanged onGateWayStateChanged);
}
