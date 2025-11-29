package com.upuphone.xr.interconnect.api;

import com.upuphone.xr.interconnect.listener.VolumeChange;

public interface VolumeChangeControllerOperator {
    void dispatchVolumeChange(int i);

    void registerVolumeChangeReceiver(VolumeChange volumeChange);

    void unregisterVolumeChangeReceiver(VolumeChange volumeChange);
}
