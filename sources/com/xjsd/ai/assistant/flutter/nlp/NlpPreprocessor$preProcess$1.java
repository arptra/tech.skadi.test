package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.NlpPreprocessor$DefaultImpls", f = "NlpPreprocessor.kt", i = {0, 0}, l = {46}, m = "preProcess", n = {"$this", "nluResponse"}, s = {"L$0", "L$1"})
public final class NlpPreprocessor$preProcess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public NlpPreprocessor$preProcess$1(Continuation<? super NlpPreprocessor$preProcess$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return NlpPreprocessor.DefaultImpls.e((NlpPreprocessor) null, (NluResponse) null, this);
    }
}
