package com.honey.account.s7;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class l implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5143a;

    public /* synthetic */ l(String str) {
        this.f5143a = str;
    }

    public final Object invoke(Object obj) {
        return ((DeviceConnectionLevelManager) obj).abandon(this.f5143a, ConnectionLevel.BALANCE);
    }
}
