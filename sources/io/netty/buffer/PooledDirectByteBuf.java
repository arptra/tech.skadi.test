package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDirectByteBuf>() {
        public PooledDirectByteBuf newObject(ObjectPool.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    });

    public static PooledDirectByteBuf newInstance(int i) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i);
        return pooledDirectByteBuf;
    }

    public byte _getByte(int i) {
        return ((ByteBuffer) this.memory).get(idx(i));
    }

    public int _getInt(int i) {
        return ((ByteBuffer) this.memory).getInt(idx(i));
    }

    public int _getIntLE(int i) {
        return ByteBufUtil.swapInt(_getInt(i));
    }

    public long _getLong(int i) {
        return ((ByteBuffer) this.memory).getLong(idx(i));
    }

    public long _getLongLE(int i) {
        return ByteBufUtil.swapLong(_getLong(i));
    }

    public short _getShort(int i) {
        return ((ByteBuffer) this.memory).getShort(idx(i));
    }

    public short _getShortLE(int i) {
        return ByteBufUtil.swapShort(_getShort(i));
    }

    public int _getUnsignedMedium(int i) {
        int idx = idx(i);
        return (((ByteBuffer) this.memory).get(idx + 2) & 255) | ((((ByteBuffer) this.memory).get(idx) & 255) << 16) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    public int _getUnsignedMediumLE(int i) {
        int idx = idx(i);
        return ((((ByteBuffer) this.memory).get(idx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(idx) & 255) | ((((ByteBuffer) this.memory).get(idx + 1) & 255) << 8);
    }

    public void _setByte(int i, int i2) {
        ((ByteBuffer) this.memory).put(idx(i), (byte) i2);
    }

    public void _setInt(int i, int i2) {
        ((ByteBuffer) this.memory).putInt(idx(i), i2);
    }

    public void _setIntLE(int i, int i2) {
        _setInt(i, ByteBufUtil.swapInt(i2));
    }

    public void _setLong(int i, long j) {
        ((ByteBuffer) this.memory).putLong(idx(i), j);
    }

    public void _setLongLE(int i, long j) {
        _setLong(i, ByteBufUtil.swapLong(j));
    }

    public void _setMedium(int i, int i2) {
        int idx = idx(i);
        ((ByteBuffer) this.memory).put(idx, (byte) (i2 >>> 16));
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) i2);
    }

    public void _setMediumLE(int i, int i2) {
        int idx = idx(i);
        ((ByteBuffer) this.memory).put(idx, (byte) i2);
        ((ByteBuffer) this.memory).put(idx + 1, (byte) (i2 >>> 8));
        ((ByteBuffer) this.memory).put(idx + 2, (byte) (i2 >>> 16));
    }

    public void _setShort(int i, int i2) {
        ((ByteBuffer) this.memory).putShort(idx(i), (short) i2);
    }

    public void _setShortLE(int i, int i2) {
        _setShort(i, ByteBufUtil.swapShort((short) i2));
    }

    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        return alloc().directBuffer(i2, maxCapacity()).writeBytes((ByteBuf) this, i, i2);
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

    public boolean hasArray() {
        return false;
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    public boolean isDirect() {
        return true;
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkDstIndex(i2, i, bArr.length);
        _internalNioBuffer(this.readerIndex, i2, false).get(bArr, i, i2);
        this.readerIndex += i2;
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else if (byteBuf.nioBufferCount() > 0) {
            for (ByteBuffer byteBuffer : byteBuf.nioBuffers(i2, i3)) {
                int remaining = byteBuffer.remaining();
                setBytes(i, byteBuffer);
                i += remaining;
            }
        } else {
            byteBuf.getBytes(i2, (ByteBuf) this, i, i3);
        }
        return this;
    }

    private PooledDirectByteBuf(ObjectPool.Handle<PooledDirectByteBuf> handle, int i) {
        super(handle, i);
    }

    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        byteBuffer.put(_internalNioBuffer(this.readerIndex, remaining, false));
        this.readerIndex += remaining;
        return this;
    }

    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i, true);
        this.readerIndex += i;
        return this;
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        _internalNioBuffer(i, i3, true).get(bArr, i2, i3);
        return this;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        _internalNioBuffer(i, i3, false).put(bArr, i2, i3);
        return this;
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        byteBuffer.put(duplicateInternalNioBuffer(i, byteBuffer.remaining()));
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        ByteBuffer internalNioBuffer = internalNioBuffer();
        if (byteBuffer == internalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int idx = idx(i);
        internalNioBuffer.limit(remaining + idx).position(idx);
        internalNioBuffer.put(byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        getBytes(i, outputStream, i2, false);
        return this;
    }

    private void getBytes(int i, OutputStream outputStream, int i2, boolean z) throws IOException {
        checkIndex(i, i2);
        if (i2 != 0) {
            ByteBufUtil.readBytes(alloc(), z ? internalNioBuffer() : ((ByteBuffer) this.memory).duplicate(), idx(i), i2, outputStream);
        }
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex(i, i2);
        byte[] threadLocalTempArray = ByteBufUtil.threadLocalTempArray(i2);
        int read = inputStream.read(threadLocalTempArray, 0, i2);
        if (read <= 0) {
            return read;
        }
        ByteBuffer internalNioBuffer = internalNioBuffer();
        internalNioBuffer.position(idx(i));
        internalNioBuffer.put(threadLocalTempArray, 0, read);
        return read;
    }
}
