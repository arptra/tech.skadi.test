package com.upuphone.ar.transcribe.ext;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\t\"\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f¨\u0006\u000e"}, d2 = {"", "size", "", "littleEndian", "", "c", "(IIZ)[B", "value", "b", "(IZ)[B", "a", "", "[C", "HEX_DIGITS", "ar-transcribe_intlRelease"}, k = 2, mv = {1, 9, 0})
public final class ByteArrayExtKt {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f6065a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final byte[] a(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
        }
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static final byte[] b(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
        }
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static final byte[] c(int i, int i2, boolean z) {
        return (i2 == 2 || i2 == 4) ? (i2 != 2 || -32768 > i || i > 32767) ? a(i, z) : b(i, z) : new byte[0];
    }

    public static /* synthetic */ byte[] d(int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 2;
        }
        if ((i3 & 2) != 0) {
            z = false;
        }
        return c(i, i2, z);
    }
}
