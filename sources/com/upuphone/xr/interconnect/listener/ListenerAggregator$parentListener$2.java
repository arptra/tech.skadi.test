package com.upuphone.xr.interconnect.listener;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "L", "", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ListenerAggregator$parentListener$2 extends Lambda implements Function0<L> {
    final /* synthetic */ ListenerAggregator<L, R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListenerAggregator$parentListener$2(ListenerAggregator<L, R> listenerAggregator) {
        super(0);
        this.this$0 = listenerAggregator;
    }

    @NotNull
    public final L invoke() {
        return this.this$0.createParentListener();
    }
}
