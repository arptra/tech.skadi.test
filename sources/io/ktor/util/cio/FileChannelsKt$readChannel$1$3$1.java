package io.ktor.util.cio;

import io.ktor.util.BufferViewJvmKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterSuspendSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.cio.FileChannelsKt$readChannel$1$3$1", f = "FileChannels.kt", i = {0}, l = {49}, m = "invokeSuspend", n = {"$this$writeSuspendSession"}, s = {"L$0"})
public final class FileChannelsKt$readChannel$1$3$1 extends SuspendLambda implements Function2<WriterSuspendSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ WriterScope $$this$writer;
    final /* synthetic */ FileChannel $fileChannel;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileChannelsKt$readChannel$1$3$1(WriterScope writerScope, FileChannel fileChannel, Continuation<? super FileChannelsKt$readChannel$1$3$1> continuation) {
        super(2, continuation);
        this.$$this$writer = writerScope;
        this.$fileChannel = fileChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FileChannelsKt$readChannel$1$3$1 fileChannelsKt$readChannel$1$3$1 = new FileChannelsKt$readChannel$1$3$1(this.$$this$writer, this.$fileChannel, continuation);
        fileChannelsKt$readChannel$1$3$1.L$0 = obj;
        return fileChannelsKt$readChannel$1$3$1;
    }

    @Nullable
    public final Object invoke(@NotNull WriterSuspendSession writerSuspendSession, @Nullable Continuation<? super Unit> continuation) {
        return ((FileChannelsKt$readChannel$1$3$1) create(writerSuspendSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        WriterSuspendSession writerSuspendSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            writerSuspendSession = (WriterSuspendSession) this.L$0;
        } else if (i == 1) {
            writerSuspendSession = (WriterSuspendSession) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (true) {
            ChunkBuffer a2 = writerSuspendSession.a(1);
            if (a2 == null) {
                this.$$this$writer.b().flush();
                this.L$0 = writerSuspendSession;
                this.label = 1;
                if (writerSuspendSession.c(1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                int a3 = BufferViewJvmKt.a(this.$fileChannel, a2);
                if (a3 == -1) {
                    return Unit.INSTANCE;
                }
                writerSuspendSession.b(a3);
            }
        }
    }
}
