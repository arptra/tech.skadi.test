package com.upuphone.starrynetsdk.ability.cast;

import com.upuphone.hub.Hub;
import com.upuphone.runasone.uupcast.api.IVirtualDeviceUupCastProxy;
import com.upuphone.starrynetsdk.api.Ability;
import com.upuphone.starrynetsdk.api.Camp;

public class CastVirtualDeviceAbility extends Ability {
    protected final IVirtualDeviceUupCastProxy vdCast = new IVirtualDeviceUupCastProxy();

    public CastVirtualDeviceAbility() {
        Camp.getInstance().addSentry(this);
    }

    public void onInstalled(Hub hub) {
        super.onInstalled(hub);
        this.vdCast.setHub(hub);
    }

    public void onUninstalled() {
        super.onUninstalled();
    }
}
