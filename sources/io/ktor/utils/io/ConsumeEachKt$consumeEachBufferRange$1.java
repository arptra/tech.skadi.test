package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nConsumeEach.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConsumeEach.kt\nio/ktor/utils/io/ConsumeEachKt$consumeEachBufferRange$1\n*L\n1#1,41:1\n*E\n"})
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ConsumeEachKt", f = "ConsumeEach.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2}, l = {46, 50, 53}, m = "consumeEachBufferRange", n = {"$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "$this$consumeEachBufferRange", "visitor", "continueFlag", "lastChunkReported", "$this$read_u24default$iv", "buffer$iv", "bytesRead$iv", "cause$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
public final class ConsumeEachKt$consumeEachBufferRange$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;

    public ConsumeEachKt$consumeEachBufferRange$1(Continuation<? super ConsumeEachKt$consumeEachBufferRange$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ConsumeEachKt.a((ByteReadChannel) null, (Function2) null, this);
    }
}
