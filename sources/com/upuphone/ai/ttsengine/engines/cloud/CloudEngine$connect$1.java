package com.upuphone.ai.ttsengine.engines.cloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine", f = "CloudEngine.kt", i = {0, 0, 0}, l = {665}, m = "connect", n = {"this", "$this$withLock_u24default$iv", "report"}, s = {"L$0", "L$1", "Z$0"})
public final class CloudEngine$connect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$connect$1(CloudEngine cloudEngine, Continuation<? super CloudEngine$connect$1> continuation) {
        super(continuation);
        this.this$0 = cloudEngine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.connect(false, this);
    }
}
