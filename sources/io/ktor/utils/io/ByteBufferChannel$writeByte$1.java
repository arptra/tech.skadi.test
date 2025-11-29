package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {936, 936, 936, 2426, 2481, 936, 936, 2508}, m = "writeByte$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", "b", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "b", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "b"}, s = {"L$0", "L$1", "B$0", "L$0", "L$1", "L$2", "B$0", "I$0", "L$0", "L$1", "B$0"})
public final class ByteBufferChannel$writeByte$1 extends ContinuationImpl {
    byte B$0;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeByte$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeByte$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.n2(this.this$0, (byte) 0, this);
    }
}
