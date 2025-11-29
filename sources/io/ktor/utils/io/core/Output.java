package io.ktor.utils.io.core;

import com.here.posclient.UpdateOptions;
import com.meizu.common.widget.CircularProgressButton;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b(\b'\u0018\u00002\u00060\u0001j\u0002`\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"J-\u0010\u0016\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010'J\u000f\u0010(\u001a\u00020\nH$¢\u0006\u0004\b(\u0010\fJ\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010\fJ\u0011\u0010*\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b*\u0010\u000eJ\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0006H\u0000¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b.\u0010-J\u0015\u0010/\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b/\u0010\u0018J\r\u00100\u001a\u00020\n¢\u0006\u0004\b0\u0010\fJ\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u00102J\u0019\u00104\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b4\u00105J)\u00108\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0016¢\u0006\u0004\b8\u00109J\u0015\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0004\b?\u0010-J\u001d\u0010A\u001a\u00020\n2\u0006\u0010@\u001a\u00020:2\u0006\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\bA\u0010BJ\u001d\u0010D\u001a\u00020\n2\u0006\u0010@\u001a\u00020:2\u0006\u0010\u0013\u001a\u00020C¢\u0006\u0004\bD\u0010EJ)\u0010J\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u0011¢\u0006\u0004\bJ\u0010KJ\r\u0010L\u001a\u00020\n¢\u0006\u0004\bL\u0010\fJ\u0017\u0010M\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011H\u0001¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\nH\u0001¢\u0006\u0004\bO\u0010\fJ\u000f\u0010P\u001a\u00020\nH\u0000¢\u0006\u0004\bP\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0004X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0018\u0010U\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010TR+\u0010\\\u001a\u00020#8\u0000@\u0000X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0012\n\u0004\b4\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010c\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010g\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bd\u0010^\u001a\u0004\be\u0010`\"\u0004\bf\u0010bR\u0016\u0010h\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u0010^R\u0016\u0010j\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010^R\u0014\u0010l\u001a\u00020\u00118DX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010`R\u0014\u0010\u000f\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u000e\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006n"}, d2 = {"Lio/ktor/utils/io/core/Output;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pool", "<init>", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "", "w", "()V", "r", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "newTail", "", "chainedSizeDelta", "n", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;I)V", "", "v", "p0", "(B)V", "", "c", "o", "(C)V", "tail", "foreignStolen", "A0", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "B0", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "Lio/ktor/utils/io/bits/Memory;", "source", "offset", "length", "(Ljava/nio/ByteBuffer;II)V", "u", "flush", "f0", "buffer", "s", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "j", "i0", "close", "value", "(C)Lio/ktor/utils/io/core/Output;", "", "d", "(Ljava/lang/CharSequence;)Lio/ktor/utils/io/core/Output;", "startIndex", "endIndex", "g", "(Ljava/lang/CharSequence;II)Lio/ktor/utils/io/core/Output;", "Lio/ktor/utils/io/core/ByteReadPacket;", "packet", "r0", "(Lio/ktor/utils/io/core/ByteReadPacket;)V", "chunkBuffer", "q0", "p", "y0", "(Lio/ktor/utils/io/core/ByteReadPacket;I)V", "", "z0", "(Lio/ktor/utils/io/core/ByteReadPacket;J)V", "", "csq", "start", "end", "i", "([CII)Ljava/lang/Appendable;", "release", "c0", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "b", "a", "Lio/ktor/utils/io/pool/ObjectPool;", "J", "()Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "_head", "_tail", "Ljava/nio/ByteBuffer;", "S", "()Ljava/nio/ByteBuffer;", "setTailMemory-3GNKZMM$ktor_io", "(Ljava/nio/ByteBuffer;)V", "tailMemory", "e", "I", "T", "()I", "d0", "(I)V", "tailPosition", "f", "N", "setTailEndExclusive$ktor_io", "tailEndExclusive", "tailInitialPosition", "h", "chainedSize", "U", "_size", "z", "ktor-io"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOutput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Output.kt\nio/ktor/utils/io/core/Output\n+ 2 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n+ 3 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Numbers.kt\nio/ktor/utils/io/core/internal/NumbersKt\n+ 6 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 7 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 8 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n+ 9 Input.kt\nio/ktor/utils/io/core/Input\n+ 10 PacketDirect.kt\nio/ktor/utils/io/core/PacketDirectKt\n*L\n1#1,576:1\n371#1,3:622\n374#1:653\n376#1,3:655\n55#1:708\n35#2,6:577\n41#2,3:584\n69#3:583\n69#3:588\n69#3:658\n69#3:659\n59#3:660\n74#3:661\n74#3:662\n59#3:663\n1#4:587\n1#4:654\n6#5,2:589\n99#6:591\n99#6:603\n99#6:634\n37#7,2:592\n37#7,2:597\n37#7,2:628\n319#8,3:594\n322#8,4:599\n326#8,18:604\n319#8,3:625\n322#8,4:630\n326#8,18:635\n77#9:664\n77#9:686\n8#10,21:665\n8#10,21:687\n*S KotlinDebug\n*F\n+ 1 Output.kt\nio/ktor/utils/io/core/Output\n*L\n176#1:622,3\n176#1:653\n176#1:655,3\n355#1:708\n65#1:577,6\n65#1:584,3\n66#1:583\n100#1:588\n237#1:658\n238#1:659\n242#1:660\n242#1:661\n260#1:662\n260#1:663\n176#1:654\n100#1:589,2\n137#1:591\n166#1:603\n177#1:634\n137#1:592,2\n166#1:597,2\n177#1:628,2\n166#1:594,3\n166#1:599,4\n166#1:604,18\n177#1:625,3\n177#1:630,4\n177#1:635,18\n308#1:664\n328#1:686\n313#1:665,21\n333#1:687,21\n*E\n"})
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public abstract class Output implements Appendable, Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final ObjectPool f9092a;
    public ChunkBuffer b;
    public ChunkBuffer c;
    public ByteBuffer d = Memory.b.a();
    public int e;
    public int f;
    public int g;
    public int h;

    public Output(ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.f9092a = objectPool;
    }

    public final void A0(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ObjectPool objectPool) {
        chunkBuffer.b(this.e);
        int k = chunkBuffer.k() - chunkBuffer.i();
        int k2 = chunkBuffer2.k() - chunkBuffer2.i();
        int a2 = PacketJVMKt.a();
        if (k2 >= a2 || k2 > (chunkBuffer.f() - chunkBuffer.g()) + (chunkBuffer.g() - chunkBuffer.k())) {
            k2 = -1;
        }
        if (k >= a2 || k > chunkBuffer2.j() || !ChunkBufferKt.a(chunkBuffer2)) {
            k = -1;
        }
        if (k2 == -1 && k == -1) {
            j(chunkBuffer2);
        } else if (k == -1 || k2 <= k) {
            BufferAppendKt.a(chunkBuffer, chunkBuffer2, (chunkBuffer.g() - chunkBuffer.k()) + (chunkBuffer.f() - chunkBuffer.g()));
            b();
            ChunkBuffer A = chunkBuffer2.A();
            if (A != null) {
                j(A);
            }
            chunkBuffer2.F(objectPool);
        } else if (k2 == -1 || k < k2) {
            B0(chunkBuffer2, chunkBuffer);
        } else {
            throw new IllegalStateException("prep = " + k + ", app = " + k2);
        }
    }

    public final void B0(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        BufferAppendKt.c(chunkBuffer, chunkBuffer2);
        ChunkBuffer chunkBuffer3 = this.b;
        if (chunkBuffer3 != null) {
            if (chunkBuffer3 == chunkBuffer2) {
                this.b = chunkBuffer;
            } else {
                while (true) {
                    ChunkBuffer C = chunkBuffer3.C();
                    Intrinsics.checkNotNull(C);
                    if (C == chunkBuffer2) {
                        break;
                    }
                    chunkBuffer3 = C;
                }
                chunkBuffer3.H(chunkBuffer);
            }
            chunkBuffer2.F(this.f9092a);
            this.c = BuffersKt.c(chunkBuffer);
            return;
        }
        throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
    }

    public final ObjectPool J() {
        return this.f9092a;
    }

    public final int N() {
        return this.f;
    }

    public final ByteBuffer S() {
        return this.d;
    }

    public final int T() {
        return this.e;
    }

    public final int U() {
        return this.h + (this.e - this.g);
    }

    public final void a() {
        ChunkBuffer z = z();
        if (z == ChunkBuffer.j.a()) {
            return;
        }
        if (z.C() == null) {
            z.t();
            z.p(8);
            int k = z.k();
            this.e = k;
            this.g = k;
            this.f = z.g();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void b() {
        ChunkBuffer chunkBuffer = this.c;
        if (chunkBuffer != null) {
            this.e = chunkBuffer.k();
        }
    }

    /* renamed from: c */
    public Output append(char c2) {
        int i = this.e;
        int i2 = 3;
        if (this.f - i >= 3) {
            ByteBuffer byteBuffer = this.d;
            if (c2 >= 0 && c2 < 128) {
                byteBuffer.put(i, (byte) c2);
                i2 = 1;
            } else if (128 <= c2 && c2 < 2048) {
                byteBuffer.put(i, (byte) (((c2 >> 6) & 31) | 192));
                byteBuffer.put(i + 1, (byte) ((c2 & '?') | 128));
                i2 = 2;
            } else if (2048 <= c2 && c2 < 0) {
                byteBuffer.put(i, (byte) (((c2 >> 12) & 15) | 224));
                byteBuffer.put(i + 1, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer.put(i + 2, (byte) ((c2 & '?') | 128));
            } else if (0 > c2 || c2 >= 0) {
                UTF8Kt.k(c2);
                throw new KotlinNothingValueException();
            } else {
                byteBuffer.put(i, (byte) (((c2 >> 18) & 7) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                byteBuffer.put(i + 1, (byte) (((c2 >> 12) & 63) | 128));
                byteBuffer.put(i + 2, (byte) (((c2 >> 6) & 63) | 128));
                byteBuffer.put(i + 3, (byte) ((c2 & '?') | 128));
                i2 = 4;
            }
            this.e = i + i2;
            return this;
        }
        o(c2);
        return this;
    }

    public final ChunkBuffer c0(int i) {
        ChunkBuffer chunkBuffer;
        if (N() - T() < i || (chunkBuffer = this.c) == null) {
            return r();
        }
        chunkBuffer.b(this.e);
        return chunkBuffer;
    }

    public final void close() {
        try {
            flush();
        } finally {
            u();
        }
    }

    /* renamed from: d */
    public Output append(CharSequence charSequence) {
        if (charSequence == null) {
            append("null", 0, 4);
        } else {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    public final void d0(int i) {
        this.e = i;
    }

    public final ChunkBuffer f0() {
        ChunkBuffer chunkBuffer = this.b;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this.c;
        if (chunkBuffer2 != null) {
            chunkBuffer2.b(this.e);
        }
        this.b = null;
        this.c = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.d = Memory.b.a();
        return chunkBuffer;
    }

    public final void flush() {
        w();
    }

    /* renamed from: g */
    public Output append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return append("null", i, i2);
        }
        StringsKt.k(this, charSequence, i, i2, Charsets.UTF_8);
        return this;
    }

    public final Appendable i(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "csq");
        StringsKt.l(this, cArr, i, i2, Charsets.UTF_8);
        return this;
    }

    public final void i0(byte b2) {
        int i = this.e;
        if (i < this.f) {
            this.e = i + 1;
            this.d.put(i, b2);
            return;
        }
        p0(b2);
    }

    public final void j(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        ChunkBuffer c2 = BuffersKt.c(chunkBuffer);
        long e2 = BuffersKt.e(chunkBuffer) - ((long) (c2.k() - c2.i()));
        if (e2 < UpdateOptions.SOURCE_ANY) {
            n(chunkBuffer, c2, (int) e2);
        } else {
            NumbersKt.a(e2, "total size increase");
            throw new KotlinNothingValueException();
        }
    }

    public final void n(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, int i) {
        ChunkBuffer chunkBuffer3 = this.c;
        if (chunkBuffer3 == null) {
            this.b = chunkBuffer;
            this.h = 0;
        } else {
            chunkBuffer3.H(chunkBuffer);
            int i2 = this.e;
            chunkBuffer3.b(i2);
            this.h += i2 - this.g;
        }
        this.c = chunkBuffer2;
        this.h += i;
        this.d = chunkBuffer2.h();
        this.e = chunkBuffer2.k();
        this.g = chunkBuffer2.i();
        this.f = chunkBuffer2.g();
    }

    public final void o(char c2) {
        int i = 3;
        ChunkBuffer c0 = c0(3);
        try {
            ByteBuffer h2 = c0.h();
            int k = c0.k();
            if (c2 >= 0 && c2 < 128) {
                h2.put(k, (byte) c2);
                i = 1;
            } else if (128 <= c2 && c2 < 2048) {
                h2.put(k, (byte) (((c2 >> 6) & 31) | 192));
                h2.put(k + 1, (byte) ((c2 & '?') | 128));
                i = 2;
            } else if (2048 <= c2 && c2 < 0) {
                h2.put(k, (byte) (((c2 >> 12) & 15) | 224));
                h2.put(k + 1, (byte) (((c2 >> 6) & 63) | 128));
                h2.put(k + 2, (byte) ((c2 & '?') | 128));
            } else if (0 > c2 || c2 >= 0) {
                UTF8Kt.k(c2);
                throw new KotlinNothingValueException();
            } else {
                h2.put(k, (byte) (((c2 >> 18) & 7) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                h2.put(k + 1, (byte) (((c2 >> 12) & 63) | 128));
                h2.put(k + 2, (byte) (((c2 >> 6) & 63) | 128));
                h2.put(k + 3, (byte) ((c2 & '?') | 128));
                i = 4;
            }
            c0.a(i);
            if (i >= 0) {
                b();
                return;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } catch (Throwable th) {
            b();
            throw th;
        }
    }

    public final void p0(byte b2) {
        r().v(b2);
        this.e++;
    }

    public final void q0(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chunkBuffer");
        ChunkBuffer chunkBuffer2 = this.c;
        if (chunkBuffer2 == null) {
            j(chunkBuffer);
        } else {
            A0(chunkBuffer2, chunkBuffer, this.f9092a);
        }
    }

    public final ChunkBuffer r() {
        ChunkBuffer chunkBuffer = (ChunkBuffer) this.f9092a.h0();
        chunkBuffer.p(8);
        s(chunkBuffer);
        return chunkBuffer;
    }

    public final void r0(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "packet");
        ChunkBuffer S0 = byteReadPacket.S0();
        if (S0 == null) {
            byteReadPacket.release();
            return;
        }
        ChunkBuffer chunkBuffer = this.c;
        if (chunkBuffer == null) {
            j(S0);
        } else {
            A0(chunkBuffer, S0, byteReadPacket.q0());
        }
    }

    public final void release() {
        close();
    }

    public final void s(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        if (chunkBuffer.C() == null) {
            n(chunkBuffer, chunkBuffer, 0);
            return;
        }
        throw new IllegalStateException("It should be a single buffer chunk.".toString());
    }

    public abstract void u();

    public abstract void v(ByteBuffer byteBuffer, int i, int i2);

    public final void w() {
        ChunkBuffer f0 = f0();
        if (f0 != null) {
            ChunkBuffer chunkBuffer = f0;
            do {
                try {
                    v(chunkBuffer.h(), chunkBuffer.i(), chunkBuffer.k() - chunkBuffer.i());
                    chunkBuffer = chunkBuffer.C();
                } finally {
                    BuffersKt.d(f0, this.f9092a);
                }
            } while (chunkBuffer != null);
        }
    }

    public final void y0(ByteReadPacket byteReadPacket, int i) {
        int i2;
        int k;
        Intrinsics.checkNotNullParameter(byteReadPacket, "p");
        while (i > 0) {
            int f0 = byteReadPacket.f0() - byteReadPacket.p0();
            if (f0 <= i) {
                i -= f0;
                ChunkBuffer R0 = byteReadPacket.R0();
                if (R0 != null) {
                    s(R0);
                } else {
                    throw new EOFException("Unexpected end of packet");
                }
            } else {
                ChunkBuffer D0 = byteReadPacket.D0(1);
                if (D0 != null) {
                    int i3 = D0.i();
                    try {
                        OutputKt.a(this, D0, i);
                        if (i2 < i3) {
                            throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                        } else if (i2 != k) {
                            byteReadPacket.O0(i2);
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        i2 = D0.i();
                        if (i2 >= i3) {
                            if (i2 == D0.k()) {
                                byteReadPacket.v(D0);
                            } else {
                                byteReadPacket.O0(i2);
                            }
                            throw th;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                } else {
                    StringsKt.a(1);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    public final ChunkBuffer z() {
        ChunkBuffer chunkBuffer = this.b;
        return chunkBuffer == null ? ChunkBuffer.j.a() : chunkBuffer;
    }

    public final void z0(ByteReadPacket byteReadPacket, long j) {
        int i;
        int k;
        Intrinsics.checkNotNullParameter(byteReadPacket, "p");
        while (j > 0) {
            long f0 = (long) (byteReadPacket.f0() - byteReadPacket.p0());
            if (f0 <= j) {
                j -= f0;
                ChunkBuffer R0 = byteReadPacket.R0();
                if (R0 != null) {
                    s(R0);
                } else {
                    throw new EOFException("Unexpected end of packet");
                }
            } else {
                ChunkBuffer D0 = byteReadPacket.D0(1);
                if (D0 != null) {
                    int i2 = D0.i();
                    try {
                        OutputKt.a(this, D0, (int) j);
                        if (i < i2) {
                            throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                        } else if (i != k) {
                            byteReadPacket.O0(i);
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        i = D0.i();
                        if (i >= i2) {
                            if (i == D0.k()) {
                                byteReadPacket.v(D0);
                            } else {
                                byteReadPacket.O0(i);
                            }
                            throw th;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                } else {
                    StringsKt.a(1);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }
}
