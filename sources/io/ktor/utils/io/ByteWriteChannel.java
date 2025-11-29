package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u000eH¦@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J<\u0010\u001a\u001a\u00020\u00072'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015¢\u0006\u0002\b\u0018H§@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH¦@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010!\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020 H¦@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001b\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020&H¦@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H¦@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u00010.H&¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0007H&¢\u0006\u0004\b2\u00103J\u001b\u00105\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u000204H¦@ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u00108R\u0016\u0010>\u001a\u0004\u0018\u00010.8&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "", "src", "", "offset", "length", "", "I", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "l", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "block", "x", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "y", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "visitor", "F", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/ByteReadPacket;", "packet", "w", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "H", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "O", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "s", "t", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "C", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "h", "(Ljava/lang/Throwable;)Z", "flush", "()V", "Lio/ktor/utils/io/core/Buffer;", "M", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "()Z", "isClosedForWrite", "z", "autoFlush", "f", "()Ljava/lang/Throwable;", "closedCause", "ktor-io"}, k = 1, mv = {1, 8, 0})
public interface ByteWriteChannel {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    Object C(byte b, Continuation continuation);

    Object F(Function2 function2, Continuation continuation);

    Object H(long j, Continuation continuation);

    Object I(byte[] bArr, int i, int i2, Continuation continuation);

    Object M(Buffer buffer, Continuation continuation);

    Object O(int i, Continuation continuation);

    Throwable f();

    void flush();

    boolean g();

    boolean h(Throwable th);

    Object l(ByteBuffer byteBuffer, Continuation continuation);

    Object t(short s, Continuation continuation);

    Object w(ByteReadPacket byteReadPacket, Continuation continuation);

    Object x(int i, Function1 function1, Continuation continuation);

    Object y(Function1 function1, Continuation continuation);

    boolean z();
}
