package com.upuphone.ar.translation.iflytek;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.iflytek.IFlyAsrHelper", f = "IFlyAsrHelper.kt", i = {0, 2}, l = {545, 547, 552, 554}, m = "reconnectToStopRequest", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class IFlyAsrHelper$reconnectToStopRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IFlyAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IFlyAsrHelper$reconnectToStopRequest$1(IFlyAsrHelper iFlyAsrHelper, Continuation<? super IFlyAsrHelper$reconnectToStopRequest$1> continuation) {
        super(continuation);
        this.this$0 = iFlyAsrHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n0(0, this);
    }
}
