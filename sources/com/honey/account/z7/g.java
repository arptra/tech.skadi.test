package com.honey.account.z7;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5354a;
    public final /* synthetic */ ConnectionLevel b;

    public /* synthetic */ g(String str, ConnectionLevel connectionLevel) {
        this.f5354a = str;
        this.b = connectionLevel;
    }

    public final Object invoke(Object obj) {
        return ((DeviceConnectionLevelManager) obj).abandon(this.f5354a, this.b);
    }
}
