package com.upuphone.xr.interconnect.listener;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004*\u0002H\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "L", "", "R", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ListenerAggregator$registerSelf$1 extends Lambda implements Function1<R, Unit> {
    final /* synthetic */ ListenerAggregator<L, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenerAggregator$registerSelf$1(ListenerAggregator<L, R> listenerAggregator) {
        super(1);
        this.this$0 = listenerAggregator;
    }

    public final void invoke(R r) {
        String access$getLogTag$p = this.this$0.logTag;
        Log.d(access$getLogTag$p, "Trying to register " + this.this$0.name + " listeners on proxy.");
        this.this$0.register.invoke(r, this.this$0.getParentListener());
        this.this$0.isParentRegistered = true;
    }
}
