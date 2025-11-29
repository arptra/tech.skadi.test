package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress = PlatformDependent.directBufferAddress(this.buffer);

    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
    }

    private long addr(int i) {
        return this.memoryAddress + ((long) i);
    }

    public byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(addr(i));
    }

    public int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(addr(i));
    }

    public long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(addr(i));
    }

    public short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(addr(i));
    }

    public int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i));
    }

    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf directBuffer = alloc().directBuffer(i2, maxCapacity());
        if (i2 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i), directBuffer.memoryAddress(), (long) i2);
                directBuffer.setIndex(0, i2);
            } else {
                directBuffer.writeBytes((ByteBuf) this, i, i2);
            }
        }
        return directBuffer;
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkIndex(i, i3);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (i2 < 0 || i2 > byteBuf.capacity() - i3) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr(i), ((long) i2) + byteBuf.memoryAddress(), (long) i3);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(addr(i), byteBuf.array(), byteBuf.arrayOffset() + i2, (long) i3);
        } else {
            byteBuf.setBytes(i2, (ByteBuf) this, i, i3);
        }
        return this;
    }

    public boolean hasMemoryAddress() {
        return true;
    }

    public long memoryAddress() {
        return this.memoryAddress;
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkIndex(i, i3);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (i2 < 0 || i2 > bArr.length - i3) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)}));
        }
        if (i3 != 0) {
            PlatformDependent.copyMemory(addr(i), bArr, i2, (long) i3);
        }
        return this;
    }
}
