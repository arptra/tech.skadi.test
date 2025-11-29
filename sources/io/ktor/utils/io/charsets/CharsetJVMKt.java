package io.ktor.utils.io.charsets;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.Input;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\b\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\n\u001a\u00020\u0007*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\t\u001a7\u0010\r\u001a\u00020\u0004*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u0010\u001a\u00020\u000f*\u00060\u0000j\u0002`\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0018\u001a\u00020\u0004*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u00142\n\u0010\f\u001a\u00060\u0015j\u0002`\u00162\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019\u001a%\u0010\u001c\u001a\u00020\u001b*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001d\u001a'\u0010\u001e\u001a\u00020\u001b*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001d\u001a'\u0010\u001f\u001a\u00020\u001b*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u001d\u001a\u0013\u0010\"\u001a\u00020!*\u00020 H\u0002¢\u0006\u0004\b\"\u0010#\"\u001c\u0010'\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010&\"\u0014\u0010*\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010)\"\u0019\u0010/\u001a\u00020\u001b*\u00060+j\u0002`,8F¢\u0006\u0006\u001a\u0004\b-\u0010.*\n\u00100\"\u00020+2\u00020+*\n\u00101\"\u00020\u00122\u00020\u0012*\n\u00102\"\u00020\u00002\u00020\u0000*\n\u00104\"\u0002032\u000203¨\u00065"}, d2 = {"Ljava/nio/charset/CharsetEncoder;", "Lio/ktor/utils/io/charsets/CharsetEncoder;", "", "input", "", "fromIndex", "toIndex", "", "g", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;II)[B", "h", "Lio/ktor/utils/io/core/Buffer;", "dst", "f", "(Ljava/nio/charset/CharsetEncoder;Ljava/lang/CharSequence;IILio/ktor/utils/io/core/Buffer;)I", "", "e", "(Ljava/nio/charset/CharsetEncoder;Lio/ktor/utils/io/core/Buffer;)Z", "Ljava/nio/charset/CharsetDecoder;", "Lio/ktor/utils/io/charsets/CharsetDecoder;", "Lio/ktor/utils/io/core/Input;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "max", "a", "(Ljava/nio/charset/CharsetDecoder;Lio/ktor/utils/io/core/Input;Ljava/lang/Appendable;I)I", "inputLength", "", "b", "(Ljava/nio/charset/CharsetDecoder;Lio/ktor/utils/io/core/Input;I)Ljava/lang/String;", "c", "d", "Ljava/nio/charset/CoderResult;", "", "j", "(Ljava/nio/charset/CoderResult;)V", "Ljava/nio/CharBuffer;", "kotlin.jvm.PlatformType", "Ljava/nio/CharBuffer;", "EmptyCharBuffer", "Ljava/nio/ByteBuffer;", "Ljava/nio/ByteBuffer;", "EmptyByteBuffer", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "i", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "name", "Charset", "CharsetDecoder", "CharsetEncoder", "Lkotlin/text/Charsets;", "Charsets", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCharsetJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharsetJVM.kt\nio/ktor/utils/io/charsets/CharsetJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferUtilsJvm.kt\nio/ktor/utils/io/core/BufferUtilsJvmKt\n+ 4 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 5 Buffer.kt\nio/ktor/utils/io/core/Buffer\n+ 6 UTF8.kt\nio/ktor/utils/io/core/internal/UTF8Kt\n+ 7 Memory.kt\nio/ktor/utils/io/bits/MemoryKt\n+ 8 MemoryJvm.kt\nio/ktor/utils/io/bits/Memory\n+ 9 Output.kt\nio/ktor/utils/io/core/OutputKt\n+ 10 BufferPrimitives.kt\nio/ktor/utils/io/core/BufferPrimitivesKt\n+ 11 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 12 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 13 Input.kt\nio/ktor/utils/io/core/Input\n+ 14 StringsJVM.kt\nio/ktor/utils/io/core/StringsJVMKt\n*L\n1#1,389:1\n1#2:390\n1#2:404\n1#2:411\n1#2:517\n1#2:548\n1#2:578\n1#2:595\n1#2:643\n1#2:701\n111#3,5:391\n116#3,3:401\n120#3:405\n44#3:408\n45#3:410\n46#3,7:412\n111#3,5:504\n116#3,3:514\n120#3:518\n111#3,5:535\n116#3,3:545\n120#3:549\n54#3,6:559\n111#3,5:565\n116#3,3:575\n120#3:579\n95#3,5:582\n100#3,3:592\n104#3:596\n95#3,5:630\n100#3,3:640\n104#3:644\n95#3,5:688\n100#3,3:698\n104#3:702\n390#4,5:396\n395#4,2:406\n372#4,5:424\n377#4,2:494\n390#4,5:509\n395#4,2:519\n390#4,5:540\n395#4,2:550\n390#4,5:570\n395#4,2:580\n372#4,5:587\n377#4,2:597\n372#4,5:635\n377#4,2:645\n372#4,5:693\n377#4,2:703\n74#5:409\n69#5:599\n69#5:626\n59#5:658\n69#5:684\n59#5:716\n123#6,5:419\n128#6,2:429\n130#6,61:433\n193#6:496\n84#7:431\n26#8:432\n506#9,7:497\n513#9,7:521\n506#9,7:528\n513#9,7:552\n256#10,7:600\n12#11,11:607\n852#12,8:618\n862#12,3:627\n866#12,11:647\n877#12,15:659\n852#12,8:676\n862#12,3:685\n866#12,11:705\n877#12,15:717\n77#13:674\n11#14:675\n*S KotlinDebug\n*F\n+ 1 CharsetJVM.kt\nio/ktor/utils/io/charsets/CharsetJVMKt\n*L\n52#1:404\n71#1:411\n99#1:517\n121#1:548\n141#1:578\n160#1:595\n231#1:643\n323#1:701\n52#1:391,5\n52#1:401,3\n52#1:405\n71#1:408\n71#1:410\n71#1:412,7\n99#1:504,5\n99#1:514,3\n99#1:518\n121#1:535,5\n121#1:545,3\n121#1:549\n71#1:559,6\n141#1:565,5\n141#1:575,3\n141#1:579\n160#1:582,5\n160#1:592,3\n160#1:596\n231#1:630,5\n231#1:640,3\n231#1:644\n323#1:688,5\n323#1:698,3\n323#1:702\n52#1:396,5\n52#1:406,2\n83#1:424,5\n83#1:494,2\n99#1:509,5\n99#1:519,2\n121#1:540,5\n121#1:550,2\n141#1:570,5\n141#1:580,2\n160#1:587,5\n160#1:597,2\n231#1:635,5\n231#1:645,2\n323#1:693,5\n323#1:703,2\n71#1:409\n199#1:599\n227#1:626\n227#1:658\n320#1:684\n320#1:716\n83#1:419,5\n83#1:429,2\n83#1:433,61\n83#1:496\n83#1:431\n83#1:432\n98#1:497,7\n98#1:521,7\n120#1:528,7\n120#1:552,7\n200#1:600,7\n204#1:607,11\n227#1:618,8\n227#1:627,3\n227#1:647,11\n227#1:659,15\n320#1:676,8\n320#1:685,3\n320#1:705,11\n320#1:717,15\n274#1:674\n282#1:675\n*E\n"})
public final class CharsetJVMKt {

    /* renamed from: a  reason: collision with root package name */
    public static final CharBuffer f9086a = CharBuffer.allocate(0);
    public static final ByteBuffer b;

    static {
        ByteBuffer allocate = ByteBuffer.allocate(0);
        Intrinsics.checkNotNull(allocate);
        b = allocate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int a(java.nio.charset.CharsetDecoder r11, io.ktor.utils.io.core.Input r12, java.lang.Appendable r13, int r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "dst"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 8192(0x2000, float:1.14794E-41)
            java.nio.CharBuffer r1 = java.nio.CharBuffer.allocate(r0)
            r2 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r3 = io.ktor.utils.io.core.internal.UnsafeKt.b(r12, r2)
            r4 = 0
            if (r3 != 0) goto L_0x001f
            goto L_0x00e0
        L_0x001f:
            r5 = r2
            r7 = r5
            r6 = r4
        L_0x0022:
            int r8 = r3.k()     // Catch:{ all -> 0x009a }
            int r9 = r3.i()     // Catch:{ all -> 0x009a }
            int r8 = r8 - r9
            if (r8 < r5) goto L_0x00b0
            int r5 = r14 - r6
            if (r5 != 0) goto L_0x0033
            r5 = r4
            goto L_0x0090
        L_0x0033:
            java.nio.ByteBuffer r8 = r3.h()     // Catch:{ all -> 0x004d }
            int r9 = r3.i()     // Catch:{ all -> 0x004d }
            int r10 = r3.k()     // Catch:{ all -> 0x004d }
            int r10 = r10 - r9
            java.nio.ByteBuffer r8 = io.ktor.utils.io.bits.Memory.h(r8, r9, r10)     // Catch:{ all -> 0x004d }
            r1.clear()     // Catch:{ all -> 0x004d }
            if (r5 >= r0) goto L_0x004f
            r1.limit(r5)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r11 = move-exception
            goto L_0x00a9
        L_0x004f:
            java.nio.charset.CoderResult r5 = r11.decode(r8, r1, r4)     // Catch:{ all -> 0x004d }
            r1.flip()     // Catch:{ all -> 0x004d }
            int r9 = r1.remaining()     // Catch:{ all -> 0x004d }
            int r6 = r6 + r9
            r13.append(r1)     // Catch:{ all -> 0x004d }
            boolean r9 = r5.isMalformed()     // Catch:{ all -> 0x004d }
            if (r9 != 0) goto L_0x006a
            boolean r9 = r5.isUnmappable()     // Catch:{ all -> 0x004d }
            if (r9 == 0) goto L_0x0072
        L_0x006a:
            java.lang.String r9 = "rc"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)     // Catch:{ all -> 0x004d }
            j(r5)     // Catch:{ all -> 0x004d }
        L_0x0072:
            boolean r5 = r5.isUnderflow()     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0081
            boolean r5 = r8.hasRemaining()     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x0081
            int r7 = r7 + 1
            goto L_0x0082
        L_0x0081:
            r7 = r2
        L_0x0082:
            int r5 = r8.limit()     // Catch:{ all -> 0x004d }
            if (r5 != r10) goto L_0x009d
            int r5 = r8.position()     // Catch:{ all -> 0x004d }
            r3.c(r5)     // Catch:{ all -> 0x004d }
            r5 = r7
        L_0x0090:
            int r8 = r3.k()     // Catch:{ all -> 0x009a }
            int r9 = r3.i()     // Catch:{ all -> 0x009a }
            int r8 = r8 - r9
            goto L_0x00b0
        L_0x009a:
            r11 = move-exception
            goto L_0x011b
        L_0x009d:
            java.lang.String r11 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004d }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x004d }
            r13.<init>(r11)     // Catch:{ all -> 0x004d }
            throw r13     // Catch:{ all -> 0x004d }
        L_0x00a9:
            r3.k()     // Catch:{ all -> 0x009a }
            r3.i()     // Catch:{ all -> 0x009a }
            throw r11     // Catch:{ all -> 0x009a }
        L_0x00b0:
            if (r8 != 0) goto L_0x00ba
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.c(r12, r3)     // Catch:{ all -> 0x00b7 }
            goto L_0x00d3
        L_0x00b7:
            r11 = move-exception
            r2 = r4
            goto L_0x011b
        L_0x00ba:
            if (r8 < r5) goto L_0x00cc
            int r8 = r3.f()     // Catch:{ all -> 0x00b7 }
            int r9 = r3.g()     // Catch:{ all -> 0x00b7 }
            int r8 = r8 - r9
            r9 = 8
            if (r8 >= r9) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r8 = r3
            goto L_0x00d3
        L_0x00cc:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r12, r3)     // Catch:{ all -> 0x00b7 }
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = io.ktor.utils.io.core.internal.UnsafeKt.b(r12, r5)     // Catch:{ all -> 0x00b7 }
        L_0x00d3:
            if (r8 != 0) goto L_0x00d6
            goto L_0x00da
        L_0x00d6:
            if (r5 > 0) goto L_0x0118
            r4 = r2
            r3 = r8
        L_0x00da:
            if (r4 == 0) goto L_0x00df
            io.ktor.utils.io.core.internal.UnsafeKt.a(r12, r3)
        L_0x00df:
            r4 = r6
        L_0x00e0:
            r1.clear()
            int r12 = r14 - r4
            if (r12 == 0) goto L_0x0117
            if (r12 >= r0) goto L_0x00ec
            r1.limit(r12)
        L_0x00ec:
            java.nio.ByteBuffer r12 = b
            java.nio.charset.CoderResult r12 = r11.decode(r12, r1, r2)
            r1.flip()
            int r3 = r1.remaining()
            int r4 = r4 + r3
            r13.append(r1)
            boolean r3 = r12.isUnmappable()
            if (r3 != 0) goto L_0x0109
            boolean r3 = r12.isMalformed()
            if (r3 == 0) goto L_0x0111
        L_0x0109:
            java.lang.String r3 = "cr"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            j(r12)
        L_0x0111:
            boolean r12 = r12.isOverflow()
            if (r12 != 0) goto L_0x00e0
        L_0x0117:
            return r4
        L_0x0118:
            r3 = r8
            goto L_0x0022
        L_0x011b:
            if (r2 == 0) goto L_0x0120
            io.ktor.utils.io.core.internal.UnsafeKt.a(r12, r3)
        L_0x0120:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.a(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, java.lang.Appendable, int):int");
    }

    public static final String b(CharsetDecoder charsetDecoder, Input input, int i) {
        Intrinsics.checkNotNullParameter(charsetDecoder, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        if (i == 0) {
            return "";
        }
        if (input.f0() - input.p0() < i) {
            return d(charsetDecoder, input, i);
        }
        if (!input.i0().hasArray()) {
            return c(charsetDecoder, input, i);
        }
        ByteBuffer i0 = input.i0();
        byte[] array = i0.array();
        Intrinsics.checkNotNullExpressionValue(array, "bb.array()");
        Charset charset = charsetDecoder.charset();
        Intrinsics.checkNotNullExpressionValue(charset, "charset()");
        String str = new String(array, i0.arrayOffset() + i0.position() + input.d0().i(), i, charset);
        input.s(i);
        return str;
    }

    public static final String c(CharsetDecoder charsetDecoder, Input input, int i) {
        CharBuffer allocate = CharBuffer.allocate(i);
        ByteBuffer h = Memory.h(input.i0(), input.d0().i(), i);
        CoderResult decode = charsetDecoder.decode(h, allocate, true);
        if (decode.isMalformed() || decode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(decode, "rc");
            j(decode);
        }
        allocate.flip();
        input.s(h.position());
        String charBuffer = allocate.toString();
        Intrinsics.checkNotNullExpressionValue(charBuffer, "cb.toString()");
        return charBuffer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String d(java.nio.charset.CharsetDecoder r17, io.ktor.utils.io.core.Input r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.nio.CharBuffer r3 = java.nio.CharBuffer.allocate(r19)
            r4 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r5 = io.ktor.utils.io.core.internal.UnsafeKt.b(r1, r4)
            java.lang.String r6 = "rc"
            r7 = 0
            if (r5 != 0) goto L_0x0017
            r9 = r2
            goto L_0x00eb
        L_0x0017:
            r9 = r2
            r8 = r4
            r11 = r8
            r10 = r7
        L_0x001b:
            int r12 = r5.k()     // Catch:{ all -> 0x00b0 }
            int r13 = r5.i()     // Catch:{ all -> 0x00b0 }
            int r12 = r12 - r13
            if (r12 < r8) goto L_0x00ba
            boolean r8 = r3.hasRemaining()     // Catch:{ all -> 0x0058 }
            if (r8 == 0) goto L_0x00a5
            if (r9 != 0) goto L_0x0030
            goto L_0x00a5
        L_0x0030:
            java.nio.ByteBuffer r8 = r5.h()     // Catch:{ all -> 0x0058 }
            int r10 = r5.i()     // Catch:{ all -> 0x0058 }
            int r12 = r5.k()     // Catch:{ all -> 0x0058 }
            int r12 = r12 - r10
            java.nio.ByteBuffer r8 = io.ktor.utils.io.bits.Memory.h(r8, r10, r12)     // Catch:{ all -> 0x0058 }
            int r10 = r8.limit()     // Catch:{ all -> 0x0058 }
            int r13 = r8.position()     // Catch:{ all -> 0x0058 }
            int r14 = r10 - r13
            if (r14 < r9) goto L_0x004f
            r14 = r4
            goto L_0x0050
        L_0x004f:
            r14 = r7
        L_0x0050:
            if (r14 == 0) goto L_0x005a
            int r15 = r13 + r9
            r8.limit(r15)     // Catch:{ all -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            r0 = move-exception
            goto L_0x00b3
        L_0x005a:
            java.nio.charset.CoderResult r15 = r0.decode(r8, r3, r14)     // Catch:{ all -> 0x0058 }
            boolean r16 = r15.isMalformed()     // Catch:{ all -> 0x0058 }
            if (r16 != 0) goto L_0x006a
            boolean r16 = r15.isUnmappable()     // Catch:{ all -> 0x0058 }
            if (r16 == 0) goto L_0x0070
        L_0x006a:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r6)     // Catch:{ all -> 0x0058 }
            j(r15)     // Catch:{ all -> 0x0058 }
        L_0x0070:
            boolean r15 = r15.isUnderflow()     // Catch:{ all -> 0x0058 }
            if (r15 == 0) goto L_0x007f
            boolean r15 = r8.hasRemaining()     // Catch:{ all -> 0x0058 }
            if (r15 == 0) goto L_0x007f
            int r11 = r11 + 1
            goto L_0x0080
        L_0x007f:
            r11 = r4
        L_0x0080:
            r8.limit(r10)     // Catch:{ all -> 0x0058 }
            int r10 = r8.position()     // Catch:{ all -> 0x0058 }
            int r10 = r10 - r13
            int r9 = r9 - r10
            int r10 = r8.limit()     // Catch:{ all -> 0x0058 }
            if (r10 != r12) goto L_0x0099
            int r8 = r8.position()     // Catch:{ all -> 0x0058 }
            r5.c(r8)     // Catch:{ all -> 0x0058 }
            r8 = r11
            r10 = r14
            goto L_0x00a6
        L_0x0099:
            java.lang.String r0 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0058 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0058 }
            r2.<init>(r0)     // Catch:{ all -> 0x0058 }
            throw r2     // Catch:{ all -> 0x0058 }
        L_0x00a5:
            r8 = r7
        L_0x00a6:
            int r12 = r5.k()     // Catch:{ all -> 0x00b0 }
            int r13 = r5.i()     // Catch:{ all -> 0x00b0 }
            int r12 = r12 - r13
            goto L_0x00ba
        L_0x00b0:
            r0 = move-exception
            goto L_0x0148
        L_0x00b3:
            r5.k()     // Catch:{ all -> 0x00b0 }
            r5.i()     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x00ba:
            if (r12 != 0) goto L_0x00c5
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = io.ktor.utils.io.core.internal.UnsafeKt.c(r1, r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x00de
        L_0x00c1:
            r0 = move-exception
            r4 = r7
            goto L_0x0148
        L_0x00c5:
            if (r12 < r8) goto L_0x00d7
            int r12 = r5.f()     // Catch:{ all -> 0x00c1 }
            int r13 = r5.g()     // Catch:{ all -> 0x00c1 }
            int r12 = r12 - r13
            r13 = 8
            if (r12 >= r13) goto L_0x00d5
            goto L_0x00d7
        L_0x00d5:
            r12 = r5
            goto L_0x00de
        L_0x00d7:
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)     // Catch:{ all -> 0x00c1 }
            io.ktor.utils.io.core.internal.ChunkBuffer r12 = io.ktor.utils.io.core.internal.UnsafeKt.b(r1, r8)     // Catch:{ all -> 0x00c1 }
        L_0x00de:
            if (r12 != 0) goto L_0x00e1
            goto L_0x00e5
        L_0x00e1:
            if (r8 > 0) goto L_0x0145
            r7 = r4
            r5 = r12
        L_0x00e5:
            if (r7 == 0) goto L_0x00ea
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)
        L_0x00ea:
            r7 = r10
        L_0x00eb:
            boolean r1 = r3.hasRemaining()
            if (r1 == 0) goto L_0x010b
            if (r7 != 0) goto L_0x010b
            java.nio.ByteBuffer r1 = b
            java.nio.charset.CoderResult r0 = r0.decode(r1, r3, r4)
            boolean r1 = r0.isMalformed()
            if (r1 != 0) goto L_0x0105
            boolean r1 = r0.isUnmappable()
            if (r1 == 0) goto L_0x010b
        L_0x0105:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            j(r0)
        L_0x010b:
            if (r9 > 0) goto L_0x0124
            if (r9 < 0) goto L_0x011c
            r3.flip()
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "cb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x011c:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.String r1 = "remainingInputBytes < 0"
            r0.<init>(r1)
            throw r0
        L_0x0124:
            java.io.EOFException r0 = new java.io.EOFException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Not enough bytes available: had only "
            r1.append(r3)
            int r3 = r2 - r9
            r1.append(r3)
            java.lang.String r3 = " instead of "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0145:
            r5 = r12
            goto L_0x001b
        L_0x0148:
            if (r4 == 0) goto L_0x014d
            io.ktor.utils.io.core.internal.UnsafeKt.a(r1, r5)
        L_0x014d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.CharsetJVMKt.d(java.nio.charset.CharsetDecoder, io.ktor.utils.io.core.Input, int):java.lang.String");
    }

    public static final boolean e(CharsetEncoder charsetEncoder, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        ByteBuffer h = buffer.h();
        int k = buffer.k();
        int g = buffer.g() - k;
        ByteBuffer h2 = Memory.h(h, k, g);
        CoderResult encode = charsetEncoder.encode(f9086a, h2, true);
        if (encode.isMalformed() || encode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(encode, "result");
            j(encode);
        }
        boolean isUnderflow = encode.isUnderflow();
        if (h2.limit() == g) {
            buffer.a(h2.position());
            return isUnderflow;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final int f(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2, Buffer buffer) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        Intrinsics.checkNotNullParameter(buffer, "dst");
        CharBuffer wrap = CharBuffer.wrap(charSequence, i, i2);
        int remaining = wrap.remaining();
        ByteBuffer h = buffer.h();
        int k = buffer.k();
        int g = buffer.g() - k;
        ByteBuffer h2 = Memory.h(h, k, g);
        CoderResult encode = charsetEncoder.encode(wrap, h2, false);
        if (encode.isMalformed() || encode.isUnmappable()) {
            Intrinsics.checkNotNullExpressionValue(encode, "result");
            j(encode);
        }
        if (h2.limit() == g) {
            buffer.a(h2.position());
            return remaining - wrap.remaining();
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final byte[] g(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charsetEncoder, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        if (!(charSequence instanceof String)) {
            return h(charsetEncoder, charSequence, i, i2);
        }
        if (i == 0 && i2 == charSequence.length()) {
            byte[] bytes = ((String) charSequence).getBytes(charsetEncoder.charset());
            Intrinsics.checkNotNullExpressionValue(bytes, "input as java.lang.String).getBytes(charset())");
            return bytes;
        }
        String substring = ((String) charSequence).substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes2 = substring.getBytes(charsetEncoder.charset());
        Intrinsics.checkNotNullExpressionValue(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
        return bytes2;
    }

    public static final byte[] h(CharsetEncoder charsetEncoder, CharSequence charSequence, int i, int i2) {
        ByteBuffer encode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i, i2));
        byte[] bArr = null;
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            byte[] array = encode.array();
            if (array.length == encode.remaining()) {
                bArr = array;
            }
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[encode.remaining()];
        encode.get(bArr2);
        return bArr2;
    }

    public static final String i(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "<this>");
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "name()");
        return name;
    }

    public static final void j(CoderResult coderResult) {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new MalformedInputException(message);
        }
    }
}
