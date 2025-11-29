package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@SourceDebugExtension({"SMAP\nInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Input.kt\nio/ktor/utils/io/core/Input\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 4 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 5 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 6 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 7 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n+ 8 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 9 BufferPrimitives.kt\nio/ktor/utils/io/core/BufferPrimitivesKt\n*L\n1#1,932:1\n77#1:933\n77#1:935\n77#1:938\n77#1:940\n77#1:941\n77#1:943\n77#1:950\n77#1:1124\n1#2:934\n15#3:936\n26#3:947\n26#3:949\n26#3:968\n26#3:1017\n69#4:937\n69#4:939\n69#4:942\n69#4:944\n74#4:945\n74#4:951\n69#4:952\n69#4:1000\n59#4:1093\n69#4:1109\n69#4:1110\n69#4:1111\n69#4:1114\n69#4:1115\n59#4:1116\n69#4:1117\n69#4:1118\n59#4:1119\n69#4:1121\n74#4:1122\n69#4:1126\n69#4:1127\n69#4:1128\n84#5:946\n84#5:948\n84#5:967\n84#5:1016\n823#6,6:953\n829#6,13:979\n852#6,8:992\n862#6,3:1001\n866#6,11:1082\n877#6,15:1094\n9#7:959\n10#7,2:965\n12#7,7:969\n21#7:978\n123#7,5:1004\n128#7,2:1014\n130#7,61:1018\n193#7:1081\n372#8,5:960\n377#8,2:976\n372#8,5:1009\n377#8,2:1079\n355#8:1120\n355#8:1123\n355#8:1125\n261#9,2:1112\n*S KotlinDebug\n*F\n+ 1 Input.kt\nio/ktor/utils/io/core/Input\n*L\n25#1:933\n81#1:935\n150#1:938\n177#1:940\n187#1:941\n253#1:943\n330#1:950\n732#1:1124\n119#1:936\n286#1:947\n295#1:949\n439#1:968\n480#1:1017\n122#1:937\n159#1:939\n240#1:942\n262#1:944\n264#1:945\n342#1:951\n342#1:952\n479#1:1000\n479#1:1093\n505#1:1109\n524#1:1110\n537#1:1111\n542#1:1114\n567#1:1115\n568#1:1116\n582#1:1117\n596#1:1118\n597#1:1119\n648#1:1121\n664#1:1122\n757#1:1126\n768#1:1127\n776#1:1128\n286#1:946\n295#1:948\n439#1:967\n480#1:1016\n438#1:953,6\n438#1:979,13\n479#1:992,8\n479#1:1001,3\n479#1:1082,11\n479#1:1094,15\n439#1:959\n439#1:965,2\n439#1:969,7\n439#1:978\n480#1:1004,5\n480#1:1014,2\n480#1:1018,61\n480#1:1081\n439#1:960,5\n439#1:976,2\n480#1:1009,5\n480#1:1079,2\n646#1:1120\n669#1:1123\n748#1:1125\n539#1:1112,2\n*E\n"})
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b7\b'\u0018\u0000 \u00012\u00060\u0001j\u0002`\u0002:\u0002\u0001B+\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0014\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u0015J \u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0010¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020%2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0002¢\u0006\u0004\b*\u0010+J\"\u0010-\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0010¢\u0006\u0004\b-\u0010.J\u0011\u0010/\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020%2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u0010'J\"\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00103\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0010¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0011H\u0002¢\u0006\u0004\b6\u0010\u0018J\u0017\u00107\u001a\u00020%2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u0010'J-\u0010<\u001a\u00020\u00112\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0011H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020%H$¢\u0006\u0004\b>\u0010?J\r\u0010A\u001a\u00020@¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\u00020@2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020%¢\u0006\u0004\bE\u0010?J\u000f\u0010F\u001a\u00020%H\u0016¢\u0006\u0004\bF\u0010?J\u0011\u0010G\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\bG\u00100J\u0011\u0010H\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0004\bH\u00100J\u0017\u0010J\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0003H\u0000¢\u0006\u0004\bJ\u0010'J\u0017\u0010K\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0003H\u0000¢\u0006\u0004\bK\u0010LJ\r\u0010M\u001a\u00020\u000b¢\u0006\u0004\bM\u0010\rJ\u0015\u0010N\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\bN\u0010OJ\u0015\u0010P\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\bP\u0010QJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010RJ'\u0010V\u001a\u00020\u00112\u0006\u00109\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\u0011H\u0000¢\u0006\u0004\bV\u0010WJ-\u0010X\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\bX\u0010\u0015J!\u0010Z\u001a\u00020Y2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\bZ\u0010[J\u0019\u0010\\\u001a\u0004\u0018\u00010\u00032\u0006\u00103\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\\\u0010]J\u0019\u0010^\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0000¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H\u0001¢\u0006\u0004\b`\u0010_J\u0017\u0010a\u001a\u00020%2\u0006\u0010$\u001a\u00020\u0003H\u0000¢\u0006\u0004\ba\u0010'J\u0011\u0010b\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\bb\u00100J\u000f\u0010c\u001a\u00020%H\u0004¢\u0006\u0004\bc\u0010?J\u0019\u0010d\u001a\u0004\u0018\u00010\u00032\u0006\u00103\u001a\u00020\u0011H\u0001¢\u0006\u0004\bd\u0010]J\u0017\u0010e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\be\u0010_R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006¢\u0006\f\n\u0004\b7\u0010f\u001a\u0004\bg\u0010hR$\u0010l\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\u00038\u0002@BX\u000e¢\u0006\f\n\u0004\bJ\u0010j\"\u0004\bk\u0010'R1\u0010s\u001a\u0002088\u0000@\u0000X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0018\n\u0004\b2\u0010m\u0012\u0004\br\u0010?\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR(\u0010y\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\b\u0017\u0010t\u0012\u0004\bx\u0010?\u001a\u0004\bu\u0010v\"\u0004\bw\u0010QR(\u0010~\u001a\u00020\u00118\u0000@\u0000X\u000e¢\u0006\u0018\n\u0004\bz\u0010t\u0012\u0004\b}\u0010?\u001a\u0004\b{\u0010v\"\u0004\b|\u0010QR7\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u001a\u00020\u00058\u0000@@X\u000e¢\u0006\u001e\n\u0005\b\u0001\u0010b\u0012\u0005\b\u0001\u0010?\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bA\u0010\u0001R\u0013\u0010\u0001\u001a\u00020@8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010BR\u001c\u0010\u0004\u001a\u00020\u00038@X\u0004¢\u0006\u000e\u0012\u0005\b\u0001\u0010?\u001a\u0005\b\u0001\u00100R\u0013\u0010\u0006\u001a\u00020\u00058F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0001"}, d2 = {"Lio/ktor/utils/io/core/Input;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "", "remaining", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "<init>", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "", "I0", "()B", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "min", "max", "G0", "(Ljava/lang/Appendable;II)I", "", "d", "(I)Ljava/lang/Void;", "A0", "(II)Ljava/lang/Void;", "copied", "C0", "M0", "n", "skipped", "r", "(JJ)J", "o", "(II)I", "current", "", "T", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "size", "overrun", "U", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;II)V", "empty", "w", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "u", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "chunk", "c", "minSize", "F0", "(ILio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "B0", "a", "Lio/ktor/utils/io/bits/Memory;", "destination", "offset", "length", "N", "(Ljava/nio/ByteBuffer;II)I", "i", "()V", "", "g", "()Z", "y0", "(I)Z", "release", "close", "S0", "R0", "chain", "b", "T0", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)Z", "readByte", "j", "(I)I", "s", "(I)V", "(J)J", "", "off", "len", "H0", "([CII)I", "J0", "", "K0", "(II)Ljava/lang/String;", "E0", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "z", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "v", "S", "J", "z0", "D0", "N0", "Lio/ktor/utils/io/pool/ObjectPool;", "q0", "()Lio/ktor/utils/io/pool/ObjectPool;", "newHead", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Q0", "_head", "Ljava/nio/ByteBuffer;", "i0", "()Ljava/nio/ByteBuffer;", "setHeadMemory-3GNKZMM", "(Ljava/nio/ByteBuffer;)V", "getHeadMemory-SK3TCg8$annotations", "headMemory", "I", "p0", "()I", "O0", "getHeadPosition$annotations", "headPosition", "e", "f0", "setHeadEndExclusive", "getHeadEndExclusive$annotations", "headEndExclusive", "newValue", "f", "getTailRemaining", "()J", "P0", "(J)V", "getTailRemaining$annotations", "tailRemaining", "Z", "noMoreChunksAvailable", "c0", "endOfInput", "d0", "getHead$annotations", "r0", "h", "Companion", "ktor-io"}, k = 1, mv = {1, 8, 0})
@Deprecated(message = "\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")
public abstract class Input implements Closeable {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final ObjectPool f9090a;
    public ChunkBuffer b;
    public ByteBuffer c;
    public int d;
    public int e;
    public long f;
    public boolean g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/core/Input$Companion;", "", "()V", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public Input(ChunkBuffer chunkBuffer, long j, ObjectPool objectPool) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.f9090a = objectPool;
        this.b = chunkBuffer;
        this.c = chunkBuffer.h();
        this.d = chunkBuffer.i();
        int k = chunkBuffer.k();
        this.e = k;
        this.f = j - ((long) (k - this.d));
    }

    public static /* synthetic */ String L0(Input input, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = Integer.MAX_VALUE;
            }
            return input.K0(i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
    }

    public final Void A0(int i, int i2) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + i + ", max = " + i2);
    }

    public final Void B0(int i) {
        throw new IllegalStateException("minSize of " + i + " is too big (should be less than 8)");
    }

    public final Void C0(int i, int i2) {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + i + " chars but had only " + i2);
    }

    public final ChunkBuffer D0(int i) {
        ChunkBuffer d0 = d0();
        return this.e - this.d >= i ? d0 : F0(i, d0);
    }

    public final ChunkBuffer E0(int i) {
        return F0(i, d0());
    }

    public final ChunkBuffer F0(int i, ChunkBuffer chunkBuffer) {
        while (true) {
            int f0 = f0() - p0();
            if (f0 >= i) {
                return chunkBuffer;
            }
            ChunkBuffer C = chunkBuffer.C();
            if (C == null && (C = u()) == null) {
                return null;
            }
            if (f0 == 0) {
                if (chunkBuffer != ChunkBuffer.j.a()) {
                    N0(chunkBuffer);
                }
                chunkBuffer = C;
            } else {
                int a2 = BufferAppendKt.a(chunkBuffer, C, i - f0);
                this.e = chunkBuffer.k();
                P0(this.f - ((long) a2));
                if (C.k() > C.i()) {
                    C.q(a2);
                } else {
                    chunkBuffer.H((ChunkBuffer) null);
                    chunkBuffer.H(C.A());
                    C.F(this.f9090a);
                }
                if (chunkBuffer.k() - chunkBuffer.i() >= i) {
                    return chunkBuffer;
                }
                if (i > 8) {
                    B0(i);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int G0(java.lang.Appendable r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 0
            if (r15 != 0) goto L_0x0006
            if (r14 != 0) goto L_0x0006
            return r0
        L_0x0006:
            boolean r1 = r12.c0()
            if (r1 == 0) goto L_0x0018
            if (r14 != 0) goto L_0x000f
            return r0
        L_0x000f:
            r12.d(r14)
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException
            r12.<init>()
            throw r12
        L_0x0018:
            if (r15 < r14) goto L_0x0093
            r1 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = io.ktor.utils.io.core.internal.UnsafeKt.b(r12, r1)
            if (r2 != 0) goto L_0x0024
            r3 = r0
            goto L_0x0076
        L_0x0024:
            r3 = r0
            r4 = r3
        L_0x0026:
            java.nio.ByteBuffer r5 = r2.h()     // Catch:{ all -> 0x0051 }
            int r6 = r2.i()     // Catch:{ all -> 0x0051 }
            int r7 = r2.k()     // Catch:{ all -> 0x0051 }
            r8 = r6
        L_0x0033:
            if (r8 >= r7) goto L_0x005a
            byte r9 = r5.get(r8)     // Catch:{ all -> 0x0051 }
            r10 = r9 & 255(0xff, float:3.57E-43)
            r11 = 128(0x80, float:1.794E-43)
            r9 = r9 & r11
            if (r9 == r11) goto L_0x0054
            char r9 = (char) r10     // Catch:{ all -> 0x0051 }
            if (r3 != r15) goto L_0x0045
            r9 = r0
            goto L_0x004b
        L_0x0045:
            r13.append(r9)     // Catch:{ all -> 0x0051 }
            int r3 = r3 + 1
            r9 = r1
        L_0x004b:
            if (r9 != 0) goto L_0x004e
            goto L_0x0054
        L_0x004e:
            int r8 = r8 + 1
            goto L_0x0033
        L_0x0051:
            r13 = move-exception
            r0 = r1
            goto L_0x008d
        L_0x0054:
            int r8 = r8 - r6
            r2.c(r8)     // Catch:{ all -> 0x0051 }
            r5 = r0
            goto L_0x005f
        L_0x005a:
            int r7 = r7 - r6
            r2.c(r7)     // Catch:{ all -> 0x0051 }
            r5 = r1
        L_0x005f:
            if (r5 == 0) goto L_0x0063
            r5 = r1
            goto L_0x0069
        L_0x0063:
            if (r3 != r15) goto L_0x0067
            r5 = r0
            goto L_0x0069
        L_0x0067:
            r5 = r0
            r4 = r1
        L_0x0069:
            if (r5 != 0) goto L_0x006f
            io.ktor.utils.io.core.internal.UnsafeKt.a(r12, r2)
            goto L_0x0075
        L_0x006f:
            io.ktor.utils.io.core.internal.ChunkBuffer r2 = io.ktor.utils.io.core.internal.UnsafeKt.c(r12, r2)     // Catch:{ all -> 0x008c }
            if (r2 != 0) goto L_0x0026
        L_0x0075:
            r0 = r4
        L_0x0076:
            if (r0 == 0) goto L_0x0080
            int r14 = r14 - r3
            int r15 = r15 - r3
            int r12 = r12.M0(r13, r14, r15)
            int r3 = r3 + r12
            return r3
        L_0x0080:
            if (r3 < r14) goto L_0x0083
            return r3
        L_0x0083:
            r12.C0(r14, r3)
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException
            r12.<init>()
            throw r12
        L_0x008c:
            r13 = move-exception
        L_0x008d:
            if (r0 == 0) goto L_0x0092
            io.ktor.utils.io.core.internal.UnsafeKt.a(r12, r2)
        L_0x0092:
            throw r13
        L_0x0093:
            r12.A0(r14, r15)
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.G0(java.lang.Appendable, int, int):int");
    }

    public final int H0(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, RtspHeaders.Values.DESTINATION);
        if (c0()) {
            return -1;
        }
        return J0(new Input$readAvailableCharacters$out$1(i, cArr), 0, i2);
    }

    public final byte I0() {
        int i = this.d;
        if (i < this.e) {
            byte b2 = this.c.get(i);
            this.d = i;
            ChunkBuffer chunkBuffer = this.b;
            chunkBuffer.d(i);
            v(chunkBuffer);
            return b2;
        }
        ChunkBuffer D0 = D0(1);
        if (D0 != null) {
            byte l = D0.l();
            UnsafeKt.a(this, D0);
            return l;
        }
        StringsKt.a(1);
        throw new KotlinNothingValueException();
    }

    public ChunkBuffer J() {
        ChunkBuffer chunkBuffer = (ChunkBuffer) this.f9090a.h0();
        try {
            chunkBuffer.p(8);
            int N = N(chunkBuffer.h(), chunkBuffer.k(), chunkBuffer.g() - chunkBuffer.k());
            if (N == 0) {
                this.g = true;
                if (chunkBuffer.k() <= chunkBuffer.i()) {
                    chunkBuffer.F(this.f9090a);
                    return null;
                }
            }
            chunkBuffer.a(N);
            return chunkBuffer;
        } catch (Throwable th) {
            chunkBuffer.F(this.f9090a);
            throw th;
        }
    }

    public final int J0(Appendable appendable, int i, int i2) {
        Intrinsics.checkNotNullParameter(appendable, "out");
        if (((long) i2) < r0()) {
            return G0(appendable, i, i2);
        }
        String j = StringsKt.j(this, (int) r0(), (Charset) null, 2, (Object) null);
        appendable.append(j);
        return j.length();
    }

    public final String K0(int i, int i2) {
        if (i == 0 && (i2 == 0 || c0())) {
            return "";
        }
        long r0 = r0();
        if (r0 > 0 && ((long) i2) >= r0) {
            return StringsKt.j(this, (int) r0, (Charset) null, 2, (Object) null);
        }
        StringBuilder sb = new StringBuilder(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 16), i2));
        G0(sb, i, i2);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00da, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r5.c(((r11 - r9) - r14) + 1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int M0(java.lang.Appendable r18, int r19, int r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.b(r1, r4)
            if (r5 != 0) goto L_0x0012
            r6 = 0
            goto L_0x0146
        L_0x0012:
            r7 = r4
            r8 = 0
        L_0x0014:
            int r9 = r5.k()     // Catch:{ all -> 0x010d }
            int r10 = r5.i()     // Catch:{ all -> 0x010d }
            int r9 = r9 - r10
            if (r9 < r7) goto L_0x0116
            java.nio.ByteBuffer r7 = r5.h()     // Catch:{ all -> 0x00e2 }
            int r9 = r5.i()     // Catch:{ all -> 0x00e2 }
            int r10 = r5.k()     // Catch:{ all -> 0x00e2 }
            r11 = r9
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x002f:
            if (r11 >= r10) goto L_0x00f2
            byte r15 = r7.get(r11)     // Catch:{ all -> 0x00e2 }
            r6 = r15 & 255(0xff, float:3.57E-43)
            r4 = r15 & 128(0x80, float:1.794E-43)
            r16 = -1
            if (r4 != 0) goto L_0x0063
            if (r12 != 0) goto L_0x005a
            char r4 = (char) r6
            if (r8 != r3) goto L_0x0044
            r4 = 0
            goto L_0x004a
        L_0x0044:
            r0.append(r4)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            r4 = 1
        L_0x004a:
            if (r4 != 0) goto L_0x0057
            int r11 = r11 - r9
            r5.c(r11)     // Catch:{ all -> 0x0053 }
        L_0x0050:
            r4 = 1
            goto L_0x00f8
        L_0x0053:
            r0 = move-exception
            r4 = 1
            goto L_0x010f
        L_0x0057:
            r4 = 1
            goto L_0x00ee
        L_0x005a:
            io.ktor.utils.io.core.internal.UTF8Kt.j(r12)     // Catch:{ all -> 0x0053 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x0053 }
            r0.<init>()     // Catch:{ all -> 0x0053 }
            throw r0     // Catch:{ all -> 0x0053 }
        L_0x0063:
            if (r12 != 0) goto L_0x0089
            r4 = 128(0x80, float:1.794E-43)
            r13 = r6
            r6 = 1
        L_0x0069:
            r14 = 7
            if (r6 >= r14) goto L_0x0079
            r14 = r13 & r4
            if (r14 == 0) goto L_0x0079
            int r14 = ~r4     // Catch:{ all -> 0x0053 }
            r13 = r13 & r14
            int r4 = r4 >> 1
            int r12 = r12 + 1
            int r6 = r6 + 1
            goto L_0x0069
        L_0x0079:
            int r4 = r12 + -1
            int r6 = r10 - r11
            if (r12 <= r6) goto L_0x0086
            int r11 = r11 - r9
            r5.c(r11)     // Catch:{ all -> 0x0053 }
            r16 = r12
            goto L_0x0050
        L_0x0086:
            r14 = r12
            r12 = r4
            goto L_0x0057
        L_0x0089:
            int r4 = r13 << 6
            r6 = r15 & 127(0x7f, float:1.78E-43)
            r13 = r4 | r6
            int r12 = r12 + -1
            if (r12 != 0) goto L_0x0057
            boolean r4 = io.ktor.utils.io.core.internal.UTF8Kt.g(r13)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x00ae
            char r4 = (char) r13     // Catch:{ all -> 0x0053 }
            if (r8 != r3) goto L_0x009e
            r4 = 0
            goto L_0x00a4
        L_0x009e:
            r0.append(r4)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00a4:
            if (r4 != 0) goto L_0x00d7
            int r11 = r11 - r9
            int r11 = r11 - r14
            r4 = 1
            int r11 = r11 + r4
            r5.c(r11)     // Catch:{ all -> 0x0053 }
            goto L_0x0050
        L_0x00ae:
            boolean r4 = io.ktor.utils.io.core.internal.UTF8Kt.h(r13)     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x00e4
            int r4 = io.ktor.utils.io.core.internal.UTF8Kt.f(r13)     // Catch:{ all -> 0x0053 }
            char r4 = (char) r4     // Catch:{ all -> 0x0053 }
            if (r8 != r3) goto L_0x00bd
            r4 = 0
            goto L_0x00c3
        L_0x00bd:
            r0.append(r4)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00c3:
            if (r4 == 0) goto L_0x00da
            int r4 = io.ktor.utils.io.core.internal.UTF8Kt.i(r13)     // Catch:{ all -> 0x0053 }
            char r4 = (char) r4     // Catch:{ all -> 0x0053 }
            if (r8 != r3) goto L_0x00ce
            r4 = 0
            goto L_0x00d4
        L_0x00ce:
            r0.append(r4)     // Catch:{ all -> 0x0053 }
            int r8 = r8 + 1
            r4 = 1
        L_0x00d4:
            if (r4 != 0) goto L_0x00d7
            goto L_0x00da
        L_0x00d7:
            r4 = 1
            r13 = 0
            goto L_0x00ee
        L_0x00da:
            int r11 = r11 - r9
            int r11 = r11 - r14
            r4 = 1
            int r11 = r11 + r4
            r5.c(r11)     // Catch:{ all -> 0x00e2 }
            goto L_0x00f8
        L_0x00e2:
            r0 = move-exception
            goto L_0x010f
        L_0x00e4:
            r4 = 1
            io.ktor.utils.io.core.internal.UTF8Kt.k(r13)     // Catch:{ all -> 0x00e2 }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x00e2 }
            r0.<init>()     // Catch:{ all -> 0x00e2 }
            throw r0     // Catch:{ all -> 0x00e2 }
        L_0x00ee:
            int r11 = r11 + 1
            goto L_0x002f
        L_0x00f2:
            int r10 = r10 - r9
            r5.c(r10)     // Catch:{ all -> 0x00e2 }
            r16 = 0
        L_0x00f8:
            if (r16 != 0) goto L_0x00fc
            r7 = r4
            goto L_0x0102
        L_0x00fc:
            if (r16 <= 0) goto L_0x0101
            r7 = r16
            goto L_0x0102
        L_0x0101:
            r7 = 0
        L_0x0102:
            int r6 = r5.k()     // Catch:{ all -> 0x010d }
            int r9 = r5.i()     // Catch:{ all -> 0x010d }
            int r9 = r6 - r9
            goto L_0x0116
        L_0x010d:
            r0 = move-exception
            goto L_0x0152
        L_0x010f:
            r5.k()     // Catch:{ all -> 0x010d }
            r5.i()     // Catch:{ all -> 0x010d }
            throw r0     // Catch:{ all -> 0x010d }
        L_0x0116:
            if (r9 != 0) goto L_0x0120
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.c(r1, r5)     // Catch:{ all -> 0x011d }
            goto L_0x0139
        L_0x011d:
            r0 = move-exception
            r4 = 0
            goto L_0x0152
        L_0x0120:
            if (r9 < r7) goto L_0x0132
            int r6 = r5.f()     // Catch:{ all -> 0x011d }
            int r9 = r5.g()     // Catch:{ all -> 0x011d }
            int r6 = r6 - r9
            r9 = 8
            if (r6 >= r9) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r6 = r5
            goto L_0x0139
        L_0x0132:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)     // Catch:{ all -> 0x011d }
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = io.ktor.utils.io.core.internal.UnsafeKt.b(r1, r7)     // Catch:{ all -> 0x011d }
        L_0x0139:
            if (r6 != 0) goto L_0x013d
            r4 = 0
            goto L_0x0140
        L_0x013d:
            r5 = r6
            if (r7 > 0) goto L_0x0014
        L_0x0140:
            if (r4 == 0) goto L_0x0145
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)
        L_0x0145:
            r6 = r8
        L_0x0146:
            if (r6 < r2) goto L_0x0149
            return r6
        L_0x0149:
            r1.C0(r2, r6)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x0152:
            if (r4 == 0) goto L_0x0157
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)
        L_0x0157:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.M0(java.lang.Appendable, int, int):int");
    }

    public abstract int N(ByteBuffer byteBuffer, int i, int i2);

    public final ChunkBuffer N0(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        ChunkBuffer A = chunkBuffer.A();
        if (A == null) {
            A = ChunkBuffer.j.a();
        }
        Q0(A);
        P0(this.f - ((long) (A.k() - A.i())));
        chunkBuffer.F(this.f9090a);
        return A;
    }

    public final void O0(int i) {
        this.d = i;
    }

    public final void P0(long j) {
        if (j >= 0) {
            this.f = j;
            return;
        }
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j).toString());
    }

    public final void Q0(ChunkBuffer chunkBuffer) {
        this.b = chunkBuffer;
        this.c = chunkBuffer.h();
        this.d = chunkBuffer.i();
        this.e = chunkBuffer.k();
    }

    public final ChunkBuffer R0() {
        ChunkBuffer d0 = d0();
        ChunkBuffer C = d0.C();
        ChunkBuffer a2 = ChunkBuffer.j.a();
        if (d0 == a2) {
            return null;
        }
        if (C == null) {
            Q0(a2);
            P0(0);
        } else {
            Q0(C);
            P0(this.f - ((long) (C.k() - C.i())));
        }
        d0.H((ChunkBuffer) null);
        return d0;
    }

    public final void S(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        ChunkBuffer C = chunkBuffer.C();
        if (C == null) {
            T(chunkBuffer);
            return;
        }
        int k = chunkBuffer.k() - chunkBuffer.i();
        int min = Math.min(k, 8 - (chunkBuffer.f() - chunkBuffer.g()));
        if (C.j() < min) {
            T(chunkBuffer);
            return;
        }
        BufferKt.f(C, min);
        if (k > min) {
            chunkBuffer.m();
            this.e = chunkBuffer.k();
            P0(this.f + ((long) min));
            return;
        }
        Q0(C);
        P0(this.f - ((long) ((C.k() - C.i()) - min)));
        chunkBuffer.A();
        chunkBuffer.F(this.f9090a);
    }

    public final ChunkBuffer S0() {
        ChunkBuffer d0 = d0();
        ChunkBuffer a2 = ChunkBuffer.j.a();
        if (d0 == a2) {
            return null;
        }
        Q0(a2);
        P0(0);
        return d0;
    }

    public final void T(ChunkBuffer chunkBuffer) {
        if (!this.g || chunkBuffer.C() != null) {
            int k = chunkBuffer.k() - chunkBuffer.i();
            int min = Math.min(k, 8 - (chunkBuffer.f() - chunkBuffer.g()));
            if (k > min) {
                U(chunkBuffer, k, min);
            } else {
                ChunkBuffer chunkBuffer2 = (ChunkBuffer) this.f9090a.h0();
                chunkBuffer2.p(8);
                chunkBuffer2.H(chunkBuffer.A());
                BufferAppendKt.a(chunkBuffer2, chunkBuffer, k);
                Q0(chunkBuffer2);
            }
            chunkBuffer.F(this.f9090a);
            return;
        }
        this.d = chunkBuffer.i();
        this.e = chunkBuffer.k();
        P0(0);
    }

    public final boolean T0(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chain");
        ChunkBuffer c2 = BuffersKt.c(d0());
        int k = chunkBuffer.k() - chunkBuffer.i();
        if (k == 0 || c2.g() - c2.k() < k) {
            return false;
        }
        BufferAppendKt.a(c2, chunkBuffer, k);
        if (d0() == c2) {
            this.e = c2.k();
            return true;
        }
        P0(this.f + ((long) k));
        return true;
    }

    public final void U(ChunkBuffer chunkBuffer, int i, int i2) {
        ChunkBuffer chunkBuffer2 = (ChunkBuffer) this.f9090a.h0();
        ChunkBuffer chunkBuffer3 = (ChunkBuffer) this.f9090a.h0();
        chunkBuffer2.p(8);
        chunkBuffer3.p(8);
        chunkBuffer2.H(chunkBuffer3);
        chunkBuffer3.H(chunkBuffer.A());
        BufferAppendKt.a(chunkBuffer2, chunkBuffer, i - i2);
        BufferAppendKt.a(chunkBuffer3, chunkBuffer, i2);
        Q0(chunkBuffer2);
        P0(BuffersKt.e(chunkBuffer3));
    }

    public final void a(ChunkBuffer chunkBuffer) {
        if (chunkBuffer.k() - chunkBuffer.i() == 0) {
            N0(chunkBuffer);
        }
    }

    public final void b(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "chain");
        ChunkBuffer.Companion companion = ChunkBuffer.j;
        if (chunkBuffer != companion.a()) {
            long e2 = BuffersKt.e(chunkBuffer);
            if (this.b == companion.a()) {
                Q0(chunkBuffer);
                P0(e2 - ((long) (f0() - p0())));
                return;
            }
            BuffersKt.c(this.b).H(chunkBuffer);
            P0(this.f + e2);
        }
    }

    public final void c(ChunkBuffer chunkBuffer) {
        ChunkBuffer c2 = BuffersKt.c(this.b);
        if (c2 == ChunkBuffer.j.a()) {
            Q0(chunkBuffer);
            long j = 0;
            if (this.f == 0) {
                ChunkBuffer C = chunkBuffer.C();
                if (C != null) {
                    j = BuffersKt.e(C);
                }
                P0(j);
                return;
            }
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
        c2.H(chunkBuffer);
        P0(this.f + BuffersKt.e(chunkBuffer));
    }

    public final boolean c0() {
        return f0() - p0() == 0 && this.f == 0 && (this.g || u() == null);
    }

    public void close() {
        release();
        if (!this.g) {
            this.g = true;
        }
        i();
    }

    public final Void d(int i) {
        throw new EOFException("at least " + i + " characters required but no bytes available");
    }

    public final ChunkBuffer d0() {
        ChunkBuffer chunkBuffer = this.b;
        chunkBuffer.d(this.d);
        return chunkBuffer;
    }

    public final int f0() {
        return this.e;
    }

    public final boolean g() {
        return (this.d == this.e && this.f == 0) ? false : true;
    }

    public abstract void i();

    public final ByteBuffer i0() {
        return this.c;
    }

    public final int j(int i) {
        if (i >= 0) {
            return o(i, 0);
        }
        throw new IllegalArgumentException(("Negative discard is not allowed: " + i).toString());
    }

    public final long n(long j) {
        if (j <= 0) {
            return 0;
        }
        return r(j, 0);
    }

    public final int o(int i, int i2) {
        while (i != 0) {
            ChunkBuffer D0 = D0(1);
            if (D0 == null) {
                return i2;
            }
            int min = Math.min(D0.k() - D0.i(), i);
            D0.c(min);
            this.d += min;
            a(D0);
            i -= min;
            i2 += min;
        }
        return i2;
    }

    public final int p0() {
        return this.d;
    }

    public final ObjectPool q0() {
        return this.f9090a;
    }

    public final long r(long j, long j2) {
        ChunkBuffer D0;
        while (j != 0 && (D0 = D0(1)) != null) {
            int min = (int) Math.min((long) (D0.k() - D0.i()), j);
            D0.c(min);
            this.d += min;
            a(D0);
            long j3 = (long) min;
            j -= j3;
            j2 += j3;
        }
        return j2;
    }

    public final long r0() {
        return ((long) (f0() - p0())) + this.f;
    }

    public final byte readByte() {
        int i = this.d;
        int i2 = i + 1;
        if (i2 >= this.e) {
            return I0();
        }
        this.d = i2;
        return this.c.get(i);
    }

    public final void release() {
        ChunkBuffer d0 = d0();
        ChunkBuffer a2 = ChunkBuffer.j.a();
        if (d0 != a2) {
            Q0(a2);
            P0(0);
            BuffersKt.d(d0, this.f9090a);
        }
    }

    public final void s(int i) {
        if (j(i) != i) {
            throw new EOFException("Unable to discard " + i + " bytes due to end of packet");
        }
    }

    public final ChunkBuffer u() {
        if (this.g) {
            return null;
        }
        ChunkBuffer J = J();
        if (J == null) {
            this.g = true;
            return null;
        }
        c(J);
        return J;
    }

    public final ChunkBuffer v(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        return w(chunkBuffer, ChunkBuffer.j.a());
    }

    public final ChunkBuffer w(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        while (chunkBuffer != chunkBuffer2) {
            ChunkBuffer A = chunkBuffer.A();
            chunkBuffer.F(this.f9090a);
            if (A == null) {
                Q0(chunkBuffer2);
                P0(0);
                chunkBuffer = chunkBuffer2;
            } else if (A.k() > A.i()) {
                Q0(A);
                P0(this.f - ((long) (A.k() - A.i())));
                return A;
            } else {
                chunkBuffer = A;
            }
        }
        return u();
    }

    public final boolean y0(int i) {
        return ((long) (f0() - p0())) + this.f >= ((long) i);
    }

    public final ChunkBuffer z(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "current");
        return v(chunkBuffer);
    }

    public final void z0() {
        if (!this.g) {
            this.g = true;
        }
    }
}
