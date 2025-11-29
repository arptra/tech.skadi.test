package org.java_websocket.util;

import java.nio.ByteBuffer;

public class ByteBufferUtils {
    public static ByteBuffer a() {
        return ByteBuffer.allocate(0);
    }

    public static int b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new IllegalArgumentException();
        }
        int remaining = byteBuffer.remaining();
        int remaining2 = byteBuffer2.remaining();
        if (remaining > remaining2) {
            int min = Math.min(remaining, remaining2);
            byteBuffer.limit(min);
            byteBuffer2.put(byteBuffer);
            return min;
        }
        byteBuffer2.put(byteBuffer);
        return remaining;
    }
}
