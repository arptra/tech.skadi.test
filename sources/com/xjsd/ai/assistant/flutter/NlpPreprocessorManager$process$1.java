package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.net.ws.protocol.EndToEndResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.flutter.NlpPreprocessorManager", f = "NlpPreprocessorManager.kt", i = {0, 0, 0}, l = {54}, m = "process", n = {"response", "type", "isNlu"}, s = {"L$0", "L$1", "Z$0"})
public final class NlpPreprocessorManager$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NlpPreprocessorManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NlpPreprocessorManager$process$1(NlpPreprocessorManager nlpPreprocessorManager, Continuation<? super NlpPreprocessorManager$process$1> continuation) {
        super(continuation);
        this.this$0 = nlpPreprocessorManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g((EndToEndResponse) null, this);
    }
}
