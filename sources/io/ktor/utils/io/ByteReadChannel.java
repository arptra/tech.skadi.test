package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.LongCompanionObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\bf\u0018\u0000 J2\u00020\u0001:\u0001KJ+\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH¦@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\bJ\u001b\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001aJ\u0013\u0010\u001d\u001a\u00020\u001cH¦@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001aJ\u0013\u0010\u001f\u001a\u00020\u001eH¦@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001aJ\u0013\u0010!\u001a\u00020 H¦@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001aJ\u0013\u0010#\u001a\u00020\"H¦@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u001aJB\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010$2'\u0010)\u001a#\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\u0006\u0012\u0004\u0018\u00010\u00010%¢\u0006\u0002\b(H§@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010\u0016\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b-\u0010\u0014J1\u00101\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u00042\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0/H¦@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0019\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103H&¢\u0006\u0004\b6\u00107J\u001b\u00109\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0004\b9\u0010\u0018JG\u0010=\u001a\u00020\u00152\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00152\b\b\u0002\u0010\u0005\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u00108\u001a\u00020\u0015H¦@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010D\u001a\u0002058&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u0002058&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0016\u0010I\u001a\u0004\u0018\u0001038&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "", "dst", "", "offset", "length", "D", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "v", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "u", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p", "size", "Lio/ktor/utils/io/core/ByteReadPacket;", "j", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "limit", "A", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "", "G", "", "q", "", "B", "", "o", "R", "Lkotlin/Function2;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "visitor", "m", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "N", "min", "Lkotlin/Function1;", "consumer", "K", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "", "e", "(Ljava/lang/Throwable;)Z", "max", "k", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "s", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "()I", "availableForRead", "Q", "()Z", "isClosedForRead", "g", "isClosedForWrite", "f", "()Ljava/lang/Throwable;", "closedCause", "a", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
public interface ByteReadChannel {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f9077a = Companion.f9078a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/ByteReadChannel;", "b", "Lkotlin/Lazy;", "a", "()Lio/ktor/utils/io/ByteReadChannel;", "Empty", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f9078a = new Companion();
        public static final Lazy b = LazyKt.lazy(ByteReadChannel$Companion$Empty$2.INSTANCE);

        public final ByteReadChannel a() {
            return (ByteReadChannel) b.getValue();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object a(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    j = LongCompanionObject.MAX_VALUE;
                }
                return byteReadChannel.A(j, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readRemaining");
        }
    }

    Object A(long j, Continuation continuation);

    Object B(Continuation continuation);

    Object D(byte[] bArr, int i, int i2, Continuation continuation);

    Object E(Continuation continuation);

    Object G(Continuation continuation);

    Object K(int i, Function1 function1, Continuation continuation);

    Object N(int i, Continuation continuation);

    boolean Q();

    boolean e(Throwable th);

    Throwable f();

    boolean g();

    int i();

    Object j(int i, Continuation continuation);

    Object k(long j, Continuation continuation);

    Object m(Function2 function2, Continuation continuation);

    Object n(Continuation continuation);

    Object o(Continuation continuation);

    Object p(byte[] bArr, int i, int i2, Continuation continuation);

    Object q(Continuation continuation);

    Object s(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation continuation);

    Object u(ByteBuffer byteBuffer, Continuation continuation);

    Object v(ChunkBuffer chunkBuffer, Continuation continuation);
}
