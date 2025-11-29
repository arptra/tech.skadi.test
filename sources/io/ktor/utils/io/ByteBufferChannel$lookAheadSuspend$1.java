package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {2, 2, 2, 2, 5, 5}, l = {1790, 1792, 1797, 1802, 1804, 1808}, m = "lookAheadSuspend$suspendImpl", n = {"$this", "visitor", "result", "this_$iv", "$this", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
public final class ByteBufferChannel$lookAheadSuspend$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$lookAheadSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$lookAheadSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.W0(this.this$0, (Function2) null, this);
    }
}
