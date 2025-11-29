package io.netty.util.internal.shaded.org.jctools.util;

public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j, int i) {
        if (isPowerOfTwo(i)) {
            int i2 = i - 1;
            return (j + ((long) i2)) & ((long) (~i2));
        }
        throw new IllegalArgumentException("alignment must be a power of 2:" + i);
    }

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + -1)) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        if (i > 1073741824) {
            throw new IllegalArgumentException("There is no larger power of 2 int for value:" + i + " since it exceeds 2^31.");
        } else if (i >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        } else {
            throw new IllegalArgumentException("Given value:" + i + ". Expecting value >= 0.");
        }
    }
}
