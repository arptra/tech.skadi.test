package io.ktor.http;

import io.ktor.utils.io.charsets.EncodingKt;
import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000X\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\u001a3\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u000f\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a=\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00012\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u0018\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0015\u001a?\u0010\u001b\u001a\u00020\u0000*\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u001e\u001a\u00020\u0000*\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#\u001a\u0017\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010&\u001a'\u0010+\u001a\u00020)*\u00020'2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020)0(H\u0002¢\u0006\u0004\b+\u0010,\"\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/\"\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020 0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/\"\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020 0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010/\"\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107\"\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020 0-8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010/\" \u0010<\u001a\b\u0012\u0004\u0012\u00020 0-8\u0000X\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b:\u0010;\"\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u00107¨\u0006>"}, d2 = {"", "", "encodeFull", "spaceToPlus", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "charset", "q", "(Ljava/lang/String;ZZLjava/nio/charset/Charset;)Ljava/lang/String;", "p", "(Ljava/lang/String;)Ljava/lang/String;", "encodeSlash", "o", "(Ljava/lang/String;Z)Ljava/lang/String;", "l", "n", "", "start", "end", "plusIsSpace", "j", "(Ljava/lang/String;IIZLjava/nio/charset/Charset;)Ljava/lang/String;", "h", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Ljava/lang/String;", "g", "", "prefixEnd", "f", "(Ljava/lang/CharSequence;IIIZLjava/nio/charset/Charset;)Ljava/lang/String;", "", "u", "(B)Ljava/lang/String;", "", "c2", "e", "(C)I", "digit", "t", "(I)C", "Lio/ktor/utils/io/core/ByteReadPacket;", "Lkotlin/Function1;", "", "block", "s", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/jvm/functions/Function1;)V", "", "a", "Ljava/util/Set;", "URL_ALPHABET", "b", "URL_ALPHABET_CHARS", "c", "HEX_ALPHABET", "", "d", "Ljava/util/List;", "URL_PROTOCOL_PART", "VALID_PATH_PART", "getATTRIBUTE_CHARACTERS", "()Ljava/util/Set;", "ATTRIBUTE_CHARACTERS", "SPECIAL_SYMBOLS", "ktor-http"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCodecs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Codecs.kt\nio/ktor/http/CodecsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 Strings.kt\nio/ktor/utils/io/core/StringsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 StringsJVM.kt\nio/ktor/utils/io/core/StringsJVMKt\n+ 6 Input.kt\nio/ktor/utils/io/core/InputKt\n+ 7 Buffer.kt\nio/ktor/utils/io/core/BufferKt\n+ 8 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,296:1\n1099#2,3:297\n8#3,3:300\n13586#4,2:303\n11#5:305\n823#6,6:306\n829#6,13:313\n355#7:312\n1549#8:326\n1620#8,3:327\n1549#8:330\n1620#8,3:331\n1549#8:334\n1620#8,3:335\n*S KotlinDebug\n*F\n+ 1 Codecs.kt\nio/ktor/http/CodecsKt\n*L\n130#1:297,3\n133#1:300,3\n141#1:303,2\n250#1:305\n289#1:306,6\n289#1:313,13\n290#1:312\n9#1:326\n9#1:327,3\n20#1:330\n20#1:331,3\n42#1:334\n42#1:335,3\n*E\n"})
public final class CodecsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Set f8940a;
    public static final Set b = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9')));
    public static final Set c = CollectionsKt.toSet(CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'f'), new CharRange('A', 'F')), new CharRange('0', '9')));
    public static final List d;
    public static final Set e = SetsKt.setOf(':', '@', '!', '$', Character.valueOf(Typography.amp), '\'', '(', ')', '*', '+', Character.valueOf(StringUtil.COMMA), ';', '=', Character.valueOf(Soundex.SILENT_MARKER), '.', '_', '~');
    public static final Set f = SetsKt.plus(b, SetsKt.setOf('!', '#', '$', Character.valueOf(Typography.amp), '+', Character.valueOf(Soundex.SILENT_MARKER), '.', '^', '_', '`', '|', '~'));
    public static final List g;

    static {
        List<Character> plus = CollectionsKt.plus(CollectionsKt.plus(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9'));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Character charValue : plus) {
            arrayList.add(Byte.valueOf((byte) charValue.charValue()));
        }
        f8940a = CollectionsKt.toSet(arrayList);
        Set<Character> of = SetsKt.setOf(':', '/', '?', '#', '[', ']', '@', '!', '$', Character.valueOf(Typography.amp), '\'', '(', ')', '*', Character.valueOf(StringUtil.COMMA), ';', '=', Character.valueOf(Soundex.SILENT_MARKER), '.', '_', '~', '+');
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        for (Character charValue2 : of) {
            arrayList2.add(Byte.valueOf((byte) charValue2.charValue()));
        }
        d = arrayList2;
        List<Character> listOf = CollectionsKt.listOf(Character.valueOf(Soundex.SILENT_MARKER), '.', '_', '~');
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Character charValue3 : listOf) {
            arrayList3.add(Byte.valueOf((byte) charValue3.charValue()));
        }
        g = arrayList3;
    }

    public static final int e(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - '7';
        }
        if ('a' > c2 || c2 >= 'g') {
            return -1;
        }
        return c2 - 'W';
    }

    public static final String f(CharSequence charSequence, int i, int i2, int i3, boolean z, Charset charset) {
        int i4 = i2 - i;
        if (i4 > 255) {
            i4 /= 3;
        }
        StringBuilder sb = new StringBuilder(i4);
        if (i3 > i) {
            sb.append(charSequence, i, i3);
        }
        byte[] bArr = null;
        while (i3 < i2) {
            char charAt = charSequence.charAt(i3);
            if (z && charAt == '+') {
                sb.append(' ');
            } else if (charAt == '%') {
                if (bArr == null) {
                    bArr = new byte[((i2 - i3) / 3)];
                }
                int i5 = 0;
                while (i3 < i2 && charSequence.charAt(i3) == '%') {
                    int i6 = i3 + 2;
                    if (i6 < i2) {
                        int i7 = i3 + 1;
                        int e2 = e(charSequence.charAt(i7));
                        int e3 = e(charSequence.charAt(i6));
                        if (e2 == -1 || e3 == -1) {
                            throw new URLDecodeException("Wrong HEX escape: %" + charSequence.charAt(i7) + charSequence.charAt(i6) + ", in " + charSequence + ", at " + i3);
                        }
                        bArr[i5] = (byte) ((e2 * 16) + e3);
                        i3 += 3;
                        i5++;
                    } else {
                        throw new URLDecodeException("Incomplete trailing HEX escape: " + charSequence.subSequence(i3, charSequence.length()).toString() + ", in " + charSequence + " at " + i3);
                    }
                }
                sb.append(new String(bArr, 0, i5, charset));
            } else {
                sb.append(charAt);
            }
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public static final String g(String str, int i, int i2, boolean z, Charset charset) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (z && charAt == '+')) {
                return f(str, i, i2, i3, z, charset);
            }
        }
        if (i == 0 && i2 == str.length()) {
            return str;
        }
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String h(String str, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return g(str, i, i2, false, charset);
    }

    public static /* synthetic */ String i(String str, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return h(str, i, i2, charset);
    }

    public static final String j(String str, int i, int i2, boolean z, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return g(str, i, i2, z, charset);
    }

    public static /* synthetic */ String k(String str, int i, int i2, boolean z, Charset charset, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            charset = Charsets.UTF_8;
        }
        return j(str, i, i2, z, charset);
    }

    public static final String l(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "UTF_8.newEncoder()");
        s(EncodingKt.e(newEncoder, str, 0, 0, 6, (Object) null), new CodecsKt$encodeURLParameter$1$1(sb, z));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String m(String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return l(str, z);
    }

    public static final String n(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return l(str, true);
    }

    public static final String o(String str, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        Charset charset = Charsets.UTF_8;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if ((z || charAt != '/') && !b.contains(Character.valueOf(charAt)) && !e.contains(Character.valueOf(charAt))) {
                if (charAt == '%' && (i = i2 + 2) < str.length()) {
                    Set set = c;
                    int i3 = i2 + 1;
                    if (set.contains(Character.valueOf(str.charAt(i3))) && set.contains(Character.valueOf(str.charAt(i)))) {
                        sb.append(charAt);
                        sb.append(str.charAt(i3));
                        sb.append(str.charAt(i));
                        i2 += 3;
                    }
                }
                int i4 = CharsKt.isSurrogate(charAt) ? 2 : 1;
                CharsetEncoder newEncoder = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                int i5 = i4 + i2;
                s(EncodingKt.c(newEncoder, str, i2, i5), new CodecsKt$encodeURLPath$1$1(sb));
                i2 = i5;
            } else {
                sb.append(charAt);
                i2++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String p(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return o(str, true);
    }

    public static final String q(String str, boolean z, boolean z2, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        StringBuilder sb = new StringBuilder();
        CharsetEncoder newEncoder = charset.newEncoder();
        Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
        s(EncodingKt.e(newEncoder, str, 0, 0, 6, (Object) null), new CodecsKt$encodeURLQueryComponent$1$1(z2, sb, z));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String r(String str, boolean z, boolean z2, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            charset = Charsets.UTF_8;
        }
        return q(str, z, z2, charset);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void s(io.ktor.utils.io.core.ByteReadPacket r4, kotlin.jvm.functions.Function1 r5) {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.b(r4, r0)
            if (r1 != 0) goto L_0x0008
            goto L_0x0026
        L_0x0008:
            int r2 = r1.k()     // Catch:{ all -> 0x001e }
            int r3 = r1.i()     // Catch:{ all -> 0x001e }
            if (r2 <= r3) goto L_0x0020
            byte r2 = r1.l()     // Catch:{ all -> 0x001e }
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)     // Catch:{ all -> 0x001e }
            r5.invoke(r2)     // Catch:{ all -> 0x001e }
            goto L_0x0008
        L_0x001e:
            r5 = move-exception
            goto L_0x0029
        L_0x0020:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.c(r4, r1)     // Catch:{ all -> 0x0027 }
            if (r1 != 0) goto L_0x0008
        L_0x0026:
            return
        L_0x0027:
            r5 = move-exception
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L_0x002e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt.s(io.ktor.utils.io.core.ByteReadPacket, kotlin.jvm.functions.Function1):void");
    }

    public static final char t(int i) {
        return (char) ((i < 0 || i >= 10) ? ((char) (i + 65)) - 10 : i + 48);
    }

    public static final String u(byte b2) {
        return StringsKt.concatToString(new char[]{'%', t((b2 & 255) >> 4), t(b2 & 15)});
    }
}
