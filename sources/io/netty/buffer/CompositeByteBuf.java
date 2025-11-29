package io.netty.buffer;

import com.here.posclient.UpdateOptions;
import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.UShort;

public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable<ByteBuf> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final ByteWrapper<byte[]> BYTE_ARRAY_WRAPPER = new ByteWrapper<byte[]>() {
        public boolean isEmpty(byte[] bArr) {
            return bArr.length == 0;
        }

        public ByteBuf wrap(byte[] bArr) {
            return Unpooled.wrappedBuffer(bArr);
        }
    };
    static final ByteWrapper<ByteBuffer> BYTE_BUFFER_WRAPPER = new ByteWrapper<ByteBuffer>() {
        public boolean isEmpty(ByteBuffer byteBuffer) {
            return !byteBuffer.hasRemaining();
        }

        public ByteBuf wrap(ByteBuffer byteBuffer) {
            return Unpooled.wrappedBuffer(byteBuffer);
        }
    };
    private static final Iterator<ByteBuf> EMPTY_ITERATOR = Collections.emptyList().iterator();
    private static final ByteBuffer EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
    private final ByteBufAllocator alloc;
    private int componentCount;
    /* access modifiers changed from: private */
    public Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;

    public interface ByteWrapper<T> {
        boolean isEmpty(T t);

        ByteBuf wrap(T t);
    }

    public static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        /* access modifiers changed from: private */
        public ByteBuf slice;
        int srcAdjustment;
        final ByteBuf srcBuf;

        public Component(ByteBuf byteBuf, int i, ByteBuf byteBuf2, int i2, int i3, int i4, ByteBuf byteBuf3) {
            this.srcBuf = byteBuf;
            this.srcAdjustment = i - i3;
            this.buf = byteBuf2;
            this.adjustment = i2 - i3;
            this.offset = i3;
            this.endOffset = i3 + i4;
            this.slice = byteBuf3;
        }

        public ByteBuf duplicate() {
            return this.srcBuf.duplicate();
        }

        public void free() {
            this.slice = null;
            this.srcBuf.release();
        }

        public int idx(int i) {
            return i + this.adjustment;
        }

        public ByteBuffer internalNioBuffer(int i, int i2) {
            return this.srcBuf.internalNioBuffer(srcIdx(i), i2);
        }

        public int length() {
            return this.endOffset - this.offset;
        }

        public void reposition(int i) {
            int i2 = i - this.offset;
            this.endOffset += i2;
            this.srcAdjustment -= i2;
            this.adjustment -= i2;
            this.offset = i;
        }

        public ByteBuf slice() {
            ByteBuf byteBuf = this.slice;
            if (byteBuf != null) {
                return byteBuf;
            }
            ByteBuf slice2 = this.srcBuf.slice(srcIdx(this.offset), length());
            this.slice = slice2;
            return slice2;
        }

        public int srcIdx(int i) {
            return i + this.srcAdjustment;
        }

        public void transferTo(ByteBuf byteBuf) {
            byteBuf.writeBytes(this.buf, idx(this.offset), length());
            free();
        }
    }

    public final class CompositeByteBufIterator implements Iterator<ByteBuf> {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = CompositeByteBuf.this.numComponents();
        }

        public boolean hasNext() {
            return this.size > this.index;
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }

        public ByteBuf next() {
            if (this.size != CompositeByteBuf.this.numComponents()) {
                throw new ConcurrentModificationException();
            } else if (hasNext()) {
                try {
                    Component[] access$200 = CompositeByteBuf.this.components;
                    int i = this.index;
                    this.index = i + 1;
                    return access$200[i].slice();
                } catch (IndexOutOfBoundsException unused) {
                    throw new ConcurrentModificationException();
                }
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, int i2) {
        super(Integer.MAX_VALUE);
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        if (i >= 1) {
            this.direct = z;
            this.maxNumComponents = i;
            this.components = newCompArray(i2, i);
            return;
        }
        throw new IllegalArgumentException("maxNumComponents: " + i + " (expected: >= 1)");
    }

    private void addComp(int i, Component component) {
        shiftComps(i, 1);
        this.components[i] = component;
    }

    private int addComponent0(boolean z, int i, ByteBuf byteBuf) {
        try {
            checkComponentIndex(i);
            Component newComponent = newComponent(ensureAccessible(byteBuf), 0);
            int length = newComponent.length();
            checkForOverflow(capacity(), length);
            addComp(i, newComponent);
            if (length > 0 && i < this.componentCount - 1) {
                updateComponentOffsets(i);
            } else if (i > 0) {
                newComponent.reposition(this.components[i - 1].endOffset);
            }
            if (z) {
                this.writerIndex += length;
            }
            return i;
        } catch (Throwable th) {
            if (0 == 0) {
                byteBuf.release();
            }
            throw th;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private io.netty.buffer.CompositeByteBuf addComponents0(boolean r8, int r9, io.netty.buffer.ByteBuf[] r10, int r11) {
        /*
            r7 = this;
            int r0 = r10.length
            int r1 = r0 - r11
            int r2 = r7.capacity()
            r3 = 0
            r4 = r11
            r5 = r3
        L_0x000a:
            int r6 = r10.length
            if (r4 >= r6) goto L_0x001d
            r6 = r10[r4]
            if (r6 != 0) goto L_0x0012
            goto L_0x001d
        L_0x0012:
            int r6 = r6.readableBytes()
            int r5 = r5 + r6
            checkForOverflow(r2, r5)
            int r4 = r4 + 1
            goto L_0x000a
        L_0x001d:
            r2 = 2147483647(0x7fffffff, float:NaN)
            r7.checkComponentIndex(r9)     // Catch:{ all -> 0x0031 }
            r7.shiftComps(r9, r1)     // Catch:{ all -> 0x0031 }
            if (r9 <= 0) goto L_0x0033
            io.netty.buffer.CompositeByteBuf$Component[] r3 = r7.components     // Catch:{ all -> 0x0031 }
            int r4 = r9 + -1
            r3 = r3[r4]     // Catch:{ all -> 0x0031 }
            int r3 = r3.endOffset     // Catch:{ all -> 0x0031 }
            goto L_0x0033
        L_0x0031:
            r3 = move-exception
            goto L_0x0080
        L_0x0033:
            r2 = r9
        L_0x0034:
            if (r11 >= r0) goto L_0x004e
            r4 = r10[r11]     // Catch:{ all -> 0x0031 }
            if (r4 != 0) goto L_0x003b
            goto L_0x004e
        L_0x003b:
            io.netty.buffer.ByteBuf r4 = ensureAccessible(r4)     // Catch:{ all -> 0x0031 }
            io.netty.buffer.CompositeByteBuf$Component r3 = r7.newComponent(r4, r3)     // Catch:{ all -> 0x0031 }
            io.netty.buffer.CompositeByteBuf$Component[] r4 = r7.components     // Catch:{ all -> 0x0031 }
            r4[r2] = r3     // Catch:{ all -> 0x0031 }
            int r3 = r3.endOffset     // Catch:{ all -> 0x0031 }
            int r11 = r11 + 1
            int r2 = r2 + 1
            goto L_0x0034
        L_0x004e:
            int r3 = r7.componentCount
            if (r2 >= r3) goto L_0x0065
            int r1 = r1 + r9
            if (r2 >= r1) goto L_0x0062
            r7.removeCompRange(r2, r1)
        L_0x0058:
            if (r11 >= r0) goto L_0x0062
            r1 = r10[r11]
            io.netty.util.ReferenceCountUtil.safeRelease(r1)
            int r11 = r11 + 1
            goto L_0x0058
        L_0x0062:
            r7.updateComponentOffsets(r2)
        L_0x0065:
            if (r8 == 0) goto L_0x007f
            if (r2 <= r9) goto L_0x007f
            int r8 = r7.componentCount
            if (r2 > r8) goto L_0x007f
            int r8 = r7.writerIndex
            io.netty.buffer.CompositeByteBuf$Component[] r10 = r7.components
            int r2 = r2 + -1
            r11 = r10[r2]
            int r11 = r11.endOffset
            r9 = r10[r9]
            int r9 = r9.offset
            int r11 = r11 - r9
            int r8 = r8 + r11
            r7.writerIndex = r8
        L_0x007f:
            return r7
        L_0x0080:
            int r4 = r7.componentCount
            if (r2 >= r4) goto L_0x0097
            int r1 = r1 + r9
            if (r2 >= r1) goto L_0x0094
            r7.removeCompRange(r2, r1)
        L_0x008a:
            if (r11 >= r0) goto L_0x0094
            r1 = r10[r11]
            io.netty.util.ReferenceCountUtil.safeRelease(r1)
            int r11 = r11 + 1
            goto L_0x008a
        L_0x0094:
            r7.updateComponentOffsets(r2)
        L_0x0097:
            if (r8 == 0) goto L_0x00b1
            if (r2 <= r9) goto L_0x00b1
            int r8 = r7.componentCount
            if (r2 > r8) goto L_0x00b1
            int r8 = r7.writerIndex
            io.netty.buffer.CompositeByteBuf$Component[] r10 = r7.components
            int r2 = r2 + -1
            r11 = r10[r2]
            int r11 = r11.endOffset
            r9 = r10[r9]
            int r9 = r9.offset
            int r11 = r11 - r9
            int r8 = r8 + r11
            r7.writerIndex = r8
        L_0x00b1:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.addComponents0(boolean, int, io.netty.buffer.ByteBuf[], int):io.netty.buffer.CompositeByteBuf");
    }

    private ByteBuf allocBuffer(int i) {
        boolean z = this.direct;
        ByteBufAllocator alloc2 = alloc();
        return z ? alloc2.directBuffer(i) : alloc2.heapBuffer(i);
    }

    private void checkComponentIndex(int i) {
        ensureAccessible();
        if (i < 0 || i > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", new Object[]{Integer.valueOf(i), Integer.valueOf(this.componentCount)}));
        }
    }

    private static void checkForOverflow(int i, int i2) {
        if (i + i2 < 0) {
            throw new IllegalArgumentException("Can't increase by " + i2 + " as capacity(" + i + ") would overflow " + Integer.MAX_VALUE);
        }
    }

    private void clearComps() {
        removeCompRange(0, this.componentCount);
    }

    private void consolidate0(int i, int i2) {
        if (i2 > 1) {
            int i3 = i + i2;
            ByteBuf allocBuffer = allocBuffer(this.components[i3 - 1].endOffset - (i != 0 ? this.components[i].offset : 0));
            for (int i4 = i; i4 < i3; i4++) {
                this.components[i4].transferTo(allocBuffer);
            }
            this.lastAccessed = null;
            removeCompRange(i + 1, i3);
            this.components[i] = newComponent(allocBuffer, 0);
            if (i != 0 || i2 != this.componentCount) {
                updateComponentOffsets(i);
            }
        }
    }

    private void consolidateIfNeeded() {
        int i = this.componentCount;
        if (i > this.maxNumComponents) {
            consolidate0(0, i);
        }
    }

    private void copyTo(int i, int i2, int i3, ByteBuf byteBuf) {
        int i4 = 0;
        while (i2 > 0) {
            Component component = this.components[i3];
            int min = Math.min(i2, component.endOffset - i);
            component.buf.getBytes(component.idx(i), byteBuf, i4, min);
            i += min;
            i4 += min;
            i2 -= min;
            i3++;
        }
        byteBuf.writerIndex(byteBuf.capacity());
    }

    private static ByteBuf ensureAccessible(ByteBuf byteBuf) {
        if (!AbstractByteBuf.checkAccessible || byteBuf.isAccessible()) {
            return byteBuf;
        }
        throw new IllegalReferenceCountException(0);
    }

    private Component findComponent(int i) {
        Component component = this.lastAccessed;
        if (component == null || i < component.offset || i >= component.endOffset) {
            checkIndex(i);
            return findIt(i);
        }
        ensureAccessible();
        return component;
    }

    private Component findComponent0(int i) {
        Component component = this.lastAccessed;
        return (component == null || i < component.offset || i >= component.endOffset) ? findIt(i) : component;
    }

    private Component findIt(int i) {
        int i2 = this.componentCount;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            Component component = this.components[i4];
            if (component == null) {
                throw new IllegalStateException("No component found for offset. Composite buffer layout might be outdated, e.g. from a discardReadBytes call.");
            } else if (i >= component.endOffset) {
                i3 = i4 + 1;
            } else if (i < component.offset) {
                i2 = i4 - 1;
            } else {
                this.lastAccessed = component;
                return component;
            }
        }
        throw new Error("should not reach here");
    }

    private static Component[] newCompArray(int i, int i2) {
        return new Component[Math.max(i, Math.min(16, i2))];
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.netty.buffer.CompositeByteBuf.Component newComponent(io.netty.buffer.ByteBuf r10, int r11) {
        /*
            r9 = this;
            int r2 = r10.readerIndex()
            int r6 = r10.readableBytes()
            r9 = r10
        L_0x0009:
            boolean r0 = r9 instanceof io.netty.buffer.WrappedByteBuf
            if (r0 != 0) goto L_0x0060
            boolean r0 = r9 instanceof io.netty.buffer.SwappedByteBuf
            if (r0 == 0) goto L_0x0012
            goto L_0x0060
        L_0x0012:
            boolean r0 = r9 instanceof io.netty.buffer.AbstractUnpooledSlicedByteBuf
            if (r0 == 0) goto L_0x0025
            r0 = r9
            io.netty.buffer.AbstractUnpooledSlicedByteBuf r0 = (io.netty.buffer.AbstractUnpooledSlicedByteBuf) r0
            r1 = 0
            int r0 = r0.idx(r1)
            int r0 = r0 + r2
            io.netty.buffer.ByteBuf r9 = r9.unwrap()
        L_0x0023:
            r4 = r0
            goto L_0x0044
        L_0x0025:
            boolean r0 = r9 instanceof io.netty.buffer.PooledSlicedByteBuf
            if (r0 == 0) goto L_0x0034
            r0 = r9
            io.netty.buffer.PooledSlicedByteBuf r0 = (io.netty.buffer.PooledSlicedByteBuf) r0
            int r0 = r0.adjustment
            int r0 = r0 + r2
            io.netty.buffer.ByteBuf r9 = r9.unwrap()
            goto L_0x0023
        L_0x0034:
            boolean r0 = r9 instanceof io.netty.buffer.DuplicatedByteBuf
            if (r0 != 0) goto L_0x003f
            boolean r0 = r9 instanceof io.netty.buffer.PooledDuplicatedByteBuf
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r4 = r2
            goto L_0x0044
        L_0x003f:
            io.netty.buffer.ByteBuf r9 = r9.unwrap()
            goto L_0x003d
        L_0x0044:
            int r0 = r10.capacity()
            if (r0 != r6) goto L_0x004c
            r7 = r10
            goto L_0x004e
        L_0x004c:
            r0 = 0
            r7 = r0
        L_0x004e:
            io.netty.buffer.CompositeByteBuf$Component r8 = new io.netty.buffer.CompositeByteBuf$Component
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            io.netty.buffer.ByteBuf r1 = r10.order(r0)
            io.netty.buffer.ByteBuf r3 = r9.order(r0)
            r0 = r8
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        L_0x0060:
            io.netty.buffer.ByteBuf r9 = r9.unwrap()
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.newComponent(io.netty.buffer.ByteBuf, int):io.netty.buffer.CompositeByteBuf$Component");
    }

    private void removeComp(int i) {
        removeCompRange(i, i + 1);
    }

    private void removeCompRange(int i, int i2) {
        if (i < i2) {
            int i3 = this.componentCount;
            if (i2 < i3) {
                Component[] componentArr = this.components;
                System.arraycopy(componentArr, i2, componentArr, i, i3 - i2);
            }
            int i4 = (i3 - i2) + i;
            for (int i5 = i4; i5 < i3; i5++) {
                this.components[i5] = null;
            }
            this.componentCount = i4;
        }
    }

    private void shiftComps(int i, int i2) {
        Component[] componentArr;
        int i3 = this.componentCount;
        int i4 = i3 + i2;
        Component[] componentArr2 = this.components;
        if (i4 > componentArr2.length) {
            int max = Math.max((i3 >> 1) + i3, i4);
            if (i == i3) {
                componentArr = (Component[]) Arrays.copyOf(this.components, max, Component[].class);
            } else {
                Component[] componentArr3 = new Component[max];
                if (i > 0) {
                    System.arraycopy(this.components, 0, componentArr3, 0, i);
                }
                if (i < i3) {
                    System.arraycopy(this.components, i, componentArr3, i2 + i, i3 - i);
                }
                componentArr = componentArr3;
            }
            this.components = componentArr;
        } else if (i < i3) {
            System.arraycopy(componentArr2, i, componentArr2, i2 + i, i3 - i);
        }
        this.componentCount = i4;
    }

    private int toComponentIndex0(int i) {
        int i2 = this.componentCount;
        int i3 = 0;
        if (i == 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                if (this.components[i4].endOffset > 0) {
                    return i4;
                }
            }
        }
        if (i2 <= 2) {
            return (i2 == 1 || i < this.components[0].endOffset) ? 0 : 1;
        }
        while (i3 <= i2) {
            int i5 = (i3 + i2) >>> 1;
            Component component = this.components[i5];
            if (i >= component.endOffset) {
                i3 = i5 + 1;
            } else if (i >= component.offset) {
                return i5;
            } else {
                i2 = i5 - 1;
            }
        }
        throw new Error("should not reach here");
    }

    private void updateComponentOffsets(int i) {
        int i2 = this.componentCount;
        if (i2 > i) {
            int i3 = i > 0 ? this.components[i - 1].endOffset : 0;
            while (i < i2) {
                Component component = this.components[i];
                component.reposition(i3);
                i3 = component.endOffset;
                i++;
            }
        }
    }

    public byte _getByte(int i) {
        Component findComponent0 = findComponent0(i);
        return findComponent0.buf.getByte(findComponent0.idx(i));
    }

    public int _getInt(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getInt(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i + 2) & UShort.MAX_VALUE) | ((_getShort(i) & UShort.MAX_VALUE) << 16);
        }
        return ((_getShort(i + 2) & UShort.MAX_VALUE) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    public int _getIntLE(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 4 <= findComponent0.endOffset) {
            return findComponent0.buf.getIntLE(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i + 2) & UShort.MAX_VALUE) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getShortLE(i + 2) & UShort.MAX_VALUE) | ((_getShortLE(i) & UShort.MAX_VALUE) << 16);
    }

    public long _getLong(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 8 <= findComponent0.endOffset) {
            return findComponent0.buf.getLong(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (((long) _getInt(i + 4)) & 4294967295L) | ((((long) _getInt(i)) & 4294967295L) << 32);
        }
        return ((((long) _getInt(i + 4)) & 4294967295L) << 32) | (((long) _getInt(i)) & 4294967295L);
    }

    public long _getLongLE(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 8 <= findComponent0.endOffset) {
            return findComponent0.buf.getLongLE(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((((long) _getIntLE(i + 4)) & 4294967295L) << 32) | (((long) _getIntLE(i)) & 4294967295L);
        }
        return (((long) _getIntLE(i + 4)) & 4294967295L) | ((((long) _getIntLE(i)) & 4294967295L) << 32);
    }

    public short _getShort(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShort(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
        }
        return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
    }

    public short _getShortLE(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 2 <= findComponent0.endOffset) {
            return findComponent0.buf.getShortLE(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
        }
        return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
    }

    public int _getUnsignedMedium(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 3 <= findComponent0.endOffset) {
            return findComponent0.buf.getUnsignedMedium(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i + 2) & 255) | ((_getShort(i) & UShort.MAX_VALUE) << 8);
        }
        return ((_getByte(i + 2) & 255) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    public int _getUnsignedMediumLE(int i) {
        Component findComponent0 = findComponent0(i);
        if (i + 3 <= findComponent0.endOffset) {
            return findComponent0.buf.getUnsignedMediumLE(findComponent0.idx(i));
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i + 2) & 255) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getByte(i + 2) & 255) | ((_getShortLE(i) & UShort.MAX_VALUE) << 8);
    }

    public void _setByte(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        findComponent0.buf.setByte(findComponent0.idx(i), i2);
    }

    public void _setInt(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 4 <= findComponent0.endOffset) {
            findComponent0.buf.setInt(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >>> 16));
            _setShort(i + 2, (short) i2);
        } else {
            _setShort(i, (short) i2);
            _setShort(i + 2, (short) (i2 >>> 16));
        }
    }

    public void _setIntLE(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 4 <= findComponent0.endOffset) {
            findComponent0.buf.setIntLE(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setShortLE(i + 2, (short) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >>> 16));
            _setShortLE(i + 2, (short) i2);
        }
    }

    public void _setLong(int i, long j) {
        Component findComponent0 = findComponent0(i);
        if (i + 8 <= findComponent0.endOffset) {
            findComponent0.buf.setLong(findComponent0.idx(i), j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setInt(i, (int) (j >>> 32));
            _setInt(i + 4, (int) j);
        } else {
            _setInt(i, (int) j);
            _setInt(i + 4, (int) (j >>> 32));
        }
    }

    public void _setLongLE(int i, long j) {
        Component findComponent0 = findComponent0(i);
        if (i + 8 <= findComponent0.endOffset) {
            findComponent0.buf.setLongLE(findComponent0.idx(i), j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setIntLE(i, (int) j);
            _setIntLE(i + 4, (int) (j >>> 32));
        } else {
            _setIntLE(i, (int) (j >>> 32));
            _setIntLE(i + 4, (int) j);
        }
    }

    public void _setMedium(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMedium(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShort(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        } else {
            _setShort(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        }
    }

    public void _setMediumLE(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 3 <= findComponent0.endOffset) {
            findComponent0.buf.setMediumLE(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setShortLE(i, (short) i2);
            _setByte(i + 2, (byte) (i2 >>> 16));
        } else {
            _setShortLE(i, (short) (i2 >> 8));
            _setByte(i + 2, (byte) i2);
        }
    }

    public void _setShort(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShort(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        } else {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        }
    }

    public void _setShortLE(int i, int i2) {
        Component findComponent0 = findComponent0(i);
        if (i + 2 <= findComponent0.endOffset) {
            findComponent0.buf.setShortLE(findComponent0.idx(i), i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            _setByte(i, (byte) i2);
            _setByte(i + 1, (byte) (i2 >>> 8));
        } else {
            _setByte(i, (byte) (i2 >>> 8));
            _setByte(i + 1, (byte) i2);
        }
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf) {
        return addComponent(false, byteBuf);
    }

    public CompositeByteBuf addComponents(ByteBuf... byteBufArr) {
        return addComponents(false, byteBufArr);
    }

    public CompositeByteBuf addFlattenedComponents(boolean z, ByteBuf byteBuf) {
        Component[] componentArr;
        int i;
        int i2;
        boolean z2 = z;
        ByteBuf byteBuf2 = byteBuf;
        ObjectUtil.checkNotNull(byteBuf2, "buffer");
        int readerIndex = byteBuf.readerIndex();
        int writerIndex = byteBuf.writerIndex();
        if (readerIndex == writerIndex) {
            byteBuf.release();
            return this;
        } else if (!(byteBuf2 instanceof CompositeByteBuf)) {
            addComponent0(z2, this.componentCount, byteBuf2);
            consolidateIfNeeded();
            return this;
        } else {
            CompositeByteBuf compositeByteBuf = byteBuf2 instanceof WrappedCompositeByteBuf ? (CompositeByteBuf) byteBuf.unwrap() : (CompositeByteBuf) byteBuf2;
            int i3 = writerIndex - readerIndex;
            compositeByteBuf.checkIndex(readerIndex, i3);
            Component[] componentArr2 = compositeByteBuf.components;
            int i4 = this.componentCount;
            int i5 = this.writerIndex;
            try {
                int componentIndex0 = compositeByteBuf.toComponentIndex0(readerIndex);
                int capacity = capacity();
                while (true) {
                    Component component = componentArr2[componentIndex0];
                    int max = Math.max(readerIndex, component.offset);
                    int min = Math.min(writerIndex, component.endOffset);
                    int i6 = min - max;
                    if (i6 > 0) {
                        int i7 = this.componentCount;
                        i = readerIndex;
                        Component component2 = r10;
                        componentArr = componentArr2;
                        i2 = min;
                        Component component3 = new Component(component.srcBuf.retain(), component.srcIdx(max), component.buf, component.idx(max), capacity, i6, (ByteBuf) null);
                        addComp(i7, component2);
                    } else {
                        i = readerIndex;
                        componentArr = componentArr2;
                        i2 = min;
                    }
                    if (writerIndex == i2) {
                        break;
                    }
                    capacity += i6;
                    componentIndex0++;
                    ByteBuf byteBuf3 = byteBuf;
                    readerIndex = i;
                    componentArr2 = componentArr;
                }
                if (z2) {
                    this.writerIndex = i3 + i5;
                }
                consolidateIfNeeded();
                byteBuf.release();
                return this;
            } catch (Throwable th) {
                if (z2) {
                    this.writerIndex = i5;
                }
                for (int i8 = this.componentCount - 1; i8 >= i4; i8--) {
                    this.components[i8].free();
                    removeComp(i8);
                }
                throw th;
            }
        }
    }

    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public byte[] array() {
        int i = this.componentCount;
        if (i == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (i == 1) {
            return this.components[0].buf.array();
        }
        throw new UnsupportedOperationException();
    }

    public int arrayOffset() {
        int i = this.componentCount;
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            Component component = this.components[0];
            return component.idx(component.buf.arrayOffset());
        }
        throw new UnsupportedOperationException();
    }

    public ByteBuf component(int i) {
        checkComponentIndex(i);
        return this.components[i].duplicate();
    }

    public ByteBuf componentAtOffset(int i) {
        return findComponent(i).duplicate();
    }

    public CompositeByteBuf consolidate() {
        ensureAccessible();
        consolidate0(0, this.componentCount);
        return this;
    }

    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf allocBuffer = allocBuffer(i2);
        if (i2 != 0) {
            copyTo(i, i2, toComponentIndex0(i), allocBuffer);
        }
        return allocBuffer;
    }

    public void deallocate() {
        if (!this.freed) {
            this.freed = true;
            int i = this.componentCount;
            for (int i2 = 0; i2 < i; i2++) {
                this.components[i2].free();
            }
        }
    }

    public List<ByteBuf> decompose(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return Collections.emptyList();
        }
        int componentIndex0 = toComponentIndex0(i);
        Component component = this.components[componentIndex0];
        ByteBuf slice = component.srcBuf.slice(component.srcIdx(i), Math.min(component.endOffset - i, i2));
        int readableBytes = i2 - slice.readableBytes();
        if (readableBytes == 0) {
            return Collections.singletonList(slice);
        }
        ArrayList arrayList = new ArrayList(this.componentCount - componentIndex0);
        arrayList.add(slice);
        do {
            componentIndex0++;
            Component component2 = this.components[componentIndex0];
            ByteBuf slice2 = component2.srcBuf.slice(component2.srcIdx(component2.offset), Math.min(component2.length(), readableBytes));
            readableBytes -= slice2.readableBytes();
            arrayList.add(slice2);
        } while (readableBytes > 0);
        return arrayList;
    }

    public CompositeByteBuf discardReadComponents() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            int i = this.componentCount;
            for (int i2 = 0; i2 < i; i2++) {
                this.components[i2].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int i3 = this.componentCount;
        Component component = null;
        int i4 = 0;
        while (i4 < i3) {
            component = this.components[i4];
            if (component.endOffset > readerIndex) {
                break;
            }
            component.free();
            i4++;
        }
        if (i4 == 0) {
            return this;
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= readerIndex) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i4);
        int i5 = component.offset;
        updateComponentOffsets(0);
        setIndex(readerIndex - i5, writerIndex - i5);
        adjustMarkers(i5);
        return this;
    }

    public int forEachByteAsc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        if (i2 <= i) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i);
        int i3 = i2 - i;
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int idx = component.idx(i);
                int min = Math.min(i3, component.endOffset - i);
                int forEachByteAsc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteAsc0(idx, idx + min, byteProcessor) : byteBuf.forEachByte(idx, min, byteProcessor);
                if (forEachByteAsc0 != -1) {
                    return forEachByteAsc0 - component.adjustment;
                }
                i += min;
                i3 -= min;
            }
            componentIndex0++;
        }
        return -1;
    }

    public int forEachByteDesc0(int i, int i2, ByteProcessor byteProcessor) throws Exception {
        if (i2 > i) {
            return -1;
        }
        int componentIndex0 = toComponentIndex0(i);
        int i3 = (i + 1) - i2;
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            if (component.offset != component.endOffset) {
                ByteBuf byteBuf = component.buf;
                int idx = component.idx(i3 + i2);
                int min = Math.min(i3, idx);
                int i4 = idx - min;
                int forEachByteDesc0 = byteBuf instanceof AbstractByteBuf ? ((AbstractByteBuf) byteBuf).forEachByteDesc0(idx - 1, i4, byteProcessor) : byteBuf.forEachByteDesc(i4, min, byteProcessor);
                if (forEachByteDesc0 != -1) {
                    return forEachByteDesc0 - component.adjustment;
                }
                i3 -= min;
            }
            componentIndex0--;
        }
        return -1;
    }

    public byte getByte(int i) {
        Component findComponent = findComponent(i);
        return findComponent.buf.getByte(findComponent.idx(i));
    }

    public boolean hasArray() {
        int i = this.componentCount;
        if (i == 0) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        return this.components[0].buf.hasArray();
    }

    public boolean hasMemoryAddress() {
        int i = this.componentCount;
        if (i == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (i != 1) {
            return false;
        }
        return this.components[0].buf.hasMemoryAddress();
    }

    public ByteBuf internalComponent(int i) {
        checkComponentIndex(i);
        return this.components[i].slice();
    }

    public ByteBuf internalComponentAtOffset(int i) {
        return findComponent(i).slice();
    }

    public ByteBuffer internalNioBuffer(int i, int i2) {
        int i3 = this.componentCount;
        if (i3 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i3 == 1) {
            return this.components[0].internalNioBuffer(i, i2);
        }
        throw new UnsupportedOperationException();
    }

    public boolean isAccessible() {
        return !this.freed;
    }

    public boolean isDirect() {
        int i = this.componentCount;
        if (i == 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.components[i2].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    public Iterator<ByteBuf> iterator() {
        ensureAccessible();
        return this.componentCount == 0 ? EMPTY_ITERATOR : new CompositeByteBufIterator();
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    public long memoryAddress() {
        int i = this.componentCount;
        if (i == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (i == 1) {
            Component component = this.components[0];
            return component.buf.memoryAddress() + ((long) component.adjustment);
        }
        throw new UnsupportedOperationException();
    }

    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        int i3 = this.componentCount;
        if (i3 == 0) {
            return EMPTY_NIO_BUFFER;
        }
        if (i3 == 1) {
            Component component = this.components[0];
            ByteBuf byteBuf = component.buf;
            if (byteBuf.nioBufferCount() == 1) {
                return byteBuf.nioBuffer(component.idx(i), i2);
            }
        }
        ByteBuffer[] nioBuffers = nioBuffers(i, i2);
        if (nioBuffers.length == 1) {
            return nioBuffers[0];
        }
        ByteBuffer order = ByteBuffer.allocate(i2).order(order());
        for (ByteBuffer put : nioBuffers) {
            order.put(put);
        }
        order.flip();
        return order;
    }

    public int nioBufferCount() {
        int i = this.componentCount;
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return this.components[0].buf.nioBufferCount();
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += this.components[i3].buf.nioBufferCount();
        }
        return i2;
    }

    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return new ByteBuffer[]{EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList newInstance = RecyclableArrayList.newInstance(this.componentCount);
        try {
            int componentIndex0 = toComponentIndex0(i);
            while (i2 > 0) {
                Component component = this.components[componentIndex0];
                ByteBuf byteBuf = component.buf;
                int min = Math.min(i2, component.endOffset - i);
                int nioBufferCount = byteBuf.nioBufferCount();
                if (nioBufferCount != 0) {
                    if (nioBufferCount != 1) {
                        Collections.addAll(newInstance, byteBuf.nioBuffers(component.idx(i), min));
                    } else {
                        newInstance.add(byteBuf.nioBuffer(component.idx(i), min));
                    }
                    i += min;
                    i2 -= min;
                    componentIndex0++;
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) newInstance.toArray(new ByteBuffer[0]);
            newInstance.recycle();
            return byteBufferArr;
        } catch (Throwable th) {
            newInstance.recycle();
            throw th;
        }
    }

    public int numComponents() {
        return this.componentCount;
    }

    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    public CompositeByteBuf removeComponent(int i) {
        checkComponentIndex(i);
        Component component = this.components[i];
        if (this.lastAccessed == component) {
            this.lastAccessed = null;
        }
        component.free();
        removeComp(i);
        if (component.length() > 0) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int i, int i2) {
        checkComponentIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        int i3 = i2 + i;
        boolean z = false;
        for (int i4 = i; i4 < i3; i4++) {
            Component component = this.components[i4];
            if (component.length() > 0) {
                z = true;
            }
            if (this.lastAccessed == component) {
                this.lastAccessed = null;
            }
            component.free();
        }
        removeCompRange(i, i3);
        if (z) {
            updateComponentOffsets(i);
        }
        return this;
    }

    public int toByteIndex(int i) {
        checkComponentIndex(i);
        return this.components[i].offset;
    }

    public int toComponentIndex(int i) {
        checkIndex(i);
        return toComponentIndex0(i);
    }

    public String toString() {
        String abstractByteBuf = super.toString();
        String substring = abstractByteBuf.substring(0, abstractByteBuf.length() - 1);
        return substring + ", components=" + this.componentCount + ')';
    }

    public CompositeByteBuf touch() {
        return this;
    }

    public ByteBuf unwrap() {
        return null;
    }

    public CompositeByteBuf addComponent(int i, ByteBuf byteBuf) {
        return addComponent(false, i, byteBuf);
    }

    public CompositeByteBuf addComponents(Iterable<ByteBuf> iterable) {
        return addComponents(false, iterable);
    }

    public int capacity() {
        int i = this.componentCount;
        if (i > 0) {
            return this.components[i - 1].endOffset;
        }
        return 0;
    }

    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    public CompositeByteBuf discardReadBytes() {
        ensureAccessible();
        int readerIndex = readerIndex();
        if (readerIndex == 0) {
            return this;
        }
        int writerIndex = writerIndex();
        if (readerIndex == writerIndex && writerIndex == capacity()) {
            int i = this.componentCount;
            for (int i2 = 0; i2 < i; i2++) {
                this.components[i2].free();
            }
            this.lastAccessed = null;
            clearComps();
            setIndex(0, 0);
            adjustMarkers(readerIndex);
            return this;
        }
        int i3 = this.componentCount;
        Component component = null;
        int i4 = 0;
        while (i4 < i3) {
            component = this.components[i4];
            if (component.endOffset > readerIndex) {
                break;
            }
            component.free();
            i4++;
        }
        int i5 = readerIndex - component.offset;
        component.offset = 0;
        component.endOffset -= readerIndex;
        component.srcAdjustment += readerIndex;
        component.adjustment += readerIndex;
        ByteBuf access$100 = component.slice;
        if (access$100 != null) {
            ByteBuf unused = component.slice = access$100.slice(i5, component.length());
        }
        Component component2 = this.lastAccessed;
        if (component2 != null && component2.endOffset <= readerIndex) {
            this.lastAccessed = null;
        }
        removeCompRange(0, i4);
        updateComponentOffsets(0);
        setIndex(0, writerIndex - readerIndex);
        adjustMarkers(readerIndex);
        return this;
    }

    public CompositeByteBuf discardSomeReadBytes() {
        return discardReadComponents();
    }

    public CompositeByteBuf ensureWritable(int i) {
        super.ensureWritable(i);
        return this;
    }

    public CompositeByteBuf markReaderIndex() {
        super.markReaderIndex();
        return this;
    }

    public CompositeByteBuf markWriterIndex() {
        super.markWriterIndex();
        return this;
    }

    public CompositeByteBuf readerIndex(int i) {
        super.readerIndex(i);
        return this;
    }

    public CompositeByteBuf resetReaderIndex() {
        super.resetReaderIndex();
        return this;
    }

    public CompositeByteBuf resetWriterIndex() {
        super.resetWriterIndex();
        return this;
    }

    public CompositeByteBuf setBoolean(int i, boolean z) {
        return setByte(i, z ? 1 : 0);
    }

    public CompositeByteBuf setByte(int i, int i2) {
        Component findComponent = findComponent(i);
        findComponent.buf.setByte(findComponent.idx(i), i2);
        return this;
    }

    public CompositeByteBuf setChar(int i, int i2) {
        return setShort(i, i2);
    }

    public CompositeByteBuf setDouble(int i, double d) {
        return setLong(i, Double.doubleToRawLongBits(d));
    }

    public CompositeByteBuf setFloat(int i, float f) {
        return setInt(i, Float.floatToRawIntBits(f));
    }

    public CompositeByteBuf setIndex(int i, int i2) {
        super.setIndex(i, i2);
        return this;
    }

    public CompositeByteBuf setInt(int i, int i2) {
        checkIndex(i, 4);
        _setInt(i, i2);
        return this;
    }

    public CompositeByteBuf setLong(int i, long j) {
        checkIndex(i, 8);
        _setLong(i, j);
        return this;
    }

    public CompositeByteBuf setMedium(int i, int i2) {
        checkIndex(i, 3);
        _setMedium(i, i2);
        return this;
    }

    public CompositeByteBuf setShort(int i, int i2) {
        checkIndex(i, 2);
        _setShort(i, i2);
        return this;
    }

    public CompositeByteBuf setZero(int i, int i2) {
        super.setZero(i, i2);
        return this;
    }

    public CompositeByteBuf skipBytes(int i) {
        super.skipBytes(i);
        return this;
    }

    public CompositeByteBuf touch(Object obj) {
        return this;
    }

    public CompositeByteBuf writeBoolean(boolean z) {
        writeByte(z ? 1 : 0);
        return this;
    }

    public CompositeByteBuf writeByte(int i) {
        ensureWritable0(1);
        int i2 = this.writerIndex;
        this.writerIndex = i2 + 1;
        _setByte(i2, i);
        return this;
    }

    public CompositeByteBuf writeChar(int i) {
        super.writeShort(i);
        return this;
    }

    public CompositeByteBuf writeDouble(double d) {
        super.writeLong(Double.doubleToRawLongBits(d));
        return this;
    }

    public CompositeByteBuf writeFloat(float f) {
        super.writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    public CompositeByteBuf writeInt(int i) {
        super.writeInt(i);
        return this;
    }

    public CompositeByteBuf writeLong(long j) {
        super.writeLong(j);
        return this;
    }

    public CompositeByteBuf writeMedium(int i) {
        super.writeMedium(i);
        return this;
    }

    public CompositeByteBuf writeShort(int i) {
        super.writeShort(i);
        return this;
    }

    public CompositeByteBuf writeZero(int i) {
        super.writeZero(i);
        return this;
    }

    public CompositeByteBuf writerIndex(int i) {
        super.writerIndex(i);
        return this;
    }

    public CompositeByteBuf addComponent(boolean z, ByteBuf byteBuf) {
        return addComponent(z, this.componentCount, byteBuf);
    }

    public CompositeByteBuf addComponents(boolean z, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(z, this.componentCount, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf consolidate(int i, int i2) {
        checkComponentIndex(i, i2);
        consolidate0(i, i2);
        return this;
    }

    public CompositeByteBuf addComponent(boolean z, int i, ByteBuf byteBuf) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        addComponent0(z, i, byteBuf);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf capacity(int i) {
        checkNewCapacity(i);
        int i2 = this.componentCount;
        int capacity = capacity();
        if (i > capacity) {
            int i3 = i - capacity;
            addComponent0(false, i2, allocBuffer(i3).setIndex(0, i3));
            if (this.componentCount >= this.maxNumComponents) {
                consolidateIfNeeded();
            }
        } else if (i < capacity) {
            this.lastAccessed = null;
            int i4 = i2 - 1;
            int i5 = capacity - i;
            while (true) {
                if (i4 < 0) {
                    break;
                }
                Component component = this.components[i4];
                int length = component.length();
                if (i5 < length) {
                    component.endOffset -= i5;
                    ByteBuf access$100 = component.slice;
                    if (access$100 != null) {
                        ByteBuf unused = component.slice = access$100.slice(0, component.length());
                    }
                } else {
                    component.free();
                    i5 -= length;
                    i4--;
                }
            }
            removeCompRange(i4 + 1, i2);
            if (readerIndex() > i) {
                setIndex0(i, i);
            } else if (this.writerIndex > i) {
                this.writerIndex = i;
            }
        }
        return this;
    }

    public CompositeByteBuf retain(int i) {
        super.retain(i);
        return this;
    }

    private void checkComponentIndex(int i, int i2) {
        ensureAccessible();
        if (i < 0 || i + i2 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.componentCount)}));
        }
    }

    public CompositeByteBuf addComponents(boolean z, Iterable<ByteBuf> iterable) {
        return addComponents(z, this.componentCount, iterable);
    }

    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i) {
        this(byteBufAllocator, z, i, 0);
    }

    public CompositeByteBuf addComponents(int i, ByteBuf... byteBufArr) {
        ObjectUtil.checkNotNull(byteBufArr, "buffers");
        addComponents0(false, i, byteBufArr, 0);
        consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf setBytes(int i, byte[] bArr, int i2, int i3) {
        checkSrcIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i3, component.endOffset - i);
            component.buf.setBytes(component.idx(i), bArr, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex0++;
        }
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf) {
        super.writeBytes(byteBuf, byteBuf.readableBytes());
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteBuf... byteBufArr) {
        this(byteBufAllocator, z, i, byteBufArr, 0);
    }

    public CompositeByteBuf getBytes(int i, byte[] bArr, int i2, int i3) {
        checkDstIndex(i, i3, i2, bArr.length);
        if (i3 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i3, component.endOffset - i);
            component.buf.getBytes(component.idx(i), bArr, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex0++;
        }
        return this;
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf) {
        super.readBytes(byteBuf, byteBuf.writableBytes());
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i) {
        super.writeBytes(byteBuf, i);
        return this;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteBuf[] byteBufArr, int i2) {
        this(byteBufAllocator, z, i, byteBufArr.length - i2);
        addComponents0(false, 0, byteBufArr, i2);
        consolidateIfNeeded();
        setIndex0(0, capacity());
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i) {
        super.readBytes(byteBuf, i);
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf, int i, int i2) {
        super.writeBytes(byteBuf, i, i2);
        return this;
    }

    public CompositeByteBuf addComponents(int i, Iterable<ByteBuf> iterable) {
        return addComponents(false, i, iterable);
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf, int i, int i2) {
        super.readBytes(byteBuf, i, i2);
        return this;
    }

    public CompositeByteBuf writeBytes(byte[] bArr) {
        super.writeBytes(bArr, 0, bArr.length);
        return this;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private io.netty.buffer.CompositeByteBuf addComponents(boolean r2, int r3, java.lang.Iterable<io.netty.buffer.ByteBuf> r4) {
        /*
            r1 = this;
            boolean r0 = r4 instanceof io.netty.buffer.ByteBuf
            if (r0 == 0) goto L_0x000b
            io.netty.buffer.ByteBuf r4 = (io.netty.buffer.ByteBuf) r4
            io.netty.buffer.CompositeByteBuf r1 = r1.addComponent(r2, r3, r4)
            return r1
        L_0x000b:
            java.lang.String r0 = "buffers"
            io.netty.util.internal.ObjectUtil.checkNotNull(r4, r0)
            java.util.Iterator r4 = r4.iterator()
            r1.checkComponentIndex(r3)     // Catch:{ all -> 0x0033 }
        L_0x0017:
            boolean r0 = r4.hasNext()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0035
            java.lang.Object r0 = r4.next()     // Catch:{ all -> 0x0033 }
            io.netty.buffer.ByteBuf r0 = (io.netty.buffer.ByteBuf) r0     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0026
            goto L_0x0035
        L_0x0026:
            int r3 = r1.addComponent0(r2, r3, r0)     // Catch:{ all -> 0x0033 }
            int r3 = r3 + 1
            int r0 = r1.componentCount     // Catch:{ all -> 0x0033 }
            int r3 = java.lang.Math.min(r3, r0)     // Catch:{ all -> 0x0033 }
            goto L_0x0017
        L_0x0033:
            r1 = move-exception
            goto L_0x0047
        L_0x0035:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0043
            java.lang.Object r2 = r4.next()
            io.netty.util.ReferenceCountUtil.safeRelease(r2)
            goto L_0x0035
        L_0x0043:
            r1.consolidateIfNeeded()
            return r1
        L_0x0047:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0055
            java.lang.Object r2 = r4.next()
            io.netty.util.ReferenceCountUtil.safeRelease(r2)
            goto L_0x0047
        L_0x0055:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.addComponents(boolean, int, java.lang.Iterable):io.netty.buffer.CompositeByteBuf");
    }

    public CompositeByteBuf readBytes(byte[] bArr) {
        super.readBytes(bArr, 0, bArr.length);
        return this;
    }

    public CompositeByteBuf writeBytes(byte[] bArr, int i, int i2) {
        super.writeBytes(bArr, i, i2);
        return this;
    }

    public CompositeByteBuf readBytes(byte[] bArr, int i, int i2) {
        super.readBytes(bArr, i, i2);
        return this;
    }

    /* JADX INFO: finally extract failed */
    public CompositeByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.setBytes(component.idx(i), byteBuffer);
                i += min;
                remaining -= min;
                componentIndex0++;
            } catch (Throwable th) {
                byteBuffer.limit(limit);
                throw th;
            }
        }
        byteBuffer.limit(limit);
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer) {
        super.writeBytes(byteBuffer);
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, Iterable<ByteBuf> iterable) {
        this(byteBufAllocator, z, i, iterable instanceof Collection ? ((Collection) iterable).size() : 0);
        addComponents(false, 0, iterable);
        setIndex(0, capacity());
    }

    /* JADX INFO: finally extract failed */
    public CompositeByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        checkIndex(i, remaining);
        if (remaining == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (remaining > 0) {
            try {
                Component component = this.components[componentIndex0];
                int min = Math.min(remaining, component.endOffset - i);
                byteBuffer.limit(byteBuffer.position() + min);
                component.buf.getBytes(component.idx(i), byteBuffer);
                i += min;
                remaining -= min;
                componentIndex0++;
            } catch (Throwable th) {
                byteBuffer.limit(limit);
                throw th;
            }
        }
        byteBuffer.limit(limit);
        return this;
    }

    public CompositeByteBuf readBytes(ByteBuffer byteBuffer) {
        super.readBytes(byteBuffer);
        return this;
    }

    public CompositeByteBuf readBytes(OutputStream outputStream, int i) throws IOException {
        super.readBytes(outputStream, i);
        return this;
    }

    public ByteBuffer[] nioBuffers() {
        return nioBuffers(readerIndex(), readableBytes());
    }

    public <T> CompositeByteBuf(ByteBufAllocator byteBufAllocator, boolean z, int i, ByteWrapper<T> byteWrapper, T[] tArr, int i2) {
        this(byteBufAllocator, z, i, tArr.length - i2);
        addComponents0(false, 0, byteWrapper, tArr, i2);
        consolidateIfNeeded();
        setIndex(0, capacity());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator) {
        super(Integer.MAX_VALUE);
        this.alloc = byteBufAllocator;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkSrcIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i3, component.endOffset - i);
            component.buf.setBytes(component.idx(i), byteBuf, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex0++;
        }
        return this;
    }

    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i3) {
        checkDstIndex(i, i3, i2, byteBuf.capacity());
        if (i3 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (i3 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i3, component.endOffset - i);
            component.buf.getBytes(component.idx(i), byteBuf, i2, min);
            i += min;
            i2 += min;
            i3 -= min;
            componentIndex0++;
        }
        return this;
    }

    private <T> int addComponents0(boolean z, int i, ByteWrapper<T> byteWrapper, T[] tArr, int i2) {
        int i3;
        checkComponentIndex(i);
        int length = tArr.length;
        while (i2 < length) {
            T t = tArr[i2];
            if (t == null) {
                break;
            }
            if (!byteWrapper.isEmpty(t) && (i = addComponent0(z, i, byteWrapper.wrap(t)) + 1) > (i3 = this.componentCount)) {
                i = i3;
            }
            i2++;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039 A[EDGE_INSN: B:16:0x0039->B:15:0x0039 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setBytes(int r6, java.io.InputStream r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.checkIndex(r6, r8)
            if (r8 != 0) goto L_0x000c
            byte[] r5 = io.netty.util.internal.EmptyArrays.EMPTY_BYTES
            int r5 = r7.read(r5)
            return r5
        L_0x000c:
            int r0 = r5.toComponentIndex0(r6)
            r1 = 0
        L_0x0011:
            io.netty.buffer.CompositeByteBuf$Component[] r2 = r5.components
            r2 = r2[r0]
            int r3 = r2.endOffset
            int r3 = r3 - r6
            int r3 = java.lang.Math.min(r8, r3)
            if (r3 != 0) goto L_0x0021
        L_0x001e:
            int r0 = r0 + 1
            goto L_0x0037
        L_0x0021:
            io.netty.buffer.ByteBuf r4 = r2.buf
            int r2 = r2.idx(r6)
            int r2 = r4.setBytes((int) r2, (java.io.InputStream) r7, (int) r3)
            if (r2 >= 0) goto L_0x0031
            if (r1 != 0) goto L_0x0039
            r5 = -1
            return r5
        L_0x0031:
            int r6 = r6 + r2
            int r8 = r8 - r2
            int r1 = r1 + r2
            if (r2 != r3) goto L_0x0037
            goto L_0x001e
        L_0x0037:
            if (r8 > 0) goto L_0x0011
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.io.InputStream, int):int");
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[EDGE_INSN: B:17:0x003c->B:16:0x003c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setBytes(int r6, java.nio.channels.ScatteringByteChannel r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            r5.checkIndex(r6, r8)
            if (r8 != 0) goto L_0x000c
            java.nio.ByteBuffer r5 = EMPTY_NIO_BUFFER
            int r5 = r7.read(r5)
            return r5
        L_0x000c:
            int r0 = r5.toComponentIndex0(r6)
            r1 = 0
        L_0x0011:
            io.netty.buffer.CompositeByteBuf$Component[] r2 = r5.components
            r2 = r2[r0]
            int r3 = r2.endOffset
            int r3 = r3 - r6
            int r3 = java.lang.Math.min(r8, r3)
            if (r3 != 0) goto L_0x0021
        L_0x001e:
            int r0 = r0 + 1
            goto L_0x003a
        L_0x0021:
            io.netty.buffer.ByteBuf r4 = r2.buf
            int r2 = r2.idx(r6)
            int r2 = r4.setBytes((int) r2, (java.nio.channels.ScatteringByteChannel) r7, (int) r3)
            if (r2 != 0) goto L_0x002e
            goto L_0x003c
        L_0x002e:
            if (r2 >= 0) goto L_0x0034
            if (r1 != 0) goto L_0x003c
            r5 = -1
            return r5
        L_0x0034:
            int r6 = r6 + r2
            int r8 = r8 - r2
            int r1 = r1 + r2
            if (r2 != r3) goto L_0x003a
            goto L_0x001e
        L_0x003a:
            if (r8 > 0) goto L_0x0011
        L_0x003c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.nio.channels.ScatteringByteChannel, int):int");
    }

    public CompositeByteBuf getBytes(int i, OutputStream outputStream, int i2) throws IOException {
        checkIndex(i, i2);
        if (i2 == 0) {
            return this;
        }
        int componentIndex0 = toComponentIndex0(i);
        while (i2 > 0) {
            Component component = this.components[componentIndex0];
            int min = Math.min(i2, component.endOffset - i);
            component.buf.getBytes(component.idx(i), outputStream, min);
            i += min;
            i2 -= min;
            componentIndex0++;
        }
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[EDGE_INSN: B:19:0x0041->B:16:0x0041 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setBytes(int r11, java.nio.channels.FileChannel r12, long r13, int r15) throws java.io.IOException {
        /*
            r10 = this;
            r10.checkIndex(r11, r15)
            if (r15 != 0) goto L_0x000c
            java.nio.ByteBuffer r10 = EMPTY_NIO_BUFFER
            int r10 = r12.read(r10, r13)
            return r10
        L_0x000c:
            int r0 = r10.toComponentIndex0(r11)
            r1 = 0
        L_0x0011:
            io.netty.buffer.CompositeByteBuf$Component[] r2 = r10.components
            r2 = r2[r0]
            int r3 = r2.endOffset
            int r3 = r3 - r11
            int r3 = java.lang.Math.min(r15, r3)
            if (r3 != 0) goto L_0x0021
        L_0x001e:
            int r0 = r0 + 1
            goto L_0x003f
        L_0x0021:
            io.netty.buffer.ByteBuf r4 = r2.buf
            int r5 = r2.idx(r11)
            long r6 = (long) r1
            long r7 = r13 + r6
            r6 = r12
            r9 = r3
            int r2 = r4.setBytes((int) r5, (java.nio.channels.FileChannel) r6, (long) r7, (int) r9)
            if (r2 != 0) goto L_0x0033
            goto L_0x0041
        L_0x0033:
            if (r2 >= 0) goto L_0x0039
            if (r1 != 0) goto L_0x0041
            r10 = -1
            return r10
        L_0x0039:
            int r11 = r11 + r2
            int r15 = r15 - r2
            int r1 = r1 + r2
            if (r2 != r3) goto L_0x003f
            goto L_0x001e
        L_0x003f:
            if (r15 > 0) goto L_0x0011
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.CompositeByteBuf.setBytes(int, java.nio.channels.FileChannel, long, int):int");
    }

    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf) {
        return getBytes(i, byteBuf, byteBuf.writableBytes());
    }

    public CompositeByteBuf getBytes(int i, ByteBuf byteBuf, int i2) {
        getBytes(i, byteBuf, byteBuf.writerIndex(), i2);
        byteBuf.writerIndex(byteBuf.writerIndex() + i2);
        return this;
    }

    public CompositeByteBuf getBytes(int i, byte[] bArr) {
        return getBytes(i, bArr, 0, bArr.length);
    }

    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf) {
        super.setBytes(i, byteBuf, byteBuf.readableBytes());
        return this;
    }

    public CompositeByteBuf setBytes(int i, ByteBuf byteBuf, int i2) {
        super.setBytes(i, byteBuf, i2);
        return this;
    }

    public CompositeByteBuf setBytes(int i, byte[] bArr) {
        return setBytes(i, bArr, 0, bArr.length);
    }
}
