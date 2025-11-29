package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.NavNlpPreprocessor", f = "NavNlpPreprocessor.kt", i = {0, 0}, l = {375}, m = "searchPoiToNavigate", n = {"this", "nluResponse"}, s = {"L$0", "L$1"})
public final class NavNlpPreprocessor$searchPoiToNavigate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NavNlpPreprocessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavNlpPreprocessor$searchPoiToNavigate$1(NavNlpPreprocessor navNlpPreprocessor, Continuation<? super NavNlpPreprocessor$searchPoiToNavigate$1> continuation) {
        super(continuation);
        this.this$0 = navNlpPreprocessor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n((NluResponse) null, (String) null, 0, this);
    }
}
