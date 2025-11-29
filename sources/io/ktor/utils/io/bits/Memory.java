package io.ktor.utils.io.bits;

import com.here.posclient.UpdateOptions;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@JvmInline
@SourceDebugExtension({"SMAP\nMemoryJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 2 Numbers.kt\nio/ktor/utils/io/core/internal/NumbersKt\n*L\n1#1,230:1\n6#2,2:231\n6#2,2:233\n6#2,2:235\n6#2,2:237\n6#2,2:239\n6#2,2:241\n*S KotlinDebug\n*F\n+ 1 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n*L\n31#1:231,2\n44#1:233,2\n51#1:235,2\n95#1:237,2\n96#1:239,2\n97#1:241,2\n*E\n"})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b@\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ&\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000bø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J3\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"Lio/ktor/utils/io/bits/Memory;", "", "Ljava/nio/ByteBuffer;", "buffer", "c", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "", "offset", "length", "h", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "", "i", "(Ljava/nio/ByteBuffer;JJ)Ljava/nio/ByteBuffer;", "destination", "destinationOffset", "", "d", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;III)V", "e", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;JJJ)V", "", "j", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "g", "(Ljava/nio/ByteBuffer;)I", "other", "", "f", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)Z", "a", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/nio/ByteBuffer;", "b", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
public final class Memory {
    public static final Companion b = new Companion((DefaultConstructorMarker) null);
    public static final ByteBuffer c;

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f9085a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Lio/ktor/utils/io/bits/Memory$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/bits/Memory;", "Empty", "Ljava/nio/ByteBuffer;", "a", "()Ljava/nio/ByteBuffer;", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ByteBuffer a() {
            return Memory.c;
        }

        public Companion() {
        }
    }

    static {
        ByteBuffer order = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        c = c(order);
    }

    public /* synthetic */ Memory(ByteBuffer byteBuffer) {
        this.f9085a = byteBuffer;
    }

    public static final /* synthetic */ Memory b(ByteBuffer byteBuffer) {
        return new Memory(byteBuffer);
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        return byteBuffer;
    }

    public static final void d(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (!byteBuffer.hasArray() || !byteBuffer2.hasArray() || byteBuffer.isReadOnly() || byteBuffer2.isReadOnly()) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.position(i);
            duplicate.limit(i + i2);
            ByteBuffer duplicate2 = byteBuffer2.duplicate();
            duplicate2.position(i3);
            duplicate2.put(duplicate);
            return;
        }
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, byteBuffer2.array(), byteBuffer2.arrayOffset() + i3, i2);
    }

    public static final void e(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(byteBuffer2, RtspHeaders.Values.DESTINATION);
        if (j < UpdateOptions.SOURCE_ANY) {
            int i = (int) j;
            if (j2 < UpdateOptions.SOURCE_ANY) {
                int i2 = (int) j2;
                if (j3 < UpdateOptions.SOURCE_ANY) {
                    d(byteBuffer, byteBuffer2, i, i2, (int) j3);
                } else {
                    NumbersKt.a(j3, "destinationOffset");
                    throw new KotlinNothingValueException();
                }
            } else {
                NumbersKt.a(j2, "length");
                throw new KotlinNothingValueException();
            }
        } else {
            NumbersKt.a(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    public static boolean f(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof Memory) && Intrinsics.areEqual((Object) byteBuffer, (Object) ((Memory) obj).k());
    }

    public static int g(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    public static final ByteBuffer h(ByteBuffer byteBuffer, int i, int i2) {
        return c(MemoryJvmKt.d(byteBuffer, i, i2));
    }

    public static final ByteBuffer i(ByteBuffer byteBuffer, long j, long j2) {
        if (j < UpdateOptions.SOURCE_ANY) {
            int i = (int) j;
            if (j2 < UpdateOptions.SOURCE_ANY) {
                return h(byteBuffer, i, (int) j2);
            }
            NumbersKt.a(j2, "length");
            throw new KotlinNothingValueException();
        }
        NumbersKt.a(j, "offset");
        throw new KotlinNothingValueException();
    }

    public static String j(ByteBuffer byteBuffer) {
        return "Memory(buffer=" + byteBuffer + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f9085a, obj);
    }

    public int hashCode() {
        return g(this.f9085a);
    }

    public final /* synthetic */ ByteBuffer k() {
        return this.f9085a;
    }

    public String toString() {
        return j(this.f9085a);
    }
}
