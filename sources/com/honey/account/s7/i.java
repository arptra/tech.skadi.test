package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class i implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IRequestCallback f5140a;

    public /* synthetic */ i(IRequestCallback iRequestCallback) {
        this.f5140a = iRequestCallback;
    }

    public final Object invoke() {
        return StarryNetDeviceManagerImpl.lambda$acquireEnhanceConnection$1(this.f5140a);
    }
}
