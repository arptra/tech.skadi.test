package io.netty.buffer;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class UnpooledHeapByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    byte[] array;
    private ByteBuffer tmpNioBuf;

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        super(i2);
        if (i <= i2) {
            this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
            setArray(allocateArray(i));
            setIndex(0, 0);
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    private void setArray(byte[] bArr) {
        this.array = bArr;
        this.tmpNioBuf = null;
    }

    public byte _getByte(int i) {
        return HeapByteBufUtil.getByte(this.array, i);
    }

    public int _getInt(int i) {
        return HeapByteBufUtil.getInt(this.array, i);
    }

    public int _getIntLE(int i) {
        return HeapByteBufUtil.getIntLE(this.array, i);
    }

    public long _getLong(int i) {
        return HeapByteBufUtil.getLong(this.array, i);
    }

    public long _getLongLE(int i) {
        return HeapByteBufUtil.getLongLE(this.array, i);
    }

    public short _getShort(int i) {
        return HeapByteBufUtil.getShort(this.array, i);
    }

    public short _getShortLE(int i) {
        return HeapByteBufUtil.getShortLE(this.array, i);
    }

    public int _getUnsignedMedium(int i) {
        return HeapByteBufUtil.getUnsignedMedium(this.array, i);
    }

    public int _getUnsignedMediumLE(int i) {
        return HeapByteBufUtil.getUnsignedMediumLE(this.array, i);
    }

    public void _setByte(int i, int i2) {
        HeapByteBufUtil.setByte(this.array, i, i2);
    }

    public void _setInt(int i, int i2) {
        HeapByteBufUtil.setInt(this.array, i, i2);
    }

    public void _setIntLE(int i, int i2) {
        HeapByteBufUtil.setIntLE(this.array, i, i2);
    }

    public void _setLong(int i, long j) {
        HeapByteBufUtil.setLong(this.array, i, j);
    }

    public void _setLongLE(int i, long j) {
        HeapByteBufUtil.setLongLE(this.array, i, j);
    }

    public void _setMedium(int i, int i2) {
        HeapByteBufUtil.setMedium(this.array, i, i2);
    }

    public void _setMediumLE(int i, int i2) {
        HeapByteBufUtil.setMediumLE(this.array, i, i2);
    }

    public void _setShort(int i, int i2) {
        HeapByteBufUtil.setShort(this.array, i, i2);
    }

    public void _setShortLE(int i, int i2) {
        HeapByteBufUtil.setShortLE(this.array, i, i2);
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public byte[] allocateArray(int i) {
        return new byte[i];
    }

    public byte[] array() {
        ensureAccessible();
        return this.array;
    }

    public int arrayOffset() {
        return 0;
    }

    public int capacity() {
        return this.array.length;
    }

    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        return alloc().heapBuffer(i2, maxCapacity()).writeBytes(this.array, i, i2);
    }

    public void deallocate() {
        freeArray(this.array);
        this.array = EmptyArrays.EMPTY_BYTES;
    }

    public void freeArray(byte[] bArr) {
    }

    public byte getByte(int i) {
        ensureAccessible();
        return _getByte(i);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(this.array, i, byteBuf.memoryAddress() + ((long) i2), (long) i3);
        } else if (byteBuf.hasArray()) {
            getBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.setBytes(i2, this.array, i, i3);
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
        return true;
    }

    public boolean hasMemoryAddress() {
        return false;
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return (ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2);
    }

    public final boolean isContiguous() {
        return true;
    }

    public boolean isDirect() {
        return false;
    }

    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        ensureAccessible();
        return ByteBuffer.wrap(this.array, i, i2).slice();
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

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i, true);
        this.readerIndex += bytes;
        return bytes;
    }

    public ByteBuf setByte(int i, int i2) {
        ensureAccessible();
        _setByte(i, i2);
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i2), this.array, i, (long) i3);
        } else if (byteBuf.hasArray()) {
            setBytes(i, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.getBytes(i2, this.array, i, i3);
        }
        return this;
    }

    public ByteBuf setInt(int i, int i2) {
        ensureAccessible();
        _setInt(i, i2);
        return this;
    }

    public ByteBuf setIntLE(int i, int i2) {
        ensureAccessible();
        _setIntLE(i, i2);
        return this;
    }

    public ByteBuf setLong(int i, long j) {
        ensureAccessible();
        _setLong(i, j);
        return this;
    }

    public ByteBuf setLongLE(int i, long j) {
        ensureAccessible();
        _setLongLE(i, j);
        return this;
    }

    public ByteBuf setMedium(int i, int i2) {
        ensureAccessible();
        _setMedium(i, i2);
        return this;
    }

    public ByteBuf setMediumLE(int i, int i2) {
        ensureAccessible();
        _setMediumLE(i, i2);
        return this;
    }

    public ByteBuf setShort(int i, int i2) {
        ensureAccessible();
        _setShort(i, i2);
        return this;
    }

    public ByteBuf setShortLE(int i, int i2) {
        ensureAccessible();
        _setShortLE(i, i2);
        return this;
    }

    public ByteBuf unwrap() {
        return null;
    }

    public ByteBuf capacity(int i) {
        checkNewCapacity(i);
        byte[] bArr = this.array;
        int length = bArr.length;
        if (i == length) {
            return this;
        }
        if (i <= length) {
            trimIndicesToCapacity(i);
            length = i;
        }
        byte[] allocateArray = allocateArray(i);
        System.arraycopy(bArr, 0, allocateArray, 0, length);
        setArray(allocateArray);
        freeArray(bArr);
        return this;
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.array);
        this.tmpNioBuf = wrap;
        return wrap;
    }

    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, fileChannel, j, i, true);
        this.readerIndex += bytes;
        return bytes;
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        System.arraycopy(this.array, i, bArr, i2, i3);
        return this;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        System.arraycopy(bArr, i2, this.array, i, i3);
        return this;
    }

    public UnpooledHeapByteBuf(ByteBufAllocator byteBufAllocator, byte[] bArr, int i) {
        super(i);
        ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNull(bArr, "initialArray");
        if (bArr.length <= i) {
            this.alloc = byteBufAllocator;
            setArray(bArr);
            setIndex(0, bArr.length);
            return;
        }
        throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)}));
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.put(this.array, i, byteBuffer.remaining());
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        ensureAccessible();
        byteBuffer.get(this.array, i, byteBuffer.remaining());
        return this;
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        ensureAccessible();
        outputStream.write(this.array, i, i2);
        return this;
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        ensureAccessible();
        return inputStream.read(this.array, i, i2);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        ensureAccessible();
        return getBytes(i, gatheringByteChannel, i2, false);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        ensureAccessible();
        try {
            return scatteringByteChannel.read((ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2));
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        return getBytes(i, fileChannel, j, i2, false);
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        ensureAccessible();
        try {
            return fileChannel.read((ByteBuffer) internalNioBuffer().clear().position(i).limit(i + i2), j);
        } catch (ClosedChannelException unused) {
            return -1;
        }
    }

    private int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2, boolean z) throws IOException {
        ByteBuffer byteBuffer;
        ensureAccessible();
        if (z) {
            byteBuffer = internalNioBuffer();
        } else {
            byteBuffer = ByteBuffer.wrap(this.array);
        }
        return gatheringByteChannel.write((ByteBuffer) byteBuffer.clear().position(i).limit(i + i2));
    }

    private int getBytes(int i, FileChannel fileChannel, long j, int i2, boolean z) throws IOException {
        ensureAccessible();
        return fileChannel.write((ByteBuffer) (z ? internalNioBuffer() : ByteBuffer.wrap(this.array)).clear().position(i).limit(i + i2), j);
    }
}
