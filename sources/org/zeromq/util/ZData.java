package org.zeromq.util;

import java.util.Arrays;
import org.zeromq.ZMQ;

public class ZData {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3518a;

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789ABCDEF".charAt((b >>> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(b & 15));
        }
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        for (byte b : bArr) {
            if (b < 32 || b > Byte.MAX_VALUE) {
                return a(bArr);
            }
        }
        return new String(bArr, ZMQ.f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.f3518a, ((ZData) obj).f3518a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3518a);
    }

    public String toString() {
        return b(this.f3518a);
    }
}
