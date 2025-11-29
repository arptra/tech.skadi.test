package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public final class EmptyByteBuf extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER;
    private static final long EMPTY_BYTE_BUFFER_ADDRESS;
    static final int EMPTY_BYTE_BUF_HASH_CODE = 1;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    static {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(0);
        EMPTY_BYTE_BUFFER = allocateDirect;
        long j = 0;
        try {
            if (PlatformDependent.hasUnsafe()) {
                j = PlatformDependent.directBufferAddress(allocateDirect);
            }
        } catch (Throwable unused) {
        }
        EMPTY_BYTE_BUFFER_ADDRESS = j;
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator) {
        this(byteBufAllocator, ByteOrder.BIG_ENDIAN);
    }

    private ByteBuf checkIndex(int i) {
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    private ByteBuf checkLength(int i) {
        ObjectUtil.checkPositiveOrZero(i, "length");
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    public int arrayOffset() {
        return 0;
    }

    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer((ByteBuf) this);
    }

    public int bytesBefore(byte b) {
        return -1;
    }

    public int capacity() {
        return 0;
    }

    public ByteBuf clear() {
        return this;
    }

    public ByteBuf copy() {
        return this;
    }

    public ByteBuf discardReadBytes() {
        return this;
    }

    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    public ByteBuf duplicate() {
        return this;
    }

    public ByteBuf ensureWritable(int i) {
        ObjectUtil.checkPositiveOrZero(i, "minWritableBytes");
        if (i == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && !((ByteBuf) obj).isReadable();
    }

    public int forEachByte(ByteProcessor byteProcessor) {
        return -1;
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return -1;
    }

    public boolean getBoolean(int i) {
        throw new IndexOutOfBoundsException();
    }

    public byte getByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        return checkIndex(i, byteBuf.writableBytes());
    }

    public char getChar(int i) {
        throw new IndexOutOfBoundsException();
    }

    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return null;
    }

    public double getDouble(int i) {
        throw new IndexOutOfBoundsException();
    }

    public float getFloat(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public long getLong(int i) {
        throw new IndexOutOfBoundsException();
    }

    public long getLongLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public short getShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    public short getShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public short getUnsignedByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    public long getUnsignedInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    public long getUnsignedIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getUnsignedMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getUnsignedMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getUnsignedShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int getUnsignedShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public boolean hasArray() {
        return true;
    }

    public boolean hasMemoryAddress() {
        return EMPTY_BYTE_BUFFER_ADDRESS != 0;
    }

    public int hashCode() {
        return 1;
    }

    public int indexOf(int i, int i2, byte b) {
        checkIndex(i);
        checkIndex(i2);
        return -1;
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        return EMPTY_BYTE_BUFFER;
    }

    public boolean isContiguous() {
        return true;
    }

    public boolean isDirect() {
        return true;
    }

    public boolean isReadOnly() {
        return false;
    }

    public boolean isReadable() {
        return false;
    }

    public boolean isWritable() {
        return false;
    }

    public ByteBuf markReaderIndex() {
        return this;
    }

    public ByteBuf markWriterIndex() {
        return this;
    }

    public int maxCapacity() {
        return 0;
    }

    public int maxWritableBytes() {
        return 0;
    }

    public long memoryAddress() {
        if (hasMemoryAddress()) {
            return EMPTY_BYTE_BUFFER_ADDRESS;
        }
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer() {
        return EMPTY_BYTE_BUFFER;
    }

    public int nioBufferCount() {
        return 1;
    }

    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EMPTY_BYTE_BUFFER};
    }

    public ByteOrder order() {
        return this.order;
    }

    public boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf readBytes(int i) {
        return checkLength(i);
    }

    public char readChar() {
        throw new IndexOutOfBoundsException();
    }

    public CharSequence readCharSequence(int i, Charset charset) {
        checkLength(i);
        return "";
    }

    public double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    public float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    public int readIntLE() {
        throw new IndexOutOfBoundsException();
    }

    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    public long readLongLE() {
        throw new IndexOutOfBoundsException();
    }

    public int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    public int readMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf readRetainedSlice(int i) {
        return checkLength(i);
    }

    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    public short readShortLE() {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf readSlice(int i) {
        return checkLength(i);
    }

    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    public long readUnsignedIntLE() {
        throw new IndexOutOfBoundsException();
    }

    public int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    public int readUnsignedMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    public int readUnsignedShortLE() {
        throw new IndexOutOfBoundsException();
    }

    public int readableBytes() {
        return 0;
    }

    public int readerIndex() {
        return 0;
    }

    public int refCnt() {
        return 1;
    }

    public boolean release() {
        return false;
    }

    public ByteBuf resetReaderIndex() {
        return this;
    }

    public ByteBuf resetWriterIndex() {
        return this;
    }

    public ByteBuf retain() {
        return this;
    }

    public ByteBuf retainedDuplicate() {
        return this;
    }

    public ByteBuf retainedSlice() {
        return this;
    }

    public ByteBuf setBoolean(int i, boolean z) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setByte(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setChar(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setDouble(int i, double d) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setFloat(int i, float f) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setIndex(int i, int i2) {
        checkIndex(i);
        checkIndex(i2);
        return this;
    }

    public ByteBuf setInt(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setIntLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setLong(int i, long j) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setLongLE(int i, long j) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setMedium(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setMediumLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setShort(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setShortLE(int i, int i2) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf setZero(int i, int i2) {
        return checkIndex(i, i2);
    }

    public ByteBuf skipBytes(int i) {
        return checkLength(i);
    }

    public ByteBuf slice() {
        return this;
    }

    public String toString(Charset charset) {
        return "";
    }

    public ByteBuf touch() {
        return this;
    }

    public ByteBuf unwrap() {
        return null;
    }

    public int writableBytes() {
        return 0;
    }

    public ByteBuf writeBoolean(boolean z) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeByte(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.readableBytes());
    }

    public ByteBuf writeChar(int i) {
        throw new IndexOutOfBoundsException();
    }

    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeDouble(double d) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeFloat(float f) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeInt(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeIntLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeLong(long j) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeLongLE(long j) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeMedium(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeMediumLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeShort(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeShortLE(int i) {
        throw new IndexOutOfBoundsException();
    }

    public ByteBuf writeZero(int i) {
        return checkLength(i);
    }

    public int writerIndex() {
        return 0;
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator, ByteOrder byteOrder) {
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.order = byteOrder;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append(byteOrder == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
        this.str = sb.toString();
    }

    private ByteBuf checkIndex(int i, int i2) {
        ObjectUtil.checkPositiveOrZero(i2, "length");
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException();
    }

    public int bytesBefore(int i, byte b) {
        checkLength(i);
        return -1;
    }

    public ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    public int compareTo(ByteBuf byteBuf) {
        return byteBuf.isReadable() ? -1 : 0;
    }

    public ByteBuf copy(int i, int i2) {
        return checkIndex(i, i2);
    }

    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        return -1;
    }

    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        return -1;
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        return checkIndex(i, i2);
    }

    public boolean isReadable(int i) {
        return false;
    }

    public boolean isWritable(int i) {
        return false;
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        return nioBuffer();
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        return nioBuffers();
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (ObjectUtil.checkNotNull(byteOrder, "endianness") == order()) {
            return this;
        }
        EmptyByteBuf emptyByteBuf = this.swapped;
        if (emptyByteBuf != null) {
            return emptyByteBuf;
        }
        EmptyByteBuf emptyByteBuf2 = new EmptyByteBuf(alloc(), byteOrder);
        this.swapped = emptyByteBuf2;
        return emptyByteBuf2;
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        return checkLength(byteBuf.writableBytes());
    }

    public ByteBuf readerIndex(int i) {
        return checkIndex(i);
    }

    public boolean release(int i) {
        return false;
    }

    public ByteBuf retain(int i) {
        return this;
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return checkIndex(i, i2);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        return checkIndex(i, i2);
    }

    public ByteBuf slice(int i, int i2) {
        return checkIndex(i, i2);
    }

    public String toString(int i, int i2, Charset charset) {
        checkIndex(i, i2);
        return toString(charset);
    }

    public ByteBuf touch(Object obj) {
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        return checkLength(i);
    }

    public ByteBuf writerIndex(int i) {
        return checkIndex(i);
    }

    public int bytesBefore(int i, int i2, byte b) {
        checkIndex(i, i2);
        return -1;
    }

    public int ensureWritable(int i, boolean z) {
        ObjectUtil.checkPositiveOrZero(i, "minWritableBytes");
        return i == 0 ? 0 : 1;
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return checkIndex(i, i3);
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i) {
        return checkLength(i);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        return checkIndex(i, i3);
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        return checkLength(i2);
    }

    public ByteBuf getBytes(int i, byte[] bArr) {
        return checkIndex(i, bArr.length);
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        return checkLength(i2);
    }

    public ByteBuf setBytes(int i, byte[] bArr) {
        return checkIndex(i, bArr.length);
    }

    public String toString() {
        return this.str;
    }

    public ByteBuf writeBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        return checkIndex(i, i3);
    }

    public ByteBuf readBytes(byte[] bArr) {
        return checkLength(bArr.length);
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        return checkIndex(i, i3);
    }

    public ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        return checkLength(i2);
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        return checkIndex(i, byteBuffer.remaining());
    }

    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        return checkLength(i2);
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        return checkIndex(i, byteBuffer.remaining());
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        return checkIndex(i, i2);
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        return checkLength(byteBuffer.remaining());
    }

    public int setBytes(int i, InputStream inputStream, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    public int writeBytes(InputStream inputStream, int i) {
        checkLength(i);
        return 0;
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    public ByteBuf readBytes(OutputStream outputStream, int i) {
        return checkLength(i);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) {
        checkLength(i);
        return 0;
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) {
        checkLength(i);
        return 0;
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) {
        checkIndex(i, i2);
        return 0;
    }

    public int writeBytes(FileChannel fileChannel, long j, int i) {
        checkLength(i);
        return 0;
    }

    public int readBytes(FileChannel fileChannel, long j, int i) {
        checkLength(i);
        return 0;
    }
}
