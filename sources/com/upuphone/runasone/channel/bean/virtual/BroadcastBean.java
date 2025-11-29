package com.upuphone.runasone.channel.bean.virtual;

import com.upuphone.runasone.device.StarryDevice;

public class BroadcastBean {
    private int actionType;
    private StarryDevice targetDevice;
    private int throughputType = 1;

    public int getActionType() {
        return this.actionType;
    }

    public StarryDevice getTargetDevice() {
        return this.targetDevice;
    }

    public int getThroughputType() {
        return this.throughputType;
    }

    public void setActionType(int i) {
        this.actionType = i;
    }

    public void setTargetDevice(StarryDevice starryDevice) {
        this.targetDevice = starryDevice;
    }

    public void setThroughputType(int i) {
        this.throughputType = i;
    }
}
