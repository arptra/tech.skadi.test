package com.here.posclient.crowdsource.hd;

public enum ControlEvent {
    WifiDataCollectionDeny(1),
    WifiDataCollectionAllow(2),
    SensorExtensionDeny(3),
    SensorExtensionAllow(4),
    DataUploadDeny(5),
    DataUploadAllow(6);
    
    public final int code;

    private ControlEvent(int i) {
        this.code = i;
    }
}
