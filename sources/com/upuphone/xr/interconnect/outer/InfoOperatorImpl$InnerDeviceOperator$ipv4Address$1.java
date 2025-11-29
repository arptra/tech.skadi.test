package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.api.info.InfoEndpoint;
import com.upuphone.xr.interconnect.outer.InfoOperatorImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J3\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042#\u0010\u0006\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/upuphone/xr/interconnect/outer/InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1", "Lcom/upuphone/xr/interconnect/api/info/InfoEndpoint;", "", "subscribe", "Lkotlin/Function0;", "", "onUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "Shared_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1 implements InfoEndpoint<String> {
    final /* synthetic */ InfoOperatorImpl this$0;
    final /* synthetic */ InfoOperatorImpl.InnerDeviceOperator this$1;

    public InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1(InfoOperatorImpl infoOperatorImpl, InfoOperatorImpl.InnerDeviceOperator innerDeviceOperator) {
        this.this$0 = infoOperatorImpl;
        this.this$1 = innerDeviceOperator;
    }

    @NotNull
    public Function0<Unit> subscribe(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onUpdate");
        InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1 infoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1 = new InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1(function1);
        this.this$0.getDataBinderSlice().subscribe("", new String[]{"device", this.this$1.deviceId, "ipv4Address"}, infoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1);
        return new InfoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$1(this.this$0, this.this$1, infoOperatorImpl$InnerDeviceOperator$ipv4Address$1$subscribe$listener$1);
    }
}
