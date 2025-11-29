package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class NativeLongArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;

    public NativeLongArray(int i) {
        this.capacity = ObjectUtil.checkPositive(i, "capacity");
        ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i));
        this.memory = allocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
    }

    private static int calculateBufferCapacity(int i) {
        return i * Limits.SIZEOF_JLONG;
    }

    private static int idx(int i) {
        return i * Limits.SIZEOF_JLONG;
    }

    private long memoryOffset(int i) {
        return this.memoryAddress + ((long) idx(i));
    }

    private void reallocIfNeeded() {
        int i = this.size;
        int i2 = this.capacity;
        if (i == i2) {
            int i3 = i2 <= 65536 ? i2 << 1 : (i2 + i2) >> 1;
            ByteBuffer allocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i3));
            this.memory.position(0).limit(this.size);
            allocateDirectWithNativeOrder.put(this.memory);
            allocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = allocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(allocateDirectWithNativeOrder);
            this.capacity = i3;
        }
    }

    public void add(long j) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), j);
        } else {
            this.memory.putLong(idx(this.size), j);
        }
        this.size++;
    }

    public void clear() {
        this.size = 0;
    }

    public void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public long memoryAddress() {
        return this.memoryAddress;
    }

    public long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
