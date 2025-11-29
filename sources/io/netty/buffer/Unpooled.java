package io.netty.buffer;

import io.netty.buffer.CompositeByteBuf;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;

    static {
        UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        ALLOC = unpooledByteBufAllocator;
        EMPTY_BUFFER = unpooledByteBufAllocator.buffer(0, 0);
    }

    private Unpooled() {
    }

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static CompositeByteBuf compositeBuffer() {
        return compositeBuffer(16);
    }

    public static ByteBuf copiedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return wrappedBuffer((byte[]) bArr.clone());
    }

    private static ByteBuf copiedBufferAscii(CharSequence charSequence) {
        ByteBuf heapBuffer = ALLOC.heapBuffer(charSequence.length());
        try {
            ByteBufUtil.writeAscii(heapBuffer, charSequence);
            return heapBuffer;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    private static ByteBuf copiedBufferUtf8(CharSequence charSequence) {
        ByteBuf heapBuffer = ALLOC.heapBuffer(ByteBufUtil.utf8Bytes(charSequence));
        try {
            ByteBufUtil.writeUtf8(heapBuffer, charSequence);
            return heapBuffer;
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    public static ByteBuf copyBoolean(boolean z) {
        ByteBuf buffer = buffer(1);
        buffer.writeBoolean(z);
        return buffer;
    }

    public static ByteBuf copyDouble(double d) {
        ByteBuf buffer = buffer(8);
        buffer.writeDouble(d);
        return buffer;
    }

    public static ByteBuf copyFloat(float f) {
        ByteBuf buffer = buffer(4);
        buffer.writeFloat(f);
        return buffer;
    }

    public static ByteBuf copyInt(int i) {
        ByteBuf buffer = buffer(4);
        buffer.writeInt(i);
        return buffer;
    }

    public static ByteBuf copyLong(long j) {
        ByteBuf buffer = buffer(8);
        buffer.writeLong(j);
        return buffer;
    }

    public static ByteBuf copyMedium(int i) {
        ByteBuf buffer = buffer(3);
        buffer.writeMedium(i);
        return buffer;
    }

    public static ByteBuf copyShort(int i) {
        ByteBuf buffer = buffer(2);
        buffer.writeShort(i);
        return buffer;
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder order = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        if (order == byteOrder) {
            return new ReadOnlyByteBuf(byteBuf);
        }
        return new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    public static ByteBuf wrappedUnmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(false, byteBufArr);
    }

    public static ByteBuf buffer(int i) {
        return ALLOC.heapBuffer(i);
    }

    public static CompositeByteBuf compositeBuffer(int i) {
        return new CompositeByteBuf(ALLOC, false, i);
    }

    public static ByteBuf directBuffer(int i) {
        return ALLOC.directBuffer(i);
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static io.netty.buffer.ByteBuf wrappedUnmodifiableBuffer(boolean r2, io.netty.buffer.ByteBuf... r3) {
        /*
            int r0 = r3.length
            if (r0 == 0) goto L_0x0022
            r1 = 1
            if (r0 == r1) goto L_0x001a
            if (r2 == 0) goto L_0x0012
            int r2 = r3.length
            java.lang.Class<io.netty.buffer.ByteBuf[]> r0 = io.netty.buffer.ByteBuf[].class
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r2, r0)
            r3 = r2
            io.netty.buffer.ByteBuf[] r3 = (io.netty.buffer.ByteBuf[]) r3
        L_0x0012:
            io.netty.buffer.FixedCompositeByteBuf r2 = new io.netty.buffer.FixedCompositeByteBuf
            io.netty.buffer.ByteBufAllocator r0 = ALLOC
            r2.<init>(r0, r3)
            return r2
        L_0x001a:
            r2 = 0
            r2 = r3[r2]
            io.netty.buffer.ByteBuf r2 = r2.asReadOnly()
            return r2
        L_0x0022:
            io.netty.buffer.ByteBuf r2 = EMPTY_BUFFER
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.Unpooled.wrappedUnmodifiableBuffer(boolean, io.netty.buffer.ByteBuf[]):io.netty.buffer.ByteBuf");
    }

    public static ByteBuf buffer(int i, int i2) {
        return ALLOC.heapBuffer(i, i2);
    }

    public static ByteBuf copyBoolean(boolean... zArr) {
        if (zArr == null || zArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(zArr.length);
        for (boolean writeBoolean : zArr) {
            buffer.writeBoolean(writeBoolean);
        }
        return buffer;
    }

    public static ByteBuf copyDouble(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(dArr.length * 8);
        for (double writeDouble : dArr) {
            buffer.writeDouble(writeDouble);
        }
        return buffer;
    }

    public static ByteBuf copyFloat(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(fArr.length * 4);
        for (float writeFloat : fArr) {
            buffer.writeFloat(writeFloat);
        }
        return buffer;
    }

    public static ByteBuf copyInt(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(iArr.length * 4);
        for (int writeInt : iArr) {
            buffer.writeInt(writeInt);
        }
        return buffer;
    }

    public static ByteBuf copyLong(long... jArr) {
        if (jArr == null || jArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(jArr.length * 8);
        for (long writeLong : jArr) {
            buffer.writeLong(writeLong);
        }
        return buffer;
    }

    public static ByteBuf copyMedium(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(iArr.length * 3);
        for (int writeMedium : iArr) {
            buffer.writeMedium(writeMedium);
        }
        return buffer;
    }

    public static ByteBuf copyShort(short... sArr) {
        if (sArr == null || sArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(sArr.length * 2);
        for (short writeShort : sArr) {
            buffer.writeShort(writeShort);
        }
        return buffer;
    }

    public static ByteBuf directBuffer(int i, int i2) {
        return ALLOC.directBuffer(i, i2);
    }

    public static ByteBuf copiedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i2);
        System.arraycopy(bArr, i, allocateUninitializedArray, 0, i2);
        return wrappedBuffer(allocateUninitializedArray);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (i == 0 && i2 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i, i2);
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf... byteBufArr) {
        return wrappedUnmodifiableBuffer(true, byteBufArr);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(remaining);
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.get(allocateUninitializedArray);
        return wrappedBuffer(allocateUninitializedArray).order(duplicate.order());
    }

    public static ByteBuf copyShort(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(iArr.length * 2);
        for (int writeShort : iArr) {
            buffer.writeShort(writeShort);
        }
        return buffer;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!byteBuffer.isDirect() && byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (!byteBuffer.isReadOnly()) {
                return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
            }
            if (byteBuffer.isDirect()) {
                return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
            }
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        } else if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        } else {
            return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes <= 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf buffer = buffer(readableBytes);
        buffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
        return buffer;
    }

    public static ByteBuf copiedBuffer(byte[]... bArr) {
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length != 1) {
            int length2 = bArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length2) {
                byte[] bArr2 = bArr[i];
                if (Integer.MAX_VALUE - i2 >= bArr2.length) {
                    i2 += bArr2.length;
                    i++;
                } else {
                    throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                }
            }
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i2);
            int i3 = 0;
            for (byte[] bArr3 : bArr) {
                System.arraycopy(bArr3, 0, allocateUninitializedArray, i3, bArr3.length);
                i3 += bArr3.length;
            }
            return wrappedBuffer(allocateUninitializedArray);
        }
        byte[] bArr4 = bArr[0];
        if (bArr4.length == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(bArr4);
    }

    public static ByteBuf wrappedBuffer(long j, int i, boolean z) {
        return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, j, i, z);
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(bArr.length, bArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuf... byteBufArr) {
        return wrappedBuffer(byteBufArr.length, byteBufArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer... byteBufferArr) {
        return wrappedBuffer(byteBufferArr.length, byteBufferArr);
    }

    public static <T> ByteBuf wrappedBuffer(int i, CompositeByteBuf.ByteWrapper<T> byteWrapper, T[] tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                int length2 = tArr.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    T t = tArr[i2];
                    if (t == null) {
                        return EMPTY_BUFFER;
                    }
                    if (!byteWrapper.isEmpty(t)) {
                        return new CompositeByteBuf(ALLOC, false, i, byteWrapper, tArr, i2);
                    }
                }
            } else if (!byteWrapper.isEmpty(tArr[0])) {
                return byteWrapper.wrap(tArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(byteBufArr[0]);
        }
        ByteOrder byteOrder = null;
        int i = 0;
        for (ByteBuf byteBuf : byteBufArr) {
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes > 0) {
                if (Integer.MAX_VALUE - i >= readableBytes) {
                    i += readableBytes;
                    if (byteOrder == null) {
                        byteOrder = byteBuf.order();
                    } else if (!byteOrder.equals(byteBuf.order())) {
                        throw new IllegalArgumentException("inconsistent byte order");
                    }
                } else {
                    throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                }
            }
        }
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i);
        int i2 = 0;
        for (ByteBuf byteBuf2 : byteBufArr) {
            int readableBytes2 = byteBuf2.readableBytes();
            byteBuf2.getBytes(byteBuf2.readerIndex(), allocateUninitializedArray, i2, readableBytes2);
            i2 += readableBytes2;
        }
        return wrappedBuffer(allocateUninitializedArray).order(byteOrder);
    }

    public static ByteBuf wrappedBuffer(int i, byte[]... bArr) {
        return wrappedBuffer(i, CompositeByteBuf.BYTE_ARRAY_WRAPPER, (T[]) bArr);
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length != 1) {
                for (int i2 = 0; i2 < byteBufArr.length; i2++) {
                    ByteBuf byteBuf = byteBufArr[i2];
                    if (byteBuf.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, i, byteBufArr, i2);
                    }
                    byteBuf.release();
                }
            } else {
                ByteBuf byteBuf2 = byteBufArr[0];
                if (byteBuf2.isReadable()) {
                    return wrappedBuffer(byteBuf2.order(BIG_ENDIAN));
                }
                byteBuf2.release();
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(byteBufferArr[0]);
        }
        ByteOrder byteOrder = null;
        int i = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                if (Integer.MAX_VALUE - i >= remaining) {
                    i += remaining;
                    if (byteOrder == null) {
                        byteOrder = byteBuffer.order();
                    } else if (!byteOrder.equals(byteBuffer.order())) {
                        throw new IllegalArgumentException("inconsistent byte order");
                    }
                } else {
                    throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                }
            }
        }
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i);
        int i2 = 0;
        for (ByteBuffer duplicate : byteBufferArr) {
            ByteBuffer duplicate2 = duplicate.duplicate();
            int remaining2 = duplicate2.remaining();
            duplicate2.get(allocateUninitializedArray, i2, remaining2);
            i2 += remaining2;
        }
        return wrappedBuffer(allocateUninitializedArray).order(byteOrder);
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuffer... byteBufferArr) {
        return wrappedBuffer(i, CompositeByteBuf.BYTE_BUFFER_WRAPPER, (T[]) byteBufferArr);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        ObjectUtil.checkNotNull(charSequence, "string");
        if (CharsetUtil.UTF_8.equals(charset)) {
            return copiedBufferUtf8(charSequence);
        }
        if (CharsetUtil.US_ASCII.equals(charset)) {
            return copiedBufferAscii(charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return copiedBuffer((CharBuffer) charSequence, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence), charset);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        ObjectUtil.checkNotNull(charSequence, "string");
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (!(charSequence instanceof CharBuffer)) {
            return copiedBuffer(CharBuffer.wrap(charSequence, i, i2 + i), charset);
        }
        CharBuffer charBuffer = (CharBuffer) charSequence;
        if (charBuffer.hasArray()) {
            return copiedBuffer(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, i2, charset);
        }
        CharBuffer slice = charBuffer.slice();
        slice.limit(i2);
        slice.position(i);
        return copiedBuffer(slice, charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, Charset charset) {
        ObjectUtil.checkNotNull(cArr, "array");
        return copiedBuffer(cArr, 0, cArr.length, charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        ObjectUtil.checkNotNull(cArr, "array");
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(CharBuffer.wrap(cArr, i, i2), charset);
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset, 0);
    }
}
