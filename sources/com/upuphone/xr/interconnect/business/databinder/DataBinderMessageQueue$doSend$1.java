package com.upuphone.xr.interconnect.business.databinder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.databinder.DataBinderMessageQueue", f = "DataBinderMessageQueue.kt", i = {0, 0, 0, 0}, l = {65}, m = "doSend", n = {"this", "pendingOperationMap", "sendBatch", "message"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class DataBinderMessageQueue$doSend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataBinderMessageQueue this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataBinderMessageQueue$doSend$1(DataBinderMessageQueue dataBinderMessageQueue, Continuation<? super DataBinderMessageQueue$doSend$1> continuation) {
        super(continuation);
        this.this$0 = dataBinderMessageQueue;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doSend(this);
    }
}
