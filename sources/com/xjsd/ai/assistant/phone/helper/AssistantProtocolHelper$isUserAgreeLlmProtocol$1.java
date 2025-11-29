package com.xjsd.ai.assistant.phone.helper;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.helper.AssistantProtocolHelper", f = "AssistantProtocolHelper.kt", i = {}, l = {32}, m = "isUserAgreeLlmProtocol", n = {}, s = {})
public final class AssistantProtocolHelper$isUserAgreeLlmProtocol$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public AssistantProtocolHelper$isUserAgreeLlmProtocol$1(Continuation<? super AssistantProtocolHelper$isUserAgreeLlmProtocol$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AssistantProtocolHelper.e(this);
    }
}
