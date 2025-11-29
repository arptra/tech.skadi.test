package io.ktor.utils.io.core;

import com.here.posclient.UpdateOptions;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.EncodeResult;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0003*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u000b\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u0011\u001a\u00020\u0010*\u00020\u00062\f\b\u0002\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\b\b\u0002\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0014\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00012\f\b\u0002\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u001c\u001a\u00020\u001b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00012\f\b\u0002\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001f\u001a\u00020\u001b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u001e2\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00012\f\b\u0002\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0002\u001a\u00020\u001b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0002\u0010!\u001a\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0001H\u0001¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "", "n", "", "b", "(Lio/ktor/utils/io/core/ByteReadPacket;I)[B", "Lio/ktor/utils/io/core/Input;", "c", "(Lio/ktor/utils/io/core/Input;)[B", "min", "max", "e", "(Lio/ktor/utils/io/core/Input;II)[B", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "", "g", "(Lio/ktor/utils/io/core/Input;Ljava/nio/charset/Charset;I)Ljava/lang/String;", "bytesCount", "i", "(Lio/ktor/utils/io/core/Input;ILjava/nio/charset/Charset;)Ljava/lang/String;", "Lio/ktor/utils/io/core/Output;", "", "text", "fromIndex", "toIndex", "", "k", "(Lio/ktor/utils/io/core/Output;Ljava/lang/CharSequence;IILjava/nio/charset/Charset;)V", "", "l", "(Lio/ktor/utils/io/core/Output;[CIILjava/nio/charset/Charset;)V", "(Lio/ktor/utils/io/core/Output;Ljava/lang/CharSequence;II)V", "size", "", "a", "(I)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nio/ktor/utils/io/core/StringsKt\n+ 2 Packet.kt\nio/ktor/utils/io/core/PacketKt\n+ 3 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 4 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 5 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n+ 6 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 7 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 8 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 9 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 10 Buffers.kt\nio/ktor/utils/io/core/BuffersKt\n+ 11 Output.kt\nio/ktor/utils/io/core/OutputKt\n*L\n1#1,482:1\n358#1:640\n358#1:641\n39#2:483\n852#3,8:484\n862#3,3:493\n866#3,11:574\n877#3,15:586\n823#3,6:601\n829#3,13:627\n823#3,6:658\n829#3,13:686\n852#3,8:699\n862#3,3:708\n866#3,11:791\n877#3,15:803\n852#3,8:818\n862#3,3:827\n866#3,11:908\n877#3,15:920\n69#4:492\n59#4:585\n69#4:664\n69#4:685\n69#4:707\n69#4:711\n69#4:790\n59#4:802\n69#4:826\n59#4:919\n123#5,5:496\n128#5,2:506\n130#5,61:510\n193#5:573\n9#5:607\n10#5,2:613\n12#5,7:617\n21#5:626\n9#5:665\n10#5,2:671\n12#5,7:675\n21#5:684\n123#5,5:712\n128#5,2:722\n130#5,61:726\n193#5:789\n123#5,5:830\n128#5,2:840\n130#5,61:844\n193#5:907\n372#6,5:501\n377#6,2:571\n372#6,5:608\n377#6,2:624\n372#6,5:666\n377#6,2:682\n372#6,5:717\n377#6,2:787\n372#6,5:835\n377#6,2:905\n84#7:508\n84#7:615\n84#7:673\n84#7:724\n84#7:842\n26#8:509\n26#8:616\n26#8:674\n26#8:725\n26#8:843\n1#9:642\n98#10,2:643\n507#11,13:645\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nio/ktor/utils/io/core/StringsKt\n*L\n156#1:640\n158#1:641\n30#1:483\n57#1:484,8\n57#1:493,3\n57#1:574,11\n57#1:586,15\n125#1:601,6\n125#1:627,13\n365#1:658,6\n365#1:686,13\n405#1:699,8\n405#1:708,3\n405#1:791,11\n405#1:803,15\n445#1:818,8\n445#1:827,3\n445#1:908,11\n445#1:920,15\n57#1:492\n57#1:585\n366#1:664\n379#1:685\n405#1:707\n406#1:711\n420#1:790\n405#1:802\n445#1:826\n445#1:919\n59#1:496,5\n59#1:506,2\n59#1:510,61\n59#1:573\n126#1:607\n126#1:613,2\n126#1:617,7\n126#1:626\n368#1:665\n368#1:671,2\n368#1:675,7\n368#1:684\n408#1:712,5\n408#1:722,2\n408#1:726,61\n408#1:789\n446#1:830,5\n446#1:840,2\n446#1:844,61\n446#1:907\n59#1:501,5\n59#1:571,2\n126#1:608,5\n126#1:624,2\n368#1:666,5\n368#1:682,2\n408#1:717,5\n408#1:787,2\n446#1:835,5\n446#1:905,2\n59#1:508\n126#1:615\n368#1:673\n408#1:724\n446#1:842\n59#1:509\n126#1:616\n368#1:674\n408#1:725\n446#1:843\n170#1:643,2\n337#1:645,13\n*E\n"})
public final class StringsKt {
    public static final Void a(int i) {
        throw new EOFException("Premature end of stream: expected " + i + " bytes");
    }

