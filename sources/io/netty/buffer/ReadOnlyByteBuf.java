package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class ReadOnlyByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public ReadOnlyByteBuf(ByteBuf byteBuf) {
        super(byteBuf.maxCapacity());
        if ((byteBuf instanceof ReadOnlyByteBuf) || (byteBuf instanceof DuplicatedByteBuf)) {
            this.buffer = byteBuf.unwrap();
        } else {
            this.buffer = byteBuf;
        }
        setIndex(byteBuf.readerIndex(), byteBuf.writerIndex());
    }

    public byte _getByte(int i) {
        return unwrap().getByte(i);
    }

    public int _getInt(int i) {
        return unwrap().getInt(i);
    }

    public int _getIntLE(int i) {
        return unwrap().getIntLE(i);
    }

    public long _getLong(int i) {
        return unwrap().getLong(i);
    }

    public long _getLongLE(int i) {
        return unwrap().getLongLE(i);
    }

    public short _getShort(int i) {
        return unwrap().getShort(i);
    }

    public short _getShortLE(int i) {
        return unwrap().getShortLE(i);
    }

    public int _getUnsignedMedium(int i) {
        return unwrap().getUnsignedMedium(i);
    }

    public int _getUnsignedMediumLE(int i) {
        return unwrap().getUnsignedMediumLE(i);
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
        return unwrap().alloc();
    }

    public byte[] array() {
        throw new ReadOnlyBufferException();
    }

    public int arrayOffset() {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf asReadOnly() {
        return this;
    }

    public int capacity() {
        return unwrap().capacity();
    }

    public ByteBuf copy(int i, int i2) {
        return unwrap().copy(i, i2);
    }

    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf duplicate() {
        return new ReadOnlyByteBuf(this);
    }

    public int ensureWritable(int i, boolean z) {
        return 1;
    }

    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        return unwrap().forEachByte(i, i2, byteProcessor);
    }

    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        return unwrap().forEachByteDesc(i, i2, byteProcessor);
    }

    public byte getByte(int i) {
        return unwrap().getByte(i);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return unwrap().getBytes(i, gatheringByteChannel, i2);
    }

    public int getInt(int i) {
        return unwrap().getInt(i);
    }

    public int getIntLE(int i) {
        return unwrap().getIntLE(i);
    }

    public long getLong(int i) {
        return unwrap().getLong(i);
    }

    public long getLongLE(int i) {
        return unwrap().getLongLE(i);
    }

    public short getShort(int i) {
        return unwrap().getShort(i);
    }

    public short getShortLE(int i) {
        return unwrap().getShortLE(i);
    }

    public int getUnsignedMedium(int i) {
        return unwrap().getUnsignedMedium(i);
    }

    public int getUnsignedMediumLE(int i) {
        return unwrap().getUnsignedMediumLE(i);
    }

    public boolean hasArray() {
        return false;
    }

    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    public boolean isDirect() {
        return unwrap().isDirect();
    }

    public boolean isReadOnly() {
        return true;
    }

    public boolean isWritable() {
        return false;
    }

    public long memoryAddress() {
        return unwrap().memoryAddress();
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        return unwrap().nioBuffer(i, i2).asReadOnlyBuffer();
    }

    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        return unwrap().nioBuffers(i, i2);
    }

    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
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

    public ByteBuf slice(int i, int i2) {
        return Unpooled.unmodifiableBuffer(unwrap().slice(i, i2));
    }

    public ByteBuf unwrap() {
        return this.buffer;
    }

    public ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf ensureWritable(int i) {
        throw new ReadOnlyBufferException();
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return unwrap().getBytes(i, fileChannel, j, i2);
    }

    public boolean isWritable(int i) {
        return false;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        unwrap().getBytes(i, outputStream, i2);
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        unwrap().getBytes(i, bArr, i2, i3);
        return this;
    }

    public int setBytes(int i, InputStream inputStream, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        unwrap().getBytes(i, byteBuf, i2, i3);
        return this;
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        unwrap().getBytes(i, byteBuffer);
        return this;
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) {
        throw new ReadOnlyBufferException();
    }
}
