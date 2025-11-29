package io.netty.buffer;

import com.here.posclient.UpdateOptions;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;
import kotlin.UShort;

final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    public static final class Component extends WrappedByteBuf {
        /* access modifiers changed from: private */
        public final int endOffset;
        /* access modifiers changed from: private */
        public final int index;
        /* access modifiers changed from: private */
        public final int offset;

        public Component(int i, int i2, ByteBuf byteBuf) {
            super(byteBuf);
            this.index = i;
            this.offset = i2;
            this.endOffset = i2 + byteBuf.readableBytes();
        }
    }

    public FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        int i = 1;
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = Unpooled.EMPTY_BUFFER.isDirect();
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = byteBufArr;
            int nioBufferCount2 = byteBuf.nioBufferCount();
            int readableBytes = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z = true;
            while (i < byteBufArr.length) {
                ByteBuf byteBuf2 = byteBufArr[i];
                if (byteBuf2.order() == this.order) {
                    nioBufferCount2 += byteBuf2.nioBufferCount();
                    readableBytes += byteBuf2.readableBytes();
                    if (!byteBuf2.isDirect()) {
                        z = false;
                    }
                    i++;
                } else {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
            }
            this.nioBufferCount = nioBufferCount2;
            this.capacity = readableBytes;
            this.direct = z;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    private ByteBuf buffer(int i) {
        ByteBuf byteBuf = this.buffers[i];
        return byteBuf instanceof Component ? ((Component) byteBuf).buf : byteBuf;
    }

    private Component findComponent(int i) {
        Component component;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            ByteBuf[] byteBufArr = this.buffers;
            if (i2 < byteBufArr.length) {
                ByteBuf byteBuf = byteBufArr[i2];
                if (byteBuf instanceof Component) {
                    Component component2 = (Component) byteBuf;
                    component = component2;
                    byteBuf = component2.buf;
                } else {
                    component = null;
                }
                i3 += byteBuf.readableBytes();
                if (i >= i3) {
                    i2++;
                } else if (component != null) {
                    return component;
                } else {
                    Component component3 = new Component(i2, i3 - byteBuf.readableBytes(), byteBuf);
                    this.buffers[i2] = component3;
                    return component3;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public byte _getByte(int i) {
        Component findComponent = findComponent(i);
        return findComponent.buf.getByte(i - findComponent.offset);
    }

    public int _getInt(int i) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            return findComponent.buf.getInt(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i + 2) & UShort.MAX_VALUE) | ((_getShort(i) & UShort.MAX_VALUE) << 16);
        }
        return ((_getShort(i + 2) & UShort.MAX_VALUE) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    public int _getIntLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 4 <= findComponent.endOffset) {
            return findComponent.buf.getIntLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i + 2) & UShort.MAX_VALUE) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getShortLE(i + 2) & UShort.MAX_VALUE) | ((_getShortLE(i) & UShort.MAX_VALUE) << 16);
    }

    public long _getLong(int i) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLong(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (((long) _getInt(i + 4)) & 4294967295L) | ((((long) _getInt(i)) & 4294967295L) << 32);
        }
        return ((((long) _getInt(i + 4)) & 4294967295L) << 32) | (((long) _getInt(i)) & 4294967295L);
    }

    public long _getLongLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 8 <= findComponent.endOffset) {
            return findComponent.buf.getLongLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((((long) _getIntLE(i + 4)) & 4294967295L) << 32) | (((long) _getIntLE(i)) & 4294967295L);
        }
        return (((long) _getIntLE(i + 4)) & 4294967295L) | ((((long) _getIntLE(i)) & 4294967295L) << 32);
    }

    public short _getShort(int i) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShort(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
        }
        return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
    }

    public short _getShortLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 2 <= findComponent.endOffset) {
            return findComponent.buf.getShortLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
        }
        return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
    }

    public int _getUnsignedMedium(int i) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMedium(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i + 2) & 255) | ((_getShort(i) & UShort.MAX_VALUE) << 8);
        }
        return ((_getByte(i + 2) & 255) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    public int _getUnsignedMediumLE(int i) {
        Component findComponent = findComponent(i);
        if (i + 3 <= findComponent.endOffset) {
            return findComponent.buf.getUnsignedMediumLE(i - findComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i + 2) & 255) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getByte(i + 2) & 255) | ((_getShortLE(i) & UShort.MAX_VALUE) << 8);
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
        int length = this.buffers.length;
        if (length == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (length == 1) {
            return buffer(0).array();
        }
        throw new UnsupportedOperationException();
    }

    public int arrayOffset() {
        int length = this.buffers.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return buffer(0).arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    public int capacity() {
        return this.capacity;
    }

    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf buffer = alloc().buffer(i2);
        try {
            buffer.writeBytes((ByteBuf) this, i, i2);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public void deallocate() {
        for (int i = 0; i < this.buffers.length; i++) {
            buffer(i).release();
        }
    }

    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    public byte getByte(int i) {
        return _getByte(i);
    }

    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        Component findComponent = findComponent(i);
        int access$200 = findComponent.index;
        int access$000 = findComponent.offset;
        ByteBuf byteBuf = findComponent.buf;
        while (true) {
            int i4 = i - access$000;
            int min = Math.min(i3, byteBuf.readableBytes() - i4);
            byteBuf.getBytes(i4, bArr, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            access$000 += byteBuf.readableBytes();
            if (i3 <= 0) {
                return this;
            }
            access$200++;
            byteBuf = buffer(access$200);
        }
    }

    public boolean hasArray() {
        int length = this.buffers.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasArray();
    }

    public boolean hasMemoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasMemoryAddress();
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i, i2);
        }
        throw new UnsupportedOperationException();
    }

    public boolean isDirect() {
        return this.direct;
    }

    public boolean isWritable() {
        return false;
    }

    public int maxCapacity() {
        return this.capacity;
    }

    public long memoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (length == 1) {
            return buffer(0).memoryAddress();
        }
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        if (this.buffers.length == 1) {
            ByteBuf buffer = buffer(0);
            if (buffer.nioBufferCount() == 1) {
                return buffer.nioBuffer(i, i2);
            }
        }
        ByteBuffer order2 = ByteBuffer.allocate(i2).order(order());
        ByteBuffer[] nioBuffers = nioBuffers(i, i2);
        for (ByteBuffer put : nioBuffers) {
            order2.put(put);
        }
        order2.flip();
        return order2;
    }

    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component findComponent = findComponent(i);
            int access$200 = findComponent.index;
            int access$000 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i3 = i - access$000;
                int min = Math.min(i2, byteBuf.readableBytes() - i3);
                int nioBufferCount2 = byteBuf.nioBufferCount();
                if (nioBufferCount2 != 0) {
                    if (nioBufferCount2 != 1) {
                        Collections.addAll(newInstance, byteBuf.nioBuffers(i3, min));
                    } else {
                        newInstance.add(byteBuf.nioBuffer(i3, min));
                    }
                    i += min;
                    i2 -= min;
                    access$000 += byteBuf.readableBytes();
                    if (i2 <= 0) {
                        ByteBuffer[] byteBufferArr = (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
                        newInstance.recycle();
                        return byteBufferArr;
                    }
                    access$200++;
                    byteBuf = buffer(access$200);
                } else {
                    throw new UnsupportedOperationException();
                }
            }
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    public ByteOrder order() {
        return this.order;
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

    public ByteBuf setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    public String toString() {
        String abstractByteBuf = super.toString();
        String substring = abstractByteBuf.substring(0, abstractByteBuf.length() - 1);
        return substring + ", components=" + this.buffers.length + ')';
    }

    public ByteBuf unwrap() {
        return null;
    }

    public ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    public boolean isWritable(int i) {
        return false;
    }

    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        throw new ReadOnlyBufferException();
    }

    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, InputStream inputStream, int i2) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        throw new ReadOnlyBufferException();
    }

    public int setBytes(int i, FileChannel fileChannel, long j, int i2) {
        throw new ReadOnlyBufferException();
    }

    /* JADX INFO: finally extract failed */
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        if (remaining == 0) {
            return this;
        }
        try {
            Component findComponent = findComponent(i);
            int access$200 = findComponent.index;
            int access$000 = findComponent.offset;
            ByteBuf byteBuf = findComponent.buf;
            while (true) {
                int i2 = i - access$000;
                int min = Math.min(remaining, byteBuf.readableBytes() - i2);
                byteBuffer.limit(byteBuffer.position() + min);
                byteBuf.getBytes(i2, byteBuffer);
                i += min;
                remaining -= min;
                access$000 += byteBuf.readableBytes();
                if (remaining <= 0) {
                    byteBuffer.limit(limit);
                    return this;
                }
                access$200++;
                byteBuf = buffer(access$200);
            }
        } catch (Throwable th) {
            byteBuffer.limit(limit);
            throw th;
        }
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        Component findComponent = findComponent(i);
        int access$200 = findComponent.index;
        int access$000 = findComponent.offset;
        ByteBuf byteBuf2 = findComponent.buf;
        while (true) {
            int i4 = i - access$000;
            int min = Math.min(i3, byteBuf2.readableBytes() - i4);
            byteBuf2.getBytes(i4, byteBuf, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            access$000 += byteBuf2.readableBytes();
            if (i3 <= 0) {
                return this;
            }
            access$200++;
            byteBuf2 = buffer(access$200);
        }
    }

    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i, i2));
        }
        long write = gatheringByteChannel.write(nioBuffers(i, i2));
        if (write > UpdateOptions.SOURCE_ANY) {
            return Integer.MAX_VALUE;
        }
        return (int) write;
    }

    public int getBytes(int i, FileChannel fileChannel, long j, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i, i2), j);
        }
        long j2 = 0;
        for (ByteBuffer write : nioBuffers(i, i2)) {
            j2 += (long) fileChannel.write(write, j + j2);
        }
        if (j2 > UpdateOptions.SOURCE_ANY) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        Component findComponent = findComponent(i);
        int access$200 = findComponent.index;
        int access$000 = findComponent.offset;
        ByteBuf byteBuf = findComponent.buf;
        while (true) {
            int i3 = i - access$000;
            int min = Math.min(i2, byteBuf.readableBytes() - i3);
            byteBuf.getBytes(i3, outputStream, min);
            i += min;
            i2 -= min;
            access$000 += byteBuf.readableBytes();
            if (i2 <= 0) {
                return this;
            }
            access$200++;
            byteBuf = buffer(access$200);
        }
    }
}
