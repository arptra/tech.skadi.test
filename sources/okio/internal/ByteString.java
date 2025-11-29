package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Base64;
import okio.Buffer;
import okio.SegmentedByteString;
import okio._JvmPlatformKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n+ 2 Util.kt\nokio/-SegmentedByteString\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utf8.kt\nokio/Utf8\n*L\n1#1,363:1\n131#1,2:369\n133#1,9:372\n68#2:364\n74#2:365\n74#2:367\n74#2:368\n68#2:396\n74#2:408\n1#3:366\n1#3:371\n212#4,7:381\n122#4:388\n219#4,5:389\n122#4:394\n226#4:395\n228#4:397\n397#4,2:398\n122#4:400\n400#4,6:401\n127#4:407\n406#4:409\n122#4:410\n407#4,13:411\n122#4:424\n422#4:425\n122#4:426\n425#4:427\n230#4,3:428\n440#4,3:431\n122#4:434\n443#4:435\n127#4:436\n446#4,10:437\n127#4:447\n456#4:448\n122#4:449\n457#4,4:450\n127#4:454\n461#4:455\n122#4:456\n462#4,14:457\n122#4:471\n477#4,2:472\n122#4:474\n481#4:475\n122#4:476\n484#4:477\n234#4,3:478\n500#4,3:481\n122#4:484\n503#4:485\n127#4:486\n506#4,2:487\n127#4:489\n510#4,10:490\n127#4:500\n520#4:501\n122#4:502\n521#4,4:503\n127#4:507\n525#4:508\n122#4:509\n526#4,4:510\n127#4:514\n530#4:515\n122#4:516\n531#4,15:517\n122#4:532\n547#4,2:533\n122#4:535\n550#4,2:536\n122#4:538\n554#4:539\n122#4:540\n557#4:541\n241#4:542\n122#4:543\n242#4,5:544\n*S KotlinDebug\n*F\n+ 1 ByteString.kt\nokio/internal/-ByteString\n*L\n329#1:369,2\n329#1:372,9\n67#1:364\n68#1:365\n258#1:367\n259#1:368\n348#1:396\n348#1:408\n329#1:371\n348#1:381,7\n353#1:388\n348#1:389,5\n353#1:394\n348#1:395\n348#1:397\n348#1:398,2\n353#1:400\n348#1:401,6\n348#1:407\n348#1:409\n353#1:410\n348#1:411,13\n353#1:424\n348#1:425\n353#1:426\n348#1:427\n348#1:428,3\n348#1:431,3\n353#1:434\n348#1:435\n348#1:436\n348#1:437,10\n348#1:447\n348#1:448\n353#1:449\n348#1:450,4\n348#1:454\n348#1:455\n353#1:456\n348#1:457,14\n353#1:471\n348#1:472,2\n353#1:474\n348#1:475\n353#1:476\n348#1:477\n348#1:478,3\n348#1:481,3\n353#1:484\n348#1:485\n348#1:486\n348#1:487,2\n348#1:489\n348#1:490,10\n348#1:500\n348#1:501\n353#1:502\n348#1:503,4\n348#1:507\n348#1:508\n353#1:509\n348#1:510,4\n348#1:514\n348#1:515\n353#1:516\n348#1:517,15\n353#1:532\n348#1:533,2\n353#1:535\n348#1:536,2\n353#1:538\n348#1:539\n353#1:540\n348#1:541\n348#1:542\n353#1:543\n348#1:544,5\n*E\n"})
@JvmName(name = "-ByteString")
/* renamed from: okio.internal.-ByteString  reason: invalid class name */
public final class ByteString {
    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            r3 = 1
            int r4 = r0.length
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x0009:
            if (r5 >= r4) goto L_0x01a6
            byte r8 = r0[r5]
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 160(0xa0, float:2.24E-43)
            r11 = 127(0x7f, float:1.78E-43)
            r12 = 32
            r13 = 13
            r14 = 10
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r8 < 0) goto L_0x0063
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x0025
            return r6
        L_0x0025:
            if (r8 == r14) goto L_0x0033
            if (r8 == r13) goto L_0x0033
            if (r8 < 0) goto L_0x002e
            if (r8 >= r12) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            if (r11 > r8) goto L_0x0033
            if (r8 >= r10) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            if (r8 != r9) goto L_0x0036
        L_0x0035:
            return r16
        L_0x0036:
            if (r8 >= r15) goto L_0x003a
            r7 = r3
            goto L_0x003b
        L_0x003a:
            r7 = 2
        L_0x003b:
            int r6 = r6 + r7
            int r5 = r5 + r3
        L_0x003d:
            r7 = r17
            if (r5 >= r4) goto L_0x0009
            byte r8 = r0[r5]
            if (r8 < 0) goto L_0x0009
            int r5 = r5 + r3
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x004b
            return r6
        L_0x004b:
            if (r8 == r14) goto L_0x0059
            if (r8 == r13) goto L_0x0059
            if (r8 < 0) goto L_0x0054
            if (r8 >= r12) goto L_0x0054
            goto L_0x005b
        L_0x0054:
            if (r11 > r8) goto L_0x0059
            if (r8 >= r10) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            if (r8 != r9) goto L_0x005c
        L_0x005b:
            return r16
        L_0x005c:
            if (r8 >= r15) goto L_0x0060
            r7 = r3
            goto L_0x0061
        L_0x0060:
            r7 = 2
        L_0x0061:
            int r6 = r6 + r7
            goto L_0x003d
        L_0x0063:
            int r2 = r8 >> 5
            r15 = -2
            r9 = 128(0x80, float:1.794E-43)
            if (r2 != r15) goto L_0x00af
            int r2 = r5 + 1
            if (r4 > r2) goto L_0x0072
            if (r7 != r1) goto L_0x0071
            return r6
        L_0x0071:
            return r16
        L_0x0072:
            byte r2 = r0[r2]
            r15 = r2 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00ab
            r2 = r2 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r2 = r2 ^ r8
            if (r2 >= r9) goto L_0x0083
            if (r7 != r1) goto L_0x0082
            return r6
        L_0x0082:
            return r16
        L_0x0083:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x0088
            return r6
        L_0x0088:
            if (r2 == r14) goto L_0x0096
            if (r2 == r13) goto L_0x0096
            if (r2 < 0) goto L_0x0091
            if (r2 >= r12) goto L_0x0091
            goto L_0x009b
        L_0x0091:
            if (r11 > r2) goto L_0x0096
            if (r2 >= r10) goto L_0x0096
            goto L_0x009b
        L_0x0096:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x009c
        L_0x009b:
            return r16
        L_0x009c:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x00a2
            r2 = r3
            goto L_0x00a3
        L_0x00a2:
            r2 = 2
        L_0x00a3:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r2 = 2
            int r5 = r5 + r2
        L_0x00a8:
            r7 = r8
            goto L_0x0009
        L_0x00ab:
            if (r7 != r1) goto L_0x00ae
            return r6
        L_0x00ae:
            return r16
        L_0x00af:
            r2 = 2
            int r10 = r8 >> 4
            r11 = 57344(0xe000, float:8.0356E-41)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r10 != r15) goto L_0x011e
            int r10 = r5 + 2
            if (r4 > r10) goto L_0x00c2
            if (r7 != r1) goto L_0x00c1
            return r6
        L_0x00c1:
            return r16
        L_0x00c2:
            int r2 = r5 + 1
            byte r2 = r0[r2]
            r15 = r2 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x011a
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x0116
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r10
            int r2 = r2 << 6
            r2 = r2 ^ r9
            int r8 = r8 << 12
            r2 = r2 ^ r8
            r8 = 2048(0x800, float:2.87E-42)
            if (r2 >= r8) goto L_0x00e2
            if (r7 != r1) goto L_0x00e1
            return r6
        L_0x00e1:
            return r16
        L_0x00e2:
            if (r12 > r2) goto L_0x00ea
            if (r2 >= r11) goto L_0x00ea
            if (r7 != r1) goto L_0x00e9
            return r6
        L_0x00e9:
            return r16
        L_0x00ea:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x00ef
            return r6
        L_0x00ef:
            if (r2 == r14) goto L_0x0103
            if (r2 == r13) goto L_0x0103
            if (r2 < 0) goto L_0x00fa
            r7 = 32
            if (r2 >= r7) goto L_0x00fa
            goto L_0x0108
        L_0x00fa:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 > r2) goto L_0x0103
            r7 = 160(0xa0, float:2.24E-43)
            if (r2 >= r7) goto L_0x0103
            goto L_0x0108
        L_0x0103:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x0109
        L_0x0108:
            return r16
        L_0x0109:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x010f
            r2 = r3
            goto L_0x0110
        L_0x010f:
            r2 = 2
        L_0x0110:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            int r5 = r5 + 3
            goto L_0x00a8
        L_0x0116:
            if (r7 != r1) goto L_0x0119
            return r6
        L_0x0119:
            return r16
        L_0x011a:
            if (r7 != r1) goto L_0x011d
            return r6
        L_0x011d:
            return r16
        L_0x011e:
            int r2 = r8 >> 3
            if (r2 != r15) goto L_0x01a2
            int r2 = r5 + 3
            if (r4 > r2) goto L_0x012a
            if (r7 != r1) goto L_0x0129
            return r6
        L_0x0129:
            return r16
        L_0x012a:
            int r10 = r5 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x019e
            r15 = 2
            int r17 = r5 + 2
            byte r15 = r0[r17]
            r13 = r15 & 192(0xc0, float:2.69E-43)
            if (r13 != r9) goto L_0x019a
            byte r2 = r0[r2]
            r13 = r2 & 192(0xc0, float:2.69E-43)
            if (r13 != r9) goto L_0x0196
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r2 = r2 ^ r9
            int r9 = r15 << 6
            r2 = r2 ^ r9
            int r9 = r10 << 12
            r2 = r2 ^ r9
            int r8 = r8 << 18
            r2 = r2 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r2 <= r8) goto L_0x0157
            if (r7 != r1) goto L_0x0156
            return r6
        L_0x0156:
            return r16
        L_0x0157:
            if (r12 > r2) goto L_0x015f
            if (r2 >= r11) goto L_0x015f
            if (r7 != r1) goto L_0x015e
            return r6
        L_0x015e:
            return r16
        L_0x015f:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r8) goto L_0x0167
            if (r7 != r1) goto L_0x0166
            return r6
        L_0x0166:
            return r16
        L_0x0167:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x016c
            return r6
        L_0x016c:
            if (r2 == r14) goto L_0x0182
            r7 = 13
            if (r2 == r7) goto L_0x0182
            if (r2 < 0) goto L_0x0179
            r7 = 32
            if (r2 >= r7) goto L_0x0179
            goto L_0x0187
        L_0x0179:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 > r2) goto L_0x0182
            r7 = 160(0xa0, float:2.24E-43)
            if (r2 >= r7) goto L_0x0182
            goto L_0x0187
        L_0x0182:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x0188
        L_0x0187:
            return r16
        L_0x0188:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x018e
            r2 = r3
            goto L_0x018f
        L_0x018e:
            r2 = 2
        L_0x018f:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            int r5 = r5 + 4
            goto L_0x00a8
        L_0x0196:
            if (r7 != r1) goto L_0x0199
            return r6
        L_0x0199:
            return r16
        L_0x019a:
            if (r7 != r1) goto L_0x019d
            return r6
        L_0x019d:
            return r16
        L_0x019e:
            if (r7 != r1) goto L_0x01a1
            return r6
        L_0x01a1:
            return r16
        L_0x01a2:
            if (r7 != r1) goto L_0x01a5
            return r6
        L_0x01a5:
            return r16
        L_0x01a6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteString.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return Base64.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull okio.ByteString byteString, @NotNull okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        for (int i = 0; i < min; i++) {
            byte b = byteString.getByte(i) & 255;
            byte b2 = byteString2.getByte(i) & 255;
            if (b != b2) {
                return b < b2 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public static final void commonCopyInto(@NotNull okio.ByteString byteString, int i, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "target");
        ArraysKt.copyInto(byteString.getData$okio(), bArr, i2, i, i3 + i);
    }

    @Nullable
    public static final okio.ByteString commonDecodeBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new okio.ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final okio.ByteString commonDecodeHex(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new okio.ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    @NotNull
    public static final okio.ByteString commonEncodeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        okio.ByteString byteString = new okio.ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull okio.ByteString byteString, @NotNull okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@NotNull okio.ByteString byteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof okio.ByteString) {
            okio.ByteString byteString2 = (okio.ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull okio.ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i = 0;
        for (byte b : byteString.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i += 2;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & 15];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final int commonIndexOf(@NotNull okio.ByteString byteString, @NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull okio.ByteString byteString, @NotNull okio.ByteString byteString2, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    @NotNull
    public static final okio.ByteString commonOf(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return new okio.ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull okio.ByteString byteString, int i, @NotNull okio.ByteString byteString2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonStartsWith(@NotNull okio.ByteString byteString, @NotNull okio.ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @NotNull
    public static final okio.ByteString commonSubstring(@NotNull okio.ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString, i2);
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        } else if (resolveDefaultParameter > byteString.getData$okio().length) {
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        } else if (resolveDefaultParameter - i >= 0) {
            return (i == 0 && resolveDefaultParameter == byteString.getData$okio().length) ? byteString : new okio.ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), i, resolveDefaultParameter));
        } else {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
    }

    @NotNull
    public static final okio.ByteString commonToAsciiLowercase(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b = byteString.getData$okio()[i];
            if (b < 65 || b > 90) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        copyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final okio.ByteString commonToAsciiUppercase(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b = byteString.getData$okio()[i];
            if (b < 97 || b > 122) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b2 = copyOf[i2];
                    if (b2 >= 97 && b2 <= 122) {
                        copyOf[i2] = (byte) (b2 - 32);
                    }
                }
                return new okio.ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final okio.ByteString commonToByteString(@NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i2);
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i, (long) resolveDefaultParameter);
        return new okio.ByteString(ArraysKt.copyOfRange(bArr, i, resolveDefaultParameter + i));
    }

    @NotNull
    public static final String commonToString(@NotNull okio.ByteString byteString) {
        okio.ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString.getData$okio().length + " text=" + replace$default + "…]";
            }
            return "[text=" + replace$default + ']';
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(byteString2, 64);
            if (resolveDefaultParameter > byteString.getData$okio().length) {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            } else if (resolveDefaultParameter >= 0) {
                if (resolveDefaultParameter != byteString.getData$okio().length) {
                    byteString2 = new okio.ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), 0, resolveDefaultParameter));
                }
                sb.append(byteString2.hex());
                sb.append("…]");
                return sb.toString();
            } else {
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
        }
    }

    @NotNull
    public static final String commonUtf8(@NotNull okio.ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull okio.ByteString byteString, @NotNull Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(@NotNull okio.ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@NotNull okio.ByteString byteString, @NotNull byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(byteString, i), byteString.getData$okio().length - bArr.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull okio.ByteString byteString, int i, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && SegmentedByteString.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final boolean commonStartsWith(@NotNull okio.ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
