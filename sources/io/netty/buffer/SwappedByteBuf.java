package io.netty.buffer;

import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import kotlin.UShort;

@Deprecated
public class SwappedByteBuf extends ByteBuf {
    private final ByteBuf buf;
    private final ByteOrder order;

    public SwappedByteBuf(ByteBuf byteBuf) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
        ByteOrder order2 = byteBuf.order();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        if (order2 == byteOrder) {
            this.order = ByteOrder.LITTLE_ENDIAN;
        } else {
            this.order = byteOrder;
        }
    }

    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    public byte[] array() {
        return this.buf.array();
    }

    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer((ByteBuf) this);
    }

    public int bytesBefore(byte b) {
        return this.buf.bytesBefore(b);
    }

    public int capacity() {
        return this.buf.capacity();
    }

    public ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    public ByteBuf copy() {
        return this.buf.copy().order(this.order);
    }

    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    public ByteBuf duplicate() {
        return this.buf.duplicate().order(this.order);
    }

    public ByteBuf ensureWritable(int i) {
        this.buf.ensureWritable(i);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ByteBuf) {
            return ByteBufUtil.equals(this, (ByteBuf) obj);
        }
        return false;
    }

    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(byteProcessor);
    }

    public boolean getBoolean(int i) {
        return this.buf.getBoolean(i);
    }

    public byte getByte(int i) {
        return this.buf.getByte(i);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        this.buf.getBytes(i, byteBuf);
        return this;
    }

    public char getChar(int i) {
        return (char) getShort(i);
    }

    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        return this.buf.getCharSequence(i, i2, charset);
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public int getInt(int i) {
        return ByteBufUtil.swapInt(this.buf.getInt(i));
    }

    public int getIntLE(int i) {
        return this.buf.getIntLE(i);
    }

    public long getLong(int i) {
        return ByteBufUtil.swapLong(this.buf.getLong(i));
    }

    public long getLongLE(int i) {
        return this.buf.getLongLE(i);
    }

    public int getMedium(int i) {
        return ByteBufUtil.swapMedium(this.buf.getMedium(i));
    }

    public int getMediumLE(int i) {
        return this.buf.getMediumLE(i);
    }

    public short getShort(int i) {
        return ByteBufUtil.swapShort(this.buf.getShort(i));
    }

    public short getShortLE(int i) {
        return this.buf.getShortLE(i);
    }

    public short getUnsignedByte(int i) {
        return this.buf.getUnsignedByte(i);
    }

    public long getUnsignedInt(int i) {
        return ((long) getInt(i)) & 4294967295L;
    }

    public long getUnsignedIntLE(int i) {
        return ((long) getIntLE(i)) & 4294967295L;
    }

    public int getUnsignedMedium(int i) {
        return getMedium(i) & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
    }

    public int getUnsignedMediumLE(int i) {
        return getMediumLE(i) & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
    }

    public int getUnsignedShort(int i) {
        return getShort(i) & UShort.MAX_VALUE;
    }

    public int getUnsignedShortLE(int i) {
        return getShortLE(i) & UShort.MAX_VALUE;
    }

    public boolean hasArray() {
        return this.buf.hasArray();
    }

    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    public int hashCode() {
        return this.buf.hashCode();
    }

    public int indexOf(int i, int i2, byte b) {
        return this.buf.indexOf(i, i2, b);
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    public final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    public boolean isContiguous() {
        return this.buf.isContiguous();
    }

    public boolean isDirect() {
        return this.buf.isDirect();
    }

    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    public boolean isReadable() {
        return this.buf.isReadable();
    }

    public boolean isWritable() {
        return this.buf.isWritable();
    }

    public ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer().order(this.order);
    }

    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    public ByteBuffer[] nioBuffers() {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers();
        for (int i = 0; i < nioBuffers.length; i++) {
            nioBuffers[i] = nioBuffers[i].order(this.order);
        }
        return nioBuffers;
    }

    public ByteOrder order() {
        return this.order;
    }

    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    public byte readByte() {
        return this.buf.readByte();
    }

    public ByteBuf readBytes(int i) {
        return this.buf.readBytes(i).order(order());
    }

    public char readChar() {
        return (char) readShort();
    }

    public CharSequence readCharSequence(int i, Charset charset) {
        return this.buf.readCharSequence(i, charset);
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        return ByteBufUtil.swapInt(this.buf.readInt());
    }

    public int readIntLE() {
        return this.buf.readIntLE();
    }

    public long readLong() {
        return ByteBufUtil.swapLong(this.buf.readLong());
    }

    public long readLongLE() {
        return this.buf.readLongLE();
    }

    public int readMedium() {
        return ByteBufUtil.swapMedium(this.buf.readMedium());
    }

    public int readMediumLE() {
        return this.buf.readMediumLE();
    }

    public ByteBuf readRetainedSlice(int i) {
        return this.buf.readRetainedSlice(i).order(this.order);
    }

    public short readShort() {
        return ByteBufUtil.swapShort(this.buf.readShort());
    }

    public short readShortLE() {
        return this.buf.readShortLE();
    }

    public ByteBuf readSlice(int i) {
        return this.buf.readSlice(i).order(this.order);
    }

    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    public long readUnsignedIntLE() {
        return ((long) readIntLE()) & 4294967295L;
    }

    public int readUnsignedMedium() {
        return readMedium() & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
    }

    public int readUnsignedMediumLE() {
        return readMediumLE() & Http2CodecUtil.MAX_FRAME_SIZE_UPPER_BOUND;
    }

    public int readUnsignedShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    public int readUnsignedShortLE() {
        return readShortLE() & UShort.MAX_VALUE;
    }

    public int readableBytes() {
        return this.buf.readableBytes();
    }

    public int readerIndex() {
        return this.buf.readerIndex();
    }

    public int refCnt() {
        return this.buf.refCnt();
    }

    public boolean release() {
        return this.buf.release();
    }

    public ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    public ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate().order(this.order);
    }

    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice().order(this.order);
    }

    public ByteBuf setBoolean(int i, boolean z) {
        this.buf.setBoolean(i, z);
        return this;
    }

    public ByteBuf setByte(int i, int i2) {
        this.buf.setByte(i, i2);
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf) {
        this.buf.setBytes(i, byteBuf);
        return this;
    }

    public ByteBuf setChar(int i, int i2) {
        setShort(i, i2);
        return this;
    }

    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i, charSequence, charset);
    }

    public ByteBuf setDouble(int i, double d) {
        setLong(i, Double.doubleToRawLongBits(d));
        return this;
    }

    public ByteBuf setFloat(int i, float f) {
        setInt(i, Float.floatToRawIntBits(f));
        return this;
    }

    public ByteBuf setIndex(int i, int i2) {
        this.buf.setIndex(i, i2);
        return this;
    }

    public ByteBuf setInt(int i, int i2) {
        this.buf.setInt(i, ByteBufUtil.swapInt(i2));
        return this;
    }

    public ByteBuf setIntLE(int i, int i2) {
        this.buf.setIntLE(i, i2);
        return this;
    }

    public ByteBuf setLong(int i, long j) {
        this.buf.setLong(i, ByteBufUtil.swapLong(j));
        return this;
    }

    public ByteBuf setLongLE(int i, long j) {
        this.buf.setLongLE(i, j);
        return this;
    }

    public ByteBuf setMedium(int i, int i2) {
        this.buf.setMedium(i, ByteBufUtil.swapMedium(i2));
        return this;
    }

    public ByteBuf setMediumLE(int i, int i2) {
        this.buf.setMediumLE(i, i2);
        return this;
    }

    public ByteBuf setShort(int i, int i2) {
        this.buf.setShort(i, ByteBufUtil.swapShort((short) i2));
        return this;
    }

    public ByteBuf setShortLE(int i, int i2) {
        this.buf.setShortLE(i, (short) i2);
        return this;
    }

    public ByteBuf setZero(int i, int i2) {
        this.buf.setZero(i, i2);
        return this;
    }

    public ByteBuf skipBytes(int i) {
        this.buf.skipBytes(i);
        return this;
    }

    public ByteBuf slice() {
        return this.buf.slice().order(this.order);
    }

    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    public ByteBuf unwrap() {
        return this.buf;
    }

    public int writableBytes() {
        return this.buf.writableBytes();
    }

    public ByteBuf writeBoolean(boolean z) {
        this.buf.writeBoolean(z);
        return this;
    }

    public ByteBuf writeByte(int i) {
        this.buf.writeByte(i);
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    public ByteBuf writeChar(int i) {
        writeShort(i);
        return this;
    }

    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    public ByteBuf writeDouble(double d) {
        writeLong(Double.doubleToRawLongBits(d));
        return this;
    }

    public ByteBuf writeFloat(float f) {
        writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    public ByteBuf writeInt(int i) {
        this.buf.writeInt(ByteBufUtil.swapInt(i));
        return this;
    }

    public ByteBuf writeIntLE(int i) {
        this.buf.writeIntLE(i);
        return this;
    }

    public ByteBuf writeLong(long j) {
        this.buf.writeLong(ByteBufUtil.swapLong(j));
        return this;
    }

    public ByteBuf writeLongLE(long j) {
        this.buf.writeLongLE(j);
        return this;
    }

    public ByteBuf writeMedium(int i) {
        this.buf.writeMedium(ByteBufUtil.swapMedium(i));
        return this;
    }

    public ByteBuf writeMediumLE(int i) {
        this.buf.writeMediumLE(i);
        return this;
    }

    public ByteBuf writeShort(int i) {
        this.buf.writeShort(ByteBufUtil.swapShort((short) i));
        return this;
    }

    public ByteBuf writeShortLE(int i) {
        this.buf.writeShortLE((short) i);
        return this;
    }

    public ByteBuf writeZero(int i) {
        this.buf.writeZero(i);
        return this;
    }

    public int writerIndex() {
        return this.buf.writerIndex();
    }

    public int bytesBefore(int i, byte b) {
        return this.buf.bytesBefore(i, b);
    }

    public ByteBuf capacity(int i) {
        this.buf.capacity(i);
        return this;
    }

    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    public ByteBuf copy(int i, int i2) {
        return this.buf.copy(i, i2).order(this.order);
    }

    public int ensureWritable(int i, boolean z) {
        return this.buf.ensureWritable(i, z);
    }

    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i, i2, byteProcessor);
    }

    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(i, i2, byteProcessor);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        this.buf.getBytes(i, byteBuf, i2);
        return this;
    }

    public boolean isReadable(int i) {
        return this.buf.isReadable(i);
    }

    public boolean isWritable(int i) {
        return this.buf.isWritable(i);
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        return this.buf.nioBuffer(i, i2).order(this.order);
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == this.order) {
            return this;
        }
        return this.buf;
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    public ByteBuf readerIndex(int i) {
        this.buf.readerIndex(i);
        return this;
    }

    public boolean release(int i) {
        return this.buf.release(i);
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return this.buf.retainedSlice(i, i2).order(this.order);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        this.buf.setBytes(i, byteBuf, i2);
        return this;
    }

    public ByteBuf slice(int i, int i2) {
        return this.buf.slice(i, i2).order(this.order);
    }

    public String toString(int i, int i2, Charset charset) {
        return this.buf.toString(i, i2, charset);
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        this.buf.writeBytes(byteBuf, i);
        return this;
    }

    public ByteBuf writerIndex(int i) {
        this.buf.writerIndex(i);
        return this;
    }

    public int bytesBefore(int i, int i2, byte b) {
        return this.buf.bytesBefore(i, i2, b);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        this.buf.getBytes(i, byteBuf, i2, i3);
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i) {
        this.buf.readBytes(byteBuf, i);
        return this;
    }

    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        this.buf.setBytes(i, byteBuf, i2, i3);
        return this;
    }

    public String toString() {
        return "Swapped(" + this.buf + ')';
    }

    public ByteBuf touch() {
        this.buf.touch();
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        this.buf.writeBytes(byteBuf, i, i2);
        return this;
    }

    public ByteBuf getBytes(int i, byte[] bArr) {
        this.buf.getBytes(i, bArr);
        return this;
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        ByteBuffer[] nioBuffers = this.buf.nioBuffers(i, i2);
        for (int i3 = 0; i3 < nioBuffers.length; i3++) {
            nioBuffers[i3] = nioBuffers[i3].order(this.order);
        }
        return nioBuffers;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        this.buf.readBytes(byteBuf, i, i2);
        return this;
    }

    public ByteBuf retain(int i) {
        this.buf.retain(i);
        return this;
    }

    public ByteBuf setBytes(int i, byte[] bArr) {
        this.buf.setBytes(i, bArr);
        return this;
    }

    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        this.buf.getBytes(i, bArr, i2, i3);
        return this;
    }

    public ByteBuf readBytes(byte[] bArr) {
        this.buf.readBytes(bArr);
        return this;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        this.buf.setBytes(i, bArr, i2, i3);
        return this;
    }

    public ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        this.buf.writeBytes(bArr, i, i2);
        return this;
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        this.buf.getBytes(i, byteBuffer);
        return this;
    }

    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        this.buf.readBytes(bArr, i, i2);
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        this.buf.setBytes(i, byteBuffer);
        return this;
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        this.buf.getBytes(i, outputStream, i2);
        return this;
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        return this.buf.setBytes(i, inputStream, i2);
    }

    public int writeBytes(InputStream inputStream, int i) throws IOException {
        return this.buf.writeBytes(inputStream, i);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        return this.buf.getBytes(i, gatheringByteChannel, i2);
    }

    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        this.buf.readBytes(outputStream, i);
        return this;
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        return this.buf.setBytes(i, scatteringByteChannel, i2);
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, i);
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return this.buf.getBytes(i, fileChannel, j, i2);
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, i);
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        return this.buf.setBytes(i, fileChannel, j, i2);
    }

    public int writeBytes(FileChannel fileChannel, long j, int i) throws IOException {
        return this.buf.writeBytes(fileChannel, j, i);
    }

    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        return this.buf.readBytes(fileChannel, j, i);
    }
}
