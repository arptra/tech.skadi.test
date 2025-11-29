package org.apache.tika.io;

import java.io.InputStream;

public class IOUtils {
    public static long a(InputStream inputStream, long j, byte[] bArr) {
        if (j >= 0) {
            long j2 = j;
            while (j2 > 0) {
                long read = (long) inputStream.read(bArr, 0, (int) Math.min(j2, (long) bArr.length));
                if (read < 0) {
                    break;
                }
                j2 -= read;
            }
            return j - j2;
        }
        throw new IllegalArgumentException("Skip count must be non-negative, actual: " + j);
    }
}
