package android.net.util;

import android.net.MacAddress;
import java.util.Arrays;
import java.util.Objects;

public final class MacAddressUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final long f84a = b(MacAddress.fromString("2:0:0:0:0:0").toByteArray());
    public static final long b = b(MacAddress.fromString("1:0:0:0:0:0").toByteArray());
    public static final long c = b(MacAddress.fromString("ff:ff:ff:0:0:0").toByteArray());
    public static final long d = b(MacAddress.fromString("0:0:0:ff:ff:ff").toByteArray());

    public static boolean a(byte[] bArr) {
        return bArr != null && bArr.length == 6;
    }

    public static long b(byte[] bArr) {
        Objects.requireNonNull(bArr);
        if (a(bArr)) {
            long j = 0;
            for (byte b2 : bArr) {
                j = (j << 8) + ((long) (b2 & 255));
            }
            return j;
        }
        throw new IllegalArgumentException(Arrays.toString(bArr) + " was not a valid MAC address");
    }
}
