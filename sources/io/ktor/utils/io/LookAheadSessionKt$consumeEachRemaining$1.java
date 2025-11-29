package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLookAheadSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LookAheadSession.kt\nio/ktor/utils/io/LookAheadSessionKt$consumeEachRemaining$1\n*L\n1#1,65:1\n*E\n"})
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.LookAheadSessionKt", f = "LookAheadSession.kt", i = {0, 0, 1, 1, 1}, l = {54, 59}, m = "consumeEachRemaining", n = {"$this$consumeEachRemaining", "visitor", "$this$consumeEachRemaining", "visitor", "s"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
public final class LookAheadSessionKt$consumeEachRemaining$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public LookAheadSessionKt$consumeEachRemaining$1(Continuation<? super LookAheadSessionKt$consumeEachRemaining$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LookAheadSessionKt.a((LookAheadSuspendSession) null, (Function2) null, this);
    }
}
