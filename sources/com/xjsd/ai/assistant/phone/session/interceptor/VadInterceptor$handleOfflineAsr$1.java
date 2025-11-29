package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.phone.vad.OfflineAsrResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.VadInterceptor", f = "VadInterceptor.kt", i = {}, l = {185}, m = "handleOfflineAsr", n = {}, s = {})
public final class VadInterceptor$handleOfflineAsr$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VadInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VadInterceptor$handleOfflineAsr$1(VadInterceptor vadInterceptor, Continuation<? super VadInterceptor$handleOfflineAsr$1> continuation) {
        super(continuation);
        this.this$0 = vadInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.t((OfflineAsrResult) null, this);
    }
}
