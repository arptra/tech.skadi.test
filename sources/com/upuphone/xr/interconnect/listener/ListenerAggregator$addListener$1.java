package com.upuphone.xr.interconnect.listener;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "L", "", "R", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ListenerAggregator$addListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ L $listener;
    final /* synthetic */ String $listenerName;
    final /* synthetic */ ListenerAggregator<L, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenerAggregator$addListener$1(ListenerAggregator<L, R> listenerAggregator, String str, L l) {
        super(0);
        this.this$0 = listenerAggregator;
        this.$listenerName = str;
        this.$listener = l;
    }

    public final void invoke() {
        String access$getLogTag$p = this.this$0.logTag;
        Log.d(access$getLogTag$p, "adding " + this.this$0.name + " listener: " + this.$listenerName + '.');
        this.this$0.listeners.add(this.$listener);
        if (!this.this$0.isParentRegistered) {
            this.this$0.registerSelf();
        }
        String access$getLogTag$p2 = this.this$0.logTag;
        Log.v(access$getLogTag$p2, "listener count: " + this.this$0.listeners.size() + '.');
    }
}
