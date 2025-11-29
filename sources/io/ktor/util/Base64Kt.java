package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Utf8;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0002\u001a\u0011\u0010\n\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u0006¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "f", "(Ljava/lang/String;)Ljava/lang/String;", "", "g", "([B)Ljava/lang/String;", "Lio/ktor/utils/io/core/ByteReadPacket;", "e", "(Lio/ktor/utils/io/core/ByteReadPacket;)Ljava/lang/String;", "d", "c", "(Ljava/lang/String;)[B", "Lio/ktor/utils/io/core/Input;", "b", "(Lio/ktor/utils/io/core/ByteReadPacket;)Lio/ktor/utils/io/core/Input;", "", "a", "[I", "BASE64_INVERSE_ALPHABET", "ktor-utils"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nio/ktor/util/Base64Kt\n+ 2 Builder.kt\nio/ktor/utils/io/core/BuilderKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 StringsJVM.kt\nio/ktor/utils/io/core/StringsJVMKt\n+ 5 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,112:1\n108#1:124\n108#1:125\n111#1:158\n12#2,11:113\n12#2,7:133\n19#2,4:144\n12#2,7:148\n19#2,4:160\n1#3:126\n10#4,6:127\n384#5,4:140\n13133#6,3:155\n13136#6:159\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nio/ktor/util/Base64Kt\n*L\n45#1:124\n61#1:125\n97#1:158\n23#1:113,11\n82#1:133,7\n82#1:144,4\n90#1:148,7\n90#1:160,4\n77#1:127,6\n83#1:140,4\n96#1:155,3\n96#1:159\n*E\n"})
public final class Base64Kt {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f9018a;

    static {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            iArr[i] = StringsKt.indexOf$default((CharSequence) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) i, 0, false, 6, (Object) null);
        }
        f9018a = iArr;
    }

    public static final Input b(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            byte[] bArr = new byte[4];
            while (byteReadPacket.r0() > 0) {
                int b = InputArraysKt.b(byteReadPacket, bArr, 0, 0, 6, (Object) null);
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < 4) {
                    i2 |= ((byte) (((byte) f9018a[bArr[i] & 255]) & Utf8.REPLACEMENT_BYTE)) << ((3 - i3) * 6);
                    i++;
                    i3++;
                }
                int i4 = 4 - b;
                int i5 = 2;
                if (i4 <= 2) {
                    while (true) {
                        bytePacketBuilder.i0((byte) ((i2 >> (i5 * 8)) & 255));
                        if (i5 == i4) {
                            break;
                        }
                        i5--;
                    }
                }
            }
            return bytePacketBuilder.F0();
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final byte[] c(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            int lastIndex = StringsKt.getLastIndex(str);
            while (true) {
                if (-1 < lastIndex) {
                    if (str.charAt(lastIndex) != '=') {
                        str2 = str.substring(0, lastIndex + 1);
                        Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                        break;
                    }
                    lastIndex--;
                } else {
                    str2 = "";
                    break;
                }
            }
            io.ktor.utils.io.core.StringsKt.m(bytePacketBuilder, str2, 0, 0, (Charset) null, 14, (Object) null);
            return io.ktor.utils.io.core.StringsKt.c(b(bytePacketBuilder.F0()));
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] c = c(str);
        return new String(c, 0, c.length, Charsets.UTF_8);
    }

    public static final String e(ByteReadPacket byteReadPacket) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        return g(io.ktor.utils.io.core.StringsKt.d(byteReadPacket, 0, 1, (Object) null));
    }

    public static final String f(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            io.ktor.utils.io.core.StringsKt.m(bytePacketBuilder, str, 0, 0, (Charset) null, 14, (Object) null);
            return e(bytePacketBuilder.F0());
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    public static final String g(byte[] bArr) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i3 = 3;
        char[] cArr = new char[(((bArr.length * 8) / 6) + 3)];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 3;
            if (i6 > bArr.length) {
                break;
            }
            byte b = (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
            int i7 = 3;
            while (-1 < i7) {
                cArr[i5] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((b >> (i7 * 6)) & 63);
                i7--;
                i5++;
            }
            i4 = i6;
        }
        int length = bArr.length - i4;
        if (length == 0) {
            return StringsKt.concatToString(cArr, 0, i5);
        }
        if (length == 1) {
            i = (bArr[i4] & 255) << 16;
        } else {
            i = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
        }
        int i8 = ((3 - length) * 8) / 6;
        if (i8 <= 3) {
            while (true) {
                i2 = i5 + 1;
                cArr[i5] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i >> (i3 * 6)) & 63);
                if (i3 == i8) {
                    break;
                }
                i3--;
                i5 = i2;
            }
            i5 = i2;
        }
        int i9 = 0;
        while (i9 < i8) {
            cArr[i5] = '=';
            i9++;
            i5++;
        }
        return StringsKt.concatToString(cArr, 0, i5);
    }
}
