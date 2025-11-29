package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.api.DataBinderOperator;
import com.upuphone.xr.interconnect.api.DataBinderSlice;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/xr/interconnect/api/DataBinderSlice;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl$dataBinderSlice$2 extends Lambda implements Function0<DataBinderSlice> {
    final /* synthetic */ InfoOperatorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoOperatorImpl$dataBinderSlice$2(InfoOperatorImpl infoOperatorImpl) {
        super(0);
        this.this$0 = infoOperatorImpl;
    }

    @NotNull
    public final DataBinderSlice invoke() {
        return ((DataBinderOperator) this.this$0.dataBinderOperatorGetter.invoke()).getSlice("info");
    }
}
