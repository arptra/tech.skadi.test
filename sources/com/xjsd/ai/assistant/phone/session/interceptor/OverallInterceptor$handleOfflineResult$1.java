package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.protocol.asr.AsrTransData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor", f = "OverallInterceptor.kt", i = {0, 0, 0}, l = {1009}, m = "handleOfflineResult", n = {"this", "asrTransData", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
public final class OverallInterceptor$handleOfflineResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OverallInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$handleOfflineResult$1(OverallInterceptor overallInterceptor, Continuation<? super OverallInterceptor$handleOfflineResult$1> continuation) {
        super(continuation);
        this.this$0 = overallInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.U((AsrTransData) null, this);
    }
}
