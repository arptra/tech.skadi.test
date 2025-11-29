package com.upuphone.xr.sapp.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.config.RequestNetConfigHelper", f = "RequestNetConfigHelper.kt", i = {0}, l = {57}, m = "requestNetConfig", n = {"this"}, s = {"L$0"})
public final class RequestNetConfigHelper$requestNetConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestNetConfigHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RequestNetConfigHelper$requestNetConfig$1(RequestNetConfigHelper requestNetConfigHelper, Continuation<? super RequestNetConfigHelper$requestNetConfig$1> continuation) {
        super(continuation);
        this.this$0 = requestNetConfigHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
