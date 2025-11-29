package com.upuphone.xr.interconnect.entity;

import com.upuphone.runasone.device.StarryDevice;

public class DeviceWrapper {
    private StarryNetDevice device;
    private boolean isBleConnected = false;
    private boolean isBonded = false;
    private boolean isBtConnected = false;
    private StarryDevice originDevice;

    public DeviceWrapper(StarryDevice starryDevice, StarryNetDevice starryNetDevice) {
        this.originDevice = starryDevice;
        this.device = starryNetDevice;
    }

    public StarryNetDevice getDevice() {
        return this.device;
    }

    public String getId() {
        return this.originDevice.getId();
    }

    public StarryDevice getOriginDevice() {
        return this.originDevice;
    }

    public boolean isBleConnected() {
        return this.isBleConnected;
    }

    public boolean isBonded() {
        return this.isBonded;
    }

    public boolean isBtConnected() {
        return this.isBtConnected;
    }

    public void setBleConnected(boolean z) {
        this.isBleConnected = z;
    }

    public void setBonded(boolean z) {
        this.isBonded = z;
    }

    public void setBtConnected(boolean z) {
        this.isBtConnected = z;
    }

    public void setOriginDevice(StarryDevice starryDevice) {
        this.originDevice = starryDevice;
    }
}
