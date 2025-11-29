package com.honey.account.w5;

import com.upuphone.runasone.channel.proxy.config.IConfigResponseListener;
import com.upuphone.runasone.channel.proxy.config.VpnConfigUtils;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IConfigResponseListener f5291a;

    public /* synthetic */ a(IConfigResponseListener iConfigResponseListener) {
        this.f5291a = iConfigResponseListener;
    }

    public final void run() {
        this.f5291a.onResponse(VpnConfigUtils.requestVpnConfig());
    }
}
