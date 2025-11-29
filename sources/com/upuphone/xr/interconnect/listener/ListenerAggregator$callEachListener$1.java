package com.upuphone.xr.interconnect.listener;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nListenerAggregator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListenerAggregator.kt\ncom/upuphone/xr/interconnect/listener/ListenerAggregator$callEachListener$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,78:1\n1855#2,2:79\n*S KotlinDebug\n*F\n+ 1 ListenerAggregator.kt\ncom/upuphone/xr/interconnect/listener/ListenerAggregator$callEachListener$1\n*L\n75#1:79,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "L", "", "R", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ListenerAggregator$callEachListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<L, Unit> $action;
    final /* synthetic */ ListenerAggregator<L, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenerAggregator$callEachListener$1(ListenerAggregator<L, R> listenerAggregator, Function1<? super L, Unit> function1) {
        super(0);
        this.this$0 = listenerAggregator;
        this.$action = function1;
    }

    public final void invoke() {
        if (!this.this$0.listeners.isEmpty() || !this.this$0.isParentRegistered) {
            HashSet<Object> access$getListeners$p = this.this$0.listeners;
            Function1<L, Unit> function1 = this.$action;
            for (Object invoke : access$getListeners$p) {
                function1.invoke(invoke);
            }
            return;
        }
        this.this$0.unregisterSelf();
    }
}
