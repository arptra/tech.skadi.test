package com.upuphone.xr.sapp.request;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.request.FeedBackReq", f = "FeedBackReq.kt", i = {}, l = {79}, m = "getConfig", n = {}, s = {})
public final class FeedBackReq$getConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedBackReq this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackReq$getConfig$1(FeedBackReq feedBackReq, Continuation<? super FeedBackReq$getConfig$1> continuation) {
        super(continuation);
        this.this$0 = feedBackReq;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
