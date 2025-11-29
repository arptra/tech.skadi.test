package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.outer.InfoOperatorImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InfoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$listener$1 $listener;
    final /* synthetic */ InfoOperatorImpl this$0;
    final /* synthetic */ InfoOperatorImpl.InnerDeviceOperator this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$1(InfoOperatorImpl infoOperatorImpl, InfoOperatorImpl.InnerDeviceOperator innerDeviceOperator, InfoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$listener$1 infoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$listener$1) {
        super(0);
        this.this$0 = infoOperatorImpl;
        this.this$1 = innerDeviceOperator;
        this.$listener = infoOperatorImpl$InnerDeviceOperator$connectionLevel$1$subscribe$listener$1;
    }

    public final void invoke() {
        this.this$0.getDataBinderSlice().unsubscribe("", new String[]{"device", this.this$1.deviceId, "connectionLevel"}, this.$listener);
    }
}
