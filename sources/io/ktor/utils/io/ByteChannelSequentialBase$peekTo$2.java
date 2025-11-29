package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nByteChannelSequential.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteChannelSequential.kt\nio/ktor/utils/io/ByteChannelSequentialBase$peekTo$2\n+ 2 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 3 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n*L\n1#1,855:1\n69#2:856\n69#2:857\n15#3:858\n*S KotlinDebug\n*F\n+ 1 ByteChannelSequential.kt\nio/ktor/utils/io/ByteChannelSequentialBase$peekTo$2\n*L\n826#1:856\n827#1:857\n827#1:858\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/SuspendableReadSession;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2", f = "ByteChannelSequential.kt", i = {0}, l = {823}, m = "invokeSuspend", n = {"$this$readSuspendableSession"}, s = {"L$0"})
public final class ByteChannelSequentialBase$peekTo$2 extends SuspendLambda implements Function2<SuspendableReadSession, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $bytesCopied;
    final /* synthetic */ ByteBuffer $destination;
    final /* synthetic */ long $destinationOffset;
    final /* synthetic */ long $max;
    final /* synthetic */ long $min;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteChannelSequentialBase$peekTo$2(long j, long j2, Ref.LongRef longRef, long j3, ByteBuffer byteBuffer, long j4, Continuation<? super ByteChannelSequentialBase$peekTo$2> continuation) {
        super(2, continuation);
        this.$min = j;
        this.$offset = j2;
        this.$bytesCopied = longRef;
        this.$max = j3;
        this.$destination = byteBuffer;
        this.$destinationOffset = j4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ByteChannelSequentialBase$peekTo$2 byteChannelSequentialBase$peekTo$2 = new ByteChannelSequentialBase$peekTo$2(this.$min, this.$offset, this.$bytesCopied, this.$max, this.$destination, this.$destinationOffset, continuation);
        byteChannelSequentialBase$peekTo$2.L$0 = obj;
        return byteChannelSequentialBase$peekTo$2;
    }

    @Nullable
    public final Object invoke(@NotNull SuspendableReadSession suspendableReadSession, @Nullable Continuation<? super Unit> continuation) {
        return ((ByteChannelSequentialBase$peekTo$2) create(suspendableReadSession, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SuspendableReadSession suspendableReadSession;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SuspendableReadSession suspendableReadSession2 = (SuspendableReadSession) this.L$0;
            this.L$0 = suspendableReadSession2;
            this.label = 1;
            if (suspendableReadSession2.b((int) RangesKt.coerceAtMost(this.$min + this.$offset, 4088), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            suspendableReadSession = suspendableReadSession2;
        } else if (i == 1) {
            suspendableReadSession = (SuspendableReadSession) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChunkBuffer a2 = suspendableReadSession.a(1);
        if (a2 == null) {
            a2 = ChunkBuffer.j.a();
        }
        if (((long) (a2.k() - a2.i())) > this.$offset) {
            this.$bytesCopied.element = Math.min(((long) (a2.k() - a2.i())) - this.$offset, Math.min(this.$max, ((long) this.$destination.limit()) - this.$destinationOffset));
            Memory.e(a2.h(), this.$destination, this.$offset, this.$bytesCopied.element, this.$destinationOffset);
        }
        return Unit.INSTANCE;
    }
}
