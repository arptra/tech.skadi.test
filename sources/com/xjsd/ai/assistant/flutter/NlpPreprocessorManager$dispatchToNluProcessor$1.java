package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import com.xjsd.ai.assistant.nlu.bean.NluResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.NlpPreprocessorManager", f = "NlpPreprocessorManager.kt", i = {}, l = {94}, m = "dispatchToNluProcessor", n = {}, s = {})
public final class NlpPreprocessorManager$dispatchToNluProcessor$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NlpPreprocessorManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NlpPreprocessorManager$dispatchToNluProcessor$1(NlpPreprocessorManager nlpPreprocessorManager, Continuation<? super NlpPreprocessorManager$dispatchToNluProcessor$1> continuation) {
        super(continuation);
        this.this$0 = nlpPreprocessorManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((EndToEndResponse) null, (NluResponse) null, (String) null, this);
    }
}
