package io.netty.buffer;

import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
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
import kotlin.UShort;

public abstract class AbstractByteBuf extends ByteBuf {
    private static final String LEGACY_PROP_CHECK_ACCESSIBLE = "io.netty.buffer.bytebuf.checkAccessible";
    private static final String PROP_CHECK_ACCESSIBLE = "io.netty.buffer.checkAccessible";
    private static final String PROP_CHECK_BOUNDS = "io.netty.buffer.checkBounds";
    static final boolean checkAccessible;
    private static final boolean checkBounds;
    static final ResourceLeakDetector<ByteBuf> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ByteBuf.class);
    private static final InternalLogger logger;
    private int markedReaderIndex;
    private int markedWriterIndex;
    private int maxCapacity;
    int readerIndex;
    int writerIndex;

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) AbstractByteBuf.class);
        logger = instance;
        if (SystemPropertyUtil.contains(PROP_CHECK_ACCESSIBLE)) {
            checkAccessible = SystemPropertyUtil.getBoolean(PROP_CHECK_ACCESSIBLE, true);
        } else {
            checkAccessible = SystemPropertyUtil.getBoolean(LEGACY_PROP_CHECK_ACCESSIBLE, true);
        }
        boolean z = SystemPropertyUtil.getBoolean(PROP_CHECK_BOUNDS, true);
        checkBounds = z;
        if (instance.isDebugEnabled()) {
            instance.debug("-D{}: {}", PROP_CHECK_ACCESSIBLE, Boolean.valueOf(checkAccessible));
            instance.debug("-D{}: {}", PROP_CHECK_BOUNDS, Boolean.valueOf(z));
        }
    }

    public AbstractByteBuf(int i) {
        ObjectUtil.checkPositiveOrZero(i, "maxCapacity");
        this.maxCapacity = i;
    }

    private static void checkIndexBounds(int i, int i2, int i3) {
        if (i < 0 || i > i2 || i2 > i3) {
            throw new IndexOutOfBoundsException(String.format("readerIndex: %d, writerIndex: %d (expected: 0 <= readerIndex <= writerIndex <= capacity(%d))", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
    }

    private static void checkRangeBounds(String str, int i, int i2, int i3) {
        if (MathUtil.isOutOfBounds(i, i2, i3)) {
            throw new IndexOutOfBoundsException(String.format("%s: %d, length: %d (expected: range(0, %d))", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
    }

    private static void checkReadableBounds(ByteBuf byteBuf, int i) {
        if (i > byteBuf.readableBytes()) {
            throw new IndexOutOfBoundsException(String.format("length(%d) exceeds src.readableBytes(%d) where src is: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(byteBuf.readableBytes()), byteBuf}));
        }
    }

    private void checkReadableBytes0(int i) {
        ensureAccessible();
        if (checkBounds && this.readerIndex > this.writerIndex - i) {
            throw new IndexOutOfBoundsException(String.format("readerIndex(%d) + length(%d) exceeds writerIndex(%d): %s", new Object[]{Integer.valueOf(this.readerIndex), Integer.valueOf(i), Integer.valueOf(this.writerIndex), this}));
        }
    }

    private int setCharSequence0(int i, CharSequence charSequence, Charset charset, boolean z) {
        if (charset.equals(CharsetUtil.UTF_8)) {
            int utf8MaxBytes = ByteBufUtil.utf8MaxBytes(charSequence);
            if (z) {
                ensureWritable0(utf8MaxBytes);
                checkIndex0(i, utf8MaxBytes);
            } else {
                checkIndex(i, utf8MaxBytes);
            }
            return ByteBufUtil.writeUtf8(this, i, utf8MaxBytes, charSequence, charSequence.length());
        } else if (charset.equals(CharsetUtil.US_ASCII) || charset.equals(CharsetUtil.ISO_8859_1)) {
            int length = charSequence.length();
            if (z) {
                ensureWritable0(length);
                checkIndex0(i, length);
            } else {
                checkIndex(i, length);
            }
            return ByteBufUtil.writeAscii(this, i, charSequence, length);
        } else {
            byte[] bytes = charSequence.toString().getBytes(charset);
            if (z) {
                ensureWritable0(bytes.length);
            }
            setBytes(i, bytes);
            return bytes.length;
        }
    }

    public abstract byte _getByte(int i);

    public abstract int _getInt(int i);

    public abstract int _getIntLE(int i);

    public abstract long _getLong(int i);

    public abstract long _getLongLE(int i);

    public abstract short _getShort(int i);

    public abstract short _getShortLE(int i);

    public abstract int _getUnsignedMedium(int i);

    public abstract int _getUnsignedMediumLE(int i);

    public abstract void _setByte(int i, int i2);

    public abstract void _setInt(int i, int i2);

    public abstract void _setIntLE(int i, int i2);

    public abstract void _setLong(int i, long j);

    public abstract void _setLongLE(int i, long j);

    public abstract void _setMedium(int i, int i2);

    public abstract void _setMediumLE(int i, int i2);

    public abstract void _setShort(int i, int i2);

    public abstract void _setShortLE(int i, int i2);

    public final void adjustMarkers(int i) {
        int i2 = this.markedReaderIndex;
        if (i2 <= i) {
            this.markedReaderIndex = 0;
            int i3 = this.markedWriterIndex;
            if (i3 <= i) {
                this.markedWriterIndex = 0;
            } else {
                this.markedWriterIndex = i3 - i;
            }
        } else {
            this.markedReaderIndex = i2 - i;
            this.markedWriterIndex -= i;
        }
    }

    public ByteBuf asReadOnly() {
        return isReadOnly() ? this : Unpooled.unmodifiableBuffer((ByteBuf) this);
    }

    public int bytesBefore(byte b) {
        return bytesBefore(readerIndex(), readableBytes(), b);
    }

    public final void checkDstIndex(int i, int i2, int i3, int i4) {
        checkIndex(i, i2);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i3, i2, i4);
        }
    }

    public final void checkIndex(int i) {
        checkIndex(i, 1);
    }

    public final void checkIndex0(int i, int i2) {
        if (checkBounds) {
            checkRangeBounds("index", i, i2, capacity());
        }
    }

    public final void checkNewCapacity(int i) {
        ensureAccessible();
        if (!checkBounds) {
            return;
        }
        if (i < 0 || i > maxCapacity()) {
            throw new IllegalArgumentException("newCapacity: " + i + " (expected: 0-" + maxCapacity() + ')');
        }
    }

    public final void checkReadableBytes(int i) {
        checkReadableBytes0(ObjectUtil.checkPositiveOrZero(i, "minimumReadableBytes"));
    }

    public final void checkSrcIndex(int i, int i2, int i3, int i4) {
        checkIndex(i, i2);
        if (checkBounds) {
            checkRangeBounds("srcIndex", i3, i2, i4);
        }
    }

    public ByteBuf clear() {
        this.writerIndex = 0;
        this.readerIndex = 0;
        return this;
    }

    public ByteBuf copy() {
        return copy(this.readerIndex, readableBytes());
    }

    public final void discardMarks() {
        this.markedWriterIndex = 0;
        this.markedReaderIndex = 0;
    }

    public ByteBuf discardReadBytes() {
        int i = this.readerIndex;
        if (i == 0) {
            ensureAccessible();
            return this;
        }
        int i2 = this.writerIndex;
        if (i != i2) {
            setBytes(0, (ByteBuf) this, i, i2 - i);
            int i3 = this.writerIndex;
            int i4 = this.readerIndex;
            this.writerIndex = i3 - i4;
            adjustMarkers(i4);
            this.readerIndex = 0;
        } else {
            ensureAccessible();
            adjustMarkers(this.readerIndex);
            this.readerIndex = 0;
            this.writerIndex = 0;
        }
        return this;
    }

    public ByteBuf discardSomeReadBytes() {
        int i = this.readerIndex;
        if (i > 0) {
            if (i == this.writerIndex) {
                ensureAccessible();
                adjustMarkers(this.readerIndex);
                this.readerIndex = 0;
                this.writerIndex = 0;
                return this;
            } else if (i >= (capacity() >>> 1)) {
                int i2 = this.readerIndex;
                setBytes(0, (ByteBuf) this, i2, this.writerIndex - i2);
                int i3 = this.writerIndex;
                int i4 = this.readerIndex;
                this.writerIndex = i3 - i4;
                adjustMarkers(i4);
                this.readerIndex = 0;
                return this;
            }
        }
        ensureAccessible();
        return this;
    }

    public ByteBuf duplicate() {
        ensureAccessible();
        return new UnpooledDuplicatedByteBuf(this);
    }

    public final void ensureAccessible() {
        if (checkAccessible && !isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
    }

    public ByteBuf ensureWritable(int i) {
        ensureWritable0(ObjectUtil.checkPositiveOrZero(i, "minWritableBytes"));
        return this;
    }

    public final void ensureWritable0(int i) {
        int writerIndex2 = writerIndex();
        int i2 = writerIndex2 + i;
        boolean z = false;
        boolean z2 = i2 >= 0;
        if (i2 <= capacity()) {
            z = true;
        }
        if (z && z2) {
            ensureAccessible();
        } else if (!checkBounds || (i2 >= 0 && i2 <= this.maxCapacity)) {
            int maxFastWritableBytes = maxFastWritableBytes();
            capacity(maxFastWritableBytes >= i ? writerIndex2 + maxFastWritableBytes : alloc().calculateNewCapacity(i2, this.maxCapacity));
        } else {
            ensureAccessible();
            throw new IndexOutOfBoundsException(String.format("writerIndex(%d) + minWritableBytes(%d) exceeds maxCapacity(%d): %s", new Object[]{Integer.valueOf(writerIndex2), Integer.valueOf(i), Integer.valueOf(this.maxCapacity), this}));
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ByteBuf) && ByteBufUtil.equals(this, (ByteBuf) obj);
    }

    public int forEachByte(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteAsc0(this.readerIndex, this.writerIndex, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    public int forEachByteAsc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        while (i < i2) {
            if (!byteProcessor.process(_getByte(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) {
        ensureAccessible();
        try {
            return forEachByteDesc0(this.writerIndex - 1, this.readerIndex, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    public int forEachByteDesc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        while (i >= i2) {
            if (!byteProcessor.process(_getByte(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public boolean getBoolean(int i) {
        return getByte(i) != 0;
    }

    public byte getByte(int i) {
        checkIndex(i);
        return _getByte(i);
    }

    public ByteBuf getBytes(int i, byte[] bArr) {
        getBytes(i, bArr, 0, bArr.length);
        return this;
    }

    public char getChar(int i) {
        return (char) getShort(i);
    }

    public CharSequence getCharSequence(int i, int i2, Charset charset) {
        return (CharsetUtil.US_ASCII.equals(charset) || CharsetUtil.ISO_8859_1.equals(charset)) ? new AsciiString(ByteBufUtil.getBytes(this, i, i2, true), false) : toString(i, i2, charset);
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public int getInt(int i) {
        checkIndex(i, 4);
        return _getInt(i);
    }

    public int getIntLE(int i) {
        checkIndex(i, 4);
        return _getIntLE(i);
    }

    public long getLong(int i) {
        checkIndex(i, 8);
        return _getLong(i);
    }

    public long getLongLE(int i) {
        checkIndex(i, 8);
        return _getLongLE(i);
    }

    public int getMedium(int i) {
        int unsignedMedium = getUnsignedMedium(i);
        return (8388608 & unsignedMedium) != 0 ? unsignedMedium | -16777216 : unsignedMedium;
    }

    public int getMediumLE(int i) {
        int unsignedMediumLE = getUnsignedMediumLE(i);
        return (8388608 & unsignedMediumLE) != 0 ? unsignedMediumLE | -16777216 : unsignedMediumLE;
    }

    public short getShort(int i) {
        checkIndex(i, 2);
        return _getShort(i);
    }

    public short getShortLE(int i) {
        checkIndex(i, 2);
        return _getShortLE(i);
    }

    public short getUnsignedByte(int i) {
        return (short) (getByte(i) & 255);
    }

    public long getUnsignedInt(int i) {
        return ((long) getInt(i)) & 4294967295L;
    }

    public long getUnsignedIntLE(int i) {
        return ((long) getIntLE(i)) & 4294967295L;
    }

    public int getUnsignedMedium(int i) {
        checkIndex(i, 3);
        return _getUnsignedMedium(i);
    }

    public int getUnsignedMediumLE(int i) {
        checkIndex(i, 3);
        return _getUnsignedMediumLE(i);
    }

    public int getUnsignedShort(int i) {
        return getShort(i) & UShort.MAX_VALUE;
    }

    public int getUnsignedShortLE(int i) {
        return getShortLE(i) & UShort.MAX_VALUE;
    }

    public int hashCode() {
        return ByteBufUtil.hashCode(this);
    }

    public int indexOf(int i, int i2, byte b) {
        return i <= i2 ? ByteBufUtil.firstIndexOf(this, i, i2, b) : ByteBufUtil.lastIndexOf(this, i, i2, b);
    }

    public boolean isReadOnly() {
        return false;
    }

    public boolean isReadable() {
        return this.writerIndex > this.readerIndex;
    }

    public boolean isWritable() {
        return capacity() > this.writerIndex;
    }

    public ByteBuf markReaderIndex() {
        this.markedReaderIndex = this.readerIndex;
        return this;
    }

    public ByteBuf markWriterIndex() {
        this.markedWriterIndex = this.writerIndex;
        return this;
    }

    public int maxCapacity() {
        return this.maxCapacity;
    }

    public int maxWritableBytes() {
        return maxCapacity() - this.writerIndex;
    }

    public SwappedByteBuf newSwappedByteBuf() {
        return new SwappedByteBuf(this);
    }

    public ByteBuffer nioBuffer() {
        return nioBuffer(this.readerIndex, readableBytes());
    }

    public ByteBuffer[] nioBuffers() {
        return nioBuffers(this.readerIndex, readableBytes());
    }

    public ByteBuf order(ByteOrder byteOrder) {
        if (byteOrder == order()) {
            return this;
        }
        ObjectUtil.checkNotNull(byteOrder, "endianness");
        return newSwappedByteBuf();
    }

    public boolean readBoolean() {
        return readByte() != 0;
    }

    public byte readByte() {
        checkReadableBytes0(1);
        int i = this.readerIndex;
        byte _getByte = _getByte(i);
        this.readerIndex = i + 1;
        return _getByte;
    }

    public ByteBuf readBytes(int i) {
        checkReadableBytes(i);
        if (i == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf buffer = alloc().buffer(i, this.maxCapacity);
        buffer.writeBytes((ByteBuf) this, this.readerIndex, i);
        this.readerIndex += i;
        return buffer;
    }

    public char readChar() {
        return (char) readShort();
    }

    public CharSequence readCharSequence(int i, Charset charset) {
        CharSequence charSequence = getCharSequence(this.readerIndex, i, charset);
        this.readerIndex += i;
        return charSequence;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        checkReadableBytes0(4);
        int _getInt = _getInt(this.readerIndex);
        this.readerIndex += 4;
        return _getInt;
    }

    public int readIntLE() {
        checkReadableBytes0(4);
        int _getIntLE = _getIntLE(this.readerIndex);
        this.readerIndex += 4;
        return _getIntLE;
    }

    public long readLong() {
        checkReadableBytes0(8);
        long _getLong = _getLong(this.readerIndex);
        this.readerIndex += 8;
        return _getLong;
    }

    public long readLongLE() {
        checkReadableBytes0(8);
        long _getLongLE = _getLongLE(this.readerIndex);
        this.readerIndex += 8;
        return _getLongLE;
    }

    public int readMedium() {
        int readUnsignedMedium = readUnsignedMedium();
        return (8388608 & readUnsignedMedium) != 0 ? readUnsignedMedium | -16777216 : readUnsignedMedium;
    }

    public int readMediumLE() {
        int readUnsignedMediumLE = readUnsignedMediumLE();
        return (8388608 & readUnsignedMediumLE) != 0 ? readUnsignedMediumLE | -16777216 : readUnsignedMediumLE;
    }

    public ByteBuf readRetainedSlice(int i) {
        checkReadableBytes(i);
        ByteBuf retainedSlice = retainedSlice(this.readerIndex, i);
        this.readerIndex += i;
        return retainedSlice;
    }

    public short readShort() {
        checkReadableBytes0(2);
        short _getShort = _getShort(this.readerIndex);
        this.readerIndex += 2;
        return _getShort;
    }

    public short readShortLE() {
        checkReadableBytes0(2);
        short _getShortLE = _getShortLE(this.readerIndex);
        this.readerIndex += 2;
        return _getShortLE;
    }

    public ByteBuf readSlice(int i) {
        checkReadableBytes(i);
        ByteBuf slice = slice(this.readerIndex, i);
        this.readerIndex += i;
        return slice;
    }

    public short readUnsignedByte() {
        return (short) (readByte() & 255);
    }

    public long readUnsignedInt() {
        return ((long) readInt()) & 4294967295L;
    }

    public long readUnsignedIntLE() {
        return ((long) readIntLE()) & 4294967295L;
    }

    public int readUnsignedMedium() {
        checkReadableBytes0(3);
        int _getUnsignedMedium = _getUnsignedMedium(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMedium;
    }

    public int readUnsignedMediumLE() {
        checkReadableBytes0(3);
        int _getUnsignedMediumLE = _getUnsignedMediumLE(this.readerIndex);
        this.readerIndex += 3;
        return _getUnsignedMediumLE;
    }

    public int readUnsignedShort() {
        return readShort() & UShort.MAX_VALUE;
    }

    public int readUnsignedShortLE() {
        return readShortLE() & UShort.MAX_VALUE;
    }

    public int readableBytes() {
        return this.writerIndex - this.readerIndex;
    }

    public int readerIndex() {
        return this.readerIndex;
    }

    public ByteBuf resetReaderIndex() {
        readerIndex(this.markedReaderIndex);
        return this;
    }

    public ByteBuf resetWriterIndex() {
        writerIndex(this.markedWriterIndex);
        return this;
    }

    public ByteBuf retainedDuplicate() {
        return duplicate().retain();
    }

    public ByteBuf retainedSlice() {
        return slice().retain();
    }

    public ByteBuf setBoolean(int i, boolean z) {
        setByte(i, z ? 1 : 0);
        return this;
    }

    public ByteBuf setByte(int i, int i2) {
        checkIndex(i);
        _setByte(i, i2);
        return this;
    }

    public ByteBuf setBytes(int i, byte[] bArr) {
        setBytes(i, bArr, 0, bArr.length);
        return this;
    }

    public ByteBuf setChar(int i, int i2) {
        setShort(i, i2);
        return this;
    }

    public int setCharSequence(int i, CharSequence charSequence, Charset charset) {
        return setCharSequence0(i, charSequence, charset, false);
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
        if (checkBounds) {
            checkIndexBounds(i, i2, capacity());
        }
        setIndex0(i, i2);
        return this;
    }

    public final void setIndex0(int i, int i2) {
        this.readerIndex = i;
        this.writerIndex = i2;
    }

    public ByteBuf setInt(int i, int i2) {
        checkIndex(i, 4);
        _setInt(i, i2);
        return this;
    }

    public ByteBuf setIntLE(int i, int i2) {
        checkIndex(i, 4);
        _setIntLE(i, i2);
        return this;
    }

    public ByteBuf setLong(int i, long j) {
        checkIndex(i, 8);
        _setLong(i, j);
        return this;
    }

    public ByteBuf setLongLE(int i, long j) {
        checkIndex(i, 8);
        _setLongLE(i, j);
        return this;
    }

    public ByteBuf setMedium(int i, int i2) {
        checkIndex(i, 3);
        _setMedium(i, i2);
        return this;
    }

    public ByteBuf setMediumLE(int i, int i2) {
        checkIndex(i, 3);
        _setMediumLE(i, i2);
        return this;
    }

    public ByteBuf setShort(int i, int i2) {
        checkIndex(i, 2);
        _setShort(i, i2);
        return this;
    }

    public ByteBuf setShortLE(int i, int i2) {
        checkIndex(i, 2);
        _setShortLE(i, i2);
        return this;
    }

    public ByteBuf setZero(int i, int i2) {
        if (i2 == 0) {
            return this;
        }
        checkIndex(i, i2);
        int i3 = i2 & 7;
        for (int i4 = i2 >>> 3; i4 > 0; i4--) {
            _setLong(i, 0);
            i += 8;
        }
        if (i3 == 4) {
            _setInt(i, 0);
        } else if (i3 < 4) {
            while (i3 > 0) {
                _setByte(i, 0);
                i++;
                i3--;
            }
        } else {
            _setInt(i, 0);
            int i5 = i + 4;
            for (int i6 = i3 - 4; i6 > 0; i6--) {
                _setByte(i5, 0);
                i5++;
            }
        }
        return this;
    }

    public ByteBuf skipBytes(int i) {
        checkReadableBytes(i);
        this.readerIndex += i;
        return this;
    }

    public ByteBuf slice() {
        return slice(this.readerIndex, readableBytes());
    }

    public String toString(Charset charset) {
        return toString(this.readerIndex, readableBytes(), charset);
    }

    public final void trimIndicesToCapacity(int i) {
        if (writerIndex() > i) {
            setIndex0(Math.min(readerIndex(), i), i);
        }
    }

    public int writableBytes() {
        return capacity() - this.writerIndex;
    }

    public ByteBuf writeBoolean(boolean z) {
        writeByte(z ? 1 : 0);
        return this;
    }

    public ByteBuf writeByte(int i) {
        ensureWritable0(1);
        int i2 = this.writerIndex;
        this.writerIndex = i2 + 1;
        _setByte(i2, i);
        return this;
    }

    public ByteBuf writeBytes(byte[] bArr, int i, int i2) {
        ensureWritable(i2);
        setBytes(this.writerIndex, bArr, i, i2);
        this.writerIndex += i2;
        return this;
    }

    public ByteBuf writeChar(int i) {
        writeShort(i);
        return this;
    }

    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        int charSequence0 = setCharSequence0(this.writerIndex, charSequence, charset, true);
        this.writerIndex += charSequence0;
        return charSequence0;
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
        ensureWritable0(4);
        _setInt(this.writerIndex, i);
        this.writerIndex += 4;
        return this;
    }

    public ByteBuf writeIntLE(int i) {
        ensureWritable0(4);
        _setIntLE(this.writerIndex, i);
        this.writerIndex += 4;
        return this;
    }

    public ByteBuf writeLong(long j) {
        ensureWritable0(8);
        _setLong(this.writerIndex, j);
        this.writerIndex += 8;
        return this;
    }

    public ByteBuf writeLongLE(long j) {
        ensureWritable0(8);
        _setLongLE(this.writerIndex, j);
        this.writerIndex += 8;
        return this;
    }

    public ByteBuf writeMedium(int i) {
        ensureWritable0(3);
        _setMedium(this.writerIndex, i);
        this.writerIndex += 3;
        return this;
    }

    public ByteBuf writeMediumLE(int i) {
        ensureWritable0(3);
        _setMediumLE(this.writerIndex, i);
        this.writerIndex += 3;
        return this;
    }

    public ByteBuf writeShort(int i) {
        ensureWritable0(2);
        _setShort(this.writerIndex, i);
        this.writerIndex += 2;
        return this;
    }

    public ByteBuf writeShortLE(int i) {
        ensureWritable0(2);
        _setShortLE(this.writerIndex, i);
        this.writerIndex += 2;
        return this;
    }

    public ByteBuf writeZero(int i) {
        int i2;
        if (i == 0) {
            return this;
        }
        ensureWritable(i);
        int i3 = this.writerIndex;
        checkIndex0(i3, i);
        int i4 = i & 7;
        for (int i5 = i >>> 3; i5 > 0; i5--) {
            _setLong(i3, 0);
            i3 += 8;
        }
        if (i4 == 4) {
            _setInt(i3, 0);
            i2 = i3 + 4;
        } else if (i4 < 4) {
            while (i4 > 0) {
                _setByte(i2, 0);
                i3 = i2 + 1;
                i4--;
            }
        } else {
            _setInt(i3, 0);
            i2 = i3 + 4;
            for (int i6 = i4 - 4; i6 > 0; i6--) {
                _setByte(i2, 0);
                i2++;
            }
        }
        this.writerIndex = i2;
        return this;
    }

    public int writerIndex() {
        return this.writerIndex;
    }

    public int bytesBefore(int i, byte b) {
        checkReadableBytes(i);
        return bytesBefore(readerIndex(), i, b);
    }

    public final void checkIndex(int i, int i2) {
        ensureAccessible();
        checkIndex0(i, i2);
    }

    public int compareTo(ByteBuf byteBuf) {
        return ByteBufUtil.compare(this, byteBuf);
    }

    public int ensureWritable(int i, boolean z) {
        int i2;
        ensureAccessible();
        ObjectUtil.checkPositiveOrZero(i, "minWritableBytes");
        if (i <= writableBytes()) {
            return 0;
        }
        int maxCapacity2 = maxCapacity();
        int writerIndex2 = writerIndex();
        if (i <= maxCapacity2 - writerIndex2) {
            int maxFastWritableBytes = maxFastWritableBytes();
            if (maxFastWritableBytes >= i) {
                i2 = writerIndex2 + maxFastWritableBytes;
            } else {
                i2 = alloc().calculateNewCapacity(writerIndex2 + i, maxCapacity2);
            }
            capacity(i2);
            return 2;
        } else if (!z || capacity() == maxCapacity2) {
            return 1;
        } else {
            capacity(maxCapacity2);
            return 3;
        }
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf) {
        getBytes(i, byteBuf, byteBuf.writableBytes());
        return this;
    }

    public boolean isReadable(int i) {
        return this.writerIndex - this.readerIndex >= i;
    }

    public boolean isWritable(int i) {
        return capacity() - this.writerIndex >= i;
    }

    public final void maxCapacity(int i) {
        this.maxCapacity = i;
    }

    public ByteBuf readerIndex(int i) {
        if (checkBounds) {
            checkIndexBounds(i, this.writerIndex, capacity());
        }
        this.readerIndex = i;
        return this;
    }

    public ByteBuf retainedSlice(int i, int i2) {
        return slice(i, i2).retain();
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf) {
        setBytes(i, byteBuf, byteBuf.readableBytes());
        return this;
    }

    public ByteBuf slice(int i, int i2) {
        ensureAccessible();
        return new UnpooledSlicedByteBuf(this, i, i2);
    }

    public String toString(int i, int i2, Charset charset) {
        return ByteBufUtil.decodeString(this, i, i2, charset);
    }

    public ByteBuf writerIndex(int i) {
        if (checkBounds) {
            checkIndexBounds(this.readerIndex, i, capacity());
        }
        this.writerIndex = i;
        return this;
    }

    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        getBytes(i, byteBuf, byteBuf.writerIndex(), i2);
        byteBuf.writerIndex(byteBuf.writerIndex() + i2);
        return this;
    }

    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        checkIndex(i, i2);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (checkBounds) {
            checkReadableBounds(byteBuf, i2);
        }
        setBytes(i, byteBuf, byteBuf.readerIndex(), i2);
        byteBuf.readerIndex(byteBuf.readerIndex() + i2);
        return this;
    }

    public String toString() {
        if (refCnt() == 0) {
            return StringUtil.simpleClassName((Object) this) + "(freed)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName((Object) this));
        sb.append("(ridx: ");
        sb.append(this.readerIndex);
        sb.append(", widx: ");
        sb.append(this.writerIndex);
        sb.append(", cap: ");
        sb.append(capacity());
        if (this.maxCapacity != Integer.MAX_VALUE) {
            sb.append('/');
            sb.append(this.maxCapacity);
        }
        ByteBuf unwrap = unwrap();
        if (unwrap != null) {
            sb.append(", unwrapped: ");
            sb.append(unwrap);
        }
        sb.append(')');
        return sb.toString();
    }

    public int bytesBefore(int i, int i2, byte b) {
        int indexOf = indexOf(i, i2 + i, b);
        if (indexOf < 0) {
            return -1;
        }
        return indexOf - i;
    }

    public final void checkDstIndex(int i, int i2, int i3) {
        checkReadableBytes(i);
        if (checkBounds) {
            checkRangeBounds("dstIndex", i2, i, i3);
        }
    }

    public int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        try {
            return forEachByteAsc0(i, i2 + i, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    public int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        checkIndex(i, i2);
        try {
            return forEachByteDesc0((i2 + i) - 1, i, byteProcessor);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return -1;
        }
    }

    public ByteBuf writeBytes(byte[] bArr) {
        writeBytes(bArr, 0, bArr.length);
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf) {
        writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    public ByteBuf readBytes(byte[] bArr, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, bArr, i, i2);
        this.readerIndex += i2;
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i) {
        if (checkBounds) {
            checkReadableBounds(byteBuf, i);
        }
        writeBytes(byteBuf, byteBuf.readerIndex(), i);
        byteBuf.readerIndex(byteBuf.readerIndex() + i);
        return this;
    }

    public ByteBuf readBytes(byte[] bArr) {
        readBytes(bArr, 0, bArr.length);
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf) {
        readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    public ByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        ensureWritable(i2);
        setBytes(this.writerIndex, byteBuf, i, i2);
        this.writerIndex += i2;
        return this;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i) {
        if (!checkBounds || i <= byteBuf.writableBytes()) {
            readBytes(byteBuf, byteBuf.writerIndex(), i);
            byteBuf.writerIndex(byteBuf.writerIndex() + i);
            return this;
        }
        throw new IndexOutOfBoundsException(String.format("length(%d) exceeds dst.writableBytes(%d) where dst is: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(byteBuf.writableBytes()), byteBuf}));
    }

    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        ensureWritable0(remaining);
        setBytes(this.writerIndex, byteBuffer);
        this.writerIndex += remaining;
        return this;
    }

    public int writeBytes(InputStream inputStream, int i) throws IOException {
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, inputStream, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public ByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        checkReadableBytes(i2);
        getBytes(this.readerIndex, byteBuf, i, i2);
        this.readerIndex += i2;
        return this;
    }

    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i) throws IOException {
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, scatteringByteChannel, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        checkReadableBytes(remaining);
        getBytes(this.readerIndex, byteBuffer);
        this.readerIndex += remaining;
        return this;
    }

    public int writeBytes(FileChannel fileChannel, long j, int i) throws IOException {
        ensureWritable(i);
        int bytes = setBytes(this.writerIndex, fileChannel, j, i);
        if (bytes > 0) {
            this.writerIndex += bytes;
        }
        return bytes;
    }

    public int readBytes(GatheringByteChannel gatheringByteChannel, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, gatheringByteChannel, i);
        this.readerIndex += bytes;
        return bytes;
    }

    public int readBytes(FileChannel fileChannel, long j, int i) throws IOException {
        checkReadableBytes(i);
        int bytes = getBytes(this.readerIndex, fileChannel, j, i);
        this.readerIndex += bytes;
        return bytes;
    }

    public ByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        checkReadableBytes(i);
        getBytes(this.readerIndex, outputStream, i);
        this.readerIndex += i;
        return this;
    }
}
