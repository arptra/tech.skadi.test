package com.upuphone.starrynetsdk.device;

import com.upuphone.hub.Hub;
import com.upuphone.runasone.core.api.device.IDeviceManagerApiProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;

public class DeviceAbility extends Ability {
    protected final IDeviceManagerApiProxy api = new IDeviceManagerApiProxy();

    public DeviceAbility() {
        Camp.getInstance().addSentry(this);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.api.setHub(hub);
    }
}
