package io.ktor.utils.io.charsets;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u000b\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\r\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\f\u001a+\u0010\u000e\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0012\u001a\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0017\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "numberOfChars", "requireBytes", "", "d", "(II)J", "Ljava/nio/ByteBuffer;", "", "out", "offset", "length", "a", "(Ljava/nio/ByteBuffer;[CII)J", "b", "c", "cp", "", "g", "(I)Z", "codePoint", "h", "i", "(I)I", "e", "arrayLength", "", "f", "(III)Ljava/lang/Throwable;", "value", "", "j", "(I)Ljava/lang/Void;", "", "k", "(B)Ljava/lang/Void;", "ktor-io"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nUTF.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UTF.kt\nio/ktor/utils/io/charsets/UTFKt\n*L\n1#1,544:1\n305#1,109:545\n426#1,97:654\n*S KotlinDebug\n*F\n+ 1 UTF.kt\nio/ktor/utils/io/charsets/UTFKt\n*L\n35#1:545,109\n78#1:654,97\n*E\n"})
public final class UTFKt {
    public static final long a(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        return byteBuffer.hasArray() ? b(byteBuffer, cArr, i, i2) : c(byteBuffer, cArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0197, code lost:
        r9 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a5, code lost:
        r0.position(r5 - r16.arrayOffset());
        r2 = d(r8 - r2, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long b(java.nio.ByteBuffer r16, char[] r17, int r18, int r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            byte[] r4 = r16.array()
            int r5 = r16.arrayOffset()
            int r6 = r16.position()
            int r5 = r5 + r6
            int r6 = r16.remaining()
            int r6 = r6 + r5
            java.lang.String r7 = "Failed requirement."
            if (r5 > r6) goto L_0x0238
            int r8 = r4.length
            if (r6 > r8) goto L_0x022e
            int r7 = r2 + r3
            int r8 = r1.length
            if (r7 > r8) goto L_0x0228
            r8 = r2
            r9 = 0
        L_0x0028:
            r10 = 13
            r11 = 2
            r12 = -1
            if (r5 >= r6) goto L_0x01d6
            if (r8 >= r7) goto L_0x01d6
            int r14 = r5 + 1
            byte r15 = r4[r5]
            r13 = 10
            if (r15 < 0) goto L_0x0064
            char r15 = (char) r15
            if (r15 != r10) goto L_0x003e
            r9 = 1
            r13 = 1
            goto L_0x004a
        L_0x003e:
            if (r15 != r13) goto L_0x0043
            r9 = 0
            r13 = 0
            goto L_0x004a
        L_0x0043:
            if (r9 == 0) goto L_0x0048
            r13 = r9
            r9 = 0
            goto L_0x004a
        L_0x0048:
            r13 = r9
            r9 = 1
        L_0x004a:
            if (r9 != 0) goto L_0x005c
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            long r2 = d(r8, r12)
        L_0x0059:
            r9 = r13
            goto L_0x01e4
        L_0x005c:
            int r5 = r8 + 1
            r1[r8] = r15
            r8 = r5
            r9 = r13
            r5 = r14
            goto L_0x0028
        L_0x0064:
            r3 = r15 & 224(0xe0, float:3.14E-43)
            r12 = 192(0xc0, float:2.69E-43)
            if (r3 != r12) goto L_0x00b3
            if (r14 < r6) goto L_0x007b
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            long r2 = d(r8, r11)
            goto L_0x01e4
        L_0x007b:
            int r3 = r5 + 2
            byte r12 = r4[r14]
            r14 = r15 & 31
            int r14 = r14 << 6
            r12 = r12 & 63
            r12 = r12 | r14
            char r12 = (char) r12
            if (r12 != r10) goto L_0x008c
            r9 = 1
            r13 = 1
            goto L_0x0098
        L_0x008c:
            if (r12 != r13) goto L_0x0091
            r9 = 0
            r13 = 0
            goto L_0x0098
        L_0x0091:
            if (r9 == 0) goto L_0x0096
            r13 = r9
            r9 = 0
            goto L_0x0098
        L_0x0096:
            r13 = r9
            r9 = 1
        L_0x0098:
            if (r9 != 0) goto L_0x00aa
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            r2 = -1
            long r3 = d(r8, r2)
            r2 = r3
            goto L_0x0059
        L_0x00aa:
            int r5 = r8 + 1
            r1[r8] = r12
            r8 = r5
            r9 = r13
            r5 = r3
            goto L_0x0028
        L_0x00b3:
            r3 = r15 & 240(0xf0, float:3.36E-43)
            r12 = 224(0xe0, float:3.14E-43)
            r13 = 3
            if (r3 != r12) goto L_0x0124
            int r3 = r6 - r14
            if (r3 >= r11) goto L_0x00cd
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            long r2 = d(r8, r13)
            goto L_0x01e4
        L_0x00cd:
            int r3 = r5 + 2
            byte r12 = r4[r14]
            int r13 = r5 + 3
            byte r3 = r4[r3]
            r14 = r15 & 15
            int r15 = r14 << 12
            r12 = r12 & 63
            int r12 = r12 << 6
            r12 = r12 | r15
            r3 = r3 & 63
            r3 = r3 | r12
            if (r14 == 0) goto L_0x00f3
            boolean r12 = g(r3)
            if (r12 == 0) goto L_0x00ea
            goto L_0x00f3
        L_0x00ea:
            j(r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00f3:
            char r3 = (char) r3
            if (r3 != r10) goto L_0x00f9
            r9 = 1
            r12 = 1
            goto L_0x0107
        L_0x00f9:
            r12 = 10
            if (r3 != r12) goto L_0x0100
            r9 = 0
            r12 = 0
            goto L_0x0107
        L_0x0100:
            if (r9 == 0) goto L_0x0105
            r12 = r9
            r9 = 0
            goto L_0x0107
        L_0x0105:
            r12 = r9
            r9 = 1
        L_0x0107:
            if (r9 != 0) goto L_0x011b
            r9 = -1
            int r5 = r5 + r9
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            long r2 = d(r8, r9)
            r9 = r12
            goto L_0x01e4
        L_0x011b:
            int r5 = r8 + 1
            r1[r8] = r3
            r8 = r5
            r9 = r12
            r5 = r13
            goto L_0x0028
        L_0x0124:
            r3 = r15 & 248(0xf8, float:3.48E-43)
            r12 = 240(0xf0, float:3.36E-43)
            if (r3 != r12) goto L_0x01cd
            int r3 = r6 - r14
            if (r3 >= r13) goto L_0x013e
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            r2 = 4
            long r2 = d(r8, r2)
            goto L_0x01e4
        L_0x013e:
            int r3 = r5 + 2
            byte r12 = r4[r14]
            int r13 = r5 + 3
            byte r3 = r4[r3]
            int r14 = r5 + 4
            byte r13 = r4[r13]
            r15 = r15 & 7
            int r15 = r15 << 18
            r12 = r12 & 63
            int r12 = r12 << 12
            r12 = r12 | r15
            r3 = r3 & 63
            int r3 = r3 << 6
            r3 = r3 | r12
            r12 = r13 & 63
            r3 = r3 | r12
            boolean r12 = h(r3)
            if (r12 == 0) goto L_0x01c4
            int r12 = r7 - r8
            if (r12 < r11) goto L_0x01b5
            int r12 = e(r3)
            char r12 = (char) r12
            int r3 = i(r3)
            char r3 = (char) r3
            if (r12 != r10) goto L_0x0176
            r9 = 1
            r13 = 10
            r15 = 1
            goto L_0x0184
        L_0x0176:
            r13 = 10
            if (r12 != r13) goto L_0x017d
            r9 = 0
            r15 = 0
            goto L_0x0184
        L_0x017d:
            if (r9 == 0) goto L_0x0182
            r15 = r9
            r9 = 0
            goto L_0x0184
        L_0x0182:
            r15 = r9
            r9 = 1
        L_0x0184:
            if (r9 == 0) goto L_0x0197
            if (r3 != r10) goto L_0x018b
            r9 = 1
            r15 = 1
            goto L_0x0195
        L_0x018b:
            if (r3 != r13) goto L_0x0190
            r9 = 0
            r15 = 0
            goto L_0x0195
        L_0x0190:
            if (r15 == 0) goto L_0x0194
            r9 = 0
            goto L_0x0195
        L_0x0194:
            r9 = 1
        L_0x0195:
            if (r9 != 0) goto L_0x0199
        L_0x0197:
            r9 = r15
            goto L_0x01a5
        L_0x0199:
            int r5 = r8 + 1
            r1[r8] = r12
            int r8 = r8 + 2
            r1[r5] = r3
            r5 = r14
            r9 = r15
            goto L_0x0028
        L_0x01a5:
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            r2 = -1
            long r3 = d(r8, r2)
            r2 = r3
            goto L_0x01e4
        L_0x01b5:
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            r2 = 0
            long r2 = d(r8, r2)
            goto L_0x01e4
        L_0x01c4:
            j(r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01cd:
            k(r15)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01d6:
            int r3 = r16.arrayOffset()
            int r5 = r5 - r3
            r0.position(r5)
            int r8 = r8 - r2
            r2 = 0
            long r2 = d(r8, r2)
        L_0x01e4:
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r2
            int r4 = (int) r4
            r5 = 32
            r6 = -1
            if (r4 != r6) goto L_0x0211
            long r4 = r2 >> r5
            int r4 = (int) r4
            if (r9 == 0) goto L_0x01fc
            r5 = 1
            int r4 = r4 - r5
            long r0 = d(r4, r6)
            return r0
        L_0x01fc:
            r5 = 1
            int r7 = r16.position()
            int r7 = r7 + r5
            r0.position(r7)
            if (r4 <= 0) goto L_0x0227
            int r4 = r4 - r5
            char r0 = r1[r4]
            if (r0 != r10) goto L_0x0227
            long r0 = d(r4, r6)
            return r0
        L_0x0211:
            if (r4 != 0) goto L_0x0227
            if (r9 == 0) goto L_0x0227
            long r1 = r2 >> r5
            int r1 = (int) r1
            int r2 = r16.position()
            r3 = 1
            int r2 = r2 - r3
            r0.position(r2)
            int r1 = r1 - r3
            long r0 = d(r1, r11)
            return r0
        L_0x0227:
            return r2
        L_0x0228:
            int r0 = r1.length
            java.lang.Throwable r0 = f(r2, r3, r0)
            throw r0
        L_0x022e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        L_0x0238:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r7.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.UTFKt.b(java.nio.ByteBuffer, char[], int, int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0082 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0036 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0177 A[EDGE_INSN: B:128:0x0177->B:90:0x0177 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x00ea A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0177 A[EDGE_INSN: B:130:0x0177->B:90:0x0177 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long c(java.nio.ByteBuffer r17, char[] r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            int r4 = r2 + r3
            int r5 = r1.length
            if (r4 > r5) goto L_0x01ea
            r3 = 0
            r5 = r2
            r6 = r3
        L_0x0010:
            boolean r7 = r17.hasRemaining()
            r8 = 2
            r9 = 13
            r10 = -1
            r11 = 1
            if (r7 == 0) goto L_0x01a5
            if (r5 >= r4) goto L_0x01a5
            byte r7 = r17.get()
            r12 = 10
            if (r7 < 0) goto L_0x004b
            char r7 = (char) r7
            if (r7 != r9) goto L_0x002b
            r6 = r11
        L_0x0029:
            r12 = r6
            goto L_0x0034
        L_0x002b:
            if (r7 != r12) goto L_0x002f
            r6 = r3
            goto L_0x0029
        L_0x002f:
            if (r6 == 0) goto L_0x0033
            r12 = r3
            goto L_0x0034
        L_0x0033:
            r12 = r11
        L_0x0034:
            if (r12 != 0) goto L_0x0045
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r10)
            goto L_0x01aa
        L_0x0045:
            int r8 = r5 + 1
            r1[r5] = r7
        L_0x0049:
            r5 = r8
            goto L_0x0010
        L_0x004b:
            r13 = r7 & 224(0xe0, float:3.14E-43)
            r14 = 192(0xc0, float:2.69E-43)
            if (r13 != r14) goto L_0x0096
            boolean r13 = r17.hasRemaining()
            if (r13 != 0) goto L_0x0066
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r8)
            goto L_0x01aa
        L_0x0066:
            byte r13 = r17.get()
            r7 = r7 & 31
            int r7 = r7 << 6
            r13 = r13 & 63
            r7 = r7 | r13
            char r7 = (char) r7
            if (r7 != r9) goto L_0x0077
            r6 = r11
        L_0x0075:
            r12 = r6
            goto L_0x0080
        L_0x0077:
            if (r7 != r12) goto L_0x007b
            r6 = r3
            goto L_0x0075
        L_0x007b:
            if (r6 == 0) goto L_0x007f
            r12 = r3
            goto L_0x0080
        L_0x007f:
            r12 = r11
        L_0x0080:
            if (r12 != 0) goto L_0x0091
            int r3 = r17.position()
            int r3 = r3 - r8
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r10)
            goto L_0x01aa
        L_0x0091:
            int r8 = r5 + 1
            r1[r5] = r7
            goto L_0x0049
        L_0x0096:
            r13 = r7 & 240(0xf0, float:3.36E-43)
            r14 = 224(0xe0, float:3.14E-43)
            r15 = 3
            if (r13 != r14) goto L_0x00ff
            int r13 = r17.remaining()
            if (r13 >= r8) goto L_0x00b2
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r15)
            goto L_0x01aa
        L_0x00b2:
            byte r13 = r17.get()
            byte r14 = r17.get()
            r7 = r7 & 15
            int r16 = r7 << 12
            r13 = r13 & 63
            int r13 = r13 << 6
            r13 = r16 | r13
            r14 = r14 & 63
            r13 = r13 | r14
            if (r7 == 0) goto L_0x00d9
            boolean r7 = g(r13)
            if (r7 == 0) goto L_0x00d0
            goto L_0x00d9
        L_0x00d0:
            j(r13)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00d9:
            char r7 = (char) r13
            if (r7 != r9) goto L_0x00df
            r6 = r11
        L_0x00dd:
            r12 = r6
            goto L_0x00e8
        L_0x00df:
            if (r7 != r12) goto L_0x00e3
            r6 = r3
            goto L_0x00dd
        L_0x00e3:
            if (r6 == 0) goto L_0x00e7
            r12 = r3
            goto L_0x00e8
        L_0x00e7:
            r12 = r11
        L_0x00e8:
            if (r12 != 0) goto L_0x00f9
            int r3 = r17.position()
            int r3 = r3 - r15
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r10)
            goto L_0x01aa
        L_0x00f9:
            int r8 = r5 + 1
            r1[r5] = r7
            goto L_0x0049
        L_0x00ff:
            r13 = r7 & 248(0xf8, float:3.48E-43)
            r14 = 240(0xf0, float:3.36E-43)
            if (r13 != r14) goto L_0x019c
            int r13 = r17.remaining()
            r14 = 4
            if (r13 >= r15) goto L_0x011b
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r14)
            goto L_0x01aa
        L_0x011b:
            byte r13 = r17.get()
            byte r15 = r17.get()
            byte r16 = r17.get()
            r7 = r7 & 7
            int r7 = r7 << 18
            r13 = r13 & 63
            int r13 = r13 << 12
            r7 = r7 | r13
            r13 = r15 & 63
            int r13 = r13 << 6
            r7 = r7 | r13
            r13 = r16 & 63
            r7 = r7 | r13
            boolean r13 = h(r7)
            if (r13 == 0) goto L_0x0193
            int r13 = r4 - r5
            if (r13 < r8) goto L_0x0185
            int r13 = e(r7)
            char r13 = (char) r13
            int r7 = i(r7)
            char r7 = (char) r7
            if (r13 != r9) goto L_0x0151
            r6 = r11
        L_0x014f:
            r15 = r6
            goto L_0x015a
        L_0x0151:
            if (r13 != r12) goto L_0x0155
            r6 = r3
            goto L_0x014f
        L_0x0155:
            if (r6 == 0) goto L_0x0159
            r15 = r3
            goto L_0x015a
        L_0x0159:
            r15 = r11
        L_0x015a:
            if (r15 == 0) goto L_0x0177
            if (r7 != r9) goto L_0x0161
            r6 = r11
        L_0x015f:
            r12 = r6
            goto L_0x016a
        L_0x0161:
            if (r7 != r12) goto L_0x0165
            r6 = r3
            goto L_0x015f
        L_0x0165:
            if (r6 == 0) goto L_0x0169
            r12 = r3
            goto L_0x016a
        L_0x0169:
            r12 = r11
        L_0x016a:
            if (r12 != 0) goto L_0x016d
            goto L_0x0177
        L_0x016d:
            int r8 = r5 + 1
            r1[r5] = r13
            int r5 = r5 + 2
            r1[r8] = r7
            goto L_0x0010
        L_0x0177:
            int r3 = r17.position()
            int r3 = r3 - r14
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = d(r5, r10)
            goto L_0x01aa
        L_0x0185:
            int r4 = r17.position()
            int r4 = r4 - r14
            r0.position(r4)
            int r5 = r5 - r2
            long r2 = d(r5, r3)
            goto L_0x01aa
        L_0x0193:
            j(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x019c:
            k(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01a5:
            int r5 = r5 - r2
            long r2 = d(r5, r3)
        L_0x01aa:
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r2
            int r4 = (int) r4
            r5 = 32
            if (r4 != r10) goto L_0x01d4
            long r4 = r2 >> r5
            int r4 = (int) r4
            if (r6 == 0) goto L_0x01c0
            int r4 = r4 - r11
            long r0 = d(r4, r10)
            return r0
        L_0x01c0:
            int r5 = r17.position()
            int r5 = r5 + r11
            r0.position(r5)
            if (r4 <= 0) goto L_0x01e9
            int r4 = r4 - r11
            char r0 = r1[r4]
            if (r0 != r9) goto L_0x01e9
            long r0 = d(r4, r10)
            return r0
        L_0x01d4:
            if (r4 != 0) goto L_0x01e9
            if (r6 == 0) goto L_0x01e9
            long r1 = r2 >> r5
            int r1 = (int) r1
            int r2 = r17.position()
            int r2 = r2 - r11
            r0.position(r2)
            int r1 = r1 - r11
            long r0 = d(r1, r8)
            return r0
        L_0x01e9:
            return r2
        L_0x01ea:
            int r0 = r1.length
            java.lang.Throwable r0 = f(r2, r3, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.UTFKt.c(java.nio.ByteBuffer, char[], int, int):long");
    }

    public static final long d(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    public static final int e(int i) {
        return (i >>> 10) + Utf8.HIGH_SURROGATE_HEADER;
    }

    public static final Throwable f(int i, int i2, int i3) {
        return new IndexOutOfBoundsException(i + " (offset) + " + i2 + " (length) > " + i3 + " (array.length)");
    }

    public static final boolean g(int i) {
        return (i >>> 16) == 0;
    }

    public static final boolean h(int i) {
        return i <= 1114111;
    }

    public static final int i(int i) {
        return (i & 1023) + 56320;
    }

    public static final Void j(int i) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(i) + " found");
    }

    public static final Void k(byte b) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported byte code, first byte is 0x");
        String num = Integer.toString(b & 255, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(StringsKt.padStart(num, 2, '0'));
        throw new IllegalStateException(sb.toString().toString());
    }
}
