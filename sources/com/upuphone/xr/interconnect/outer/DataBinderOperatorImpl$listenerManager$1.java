package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.common.IDataBinderServer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/common/IDataBinderServer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataBinderOperatorImpl$listenerManager$1 extends Lambda implements Function0<IDataBinderServer> {
    final /* synthetic */ DataBinderOperatorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderOperatorImpl$listenerManager$1(DataBinderOperatorImpl dataBinderOperatorImpl) {
        super(0);
        this.this$0 = dataBinderOperatorImpl;
    }

    @Nullable
    public final IDataBinderServer invoke() {
        return this.this$0.provider.getDataBinder();
    }
}
