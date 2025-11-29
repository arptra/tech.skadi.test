package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDataBinderServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorImpl$onServiceConnected$2 extends Lambda implements Function1<IDataBinderServer, Unit> {
    final /* synthetic */ DataBinderOperatorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorImpl$onServiceConnected$2(DataBinderOperatorImpl dataBinderOperatorImpl) {
        super(1);
        this.this$0 = dataBinderOperatorImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IDataBinderServer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull IDataBinderServer iDataBinderServer) {
        Intrinsics.checkNotNullParameter(iDataBinderServer, "$this$safeRemoteCall");
        iDataBinderServer.register(this.this$0.client);
    }
}
