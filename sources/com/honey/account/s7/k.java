package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class k implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IRequestCallback f5142a;

    public /* synthetic */ k(IRequestCallback iRequestCallback) {
        this.f5142a = iRequestCallback;
    }

    public final Object invoke() {
        return StarryNetDeviceManagerImpl.lambda$acquireBalanceConnection$4(this.f5142a);
    }
}
