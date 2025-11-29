package com.honey.account.z7;

import com.upuphone.xr.interconnect.common.IRequestCallback;
import com.upuphone.xr.interconnect.remote.DeviceManagerImpl;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class f implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IRequestCallback f5353a;

    public /* synthetic */ f(IRequestCallback iRequestCallback) {
        this.f5353a = iRequestCallback;
    }

    public final Object invoke() {
        return DeviceManagerImpl.lambda$requestConnectionLevel$3(this.f5353a);
    }
}
