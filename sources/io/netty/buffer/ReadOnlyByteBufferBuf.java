package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

class ReadOnlyByteBufferBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator allocator;
    protected final ByteBuffer buffer;
    private ByteBuffer tmpNioBuf;

    public ReadOnlyByteBufferBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBuffer.remaining());
        if (byteBuffer.isReadOnly()) {
            this.allocator = byteBufAllocator;
            ByteBuffer order = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
            this.buffer = order;
            writerIndex(order.limit());
            return;
        }
        throw new IllegalArgumentException("must be a readonly buffer: " + StringUtil.simpleClassName((Object) byteBuffer));
    }

    public byte _getByte(int i) {
        return this.buffer.get(i);
    }

    public int _getInt(int i) {
        return this.buffer.getInt(i);
    }

    public int _getIntLE(int i) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i));
    }

    public long _getLong(int i) {
        return this.buffer.getLong(i);
    }

    public long _getLongLE(int i) {
        return ByteBufUtil.swapLong(this.buffer.getLong(i));
    }

    public short _getShort(int i) {
        return this.buffer.getShort(i);
    }

    public short _getShortLE(int i) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i));
    }

    public int _getUnsignedMedium(int i) {
        return (getByte(i + 2) & 255) | ((getByte(i) & 255) << 16) | ((getByte(i + 1) & 255) << 8);
    }

    public int _getUnsignedMediumLE(int i) {
        return ((getByte(i + 2) & 255) << 16) | (getByte(i) & 255) | ((getByte(i + 1) & 255) << 8);
    }

    public void _setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setIntLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public void _setLongLE(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public void _setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setMediumLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public void _setShortLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    public byte[] array() {
        return this.buffer.array();
    }

    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    public int capacity() {
        return maxCapacity();
    }

    public ByteBuf copy(int i, int i2) {
        ensureAccessible();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2);
            boolean isDirect = byteBuffer.isDirect();
            ByteBufAllocator alloc = alloc();
            ByteBuf directBuffer = isDirect ? alloc.directBuffer(i2) : alloc.heapBuffer(i2);
            directBuffer.writeBytes(byteBuffer);
            return directBuffer;
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (i + i2));
        }
    }

    public void deallocate() {
    }

    public int ensureWritable(int i, boolean z) {
        return 1;
    }

    public byte getByte(int i) {
        ensureAccessible();
        return _getByte(i);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            for (ByteBuffer byteBuffer : byteBuf.nioBuffers(i2, i3)) {
                int remaining = byteBuffer.remaining();
                getBytes(i, byteBuffer);
                i += remaining;
            }
        } else {
            byteBuf.setBytes(i2, (ByteBuf) this, i, i3);
        }
        return this;
    }

    public int getInt(int i) {
        ensureAccessible();
        return _getInt(i);
    }

    public int getIntLE(int i) {
        ensureAccessible();
        return _getIntLE(i);
    }

    public long getLong(int i) {
        ensureAccessible();
        return _getLong(i);
    }

    public long getLongLE(int i) {
        ensureAccessible();
        return _getLongLE(i);
    }

    public short getShort(int i) {
        ensureAccessible();
        return _getShort(i);
    }

    public short getShortLE(int i) {
        ensureAccessible();
        return _getShortLE(i);
    }

    public int getUnsignedMedium(int i) {
        ensureAccessible();
        return _getUnsignedMedium(i);
    }

    public int getUnsignedMediumLE(int i) {
        ensureAccessible();
        return _getUnsignedMediumLE(i);
    }

    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer duplicate = this.buffer.duplicate();
        this.tmpNioBuf = duplicate;
        return duplicate;
    }

    public final boolean isContiguous() {
        return true;
    }

    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    public boolean isReadOnly() {
        return this.buffer.isReadOnly();
    }

    public boolean isWritable() {
        return false;
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return (ByteBuffer) this.buffer.duplicate().position(i).limit(i + i2);
    }

    public int nioBufferCount() {
        return 1;
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        return new ByteBuffer[]{nioBuffer(i, i2)};
    }

    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public ByteBuf setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setIntLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setLongLE(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setMediumLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setShortLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf unwrap() {
        return null;
    }

    public ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf ensureWritable(int i) {
        throw new ReadOnlyBufferException();
    }

    public boolean isWritable(int i) {
        return false;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        ensureAccessible();
        return (ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2);
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + i3);
        internalNioBuffer.get(bArr, i2, i3);
        return this;
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        checkIndex(i, byteBuffer.remaining());
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + byteBuffer.remaining());
        byteBuffer.put(internalNioBuffer);
        return this;
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        ensureAccessible();
        if (i2 == 0) {
            return this;
        }
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), i + this.buffer.arrayOffset(), i2);
        } else {
            byte[] threadLocalTempArray = ByteBufUtil.threadLocalTempArray(i2);
            ByteBuffer internalNioBuffer = internalNioBuffer();
            internalNioBuffer.clear().position(i);
            internalNioBuffer.get(threadLocalTempArray, 0, i2);
            outputStream.write(threadLocalTempArray, 0, i2);
        }
        return this;
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        ensureAccessible();
        if (i2 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + i2);
        return gatheringByteChannel.write(internalNioBuffer);
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        if (i2 == 0) {
            return 0;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.clear().position(i).limit(i + i2);
        return fileChannel.write(internalNioBuffer, j);
    }
}
