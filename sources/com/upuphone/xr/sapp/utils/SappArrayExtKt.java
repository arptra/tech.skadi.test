package com.upuphone.xr.sapp.utils;

import android.util.Base64;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0014\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a!\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000f\u001a!\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u000f\u001a%\u0010\u0014\u001a\u00020\u0001*\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"", "", "g", "([F)[B", "i", "([B)[F", "", "e", "([B)Ljava/lang/String;", "a", "(Ljava/lang/String;)[B", "", "littleEndian", "", "j", "([BZ)I", "bytes", "l", "b", "size", "f", "(IIZ)[B", "value", "d", "(IZ)[B", "c", "app_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class SappArrayExtKt {
    public static final byte[] a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
        return decode;
    }

    public static final int b(byte[] bArr, boolean z) {
        byte b;
        int i;
        if (bArr.length != 4) {
            return 0;
        }
        if (z) {
            b = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
            i = (bArr[3] & 255) << 24;
        } else {
            b = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
            i = bArr[3] & 255;
        }
        return i | b;
    }

    public static final byte[] c(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
        }
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static final byte[] d(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
        }
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static final String e(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String encodeToString = Base64.encodeToString(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    public static final byte[] f(int i, int i2, boolean z) {
        return (i2 == 2 || i2 == 4) ? (i2 != 2 || -32768 > i || i > 32767) ? c(i, z) : d(i, z) : new byte[0];
    }

    public static final byte[] g(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ByteBuffer allocate = ByteBuffer.allocate(fArr.length * 4);
        for (float putFloat : fArr) {
            allocate.putFloat(putFloat);
        }
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, "array(...)");
        return array;
    }

    public static /* synthetic */ byte[] h(int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 2;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        return f(i, i2, z);
    }

    public static final float[] i(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length / 4;
        float[] fArr = new float[length];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (int i = 0; i < length; i++) {
            fArr[i] = wrap.getFloat();
        }
        return fArr;
    }

    public static final int j(byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length == 2 ? l(bArr, z) : b(bArr, z);
    }

    public static /* synthetic */ int k(byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return j(bArr, z);
    }

    public static final int l(byte[] bArr, boolean z) {
        int i;
        int i2;
        if (bArr.length != 2) {
            return 0;
        }
        if (z) {
            i = bArr[0] & 255;
            i2 = (bArr[1] & 255) << 8;
        } else {
            i = (bArr[0] & 255) << 8;
            i2 = bArr[1] & 255;
        }
        return i2 | i;
    }
}
