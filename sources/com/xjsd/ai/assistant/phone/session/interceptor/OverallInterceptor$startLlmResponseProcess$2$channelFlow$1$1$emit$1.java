package com.xjsd.ai.assistant.phone.session.interceptor;

import com.xjsd.ai.assistant.chatgpt.model.LlmResponse;
import com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.session.interceptor.OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1", f = "OverallInterceptor.kt", i = {0, 0}, l = {877}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$1"})
public final class OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OverallInterceptor$startLlmResponseProcess$2$channelFlow$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1(OverallInterceptor$startLlmResponseProcess$2$channelFlow$1.AnonymousClass1<? super T> r1, Continuation<? super OverallInterceptor$startLlmResponseProcess$2$channelFlow$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((LlmResponse) null, this);
    }
}
