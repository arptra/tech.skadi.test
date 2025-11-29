package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.VolumeChangeControllerOperator;
import com.upuphone.xr.interconnect.listener.VolumeChange;

public class InnerVolumeChangeController implements VolumeChangeControllerOperator {
    private static final String TAG = "InnerVolumeChangeControllerImpl";

    public void dispatchVolumeChange(int i) {
        InterconnectManager.getInstance().getVolumeChange().dispatchVolumeChange(i);
    }

    public void registerVolumeChangeReceiver(VolumeChange volumeChange) {
        InterconnectManager.getInstance().getVolumeChange().registerMessageReceiver(volumeChange);
    }

    public void unregisterVolumeChangeReceiver(VolumeChange volumeChange) {
        InterconnectManager.getInstance().getVolumeChange().unregisterMessageReceiver(volumeChange);
    }
}
