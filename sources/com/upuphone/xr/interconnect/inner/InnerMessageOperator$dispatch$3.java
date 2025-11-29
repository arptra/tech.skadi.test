package com.upuphone.xr.interconnect.inner;

import com.upuphone.xr.interconnect.entity.StarryNetRingMessage;
import com.upuphone.xr.interconnect.listener.RingMessageReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/listener/RingMessageReceiver;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class InnerMessageOperator$dispatch$3 extends Lambda implements Function1<RingMessageReceiver, Unit> {
    final /* synthetic */ StarryNetRingMessage $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InnerMessageOperator$dispatch$3(StarryNetRingMessage starryNetRingMessage) {
        super(1);
        this.$message = starryNetRingMessage;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RingMessageReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RingMessageReceiver ringMessageReceiver) {
        Intrinsics.checkNotNullParameter(ringMessageReceiver, "$this$threadSafeAlienCall");
        ringMessageReceiver.onMessageReceive(this.$message);
    }
}
