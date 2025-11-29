package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

final class AdvancedLeakAwareByteBuf extends SimpleLeakAwareByteBuf {
    private static final boolean ACQUIRE_AND_RELEASE_ONLY;
    private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
    private static final InternalLogger logger;

    static {
        Class<AdvancedLeakAwareByteBuf> cls = AdvancedLeakAwareByteBuf.class;
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) cls);
        logger = instance;
        boolean z = SystemPropertyUtil.getBoolean(PROP_ACQUIRE_AND_RELEASE_ONLY, false);
        ACQUIRE_AND_RELEASE_ONLY = z;
        if (instance.isDebugEnabled()) {
            instance.debug("-D{}: {}", PROP_ACQUIRE_AND_RELEASE_ONLY, Boolean.valueOf(z));
        }
        ResourceLeakDetector.addExclusions(cls, "touch", "recordLeakNonRefCountingOperation");
    }

    public AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf, resourceLeakTracker);
    }

    public static void recordLeakNonRefCountingOperation(ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        if (!ACQUIRE_AND_RELEASE_ONLY) {
            resourceLeakTracker.record();
        }
    }

    public ByteBuf asReadOnly() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.asReadOnly();
    }

    public int bytesBefore(byte b) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(b);
    }

    public ByteBuf capacity(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(i);
    }

    public ByteBuf copy() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    public ByteBuf discardReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    public ByteBuf discardSomeReadBytes() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    public ByteBuf duplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    public ByteBuf ensureWritable(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i);
    }

    public int forEachByte(ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor);
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteProcessor);
    }

    public boolean getBoolean(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(i);
    }

    public byte getByte(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(i);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, byteBuf);
    }

    public char getChar(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(i);
    }

    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getCharSequence(i, i2, charset);
    }

    public double getDouble(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(i);
    }

    public float getFloat(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(i);
    }

    public int getInt(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(i);
    }

    public int getIntLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(i);
    }

    public long getLong(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(i);
    }

    public long getLongLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getLongLE(i);
    }

    public int getMedium(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(i);
    }

    public int getMediumLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getMediumLE(i);
    }

    public short getShort(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(i);
    }

    public short getShortLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(i);
    }

    public short getUnsignedByte(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(i);
    }

    public long getUnsignedInt(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(i);
    }

    public long getUnsignedIntLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(i);
    }

    public int getUnsignedMedium(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(i);
    }

    public int getUnsignedMediumLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMediumLE(i);
    }

    public int getUnsignedShort(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(i);
    }

    public int getUnsignedShortLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShortLE(i);
    }

    public int indexOf(int i, int i2, byte b) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(i, i2, b);
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(i, i2);
    }

    public ByteBuffer nioBuffer() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    public int nioBufferCount() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    public ByteBuffer[] nioBuffers() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    public ByteBuf order(ByteOrder byteOrder) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder);
    }

    public boolean readBoolean() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    public byte readByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    public ByteBuf readBytes(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(i);
    }

    public char readChar() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    public CharSequence readCharSequence(int i, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readCharSequence(i, charset);
    }

    public double readDouble() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    public float readFloat() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    public int readInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    public int readIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readIntLE();
    }

    public long readLong() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    public long readLongLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readLongLE();
    }

    public int readMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    public int readMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readMediumLE();
    }

    public ByteBuf readRetainedSlice(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readRetainedSlice(i);
    }

    public short readShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    public short readShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readShortLE();
    }

    public ByteBuf readSlice(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(i);
    }

    public short readUnsignedByte() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    public long readUnsignedInt() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    public long readUnsignedIntLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedIntLE();
    }

    public int readUnsignedMedium() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    public int readUnsignedMediumLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMediumLE();
    }

    public int readUnsignedShort() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    public int readUnsignedShortLE() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShortLE();
    }

    public boolean release() {
        this.leak.record();
        return super.release();
    }

    public ByteBuf retainedDuplicate() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.retainedDuplicate();
    }

    public ByteBuf retainedSlice() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice();
    }

    public ByteBuf setBoolean(int i, boolean z) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(i, z);
    }

    public ByteBuf setByte(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(i, i2);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, byteBuf);
    }

    public ByteBuf setChar(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(i, i2);
    }

    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(i, charSequence, charset);
    }

    public ByteBuf setDouble(int i, double d) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(i, d);
    }

    public ByteBuf setFloat(int i, float f) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(i, f);
    }

    public ByteBuf setInt(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(i, i2);
    }

    public ByteBuf setIntLE(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setIntLE(i, i2);
    }

    public ByteBuf setLong(int i, long j) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(i, j);
    }

    public ByteBuf setLongLE(int i, long j) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setLongLE(i, j);
    }

    public ByteBuf setMedium(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(i, i2);
    }

    public ByteBuf setMediumLE(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setMediumLE(i, i2);
    }

    public ByteBuf setShort(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(i, i2);
    }

    public ByteBuf setShortLE(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setShortLE(i, i2);
    }

    public ByteBuf setZero(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(i, i2);
    }

    public ByteBuf skipBytes(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(i);
    }

    public ByteBuf slice() {
        recordLeakNonRefCountingOperation(this.leak);
        return super.slice();
    }

    public String toString(Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset);
    }

    public ByteBuf writeBoolean(boolean z) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(z);
    }

    public ByteBuf writeByte(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(i);
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf);
    }

    public ByteBuf writeChar(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(i);
    }

    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence, charset);
    }

    public ByteBuf writeDouble(double d) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(d);
    }

    public ByteBuf writeFloat(float f) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f);
    }

    public ByteBuf writeInt(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(i);
    }

    public ByteBuf writeIntLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeIntLE(i);
    }

    public ByteBuf writeLong(long j) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(j);
    }

    public ByteBuf writeLongLE(long j) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeLongLE(j);
    }

    public ByteBuf writeMedium(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(i);
    }

    public ByteBuf writeMediumLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeMediumLE(i);
    }

    public ByteBuf writeShort(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(i);
    }

    public ByteBuf writeShortLE(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeShortLE(i);
    }

    public ByteBuf writeZero(int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(i);
    }

    public AdvancedLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        super(byteBuf, byteBuf2, resourceLeakTracker);
    }

    public AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf, ByteBuf byteBuf2, ResourceLeakTracker<ByteBuf> resourceLeakTracker) {
        return new AdvancedLeakAwareByteBuf(byteBuf, byteBuf2, resourceLeakTracker);
    }

    public int bytesBefore(int i, byte b) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i, b);
    }

    public ByteBuf copy(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.copy(i, i2);
    }

    public int ensureWritable(int i, boolean z) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(i, z);
    }

    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(i, i2, byteProcessor);
    }

    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(i, i2, byteProcessor);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, byteBuf, i2);
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(i, i2);
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(i, i2);
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf);
    }

    public boolean release(int i) {
        this.leak.record();
        return super.release(i);
    }

    public ByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    public ByteBuf retainedSlice(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice(i, i2);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, byteBuf, i2);
    }

    public ByteBuf slice(int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.slice(i, i2);
    }

    public String toString(int i, int i2, Charset charset) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.toString(i, i2, charset);
    }

    public ByteBuf touch() {
        this.leak.record();
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i);
    }

    public ByteBuf touch(Object obj) {
        this.leak.record(obj);
        return this;
    }

    public int bytesBefore(int i, int i2, byte b) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(i, i2, b);
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, byteBuf, i2, i3);
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i);
    }

    public ByteBuf retain(int i) {
        this.leak.record();
        return super.retain(i);
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, byteBuf, i2, i3);
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf, i, i2);
    }

    public ByteBuf getBytes(int i, byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, bArr);
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf, i, i2);
    }

    public ByteBuf setBytes(int i, byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, bArr);
    }

    public ByteBuf writeBytes(byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr);
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, bArr, i2, i3);
    }

    public ByteBuf readBytes(byte[] bArr) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr);
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, bArr, i2, i3);
    }

    public ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(bArr, i, i2);
    }

    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, byteBuffer);
    }

    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(bArr, i, i2);
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, byteBuffer);
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer);
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, outputStream, i2);
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer);
    }

    public int setBytes(int i, InputStream inputStream, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, inputStream, i2);
    }

    public int writeBytes(InputStream inputStream, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream, i);
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, gatheringByteChannel, i2);
    }

    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream, i);
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, scatteringByteChannel, i2);
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel, i);
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(i, fileChannel, j, i2);
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel, i);
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(i, fileChannel, j, i2);
    }

    public int writeBytes(FileChannel fileChannel, long j, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(fileChannel, j, i);
    }

    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(fileChannel, j, i);
    }
}
