package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.ApplicationNlpPreprocessor", f = "ApplicationNlpPreprocessor.kt", i = {0}, l = {19}, m = "process", n = {"nluResponse"}, s = {"L$0"})
public final class ApplicationNlpPreprocessor$process$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationNlpPreprocessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplicationNlpPreprocessor$process$1(ApplicationNlpPreprocessor applicationNlpPreprocessor, Continuation<? super ApplicationNlpPreprocessor$process$1> continuation) {
        super(continuation);
        this.this$0 = applicationNlpPreprocessor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((NluResponse) null, this);
    }
}
