package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {57}, m = "trySuspend", n = {"suspended"}, s = {"I$0"})
public final class AwaitingSlot$trySuspend$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitingSlot this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitingSlot$trySuspend$1(AwaitingSlot awaitingSlot, Continuation<? super AwaitingSlot$trySuspend$1> continuation) {
        super(continuation);
        this.this$0 = awaitingSlot;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e((Function0) null, this);
    }
}
