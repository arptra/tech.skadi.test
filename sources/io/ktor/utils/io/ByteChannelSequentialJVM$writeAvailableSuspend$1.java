package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {41, 42}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
public final class ByteChannelSequentialJVM$writeAvailableSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialJVM$writeAvailableSuspend$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation<? super ByteChannelSequentialJVM$writeAvailableSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialJVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R1((ByteBuffer) null, this);
    }
}
