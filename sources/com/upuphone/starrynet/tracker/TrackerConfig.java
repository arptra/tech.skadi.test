package com.upuphone.starrynet.tracker;

public class TrackerConfig {
    private boolean debug;
    private String ownDeviceID;

    public String getOwnDeviceID() {
        return this.ownDeviceID;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public TrackerConfig setDebug(boolean z) {
        this.debug = z;
        return this;
    }

    public TrackerConfig setOwnDeviceId(String str) {
        this.ownDeviceID = str;
        return this;
    }
}
