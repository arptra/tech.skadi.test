package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.nio.Buffer;

@GwtIncompatible
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    public static void clear(Buffer buffer) {
        buffer.clear();
    }

    public static void flip(Buffer buffer) {
        buffer.flip();
    }

    public static void limit(Buffer buffer, int i) {
        buffer.limit(i);
    }

    public static void position(Buffer buffer, int i) {
        buffer.position(i);
    }
}
