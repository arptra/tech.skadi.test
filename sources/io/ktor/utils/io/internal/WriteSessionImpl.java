package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.WriterSuspendSession;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lio/ktor/utils/io/internal/WriteSessionImpl;", "Lio/ktor/utils/io/WriterSuspendSession;", "Lio/ktor/utils/io/ByteBufferChannel;", "channel", "<init>", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "", "e", "()V", "f", "", "min", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "a", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "n", "b", "(I)V", "c", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", "i", "(I)Ljava/lang/Void;", "h", "I", "locked", "Lio/ktor/utils/io/ByteBufferChannel;", "current", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "byteBuffer", "d", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "view", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "ringBufferCapacity", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class WriteSessionImpl implements WriterSuspendSession {

    /* renamed from: a  reason: collision with root package name */
    public int f9106a;
    public ByteBufferChannel b;
    public ByteBuffer c;
    public ChunkBuffer d;
    public RingBufferCapacity e = this.b.J0().b;

    public WriteSessionImpl(ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(byteBufferChannel, "channel");
        this.b = byteBufferChannel.G1();
        ChunkBuffer.Companion companion = ChunkBuffer.j;
        this.c = companion.a().h();
        this.d = companion.a();
    }

    public ChunkBuffer a(int i) {
        int n = this.f9106a + this.e.n(0);
        this.f9106a = n;
        if (n < i) {
            return null;
        }
        this.b.a1(this.c, n);
        if (this.c.remaining() < i) {
            return null;
        }
        BufferUtilsJvmKt.d(this.d, this.c);
        return this.d;
    }

    public void b(int i) {
        int i2;
        if (i < 0 || i > (i2 = this.f9106a)) {
            i(i);
            throw new KotlinNothingValueException();
        }
        this.f9106a = i2 - i;
        this.b.F0(this.c, this.e, i);
    }

    public Object c(int i, Continuation continuation) {
        if (this.b.P0() != null) {
            Object h = h(i, continuation);
            return h == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? h : Unit.INSTANCE;
        }
        int i2 = this.f9106a;
        if (i2 >= i) {
            return Unit.INSTANCE;
        }
        if (i2 > 0) {
            this.e.a(i2);
            this.f9106a = 0;
        }
        Object Z1 = this.b.Z1(i, continuation);
        return Z1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? Z1 : Unit.INSTANCE;
    }

    public final void e() {
        ByteBufferChannel G1 = this.b.G1();
        this.b = G1;
        ByteBuffer S1 = G1.S1();
        if (S1 != null) {
            this.c = S1;
            ChunkBuffer b2 = BufferUtilsJvmKt.b(this.b.J0().f9103a, (ObjectPool) null, 2, (Object) null);
            this.d = b2;
            BufferUtilsJvmKt.d(b2, this.c);
            this.e = this.b.J0().b;
        }
    }

    public final void f() {
        int i = this.f9106a;
        if (i > 0) {
            this.e.a(i);
            this.f9106a = 0;
        }
        this.b.J1();
        this.b.X1();
    }

    public void g() {
        this.b.flush();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(int r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = (io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1 r0 = new io.ktor.utils.io.internal.WriteSessionImpl$tryAwaitJoinSwitch$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r4 = (io.ktor.utils.io.internal.WriteSessionImpl) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.f9106a
            if (r6 <= 0) goto L_0x0044
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r4.e
            r2.a(r6)
            r6 = 0
            r4.f9106a = r6
        L_0x0044:
            r4.g()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.b
            r6.J1()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.b
            r6.X1()
            io.ktor.utils.io.ByteBufferChannel r6 = r4.b
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.Z1(r5, r0)
            if (r5 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.ktor.utils.io.ByteBufferChannel r5 = r4.b
            io.ktor.utils.io.ByteBufferChannel r5 = r5.G1()
            r4.b = r5
            java.nio.ByteBuffer r5 = r5.S1()
            if (r5 != 0) goto L_0x006d
            goto L_0x008e
        L_0x006d:
            r4.c = r5
            io.ktor.utils.io.ByteBufferChannel r5 = r4.b
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r5.J0()
            java.nio.ByteBuffer r5 = r5.f9103a
            r6 = 2
            r0 = 0
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.BufferUtilsJvmKt.b(r5, r0, r6, r0)
            r4.d = r5
            java.nio.ByteBuffer r6 = r4.c
            io.ktor.utils.io.core.BufferUtilsJvmKt.d(r5, r6)
            io.ktor.utils.io.ByteBufferChannel r5 = r4.b
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r5.J0()
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r5.b
            r4.e = r5
        L_0x008e:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.WriteSessionImpl.h(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Void i(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Written bytes count shouldn't be negative: " + i);
        }
        throw new IllegalStateException("Unable to mark " + i + " bytes as written: only " + this.f9106a + " were pre-locked.");
    }
}
