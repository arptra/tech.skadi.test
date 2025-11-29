package io.netty.channel.unix;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class Buffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private Buffer() {
    }

    public static int addressSize() {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.addressSize() : addressSize0();
    }

    private static native int addressSize0();

    public static ByteBuffer allocateDirectWithNativeOrder(int i) {
        return ByteBuffer.allocateDirect(i).order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
    }

    public static void free(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectBuffer(byteBuffer);
    }

    public static long memoryAddress(ByteBuffer byteBuffer) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.directBufferAddress(byteBuffer) : memoryAddress0(byteBuffer);
    }

    private static native long memoryAddress0(ByteBuffer byteBuffer);
}
