package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.WriteSessionImpl", f = "WriteSessionImpl.kt", i = {0}, l = {86}, m = "tryAwaitJoinSwitch", n = {"this"}, s = {"L$0"})
public final class WriteSessionImpl$tryAwaitJoinSwitch$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WriteSessionImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WriteSessionImpl$tryAwaitJoinSwitch$1(WriteSessionImpl writeSessionImpl, Continuation<? super WriteSessionImpl$tryAwaitJoinSwitch$1> continuation) {
        super(continuation);
        this.this$0 = writeSessionImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(0, this);
    }
}
