package com.honey.account.z7;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5352a;
    public final /* synthetic */ ConnectionLevel b;
    public final /* synthetic */ IRequestCallback c;

    public /* synthetic */ e(String str, ConnectionLevel connectionLevel, IRequestCallback iRequestCallback) {
        this.f5352a = str;
        this.b = connectionLevel;
        this.c = iRequestCallback;
    }

    public final Object invoke(Object obj) {
        return ((DeviceConnectionLevelManager) obj).request(this.f5352a, this.b, this.c);
    }
}
