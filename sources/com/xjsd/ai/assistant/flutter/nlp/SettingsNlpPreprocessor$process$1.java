package com.xjsd.ai.assistant.flutter.nlp;

import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.nlp.SettingsNlpPreprocessor", f = "SettingsNlpPreprocessor.kt", i = {0}, l = {105}, m = "process", n = {"nluResponse"}, s = {"L$0"})
public final class SettingsNlpPreprocessor$process$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsNlpPreprocessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingsNlpPreprocessor$process$1(SettingsNlpPreprocessor settingsNlpPreprocessor, Continuation<? super SettingsNlpPreprocessor$process$1> continuation) {
        super(continuation);
        this.this$0 = settingsNlpPreprocessor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i((NluResponse) null, this);
    }
}
