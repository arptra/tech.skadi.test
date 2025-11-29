package io.ktor.websocket;

import io.ktor.util.NIOKt;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0003\u001a\u00020\u0007*\u00020\u0007H\u0002¢\u0006\u0004\b\u0003\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0019R\u0011\u0010*\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010'R\u0011\u0010,\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\"\u0010+¨\u0006-"}, d2 = {"Lio/ktor/websocket/Serializer;", "", "Lio/ktor/websocket/Frame;", "f", "", "a", "(Lio/ktor/websocket/Frame;)V", "Ljava/nio/ByteBuffer;", "buffer", "g", "(Ljava/nio/ByteBuffer;)V", "frame", "", "mask", "h", "(Lio/ktor/websocket/Frame;Ljava/nio/ByteBuffer;Z)V", "", "b", "(Lio/ktor/websocket/Frame;Z)I", "k", "(Ljava/nio/ByteBuffer;)Z", "e", "(Z)I", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "i", "(Z)V", "Ljava/util/concurrent/ArrayBlockingQueue;", "Ljava/util/concurrent/ArrayBlockingQueue;", "messages", "Ljava/nio/ByteBuffer;", "frameBody", "c", "maskBuffer", "Lio/ktor/websocket/FrameType;", "d", "Lio/ktor/websocket/FrameType;", "lastDataFrameType", "Z", "getMasking", "()Z", "j", "masking", "hasOutstandingBytes", "()I", "remainingCapacity", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Serializer.kt\nio/ktor/websocket/Serializer\n+ 2 Utils.kt\nio/ktor/websocket/UtilsKt__UtilsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,128:1\n14#2:129\n14#2:130\n14#2:131\n14#2:132\n14#2:133\n1#3:134\n*S KotlinDebug\n*F\n+ 1 Serializer.kt\nio/ktor/websocket/Serializer\n*L\n76#1:129\n77#1:130\n78#1:131\n79#1:132\n83#1:133\n*E\n"})
public final class Serializer {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayBlockingQueue f9138a;
    public ByteBuffer b;
    public ByteBuffer c;
    public FrameType d;
    public boolean e;

    public final void a(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "f");
        this.f9138a.put(frame);
    }

    public final int b(Frame frame, boolean z) {
        int remaining = frame.a().remaining();
        return (remaining < 126 ? 2 : remaining <= 32767 ? 4 : 10) + e(z);
    }

    public final boolean c() {
        return (this.f9138a.isEmpty() ^ true) || this.b != null;
    }

    public final int d() {
        return this.f9138a.remainingCapacity();
    }

    public final int e(boolean z) {
        return z ? 4 : 0;
    }

    public final ByteBuffer f(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.c;
        if (byteBuffer2 == null) {
            return byteBuffer;
        }
        ByteBuffer b2 = NIOKt.b(byteBuffer, 0, 1, (Object) null);
        UtilsKt.b(b2, byteBuffer2);
        return b2 == null ? byteBuffer : b2;
    }

    public final void g(ByteBuffer byteBuffer) {
        Frame frame;
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        while (k(byteBuffer) && (frame = (Frame) this.f9138a.peek()) != null) {
            boolean z = this.e;
            i(z);
            if (byteBuffer.remaining() >= b(frame, z)) {
                h(frame, byteBuffer, z);
                this.f9138a.remove();
                this.b = f(frame.a());
            } else {
                return;
            }
        }
    }

    public final void h(Frame frame, ByteBuffer byteBuffer, boolean z) {
        int i;
        ByteBuffer duplicate;
        int remaining = frame.a().remaining();
        if (remaining >= 126) {
            remaining = remaining <= 65535 ? 126 : 127;
        }
        FrameType frameType = this.d;
        if (frameType == null) {
            if (!frame.c()) {
                this.d = frame.d();
            }
            i = frame.d().getOpcode();
        } else if (frameType == frame.d()) {
            if (frame.c()) {
                this.d = null;
            }
            i = 0;
        } else if (frame.d().getControlFrame()) {
            i = frame.d().getOpcode();
        } else {
            throw new IllegalStateException("Can't continue with different data frame opcode");
        }
        int i2 = 128;
        byteBuffer.put((byte) (i | (frame.c() ? 128 : 0) | (frame.e() ? 64 : 0) | (frame.f() ? 32 : 0) | (frame.g() ? 16 : 0)));
        if (!z) {
            i2 = 0;
        }
        byteBuffer.put((byte) (i2 | remaining));
        if (remaining == 126) {
            byteBuffer.putShort((short) frame.a().remaining());
        } else if (remaining == 127) {
            byteBuffer.putLong((long) frame.a().remaining());
        }
        ByteBuffer byteBuffer2 = this.c;
        if (byteBuffer2 != null && (duplicate = byteBuffer2.duplicate()) != null) {
            NIOKt.d(duplicate, byteBuffer, 0, 2, (Object) null);
        }
    }

    public final void i(boolean z) {
        if (z) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(Random.Default.nextInt());
            allocate.clear();
            this.c = allocate;
            return;
        }
        this.c = null;
    }

    public final void j(boolean z) {
        this.e = z;
    }

    public final boolean k(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.b;
        if (byteBuffer2 == null) {
            return true;
        }
        NIOKt.d(byteBuffer2, byteBuffer, 0, 2, (Object) null);
        if (byteBuffer2.hasRemaining()) {
            return false;
        }
        this.b = null;
        return true;
    }
}
