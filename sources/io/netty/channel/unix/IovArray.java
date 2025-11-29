package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    public static final int IOV_SIZE;
    private static final int MAX_CAPACITY;
    private int count;
    private long maxBytes;
    private final ByteBuf memory;
    private final long memoryAddress;
    private long size;

    static {
        int addressSize = Buffer.addressSize();
        ADDRESS_SIZE = addressSize;
        int i = addressSize * 2;
        IOV_SIZE = i;
        MAX_CAPACITY = Limits.IOV_MAX * i;
    }

    public IovArray() {
        this(Unpooled.wrappedBuffer(Buffer.allocateDirectWithNativeOrder(MAX_CAPACITY)).setIndex(0, 0));
    }

    private static int idx(int i) {
        return IOV_SIZE * i;
    }

    @Deprecated
    public boolean add(ByteBuf byteBuf) {
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void clear() {
        this.count = 0;
        this.size = 0;
    }

    public int count() {
        return this.count;
    }

    public void maxBytes(long j) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(j, "maxBytes"));
    }

    public long memoryAddress(int i) {
        return this.memoryAddress + ((long) idx(i));
    }

    public boolean processMessage(Object obj) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            return false;
        }
        ByteBuf byteBuf = (ByteBuf) obj;
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void release() {
        this.memory.release();
    }

    public long size() {
        return this.size;
    }

    public IovArray(ByteBuf byteBuf) {
        ByteBuf byteBuf2;
        this.maxBytes = Limits.SSIZE_MAX;
        if (PlatformDependent.hasUnsafe()) {
            byteBuf2 = byteBuf;
        } else {
            byteBuf2 = byteBuf.order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        }
        this.memory = byteBuf2;
        if (byteBuf.hasMemoryAddress()) {
            this.memoryAddress = byteBuf.memoryAddress();
        } else {
            this.memoryAddress = Buffer.memoryAddress(byteBuf.internalNioBuffer(0, byteBuf.capacity()));
        }
    }

    public boolean add(ByteBuf byteBuf, int i, int i2) {
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (byteBuf.nioBufferCount() != 1) {
            for (ByteBuffer byteBuffer : byteBuf.nioBuffers(i, i2)) {
                int remaining = byteBuffer.remaining();
                if (remaining != 0) {
                    if (!add(this.memoryAddress, Buffer.memoryAddress(byteBuffer) + ((long) byteBuffer.position()), remaining) || this.count == Limits.IOV_MAX) {
                        return false;
                    }
                }
            }
            return true;
        } else if (i2 == 0) {
            return true;
        } else {
            if (byteBuf.hasMemoryAddress()) {
                return add(this.memoryAddress, byteBuf.memoryAddress() + ((long) i), i2);
            }
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(i, i2);
            return add(this.memoryAddress, Buffer.memoryAddress(internalNioBuffer) + ((long) internalNioBuffer.position()), i2);
        }
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    private boolean add(long j, long j2, int i) {
        long j3 = (long) i;
        if (this.maxBytes - j3 < this.size && this.count > 0) {
            return false;
        }
        int capacity = this.memory.capacity();
        int i2 = this.count;
        if (capacity < (i2 + 1) * IOV_SIZE) {
            return false;
        }
        int idx = idx(i2);
        int i3 = ADDRESS_SIZE;
        int i4 = idx + i3;
        this.size += j3;
        this.count++;
        if (i3 == 8) {
            if (PlatformDependent.hasUnsafe()) {
                PlatformDependent.putLong(((long) idx) + j, j2);
                PlatformDependent.putLong(((long) i4) + j, j3);
            } else {
                this.memory.setLong(idx, j2);
                this.memory.setLong(i4, j3);
            }
        } else if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putInt(((long) idx) + j, (int) j2);
            PlatformDependent.putInt(((long) i4) + j, i);
        } else {
            this.memory.setInt(idx, (int) j2);
            this.memory.setInt(i4, i);
        }
        return true;
    }
}
