package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;

@SourceDebugExtension({"SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 2 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n*L\n1#1,472:1\n69#1:475\n69#1:476\n74#1:477\n74#1:478\n74#1:479\n69#1:480\n69#1,6:491\n59#1:497\n21#2:473\n21#2:474\n26#2:483\n26#2:485\n26#2:487\n37#2,2:489\n1#3:481\n84#4:482\n84#4:484\n84#4:486\n99#4:488\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n86#1:475\n81#1:476\n94#1:477\n106#1:478\n113#1:479\n122#1:480\n333#1:491,6\n333#1:497\n53#1:473\n64#1:474\n277#1:483\n291#1:485\n307#1:487\n319#1:489,2\n277#1:482\n291#1:484\n307#1:486\n319#1:488\n*E\n"})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0017\u0018\u0000 62\u00020\u0001:\u00019B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0010\u0010\nJ\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0000H\u0014¢\u0006\u0004\b\u001f\u0010 J\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\u0016J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R \u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R$\u00102\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101R$\u00104\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\t\u0010/\u001a\u0004\b3\u00101R$\u0010\u0011\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0010\u0010/\u001a\u0004\b5\u00101R$\u0010\u0018\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00068\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010/\u001a\u0004\b6\u00101R\u0017\u00108\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b7\u0010/\u001a\u0004\b7\u00101\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Lio/ktor/utils/io/core/Buffer;", "", "Lio/ktor/utils/io/bits/Memory;", "memory", "<init>", "(Ljava/nio/ByteBuffer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "count", "", "c", "(I)V", "a", "position", "", "b", "(I)Z", "d", "startGap", "q", "endGap", "p", "s", "()V", "t", "limit", "u", "n", "m", "newReadPosition", "o", "copy", "e", "(Lio/ktor/utils/io/core/Buffer;)V", "", "l", "()B", "value", "v", "(B)V", "r", "", "toString", "()Ljava/lang/String;", "Ljava/nio/ByteBuffer;", "h", "()Ljava/nio/ByteBuffer;", "<set-?>", "I", "i", "()I", "readPosition", "k", "writePosition", "j", "g", "f", "capacity", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public class Buffer {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f9087a;
    public int b;
    public int c;
    public int d;
    public int e;
    public final int f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/core/Buffer$Companion;", "", "<init>", "()V", "Lio/ktor/utils/io/core/Buffer;", "a", "()Lio/ktor/utils/io/core/Buffer;", "Empty", "", "ReservedSize", "I", "ktor-io"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Buffer a() {
            return ChunkBuffer.j.a();
        }

        public Companion() {
        }
    }

    public /* synthetic */ Buffer(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    public final void a(int i) {
        int i2 = this.c + i;
        if (i < 0 || i2 > this.e) {
            BufferKt.a(i, g() - k());
            throw new KotlinNothingValueException();
        } else {
            this.c = i2;
        }
    }

    public final boolean b(int i) {
        int i2 = this.e;
        int i3 = this.c;
        if (i < i3) {
            BufferKt.a(i - i3, g() - k());
            throw new KotlinNothingValueException();
        } else if (i < i2) {
            this.c = i;
            return true;
        } else if (i == i2) {
            this.c = i;
            return false;
        } else {
            BufferKt.a(i - i3, g() - k());
            throw new KotlinNothingValueException();
        }
    }

    public final void c(int i) {
        if (i != 0) {
            int i2 = this.b + i;
            if (i < 0 || i2 > this.c) {
                BufferKt.b(i, k() - i());
                throw new KotlinNothingValueException();
            } else {
                this.b = i2;
            }
        }
    }

    public final void d(int i) {
        if (i < 0 || i > this.c) {
            BufferKt.b(i - this.b, k() - i());
            throw new KotlinNothingValueException();
        } else if (this.b != i) {
            this.b = i;
        }
    }

    public void e(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "copy");
        buffer.e = this.e;
        buffer.d = this.d;
        buffer.b = this.b;
        buffer.c = this.c;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.e;
    }

    public final ByteBuffer h() {
        return this.f9087a;
    }

    public final int i() {
        return this.b;
    }

    public final int j() {
        return this.d;
    }

    public final int k() {
        return this.c;
    }

    public final byte l() {
        int i = this.b;
        if (i != this.c) {
            this.b = i + 1;
            return this.f9087a.get(i);
        }
        throw new EOFException("No readable bytes available.");
    }

    public final void m() {
        this.e = this.f;
    }

    public final void n() {
        o(0);
        m();
    }

    public final void o(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(("newReadPosition shouldn't be negative: " + i).toString());
        } else if (i <= this.b) {
            this.b = i;
            if (this.d > i) {
                this.d = i;
            }
        } else {
            throw new IllegalArgumentException(("newReadPosition shouldn't be ahead of the read position: " + i + " > " + this.b).toString());
        }
    }

    public final void p(int i) {
        if (i >= 0) {
            int i2 = this.f - i;
            if (i2 >= this.c) {
                this.e = i2;
                return;
            }
            if (i2 < 0) {
                BufferKt.c(this, i);
            }
            if (i2 < this.d) {
                BufferKt.e(this, i);
            }
            if (this.b == this.c) {
                this.e = i2;
                this.b = i2;
                this.c = i2;
                return;
            }
            BufferKt.d(this, i);
            return;
        }
        throw new IllegalArgumentException(("endGap shouldn't be negative: " + i).toString());
    }

    public final void q(int i) {
        if (i >= 0) {
            int i2 = this.b;
            if (i2 >= i) {
                this.d = i;
            } else if (i2 != this.c) {
                BufferKt.g(this, i);
                throw new KotlinNothingValueException();
            } else if (i <= this.e) {
                this.c = i;
                this.b = i;
                this.d = i;
            } else {
                BufferKt.h(this, i);
                throw new KotlinNothingValueException();
            }
        } else {
            throw new IllegalArgumentException(("startGap shouldn't be negative: " + i).toString());
        }
    }

    public void r() {
        n();
        t();
    }

    public final void s() {
        this.d = 0;
        this.b = 0;
        this.c = this.f;
    }

    public final void t() {
        u(this.f - this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Buffer[0x");
        String num = Integer.toString(hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        sb.append("](");
        sb.append(k() - i());
        sb.append(" used, ");
        sb.append(g() - k());
        sb.append(" free, ");
        sb.append(this.d + (f() - g()));
        sb.append(" reserved of ");
        sb.append(this.f);
        sb.append(')');
        return sb.toString();
    }

    public final void u(int i) {
        int i2 = this.d;
        this.b = i2;
        this.c = i2;
        this.e = i;
    }

    public final void v(byte b2) {
        int i = this.c;
        if (i != this.e) {
            this.f9087a.put(i, b2);
            this.c = i + 1;
            return;
        }
        throw new InsufficientSpaceException("No free space in the buffer to write a byte");
    }

    public Buffer(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "memory");
        this.f9087a = byteBuffer;
        this.e = byteBuffer.limit();
        this.f = byteBuffer.limit();
    }
}