    public static final byte[] b(ByteReadPacket byteReadPacket, int i) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        if (i == 0) {
            return UnsafeKt.f9096a;
        }
        byte[] bArr = new byte[i];
        InputArraysKt.e(byteReadPacket, bArr, 0, i);
        return bArr;
    }

    public static final byte[] c(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return f(input, 0, 0, 3, (Object) null);
    }

    public static /* synthetic */ byte[] d(ByteReadPacket byteReadPacket, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            long r0 = byteReadPacket.r0();
            if (r0 <= UpdateOptions.SOURCE_ANY) {
                i = (int) r0;
            } else {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
        }
        return b(byteReadPacket, i);
    }

    public static final byte[] e(Input input, int i, int i2) {
        int a2;
        Intrinsics.checkNotNullParameter(input, "<this>");
        if (i == i2 && i == 0) {
            return UnsafeKt.f9096a;
        }
        int i3 = 0;
        if (i == i2) {
            byte[] bArr = new byte[i];
            InputArraysKt.e(input, bArr, 0, i);
            return bArr;
        }
        byte[] bArr2 = new byte[((int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost((long) i2, EncodingKt.i(input)), (long) i))];
        while (i3 < i2 && (a2 = InputArraysKt.a(input, bArr2, i3, Math.min(i2, bArr2.length) - i3)) > 0) {
            i3 += a2;
            if (bArr2.length == i3) {
                bArr2 = Arrays.copyOf(bArr2, i3 * 2);
                Intrinsics.checkNotNullExpressionValue(bArr2, "copyOf(this, newSize)");
            }
        }
        if (i3 < i) {
            throw new EOFException("Not enough bytes available to read " + i + " bytes: " + (i - i3) + " more required");
        } else if (i3 == bArr2.length) {
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr2, i3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            return copyOf;
        }
    }

    public static /* synthetic */ byte[] f(Input input, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        return e(input, i, i2);
    }

    public static final String g(Input input, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return EncodingKt.a(newDecoder, input, i);
    }

    public static /* synthetic */ String h(Input input, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return g(input, charset, i);
    }

    public static final String i(Input input, int i, Charset charset) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        return CharsetJVMKt.b(newDecoder, input, i);
    }

    public static /* synthetic */ String j(Input input, int i, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        return i(input, i, charset);
    }

    public static final void k(Output output, CharSequence charSequence, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            n(output, charSequence, i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.h(newEncoder, output, charSequence, i, i2);
    }

    public static final void l(Output output, char[] cArr, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(output, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (charset == Charsets.UTF_8) {
            n(output, new CharArraySequence(cArr, 0, cArr.length), i, i2);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        EncodingKt.d(newEncoder, cArr, i, i2, output);
    }

    public static /* synthetic */ void m(Output output, CharSequence charSequence, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        k(output, charSequence, i, i2, charset);
    }

    public static final void n(Output output, CharSequence charSequence, int i, int i2) {
        ChunkBuffer d = UnsafeKt.d(output, 1, (ChunkBuffer) null);
        while (true) {
            try {
                int c = UTF8Kt.c(d.h(), charSequence, i, i2, d.k(), d.g());
                short a2 = EncodeResult.a(c);
                short b = EncodeResult.b(c);
                short s = a2 & UShort.MAX_VALUE;
                i += s;
                d.a(b & UShort.MAX_VALUE);
                int i3 = (s != 0 || i >= i2) ? i < i2 ? 1 : 0 : 8;
                if (i3 > 0) {
                    d = UnsafeKt.d(output, i3, d);
                } else {
                    return;
                }
            } finally {
                output.b();
            }
        }
    }
}
