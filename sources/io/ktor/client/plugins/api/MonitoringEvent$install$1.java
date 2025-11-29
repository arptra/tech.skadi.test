package io.ktor.client.plugins.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Param", "", "Event", "Lio/ktor/events/EventDefinition;", "it", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MonitoringEvent$install$1 extends Lambda implements Function1<Param, Unit> {
    final /* synthetic */ Function1<Param, Unit> $handler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitoringEvent$install$1(Function1<? super Param, Unit> function1) {
        super(1);
        this.$handler = function1;
    }

    public final void invoke(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "it");
        this.$handler.invoke(param);
    }
}
