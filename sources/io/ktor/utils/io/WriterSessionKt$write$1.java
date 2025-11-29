package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWriterSession.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WriterSession.kt\nio/ktor/utils/io/WriterSessionKt$write$1\n*L\n1#1,108:1\n*E\n"})
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {22, 29, 29}, m = "write", n = {"$this$write", "block"}, s = {"L$0", "L$1"})
public final class WriterSessionKt$write$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public WriterSessionKt$write$1(Continuation<? super WriterSessionKt$write$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.f((ByteWriteChannel) null, 0, (Function3) null, this);
    }
}
