package com.honey.account.u5;

import com.upuphone.runasone.channel.proxy.ProxyManager;
import com.upuphone.runasone.channel.proxy.config.IConfigChangedListener;
import com.upuphone.runasone.channel.proxy.config.VpnConfig;

public final /* synthetic */ class a implements IConfigChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProxyManager f5226a;

    public /* synthetic */ a(ProxyManager proxyManager) {
        this.f5226a = proxyManager;
    }

    public final void onChanged(VpnConfig vpnConfig) {
        this.f5226a.lambda$new$0(vpnConfig);
    }
}
