package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"io/ktor/utils/io/ByteChannelSequentialBase$beginWriteSession$1", "Lio/ktor/utils/io/WriterSuspendSession;", "", "min", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "n", "", "b", "(I)V", "c", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class ByteChannelSequentialBase$beginWriteSession$1 implements WriterSuspendSession {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteChannelSequentialBase f9076a;

    public ByteChannelSequentialBase$beginWriteSession$1(ByteChannelSequentialBase byteChannelSequentialBase) {
        this.f9076a = byteChannelSequentialBase;
    }

    public ChunkBuffer a(int i) {
        if (this.f9076a.z0() == 0) {
            return null;
        }
        return this.f9076a.E0().c0(i);
    }

    public void b(int i) {
        this.f9076a.E0().b();
        this.f9076a.i0(i);
    }

    public Object c(int i, Continuation continuation) {
        if (this.f9076a.z0() >= i) {
            return Unit.INSTANCE;
        }
        Object l0 = this.f9076a.l0(i, continuation);
        return l0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? l0 : Unit.INSTANCE;
    }
}
