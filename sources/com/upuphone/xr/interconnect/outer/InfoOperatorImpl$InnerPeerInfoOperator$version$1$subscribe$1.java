package com.upuphone.xr.interconnect.outer;

import com.upuphone.xr.interconnect.api.DataBinderSlice;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class InfoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DataBinderSlice $dataBinderSlice;
    final /* synthetic */ InfoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$listener$1 $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InfoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$1(DataBinderSlice dataBinderSlice, InfoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$listener$1 infoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$listener$1) {
        super(0);
        this.$dataBinderSlice = dataBinderSlice;
        this.$listener = infoOperatorImpl$InnerPeerInfoOperator$version$1$subscribe$listener$1;
    }

    public final void invoke() {
        this.$dataBinderSlice.unsubscribe("", new String[]{"peer", "version"}, this.$listener);
    }
}
