package com.upuphone.starrynet.core.ble.client;

import java.util.UUID;

public class BleConnectConfig {
    private boolean activelyOpen2MPhy = false;
    private String bleMac;
    private UUID destCharacterUUID = null;
    private UUID heartBeatUUID;
    private boolean openHighSpeed = true;
    private int retryTimes = 2;

    public BleConnectConfig(String str) {
        this.bleMac = str;
    }

    public BleConnectConfig activelyOpen2MPhy(boolean z) {
        this.activelyOpen2MPhy = z;
        return this;
    }

    public BleConnectConfig checkDestCharacterUUID(UUID uuid) {
        this.destCharacterUUID = uuid;
        return this;
    }

    public String getBleMac() {
        return this.bleMac;
    }

    public UUID getDestCharacterUUID() {
        return this.destCharacterUUID;
    }

    public UUID getHeartBeatUUID() {
        return this.heartBeatUUID;
    }

    public int getMaxRetryTimes() {
        return this.retryTimes;
    }

    public BleConnectConfig heartBeatUUID(UUID uuid) {
        this.heartBeatUUID = uuid;
        return this;
    }

    public boolean isActivelyOpen2MPhy() {
        return this.activelyOpen2MPhy;
    }

    public boolean isOpenHighSpeed() {
        return this.openHighSpeed;
    }

    public BleConnectConfig openHighSpeed(boolean z) {
        this.openHighSpeed = z;
        return this;
    }

    public void setMaxRetryTimes(int i) {
        this.retryTimes = i;
    }
}
