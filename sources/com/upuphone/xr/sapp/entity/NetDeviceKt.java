package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isConnected", "", "Lcom/upuphone/xr/sapp/entity/ConnectState;", "app_intlRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class NetDeviceKt {
    public static final boolean isConnected(@NotNull ConnectState connectState) {
        Intrinsics.checkNotNullParameter(connectState, "<this>");
        return connectState == ConnectState.CONNECTED;
    }
}
