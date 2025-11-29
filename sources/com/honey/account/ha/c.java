package com.honey.account.ha;

import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.xjsd.ai.assistant.connect.OnDeviceStateChangeListener;
import com.xjsd.ai.assistant.phone.Commander;

public final /* synthetic */ class c implements OnDeviceStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Commander f7333a;

    public /* synthetic */ c(Commander commander) {
        this.f7333a = commander;
    }

    public final void a(StarryNetDevice starryNetDevice, boolean z) {
        this.f7333a.handleDeviceConnection(starryNetDevice, z);
    }
}
