package com.upuphone.xr.interconnect.databinder;

import com.upuphone.xr.interconnect.common.IDataBinderServer;
import com.upuphone.xr.interconnect.databinder.DataBinderOperatorItemUpdateListenerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1$1$1$2 extends Lambda implements Function1<IDataBinderServer, Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ String $name;
    final /* synthetic */ DataBinderOperatorItemUpdateListenerManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorItemUpdateListenerManager$registerSubscribers$1$1$1$2(String str, String str2, DataBinderOperatorItemUpdateListenerManager dataBinderOperatorItemUpdateListenerManager) {
        super(1);
        this.$deviceId = str;
        this.$name = str2;
        this.this$0 = dataBinderOperatorItemUpdateListenerManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IDataBinderServer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDataBinderServer iDataBinderServer) {
        Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
        iDataBinderServer.subscribe(this.$deviceId, this.$name, new DataBinderOperatorItemUpdateListenerManager.DataBinderItemUpdateAggregateListener(this.this$0, this.$deviceId, this.$name));
    }
}
