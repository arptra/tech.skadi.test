package com.here.services.internal;

public interface Manager {

    public interface ConnectionListener {
        void onConnected();

        void onConnectionFailed();

        void onDisconnected();
    }

    void connect(ConnectionListener connectionListener);

    void disconnect();
}
