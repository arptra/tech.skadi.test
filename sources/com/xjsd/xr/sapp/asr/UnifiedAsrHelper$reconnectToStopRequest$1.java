package com.xjsd.xr.sapp.asr;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.xr.sapp.asr.UnifiedAsrHelper", f = "UnifiedAsrHelper.kt", i = {0, 2}, l = {399, 401, 406, 408}, m = "reconnectToStopRequest", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class UnifiedAsrHelper$reconnectToStopRequest$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnifiedAsrHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedAsrHelper$reconnectToStopRequest$1(UnifiedAsrHelper unifiedAsrHelper, Continuation<? super UnifiedAsrHelper$reconnectToStopRequest$1> continuation) {
        super(continuation);
        this.this$0 = unifiedAsrHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reconnectToStopRequest(0, this);
    }
}
