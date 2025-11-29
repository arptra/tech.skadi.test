package com.honey.account.w5;

import com.upuphone.runasone.channel.proxy.config.IConfigResponseListener;
import com.upuphone.runasone.channel.proxy.config.VpnConfig;
import com.upuphone.runasone.channel.proxy.config.VpnConfigUtils;

public final /* synthetic */ class b implements IConfigResponseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f5292a;
    public final /* synthetic */ VpnConfig[] b;

    public /* synthetic */ b(Object obj, VpnConfig[] vpnConfigArr) {
        this.f5292a = obj;
        this.b = vpnConfigArr;
    }

    public final void onResponse(VpnConfig vpnConfig) {
        VpnConfigUtils.lambda$requestVpnConfig$1(this.f5292a, this.b, vpnConfig);
    }
}
