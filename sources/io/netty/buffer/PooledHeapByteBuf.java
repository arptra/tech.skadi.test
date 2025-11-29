package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledHeapByteBuf>() {
        public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    });

    public PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> handle, int i) {
        super(handle, i);
    }

    public static PooledHeapByteBuf newInstance(int i) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i);
        return pooledHeapByteBuf;
    }

    public byte _getByte(int i) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i));
    }

    public int _getInt(int i) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i));
    }

    public int _getIntLE(int i) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i));
    }

    public long _getLong(int i) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i));
    }

    public long _getLongLE(int i) {
        return HeapByteBufUtil.getLongLE((byte[]) this.memory, idx(i));
    }

    public short _getShort(int i) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i));
    }

    public short _getShortLE(int i) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i));
    }

    public int _getUnsignedMedium(int i) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i));
    }

    public int _getUnsignedMediumLE(int i) {
        return HeapByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i));
    }

    public void _setByte(int i, int i2) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i), i2);
    }

    public void _setInt(int i, int i2) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i), i2);
    }

    public void _setIntLE(int i, int i2) {
        HeapByteBufUtil.setIntLE((byte[]) this.memory, idx(i), i2);
    }

    public void _setLong(int i, long j) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(i), j);
    }

    public void _setLongLE(int i, long j) {
        HeapByteBufUtil.setLongLE((byte[]) this.memory, idx(i), j);
    }

    public void _setMedium(int i, int i2) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i), i2);
    }

    public void _setMediumLE(int i, int i2) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(i), i2);
    }

    public void _setShort(int i, int i2) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i), i2);
    }

    public void _setShortLE(int i, int i2) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(i), i2);
    }

    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    public final int arrayOffset() {
        return this.offset;
    }

    public final ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        return alloc().heapBuffer(i2, maxCapacity()).writeBytes((byte[]) this.memory, idx(i), i2);
    }

    public final ByteBuffer duplicateInternalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i), i2).slice();
    }

    public final ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i), ((long) i2) + byteBuf.memoryAddress(), (long) i3);
        } else if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.setBytes(i2, (byte[]) this.memory, idx(i), i3);
        }
        return this;
    }

    public final boolean hasArray() {
        return true;
    }

    public final boolean hasMemoryAddress() {
        return false;
    }

    public final boolean isDirect() {
        return false;
    }

    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public final ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i2), (byte[]) this.memory, idx(i), (long) i3);
        } else if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.getBytes(i2, (byte[]) this.memory, idx(i), i3);
        }
        return this;
    }

    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    public final ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        System.arraycopy(this.memory, idx(i), bArr, i2, i3);
        return this;
    }

    public final ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        System.arraycopy(bArr, i2, this.memory, idx(i), i3);
        return this;
    }

    public final ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        byteBuffer.put((byte[]) this.memory, idx(i), remaining);
        return this;
    }

    public final ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        byteBuffer.get((byte[]) this.memory, idx(i), remaining);
        return this;
    }

    public final ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex(i, i2);
        outputStream.write((byte[]) this.memory, idx(i), i2);
        return this;
    }

    public final int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        checkIndex(i, i2);
        return inputStream.read((byte[]) this.memory, idx(i), i2);
    }
}
