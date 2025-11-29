package com.upuphone.ar.translation.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\n\"\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"", "", "b", "([B)Ljava/lang/String;", "", "littleEndian", "", "d", "([BZ)[S", "c", "([B)[S", "a", "", "[C", "HEX_DIGITS", "ar-translator_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ByteArrayExtKt {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f6206a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final short[] a(byte[] bArr) {
        int length = bArr.length;
        int length2 = bArr.length / 2;
        short[] sArr = new short[length2];
        for (int i = 0; i < length2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
        }
        return sArr;
    }

    public static final String b(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = f6206a;
            sb.append(cArr[(b & 240) >>> 4]);
            sb.append(cArr[b & 15]);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final short[] c(byte[] bArr) {
        int length = bArr.length;
        int length2 = bArr.length / 2;
        short[] sArr = new short[length2];
        for (int i = 0; i < length2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) (((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255));
        }
        return sArr;
    }

    public static final short[] d(byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return z ? c(bArr) : a(bArr);
    }

    public static /* synthetic */ short[] e(byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return d(bArr, z);
    }
}
