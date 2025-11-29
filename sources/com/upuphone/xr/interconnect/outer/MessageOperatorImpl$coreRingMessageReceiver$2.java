package com.upuphone.xr.interconnect.outer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class MessageOperatorImpl$coreRingMessageReceiver$2 extends FunctionReferenceImpl implements Function2<String, Function0<? extends Unit>, Unit> {
    public MessageOperatorImpl$coreRingMessageReceiver$2(Object obj) {
        super(2, obj, MessageOperatorImpl.class, "serialize", "serialize(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Function0<Unit>) (Function0) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(function0, "p1");
        ((MessageOperatorImpl) this.receiver).serialize(str, function0);
    }
}
