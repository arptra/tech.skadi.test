package com.upuphone.runasone.channel.proxy.config;

import com.upuphone.runasone.device.StarryDevice;

public final /* synthetic */ class a implements IConfigResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StarryDevice f6436a;
    public final /* synthetic */ VpnConfigCmd b;

    public /* synthetic */ a(StarryDevice starryDevice, VpnConfigCmd vpnConfigCmd) {
        this.f6436a = starryDevice;
        this.b = vpnConfigCmd;
    }

    public final void onResponse(VpnConfig vpnConfig) {
        VpnConfigUtils.lambda$notifyVpnStateChangedWhenChannelStateChanged$2(this.f6436a, this.b, vpnConfig);
    }
}
