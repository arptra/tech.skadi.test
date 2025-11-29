package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor", f = "NavNlpPreprocessor.kt", i = {0, 1, 2, 3, 4, 5, 6}, l = {129, 196, 211, 226, 241, 279, 296}, m = "process", n = {"nluResponse", "nluResponse", "nluResponse", "nluResponse", "nluResponse", "nluResponse", "nluResponse"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
public final class NavNlpPreprocessor$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NavNlpPreprocessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavNlpPreprocessor$process$1(NavNlpPreprocessor navNlpPreprocessor, Continuation<? super NavNlpPreprocessor$process$1> continuation) {
        super(continuation);
        this.this$0 = navNlpPreprocessor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((NluResponse) null, this);
    }
}
