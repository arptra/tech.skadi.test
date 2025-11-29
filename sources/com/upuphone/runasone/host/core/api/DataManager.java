package com.upuphone.runasone.host.core.api;

import com.upuphone.runasone.device.StarryDevice;

public final class DataManager {
    private static DataManager dataManager = new DataManager();
    private StarryDevice ownDevice;

    private DataManager() {
    }

    public static DataManager getInstance() {
        return dataManager;
    }

    public StarryDevice getOwnDevice() {
        return this.ownDevice;
    }

    public void setOwnDevice(StarryDevice starryDevice) {
        this.ownDevice = starryDevice;
    }
}
