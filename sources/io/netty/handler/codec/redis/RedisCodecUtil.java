package io.netty.handler.codec.redis;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;

final class RedisCodecUtil {
    private RedisCodecUtil() {
    }

    public static byte[] longToAsciiBytes(long j) {
        return Long.toString(j).getBytes(CharsetUtil.US_ASCII);
    }

    public static short makeShort(char c, char c2) {
        return (short) (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? c | (c2 << 8) : (c << 8) | c2);
    }

    public static byte[] shortToBytes(short s) {
        byte[] bArr = new byte[2];
        if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
            bArr[1] = (byte) ((s >> 8) & 255);
            bArr[0] = (byte) (s & 255);
        } else {
            bArr[0] = (byte) ((s >> 8) & 255);
            bArr[1] = (byte) (s & 255);
        }
        return bArr;
    }
}
