package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5139a;
    public final /* synthetic */ IRequestCallback b;

    public /* synthetic */ h(String str, IRequestCallback iRequestCallback) {
        this.f5139a = str;
        this.b = iRequestCallback;
    }

    public final Object invoke(Object obj) {
        return ((DeviceConnectionLevelManager) obj).request(this.f5139a, ConnectionLevel.ENHANCE, this.b);
    }
}
