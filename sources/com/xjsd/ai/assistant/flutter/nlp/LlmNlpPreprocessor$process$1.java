package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.LlmNlpPreprocessor", f = "LlmNlpPreprocessor.kt", i = {0, 0}, l = {27}, m = "process", n = {"this", "nluResponse"}, s = {"L$0", "L$1"})
public final class LlmNlpPreprocessor$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LlmNlpPreprocessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LlmNlpPreprocessor$process$1(LlmNlpPreprocessor llmNlpPreprocessor, Continuation<? super LlmNlpPreprocessor$process$1> continuation) {
        super(continuation);
        this.this$0 = llmNlpPreprocessor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((NluResponse) null, this);
    }
}
