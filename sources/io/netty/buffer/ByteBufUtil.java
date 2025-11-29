package io.netty.buffer;

import com.here.posclient.UpdateOptions;
import com.meizu.common.widget.CircularProgressButton;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;
import org.extra.tools.a;

public final class ByteBufUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final FastThreadLocal<byte[]> BYTE_ARRAYS = new FastThreadLocal<byte[]>() {
        public byte[] initialValue() throws Exception {
            return PlatformDependent.allocateUninitializedArray(1024);
        }
    };
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII = new ByteProcessor() {
        public boolean process(byte b) {
            return b >= 0;
        }
    };
    private static final int MAX_BYTES_PER_CHAR_UTF8 = ((int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar());
    private static final int MAX_CHAR_BUFFER_SIZE;
    static final int MAX_TL_ARRAY_LEN = 1024;
    /* access modifiers changed from: private */
    public static final int THREAD_LOCAL_BUFFER_SIZE;
    static final int WRITE_CHUNK_SIZE = 8192;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final InternalLogger logger;

    public static final class SWARByteSearch {
        private SWARByteSearch() {
        }

        /* access modifiers changed from: private */
        public static long compilePattern(byte b) {
            return (((long) b) & 255) * 72340172838076673L;
        }

        /* access modifiers changed from: private */
        public static int firstAnyPattern(long j, long j2, boolean z) {
            long j3 = j ^ j2;
            long j4 = ~(j3 | ((j3 & 9187201950435737471L) + 9187201950435737471L) | 9187201950435737471L);
            return (z ? Long.numberOfLeadingZeros(j4) : Long.numberOfTrailingZeros(j4)) >>> 3;
        }
    }

    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final ObjectPool<ThreadLocalDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalDirectByteBuf>() {
            public ThreadLocalDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalDirectByteBuf> handle;

        public static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.resetRefCnt();
            return threadLocalDirectByteBuf;
        }

        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalDirectByteBuf(ObjectPool.Handle<ThreadLocalDirectByteBuf> handle2) {
            super((ByteBufAllocator) UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle2;
        }
    }

    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final ObjectPool<ThreadLocalUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<ThreadLocalUnsafeDirectByteBuf>() {
            public ThreadLocalUnsafeDirectByteBuf newObject(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        });
        private final ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        public static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.resetRefCnt();
            return threadLocalUnsafeDirectByteBuf;
        }

        public void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalUnsafeDirectByteBuf(ObjectPool.Handle<ThreadLocalUnsafeDirectByteBuf> handle2) {
            super((ByteBufAllocator) UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle2;
        }
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
        logger = instance;
        String trim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(trim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            instance.debug("-Dio.netty.allocator.type: {}", (Object) trim);
        } else if ("pooled".equals(trim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            instance.debug("-Dio.netty.allocator.type: {}", (Object) trim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            instance.debug("-Dio.netty.allocator.type: pooled (unknown: {})", (Object) trim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 0);
        THREAD_LOCAL_BUFFER_SIZE = i;
        instance.debug("-Dio.netty.threadLocalDirectBufferSize: {}", (Object) Integer.valueOf(i));
        int i2 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i2;
        instance.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", (Object) Integer.valueOf(i2));
    }

    private ByteBufUtil() {
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf) {
        appendPrettyHexDump(sb, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static CharSequence checkCharSequenceBounds(CharSequence charSequence, int i, int i2) {
        if (!MathUtil.isOutOfBounds(i, i2 - i, charSequence.length())) {
            return charSequence;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= end (" + i2 + ") <= seq.length(" + charSequence.length() + ')');
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        boolean z = false;
        if (byteBuf == byteBuf2) {
            return 0;
        }
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int min = Math.min(readableBytes, readableBytes2);
        int i = min >>> 2;
        int i2 = min & 3;
        int readerIndex = byteBuf.readerIndex();
        int readerIndex2 = byteBuf2.readerIndex();
        if (i > 0) {
            if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                z = true;
            }
            int i3 = i << 2;
            long compareUintBigEndian = byteBuf.order() == byteBuf2.order() ? z ? compareUintBigEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i3) : compareUintLittleEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i3) : z ? compareUintBigEndianA(byteBuf, byteBuf2, readerIndex, readerIndex2, i3) : compareUintBigEndianB(byteBuf, byteBuf2, readerIndex, readerIndex2, i3);
            if (compareUintBigEndian != 0) {
                return (int) Math.min(UpdateOptions.SOURCE_ANY, Math.max(-2147483648L, compareUintBigEndian));
            }
            readerIndex += i3;
            readerIndex2 += i3;
        }
        int i4 = i2 + readerIndex;
        while (readerIndex < i4) {
            int unsignedByte = byteBuf.getUnsignedByte(readerIndex) - byteBuf2.getUnsignedByte(readerIndex2);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            readerIndex++;
            readerIndex2++;
        }
        return readableBytes - readableBytes2;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long unsignedInt = byteBuf.getUnsignedInt(i) - byteBuf2.getUnsignedInt(i2);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i += 4;
            i2 += 4;
        }
        return 0;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long unsignedInt = byteBuf.getUnsignedInt(i) - uintFromLE(byteBuf2.getUnsignedIntLE(i2));
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i += 4;
            i2 += 4;
        }
        return 0;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long uintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i)) - byteBuf2.getUnsignedInt(i2);
            if (uintFromLE != 0) {
                return uintFromLE;
            }
            i += 4;
            i2 += 4;
        }
        return 0;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            long uintFromLE = uintFromLE(byteBuf.getUnsignedIntLE(i)) - uintFromLE(byteBuf2.getUnsignedIntLE(i2));
            if (uintFromLE != 0) {
                return uintFromLE;
            }
            i += 4;
            i2 += 4;
        }
        return 0;
    }

    public static void copy(AsciiString asciiString, ByteBuf byteBuf) {
        copy(asciiString, 0, byteBuf, asciiString.length());
    }

    public static byte decodeHexByte(CharSequence charSequence, int i) {
        return StringUtil.decodeHexByte(charSequence, i);
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return StringUtil.decodeHexDump(charSequence, 0, charSequence.length());
    }

    public static String decodeString(ByteBuf byteBuf, int i, int i2, Charset charset) {
        int i3;
        byte[] bArr;
        if (i2 == 0) {
            return "";
        }
        if (byteBuf.hasArray()) {
            bArr = byteBuf.array();
            i3 = byteBuf.arrayOffset() + i;
        } else {
            bArr = threadLocalTempArray(i2);
            byteBuf.getBytes(i, bArr, 0, i2);
            i3 = 0;
        }
        return CharsetUtil.US_ASCII.equals(charset) ? new String(bArr, 0, i3, i2) : new String(bArr, i3, i2, charset);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, 0);
    }

    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z, CharBuffer charBuffer, Charset charset, int i) {
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        int remaining = ((int) (((double) charBuffer.remaining()) * ((double) encoder.maxBytesPerChar()))) + i;
        ByteBuf heapBuffer = z ? byteBufAllocator.heapBuffer(remaining) : byteBufAllocator.buffer(remaining);
        try {
            ByteBuffer internalNioBuffer = heapBuffer.internalNioBuffer(heapBuffer.readerIndex(), remaining);
            int position = internalNioBuffer.position();
            CoderResult encode = encoder.encode(charBuffer, internalNioBuffer, true);
            if (!encode.isUnderflow()) {
                encode.throwException();
            }
            CoderResult flush = encoder.flush(internalNioBuffer);
            if (!flush.isUnderflow()) {
                flush.throwException();
            }
            heapBuffer.writerIndex((heapBuffer.writerIndex() + internalNioBuffer.position()) - position);
            return heapBuffer;
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        } catch (Throwable th) {
            heapBuffer.release();
            throw th;
        }
    }

    public static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(byteBuf.refCnt());
    }

    public static boolean ensureWritableSuccess(int i) {
        return i == 0 || i == 2;
    }

    public static boolean equals(ByteBuf byteBuf, int i, ByteBuf byteBuf2, int i2, int i3) {
        ObjectUtil.checkNotNull(byteBuf, a.f3359a);
        ObjectUtil.checkNotNull(byteBuf2, "b");
        ObjectUtil.checkPositiveOrZero(i, "aStartIndex");
        ObjectUtil.checkPositiveOrZero(i2, "bStartIndex");
        ObjectUtil.checkPositiveOrZero(i3, "length");
        if (byteBuf.writerIndex() - i3 < i || byteBuf2.writerIndex() - i3 < i2) {
            return false;
        }
        int i4 = i3 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i4 > 0) {
                if (byteBuf.getLong(i) != byteBuf2.getLong(i2)) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        } else {
            while (i4 > 0) {
                if (byteBuf.getLong(i) != swapLong(byteBuf2.getLong(i2))) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        }
        for (int i5 = i3 & 7; i5 > 0; i5--) {
            if (byteBuf.getByte(i) != byteBuf2.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static int firstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        int max = Math.max(i, 0);
        if (max < i2 && abstractByteBuf.capacity() != 0) {
            int i3 = i2 - max;
            abstractByteBuf.checkIndex(max, i3);
            if (!PlatformDependent.isUnaligned()) {
                return linearFirstIndexOf(abstractByteBuf, max, i2, b);
            }
            int i4 = i3 & 7;
            if (i4 > 0) {
                int unrolledFirstIndexOf = unrolledFirstIndexOf(abstractByteBuf, max, i4, b);
                if (unrolledFirstIndexOf != -1) {
                    return unrolledFirstIndexOf;
                }
                max += i4;
                if (max == i2) {
                    return -1;
                }
            }
            int i5 = i3 >>> 3;
            ByteOrder nativeOrder = ByteOrder.nativeOrder();
            boolean z = true;
            boolean z2 = nativeOrder == abstractByteBuf.order();
            if (nativeOrder != ByteOrder.LITTLE_ENDIAN) {
                z = false;
            }
            long access$200 = SWARByteSearch.compilePattern(b);
            for (int i6 = 0; i6 < i5; i6++) {
                int access$300 = SWARByteSearch.firstAnyPattern(z ? abstractByteBuf._getLongLE(max) : abstractByteBuf._getLong(max), access$200, z2);
                if (access$300 < 8) {
                    return max + access$300;
                }
                max += 8;
            }
        }
        return -1;
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int hashCode(ByteBuf byteBuf) {
        int i;
        int readableBytes = byteBuf.readableBytes();
        int i2 = readableBytes >>> 2;
        int i3 = readableBytes & 3;
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            i = 1;
            while (i2 > 0) {
                i = (i * 31) + byteBuf.getInt(readerIndex);
                readerIndex += 4;
                i2--;
            }
        } else {
            int i4 = 1;
            while (i2 > 0) {
                i4 = (i * 31) + swapInt(byteBuf.getInt(readerIndex));
                readerIndex += 4;
                i2--;
            }
        }
        while (i3 > 0) {
            i = (i * 31) + byteBuf.getByte(readerIndex);
            i3--;
            readerIndex++;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3 = byteBuf;
        ByteBuf byteBuf4 = byteBuf2;
        if (byteBuf4 == null || byteBuf3 == null || byteBuf.readableBytes() > byteBuf2.readableBytes()) {
            return -1;
        }
        int readableBytes = byteBuf2.readableBytes();
        int readableBytes2 = byteBuf.readableBytes();
        if (readableBytes2 == 0) {
            return 0;
        }
        if (readableBytes2 == 1) {
            return byteBuf4.indexOf(byteBuf2.readerIndex(), byteBuf2.writerIndex(), byteBuf3.getByte(byteBuf.readerIndex()));
        }
        int readerIndex = byteBuf.readerIndex();
        int readerIndex2 = byteBuf2.readerIndex();
        long maxSuf = maxSuf(byteBuf3, readableBytes2, readerIndex, true);
        long maxSuf2 = maxSuf(byteBuf3, readableBytes2, readerIndex, false);
        int max = Math.max((int) (maxSuf >> 32), (int) (maxSuf2 >> 32));
        int max2 = Math.max((int) maxSuf, (int) maxSuf2);
        int i = readableBytes2 - max2;
        int i2 = max + 1;
        if (equals(byteBuf3, readerIndex, byteBuf3, readerIndex + max2, Math.min(i, i2))) {
            int i3 = -1;
            int i4 = 0;
            while (i4 <= readableBytes - readableBytes2) {
                int max3 = Math.max(max, i3) + 1;
                while (max3 < readableBytes2 && byteBuf3.getByte(max3 + readerIndex) == byteBuf4.getByte(max3 + i4 + readerIndex2)) {
                    max3++;
                }
                if (max3 > readableBytes) {
                    return -1;
                }
                if (max3 >= readableBytes2) {
                    int i5 = max;
                    while (i5 > i3 && byteBuf3.getByte(i5 + readerIndex) == byteBuf4.getByte(i5 + i4 + readerIndex2)) {
                        i5--;
                    }
                    if (i5 <= i3) {
                        return i4 + readerIndex2;
                    }
                    i4 += max2;
                    i3 = i - 1;
                } else {
                    i4 += max3 - max;
                    i3 = -1;
                }
            }
        } else {
            int max4 = Math.max(i2, (readableBytes2 - max) - 1) + 1;
            int i6 = 0;
            while (i6 <= readableBytes - readableBytes2) {
                int i7 = i2;
                while (i7 < readableBytes2 && byteBuf3.getByte(i7 + readerIndex) == byteBuf4.getByte(i7 + i6 + readerIndex2)) {
                    i7++;
                }
                if (i7 > readableBytes) {
                    return -1;
                }
                if (i7 >= readableBytes2) {
                    int i8 = max;
                    while (i8 >= 0 && byteBuf3.getByte(i8 + readerIndex) == byteBuf4.getByte(i8 + i6 + readerIndex2)) {
                        i8--;
                    }
                    if (i8 < 0) {
                        return i6 + readerIndex2;
                    }
                    i6 += max4;
                } else {
                    i6 += i7 - max;
                }
            }
        }
        return -1;
    }

    public static boolean isAccessible(ByteBuf byteBuf) {
        return byteBuf.isAccessible();
    }

    private static boolean isAscii(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.forEachByte(i, i2, FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int i, int i2) {
        byte b;
        int i3 = i2 + i;
        while (i < i3) {
            int i4 = i + 1;
            byte b2 = byteBuf.getByte(i);
            if ((b2 & 128) == 0) {
                i = i4;
            } else if ((b2 & 224) == 192) {
                if (i4 >= i3) {
                    return false;
                }
                i += 2;
                if ((byteBuf.getByte(i4) & 192) != 128 || (b2 & 255) < 194) {
                    return false;
                }
            } else if ((b2 & 240) == 224) {
                if (i4 > i3 - 2) {
                    return false;
                }
                int i5 = i + 2;
                byte b3 = byteBuf.getByte(i4);
                i += 3;
                byte b4 = byteBuf.getByte(i5);
                if ((b3 & 192) != 128 || (b4 & 192) != 128 || ((b = b2 & 15) == 0 && (b3 & 255) < 160)) {
                    return false;
                }
                if (b == 13 && (b3 & 255) > 159) {
                    return false;
                }
            } else if ((b2 & 248) != 240 || i4 > i3 - 3) {
                return false;
            } else {
                byte b5 = byteBuf.getByte(i4);
                int i6 = i + 3;
                byte b6 = byteBuf.getByte(i + 2);
                i += 4;
                byte b7 = byteBuf.getByte(i6);
                if ((b5 & 192) == 128) {
                    if ((b6 & 192) == 128) {
                        if ((b7 & 192) == 128) {
                            byte b8 = b2 & 255;
                            if (b8 <= 244) {
                                if (b8 == 240) {
                                    if ((b5 & 255) < 144) {
                                    }
                                }
                                if (b8 == 244 && (b5 & 255) > 143) {
                                }
                            }
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static int lastIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        int capacity = abstractByteBuf.capacity();
        int min = Math.min(i, capacity);
        if (min >= 0 && capacity != 0) {
            abstractByteBuf.checkIndex(i2, min - i2);
            for (int i3 = min - 1; i3 >= i2; i3--) {
                if (abstractByteBuf._getByte(i3) == b) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static int linearFirstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        while (i < i2) {
            if (abstractByteBuf._getByte(i) == b) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static long maxSuf(ByteBuf byteBuf, int i, int i2, boolean z) {
        int i3 = -1;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int i6 = i2 + i4;
            if (i6 >= i) {
                return (((long) i3) << 32) + ((long) i5);
            }
            byte b = byteBuf.getByte(i6);
            byte b2 = byteBuf.getByte(i3 + i4);
            if (!z ? b > b2 : b < b2) {
                i5 = i6 - i3;
                i4 = 1;
                i2 = i6;
            } else if (b != b2) {
                i4 = 1;
                i5 = 1;
                i3 = i2;
                i2++;
            } else if (i4 != i5) {
                i4++;
            } else {
                i2 += i5;
                i4 = 1;
            }
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i) {
        ByteBuf buffer = byteBufAllocator.buffer(i);
        try {
            byteBuf.readBytes(buffer);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i) {
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, charSequence.length(), i);
    }

    private static int reserveAndWriteUtf8Seq(ByteBuf byteBuf, CharSequence charSequence, int i, int i2, int i3) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else if (byteBuf instanceof AbstractByteBuf) {
                AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                abstractByteBuf.ensureWritable0(i3);
                int writeUtf8 = writeUtf8(abstractByteBuf, abstractByteBuf.writerIndex, i3, charSequence, i, i2);
                abstractByteBuf.writerIndex += writeUtf8;
                return writeUtf8;
            } else if (byteBuf instanceof WrappedByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                byte[] bytes = charSequence.subSequence(i, i2).toString().getBytes(CharsetUtil.UTF_8);
                byteBuf.writeBytes(bytes);
                return bytes.length;
            }
        }
    }

    private static int safeArrayWriteUtf8(byte[] bArr, int i, CharSequence charSequence, int i2, int i3) {
        int i4 = i;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 128) {
                bArr[i4] = (byte) charAt;
                i4++;
            } else if (charAt < 2048) {
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((charAt >> 6) | 192);
                i4 += 2;
                bArr[i5] = (byte) ((charAt & '?') | 128);
            } else {
                char c = '?';
                if (!StringUtil.isSurrogate(charAt)) {
                    bArr[i4] = (byte) ((charAt >> 12) | 224);
                    int i6 = i4 + 2;
                    bArr[i4 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    i4 += 3;
                    bArr[i6] = (byte) ((charAt & '?') | 128);
                } else if (!Character.isHighSurrogate(charAt)) {
                    bArr[i4] = 63;
                    i4++;
                } else {
                    i2++;
                    if (i2 == i3) {
                        bArr[i4] = 63;
                        i4++;
                        break;
                    }
                    char charAt2 = charSequence.charAt(i2);
                    if (!Character.isLowSurrogate(charAt2)) {
                        int i7 = i4 + 1;
                        bArr[i4] = 63;
                        i4 += 2;
                        if (!Character.isHighSurrogate(charAt2)) {
                            c = charAt2;
                        }
                        bArr[i7] = (byte) c;
                    } else {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        bArr[i4] = (byte) ((codePoint >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL);
                        bArr[i4 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
                        int i8 = i4 + 3;
                        bArr[i4 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
                        i4 += 4;
                        bArr[i8] = (byte) ((codePoint & 63) | 128);
                    }
                }
            }
            i2++;
        }
        return i4 - i;
    }

    private static int safeDirectWriteUtf8(ByteBuffer byteBuffer, int i, CharSequence charSequence, int i2, int i3) {
        int i4 = i;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 128) {
                byteBuffer.put(i4, (byte) charAt);
                i4++;
            } else if (charAt < 2048) {
                int i5 = i4 + 1;
                byteBuffer.put(i4, (byte) ((charAt >> 6) | 192));
                i4 += 2;
                byteBuffer.put(i5, (byte) ((charAt & '?') | 128));
            } else {
                byte b = 63;
                if (!StringUtil.isSurrogate(charAt)) {
                    byteBuffer.put(i4, (byte) ((charAt >> 12) | 224));
                    int i6 = i4 + 2;
                    byteBuffer.put(i4 + 1, (byte) ((63 & (charAt >> 6)) | 128));
                    i4 += 3;
                    byteBuffer.put(i6, (byte) ((charAt & '?') | 128));
                } else if (!Character.isHighSurrogate(charAt)) {
                    byteBuffer.put(i4, (byte) 63);
                    i4++;
                } else {
                    i2++;
                    if (i2 == i3) {
                        byteBuffer.put(i4, (byte) 63);
                        i4++;
                        break;
                    }
                    char charAt2 = charSequence.charAt(i2);
                    if (!Character.isLowSurrogate(charAt2)) {
                        int i7 = i4 + 1;
                        byteBuffer.put(i4, (byte) 63);
                        i4 += 2;
                        if (!Character.isHighSurrogate(charAt2)) {
                            b = (byte) charAt2;
                        }
                        byteBuffer.put(i7, b);
                    } else {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put(i4, (byte) ((codePoint >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                        byteBuffer.put(i4 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i8 = i4 + 3;
                        byteBuffer.put(i4 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i4 += 4;
                        byteBuffer.put(i8, (byte) ((codePoint & 63) | 128));
                    }
                }
            }
            i2++;
        }
        return i4 - i;
    }

    private static int safeWriteUtf8(AbstractByteBuf abstractByteBuf, int i, CharSequence charSequence, int i2, int i3) {
        int i4 = i;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 128) {
                abstractByteBuf._setByte(i4, (byte) charAt);
                i4++;
            } else if (charAt < 2048) {
                int i5 = i4 + 1;
                abstractByteBuf._setByte(i4, (byte) ((charAt >> 6) | 192));
                i4 += 2;
                abstractByteBuf._setByte(i5, (byte) ((charAt & '?') | 128));
            } else {
                char c = '?';
                if (!StringUtil.isSurrogate(charAt)) {
                    abstractByteBuf._setByte(i4, (byte) ((charAt >> 12) | 224));
                    int i6 = i4 + 2;
                    abstractByteBuf._setByte(i4 + 1, (byte) ((63 & (charAt >> 6)) | 128));
                    i4 += 3;
                    abstractByteBuf._setByte(i6, (byte) ((charAt & '?') | 128));
                } else if (!Character.isHighSurrogate(charAt)) {
                    abstractByteBuf._setByte(i4, 63);
                    i4++;
                } else {
                    i2++;
                    if (i2 == i3) {
                        abstractByteBuf._setByte(i4, 63);
                        i4++;
                        break;
                    }
                    char charAt2 = charSequence.charAt(i2);
                    if (!Character.isLowSurrogate(charAt2)) {
                        int i7 = i4 + 1;
                        abstractByteBuf._setByte(i4, 63);
                        i4 += 2;
                        if (!Character.isHighSurrogate(charAt2)) {
                            c = charAt2;
                        }
                        abstractByteBuf._setByte(i7, c);
                    } else {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        abstractByteBuf._setByte(i4, (byte) ((codePoint >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                        abstractByteBuf._setByte(i4 + 1, (byte) (((codePoint >> 12) & 63) | 128));
                        int i8 = i4 + 3;
                        abstractByteBuf._setByte(i4 + 2, (byte) (((codePoint >> 6) & 63) | 128));
                        i4 += 4;
                        abstractByteBuf._setByte(i8, (byte) ((codePoint & 63) | 128));
                    }
                }
            }
            i2++;
        }
        return i4 - i;
    }

    public static ByteBuf setShortBE(ByteBuf byteBuf, int i, int i2) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.setShort(i, i2) : byteBuf.setShort(i, swapShort((short) i2));
    }

    public static int swapInt(int i) {
        return Integer.reverseBytes(i);
    }

    public static long swapLong(long j) {
        return Long.reverseBytes(j);
    }

    public static int swapMedium(int i) {
        int i2 = ((i >>> 16) & 255) | ((i << 16) & 16711680) | (65280 & i);
        return (8388608 & i2) != 0 ? i2 | -16777216 : i2;
    }

    public static short swapShort(short s) {
        return Short.reverseBytes(s);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        return PlatformDependent.hasUnsafe() ? ThreadLocalUnsafeDirectByteBuf.newInstance() : ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] threadLocalTempArray(int i) {
        return i <= 1024 ? BYTE_ARRAYS.get() : PlatformDependent.allocateUninitializedArray(i);
    }

    private static long uintFromLE(long j) {
        return Long.reverseBytes(j) >>> 32;
    }

    private static int unrolledFirstIndexOf(AbstractByteBuf abstractByteBuf, int i, int i2, byte b) {
        if (abstractByteBuf._getByte(i) == b) {
            return i;
        }
        if (i2 == 1) {
            return -1;
        }
        int i3 = i + 1;
        if (abstractByteBuf._getByte(i3) == b) {
            return i3;
        }
        if (i2 == 2) {
            return -1;
        }
        int i4 = i + 2;
        if (abstractByteBuf._getByte(i4) == b) {
            return i4;
        }
        if (i2 == 3) {
            return -1;
        }
        int i5 = i + 3;
        if (abstractByteBuf._getByte(i5) == b) {
            return i5;
        }
        if (i2 == 4) {
            return -1;
        }
        int i6 = i + 4;
        if (abstractByteBuf._getByte(i6) == b) {
            return i6;
        }
        if (i2 == 5) {
            return -1;
        }
        int i7 = i + 5;
        if (abstractByteBuf._getByte(i7) == b) {
            return i7;
        }
        if (i2 == 6) {
            return -1;
        }
        int i8 = i + 6;
        if (abstractByteBuf._getByte(i8) == b) {
            return i8;
        }
        return -1;
    }

    private static int unsafeWriteUtf8(byte[] bArr, long j, int i, CharSequence charSequence, int i2, int i3) {
        long j2;
        byte[] bArr2 = bArr;
        CharSequence charSequence2 = charSequence;
        int i4 = i3;
        long j3 = j + ((long) i);
        int i5 = i2;
        long j4 = j3;
        while (true) {
            if (i5 >= i4) {
                break;
            }
            char charAt = charSequence2.charAt(i5);
            if (charAt < 128) {
                j2 = 1 + j4;
                PlatformDependent.putByte((Object) bArr2, j4, (byte) charAt);
            } else {
                if (charAt < 2048) {
                    long j5 = 1 + j4;
                    PlatformDependent.putByte((Object) bArr2, j4, (byte) ((charAt >> 6) | 192));
                    j4 += 2;
                    PlatformDependent.putByte((Object) bArr2, j5, (byte) ((charAt & '?') | 128));
                } else {
                    char c = '?';
                    if (!StringUtil.isSurrogate(charAt)) {
                        PlatformDependent.putByte((Object) bArr2, j4, (byte) ((charAt >> 12) | 224));
                        long j6 = 2 + j4;
                        PlatformDependent.putByte((Object) bArr2, 1 + j4, (byte) (((charAt >> 6) & 63) | 128));
                        j4 += 3;
                        PlatformDependent.putByte((Object) bArr2, j6, (byte) ((charAt & '?') | 128));
                    } else if (!Character.isHighSurrogate(charAt)) {
                        j2 = 1 + j4;
                        PlatformDependent.putByte((Object) bArr2, j4, (byte) 63);
                    } else {
                        i5++;
                        if (i5 == i4) {
                            PlatformDependent.putByte((Object) bArr2, j4, (byte) 63);
                            j4 = 1 + j4;
                            break;
                        }
                        char charAt2 = charSequence2.charAt(i5);
                        if (!Character.isLowSurrogate(charAt2)) {
                            long j7 = 1 + j4;
                            PlatformDependent.putByte((Object) bArr2, j4, (byte) 63);
                            j4 += 2;
                            if (!Character.isHighSurrogate(charAt2)) {
                                c = charAt2;
                            }
                            PlatformDependent.putByte((Object) bArr2, j7, (byte) c);
                        } else {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            PlatformDependent.putByte((Object) bArr2, j4, (byte) ((codePoint >> 18) | CircularProgressButton.MorphingAnimation.DURATION_NORMAL));
                            PlatformDependent.putByte((Object) bArr2, 1 + j4, (byte) (((codePoint >> 12) & 63) | 128));
                            long j8 = 3 + j4;
                            PlatformDependent.putByte((Object) bArr2, 2 + j4, (byte) (((codePoint >> 6) & 63) | 128));
                            j4 += 4;
                            PlatformDependent.putByte((Object) bArr2, j8, (byte) ((codePoint & 63) | 128));
                        }
                    }
                }
                i5++;
            }
            j4 = j2;
            i5++;
        }
        return (int) (j4 - j3);
    }

    private static int utf8ByteCount(CharSequence charSequence, int i, int i2) {
        if (charSequence instanceof AsciiString) {
            return i2 - i;
        }
        int i3 = i;
        while (i3 < i2 && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = i3 - i;
        return i3 < i2 ? i4 + utf8BytesNonAscii(charSequence, i3, i2) : i4;
    }

    public static int utf8Bytes(CharSequence charSequence) {
        return utf8ByteCount(charSequence, 0, charSequence.length());
    }

    private static int utf8BytesNonAscii(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i3 += ((127 - charAt) >>> 31) + 1;
            } else if (!StringUtil.isSurrogate(charAt)) {
                i3 += 3;
            } else if (!Character.isHighSurrogate(charAt)) {
                i3++;
            } else {
                i++;
                if (i == i2) {
                    return i3 + 1;
                }
                i3 = !Character.isLowSurrogate(charSequence.charAt(i)) ? i3 + 2 : i3 + 4;
            }
            i++;
        }
        return i3;
    }

    public static int utf8MaxBytes(int i) {
        return i * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(charSequence.length());
        writeAscii(buffer, charSequence);
        return buffer;
    }

    public static void writeAsciiString(AbstractByteBuf abstractByteBuf, int i, AsciiString asciiString, int i2, int i3) {
        int arrayOffset = asciiString.arrayOffset() + i2;
        int i4 = i3 - i2;
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                PlatformDependent.copyMemory(asciiString.array(), arrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i, (long) i4);
                return;
            } else if (abstractByteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(asciiString.array(), arrayOffset, abstractByteBuf.memoryAddress() + ((long) i), (long) i4);
                return;
            }
        }
        if (abstractByteBuf.hasArray()) {
            System.arraycopy(asciiString.array(), arrayOffset, abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i, i4);
        } else {
            abstractByteBuf.setBytes(i, asciiString.array(), arrayOffset, i4);
        }
    }

    public static ByteBuf writeMediumBE(ByteBuf byteBuf, int i) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeMedium(i) : byteBuf.writeMedium(swapMedium(i));
    }

    public static ByteBuf writeShortBE(ByteBuf byteBuf, int i) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.writeShort(i) : byteBuf.writeShort(swapShort((short) i));
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(utf8MaxBytes(charSequence));
        writeUtf8(buffer, charSequence);
        return buffer;
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
        HexUtil.appendPrettyHexDump(sb, byteBuf, i, i2);
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2, int i3) {
        if (!MathUtil.isOutOfBounds(i, i3, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i2, asciiString.array(), i + asciiString.arrayOffset(), i3);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i, int i2) {
        return StringUtil.decodeHexDump(charSequence, i, i2);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset, int i) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, i);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2) {
        return getBytes(byteBuf, i, i2, true);
    }

    public static String hexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.hexDump(byteBuf, i, i2);
    }

    public static boolean isText(ByteBuf byteBuf, int i, int i2, Charset charset) {
        ByteBuf heapBuffer;
        ObjectUtil.checkNotNull(byteBuf, "buf");
        ObjectUtil.checkNotNull(charset, "charset");
        int readerIndex = byteBuf.readerIndex() + byteBuf.readableBytes();
        if (i < 0 || i2 < 0 || i > readerIndex - i2) {
            throw new IndexOutOfBoundsException("index: " + i + " length: " + i2);
        } else if (charset.equals(CharsetUtil.UTF_8)) {
            return isUtf8(byteBuf, i, i2);
        } else {
            if (charset.equals(CharsetUtil.US_ASCII)) {
                return isAscii(byteBuf, i, i2);
            }
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            CharsetDecoder decoder = CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
            try {
                if (byteBuf.nioBufferCount() == 1) {
                    decoder.decode(byteBuf.nioBuffer(i, i2));
                } else {
                    heapBuffer = byteBuf.alloc().heapBuffer(i2);
                    heapBuffer.writeBytes(byteBuf, i, i2);
                    decoder.decode(heapBuffer.internalNioBuffer(heapBuffer.readerIndex(), i2));
                    heapBuffer.release();
                }
                return true;
            } catch (CharacterCodingException unused) {
                return false;
            } catch (Throwable th) {
                heapBuffer.release();
                throw th;
            }
        }
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.prettyHexDump(byteBuf, i, i2);
    }

    public static int reserveAndWriteUtf8(ByteBuf byteBuf, CharSequence charSequence, int i, int i2, int i3) {
        return reserveAndWriteUtf8Seq(byteBuf, checkCharSequenceBounds(charSequence, i, i2), i, i2, i3);
    }

    public static int utf8Bytes(CharSequence charSequence, int i, int i2) {
        return utf8ByteCount(checkCharSequenceBounds(charSequence, i, i2), i, i2);
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return utf8MaxBytes(charSequence.length());
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2, boolean z) {
        int capacity = byteBuf.capacity();
        if (MathUtil.isOutOfBounds(i, i2, capacity)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= buf.capacity(" + capacity + ')');
        } else if (byteBuf.hasArray()) {
            int arrayOffset = byteBuf.arrayOffset() + i;
            byte[] array = byteBuf.array();
            if (!z && arrayOffset == 0 && i2 == array.length) {
                return array;
            }
            return Arrays.copyOfRange(array, arrayOffset, i2 + arrayOffset);
        } else {
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i2);
            byteBuf.getBytes(i, allocateUninitializedArray);
            return allocateUninitializedArray;
        }
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        while (true) {
            if (byteBuf instanceof WrappedCompositeByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else if (byteBuf instanceof AbstractByteBuf) {
                int length = charSequence.length();
                AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
                abstractByteBuf.ensureWritable0(length);
                if (charSequence instanceof AsciiString) {
                    writeAsciiString(abstractByteBuf, abstractByteBuf.writerIndex, (AsciiString) charSequence, 0, length);
                } else {
                    writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
                }
                abstractByteBuf.writerIndex += length;
                return length;
            } else if (byteBuf instanceof WrappedByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                byte[] bytes = charSequence.toString().getBytes(CharsetUtil.US_ASCII);
                byteBuf.writeBytes(bytes);
                return bytes.length;
            }
        }
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, 0, length, utf8MaxBytes(length));
    }

    public static String hexDump(byte[] bArr, int i, int i2) {
        return HexUtil.hexDump(bArr, i, i2);
    }

    public static void readBytes(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer, int i, int i2, OutputStream outputStream) throws IOException {
        if (byteBuffer.hasArray()) {
            outputStream.write(byteBuffer.array(), i + byteBuffer.arrayOffset(), i2);
            return;
        }
        int min = Math.min(i2, 8192);
        byteBuffer.clear().position(i);
        if (i2 <= 1024 || !byteBufAllocator.isDirectBufferPooled()) {
            getBytes(byteBuffer, threadLocalTempArray(min), 0, min, outputStream, i2);
            return;
        }
        ByteBuf heapBuffer = byteBufAllocator.heapBuffer(min);
        try {
            getBytes(byteBuffer, heapBuffer.array(), heapBuffer.arrayOffset(), min, outputStream, i2);
        } finally {
            heapBuffer.release();
        }
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence, int i, int i2) {
        checkCharSequenceBounds(charSequence, i, i2);
        return reserveAndWriteUtf8Seq(byteBuf, charSequence, i, i2, utf8MaxBytes(i2 - i));
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2) {
        if (!MathUtil.isOutOfBounds(i, i2, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i + asciiString.arrayOffset(), i2);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i2 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i = 0;
            for (int i2 = 0; i2 < 256; i2++) {
                char[] cArr = HEXDUMP_TABLE;
                int i3 = i2 << 1;
                cArr[i3] = charArray[(i2 >>> 4) & 15];
                cArr[i3 + 1] = charArray[i2 & 15];
            }
            int i4 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i4 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i4;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i5 = 0; i5 < length; i5++) {
                    sb.append("   ");
                }
                HEXPADDING[i4] = sb.toString();
                i4++;
            }
            int i6 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i6 >= strArr2.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString((((long) (i6 << 4)) & 4294967295L) | 4294967296L));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                strArr2[i6] = sb2.toString();
                i6++;
            }
            int i7 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i7 >= strArr3.length) {
                    break;
                }
                strArr3[i7] = ' ' + StringUtil.byteToHexStringPadded(i7);
                i7++;
            }
            int i8 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i8 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i8;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i9 = 0; i9 < length2; i9++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i8] = sb3.toString();
                i8++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i < cArr2.length) {
                    if (i <= 31 || i >= 127) {
                        cArr2[i] = '.';
                    } else {
                        cArr2[i] = (char) i;
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        private HexUtil() {
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb, int i, int i2) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i < strArr.length) {
                sb.append(strArr[i]);
                return;
            }
            sb.append(StringUtil.NEWLINE);
            sb.append(Long.toHexString((((long) i2) & 4294967295L) | 4294967296L));
            sb.setCharAt(sb.length() - 9, '|');
            sb.append('|');
        }

        /* access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
            if (MathUtil.isOutOfBounds(i, i2, byteBuf.capacity())) {
                throw new IndexOutOfBoundsException("expected: 0 <= offset(" + i + ") <= offset + length(" + i2 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
            } else if (i2 != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("         +-------------------------------------------------+");
                String str = StringUtil.NEWLINE;
                sb2.append(str);
                sb2.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
                sb2.append(str);
                sb2.append("+--------+-------------------------------------------------+----------------+");
                sb.append(sb2.toString());
                int i3 = i2 >>> 4;
                int i4 = i2 & 15;
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = (i5 << 4) + i;
                    appendHexDumpRowPrefix(sb, i5, i6);
                    int i7 = i6 + 16;
                    for (int i8 = i6; i8 < i7; i8++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i8)]);
                    }
                    sb.append(" |");
                    while (i6 < i7) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i6)]);
                        i6++;
                    }
                    sb.append('|');
                }
                if (i4 != 0) {
                    int i9 = (i3 << 4) + i;
                    appendHexDumpRowPrefix(sb, i3, i9);
                    int i10 = i9 + i4;
                    for (int i11 = i9; i11 < i10; i11++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i11)]);
                    }
                    sb.append(HEXPADDING[i4]);
                    sb.append(" |");
                    while (i9 < i10) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i9)]);
                        i9++;
                    }
                    sb.append(BYTEPADDING[i4]);
                    sb.append('|');
                }
                sb.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
            }
        }

        /* access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i, int i2) {
            ObjectUtil.checkPositiveOrZero(i2, "length");
            if (i2 == 0) {
                return "";
            }
            int i3 = i + i2;
            char[] cArr = new char[(i2 << 1)];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }

        /* access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
            if (i2 == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(((i2 / 16) + ((i2 & 15) == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb, byteBuf, i, i2);
            return sb.toString();
        }

        /* access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i, int i2) {
            ObjectUtil.checkPositiveOrZero(i2, "length");
            if (i2 == 0) {
                return "";
            }
            int i3 = i + i2;
            char[] cArr = new char[(i2 << 1)];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i] & 255) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i, int i2, CharSequence charSequence, int i3) {
        return writeUtf8(abstractByteBuf, i, i2, charSequence, 0, i3);
    }

    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (charSequence instanceof AsciiString) {
            writeAsciiString(abstractByteBuf, i, (AsciiString) charSequence, i3, i4);
            return i4 - i3;
        }
        if (PlatformDependent.hasUnsafe()) {
            if (abstractByteBuf.hasArray()) {
                return unsafeWriteUtf8(abstractByteBuf.array(), PlatformDependent.byteArrayBaseOffset(), abstractByteBuf.arrayOffset() + i, charSequence, i3, i4);
            }
            if (abstractByteBuf.hasMemoryAddress()) {
                return unsafeWriteUtf8((byte[]) null, abstractByteBuf.memoryAddress(), i, charSequence, i3, i4);
            }
        } else if (abstractByteBuf.hasArray()) {
            return safeArrayWriteUtf8(abstractByteBuf.array(), abstractByteBuf.arrayOffset() + i, charSequence, i3, i4);
        } else {
            if (abstractByteBuf.isDirect()) {
                ByteBuffer internalNioBuffer = abstractByteBuf.internalNioBuffer(i, i2);
                return safeDirectWriteUtf8(internalNioBuffer, internalNioBuffer.position(), charSequence, i3, i4);
            }
        }
        return safeWriteUtf8(abstractByteBuf, i, charSequence, i3, i4);
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == byteBuf2) {
            return true;
        }
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), readableBytes);
    }

    private static void getBytes(ByteBuffer byteBuffer, byte[] bArr, int i, int i2, OutputStream outputStream, int i3) throws IOException {
        do {
            int min = Math.min(i2, i3);
            byteBuffer.get(bArr, i, min);
            outputStream.write(bArr, i, min);
            i3 -= min;
        } while (i3 > 0);
    }

    public static int writeAscii(AbstractByteBuf abstractByteBuf, int i, CharSequence charSequence, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            abstractByteBuf._setByte(i, AsciiString.c2b(charSequence.charAt(i3)));
            i3++;
            i++;
        }
        return i2;
    }

    public static int indexOf(ByteBuf byteBuf, int i, int i2, byte b) {
        return byteBuf.indexOf(i, i2, b);
    }
}
