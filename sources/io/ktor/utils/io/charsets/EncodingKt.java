package io.ktor.utils.io.charsets;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.CharArraySequence;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u001a1\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a5\u0010\u000e\u001a\u00020\r*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0015\u001a\u00020\u0014*\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u0018\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\u0012H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u001d\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a7\u0010 \u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "Lio/ktor/utils/io/core/ByteReadPacket;", "c", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)Lio/ktor/utils/io/core/ByteReadPacket;", "", "Lio/ktor/utils/io/core/Output;", "dst", "", "d", "(Ljava/nio/charset/CharsetEncoder;[CIILio/ktor/utils/io/core/Output;)V", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "Lio/ktor/utils/io/core/Input;", "max", "", "a", "(Ljava/nio/charset/CharsetDecoder;Lio/ktor/utils/io/core/Input;I)Ljava/lang/String;", "Lio/ktor/utils/io/core/Buffer;", "f", "(Ljava/nio/charset/CharsetEncoder;[CIILio/ktor/utils/io/core/Buffer;)I", "", "i", "(Lio/ktor/utils/io/core/Input;)J", "g", "(Ljava/nio/charset/CharsetEncoder;Lio/ktor/utils/io/core/Output;)I", "destination", "h", "(Ljava/nio/charset/CharsetEncoder;Lio/ktor/utils/io/core/Output;Ljava/lang/CharSequence;II)I", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEncoding.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Encoding.kt\nio/ktor/utils/io/charsets/EncodingKt\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 3 Output.kt\nio/ktor/utils/io/core/OutputKt\n+ 4 Buffer.kt\nio/ktor/utils/io/core/Buffer\n*L\n1#1,204:1\n12#2,11:205\n12#2,11:216\n507#3,13:227\n488#3,4:240\n492#3,6:246\n507#3,6:252\n513#3,7:260\n74#4:244\n74#4:245\n74#4:258\n74#4:259\n*S KotlinDebug\n*F\n+ 1 Encoding.kt\nio/ktor/utils/io/charsets/EncodingKt\n*L\n63#1:205,11\n67#1:216,11\n76#1:227,13\n161#1:240,4\n161#1:246,6\n187#1:252,6\n187#1:260,7\n162#1:244\n168#1:245\n188#1:258\n192#1:259\n*E\n"})
public final class EncodingKt {
    public static final String a(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        StringBuilder sb = new StringBuilder((int) Math.min((long) i, i(input)));
        CharsetJVMKt.a(charsetDecoder, input, sb, i);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String b(CharsetDecoder charsetDecoder, Input input, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return a(charsetDecoder, input, i);
    }

    public static final ByteReadPacket c(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            h(charsetEncoder, bytePacketBuilder, charSequence, i, i2);
            return bytePacketBuilder.F0();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static final void d(CharsetEncoder charsetEncoder, char[] cArr, int i, int i2, Output output) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "input");
        Intrinsics.checkNotNullParameter(output, "dst");
        if (i < i2) {
            ChunkBuffer d = UnsafeKt.d(output, 1, (ChunkBuffer) null);
            while (true) {
                try {
                    int f = f(charsetEncoder, cArr, i, i2, d);
                    if (f >= 0) {
                        i += f;
                        int i3 = i >= i2 ? 0 : f == 0 ? 8 : 1;
                        if (i3 > 0) {
                            d = UnsafeKt.d(output, i3, d);
                        } else {
                            output.b();
                            g(charsetEncoder, output);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } catch (Throwable th) {
                    output.b();
                    throw th;
                }
            }
        }
    }

    public static /* synthetic */ ByteReadPacket e(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = charSequence.length();
        }
        return c(charsetEncoder, charSequence, i, i2);
    }

    public static final int f(CharsetEncoder charsetEncoder, char[] cArr, int i, int i2, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "input");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        int i3 = i2 - i;
        return CharsetJVMKt.f(charsetEncoder, new CharArraySequence(cArr, i, i3), 0, i3, buffer);
    }

    public static final int g(CharsetEncoder charsetEncoder, Output output) {
        ChunkBuffer d = UnsafeKt.d(output, 1, (ChunkBuffer) null);
        int i = 1;
        int i2 = 0;
        while (true) {
            try {
                int g = d.g() - d.k();
                i = CharsetJVMKt.e(charsetEncoder, d) ? 0 : i + 1;
                i2 += g - (d.g() - d.k());
                if (i <= 0) {
                    return i2;
                }
                d = UnsafeKt.d(output, 1, d);
            } finally {
                output.b();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static final int h(CharsetEncoder charsetEncoder, Output output, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(output, RtspHeaders.Values.DESTINATION);
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (i >= i2) {
            return 0;
        }
        ChunkBuffer d = UnsafeKt.d(output, 1, (ChunkBuffer) null);
        int i3 = 0;
        while (true) {
            try {
                int g = d.g() - d.k();
                int f = CharsetJVMKt.f(charsetEncoder, charSequence, i, i2, d);
                if (f >= 0) {
                    i += f;
                    i3 += g - (d.g() - d.k());
                    int i4 = i >= i2 ? 0 : f == 0 ? 8 : 1;
                    if (i4 > 0) {
                        d = UnsafeKt.d(output, i4, d);
                    } else {
                        output.b();
                        return i3 + g(charsetEncoder, output);
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } catch (Throwable th) {
                output.b();
                throw th;
            }
        }
    }

    public static final long i(Input input) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        return input instanceof ByteReadPacket ? input.r0() : Math.max(input.r0(), 16);
    }
}
