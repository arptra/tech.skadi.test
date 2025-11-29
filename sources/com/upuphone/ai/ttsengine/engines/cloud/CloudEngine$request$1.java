package com.upuphone.ai.ttsengine.engines.cloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cloud.CloudEngine", f = "CloudEngine.kt", i = {0, 1, 1, 1, 1}, l = {282, 319}, m = "request", n = {"this", "this", "requestStr", "textType", "requestId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
public final class CloudEngine$request$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudEngine$request$1(CloudEngine cloudEngine, Continuation<? super CloudEngine$request$1> continuation) {
        super(continuation);
        this.this$0 = cloudEngine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request(false, this);
    }
}
