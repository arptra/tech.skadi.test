package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

abstract class PoolArena<T> extends SizeClasses implements PoolArenaMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final boolean HAS_UNSAFE = PlatformDependent.hasUnsafe();
    private final LongCounter activeBytesHuge = PlatformDependent.newLongCounter();
    private final LongCounter allocationsHuge = PlatformDependent.newLongCounter();
    private long allocationsNormal;
    private final LongCounter allocationsSmall = PlatformDependent.newLongCounter();
    private final List<PoolChunkListMetric> chunkListMetrics;
    private final LongCounter deallocationsHuge = PlatformDependent.newLongCounter();
    private long deallocationsNormal;
    private long deallocationsSmall;
    final int directMemoryCacheAlignment;
    private final ReentrantLock lock = new ReentrantLock();
    final int numSmallSubpagePools;
    final AtomicInteger numThreadCaches = new AtomicInteger();
    final PooledByteBufAllocator parent;
    private final PoolChunkList<T> q000;
    private final PoolChunkList<T> q025;
    private final PoolChunkList<T> q050;
    private final PoolChunkList<T> q075;
    private final PoolChunkList<T> q100;
    private final PoolChunkList<T> qInit;
    private final PoolSubpage<T>[] smallSubpagePools;

    /* renamed from: io.netty.buffer.PoolArena$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$buffer$PoolArena$SizeClass;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.netty.buffer.PoolArena$SizeClass[] r0 = io.netty.buffer.PoolArena.SizeClass.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$netty$buffer$PoolArena$SizeClass = r0
                io.netty.buffer.PoolArena$SizeClass r1 = io.netty.buffer.PoolArena.SizeClass.Normal     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$netty$buffer$PoolArena$SizeClass     // Catch:{ NoSuchFieldError -> 0x001d }
                io.netty.buffer.PoolArena$SizeClass r1 = io.netty.buffer.PoolArena.SizeClass.Small     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.PoolArena.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class DirectArena extends PoolArena<ByteBuffer> {
        public DirectArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3, int i4) {
            super(pooledByteBufAllocator, i, i2, i3, i4);
        }

        private static ByteBuffer allocateDirect(int i) {
            return PlatformDependent.useDirectBufferNoCleaner() ? PlatformDependent.allocateDirectNoCleaner(i) : ByteBuffer.allocateDirect(i);
        }

        public void destroyChunk(PoolChunk<ByteBuffer> poolChunk) {
            if (PlatformDependent.useDirectBufferNoCleaner()) {
                PlatformDependent.freeDirectNoCleaner((ByteBuffer) poolChunk.base);
            } else {
                PlatformDependent.freeDirectBuffer((ByteBuffer) poolChunk.base);
            }
        }

        public boolean isDirect() {
            return true;
        }

        public PooledByteBuf<ByteBuffer> newByteBuf(int i) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeDirectByteBuf.newInstance(i) : PooledDirectByteBuf.newInstance(i);
        }

        public PoolChunk<ByteBuffer> newChunk(int i, int i2, int i3, int i4) {
            int i5 = this.directMemoryCacheAlignment;
            if (i5 == 0) {
                ByteBuffer allocateDirect = allocateDirect(i4);
                return new PoolChunk(this, allocateDirect, allocateDirect, i, i3, i4, i2);
            }
            ByteBuffer allocateDirect2 = allocateDirect(i5 + i4);
            return new PoolChunk(this, allocateDirect2, PlatformDependent.alignDirectBuffer(allocateDirect2, this.directMemoryCacheAlignment), i, i3, i4, i2);
        }

        public PoolChunk<ByteBuffer> newUnpooledChunk(int i) {
            int i2 = this.directMemoryCacheAlignment;
            if (i2 == 0) {
                ByteBuffer allocateDirect = allocateDirect(i);
                return new PoolChunk<>(this, allocateDirect, allocateDirect, i);
            }
            ByteBuffer allocateDirect2 = allocateDirect(i2 + i);
            return new PoolChunk<>(this, allocateDirect2, PlatformDependent.alignDirectBuffer(allocateDirect2, this.directMemoryCacheAlignment), i);
        }

        public void memoryCopy(ByteBuffer byteBuffer, int i, PooledByteBuf<ByteBuffer> pooledByteBuf, int i2) {
            if (i2 != 0) {
                if (PoolArena.HAS_UNSAFE) {
                    PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + ((long) i), PlatformDependent.directBufferAddress((ByteBuffer) pooledByteBuf.memory) + ((long) pooledByteBuf.offset), (long) i2);
                    return;
                }
                ByteBuffer duplicate = byteBuffer.duplicate();
                ByteBuffer internalNioBuffer = pooledByteBuf.internalNioBuffer();
                duplicate.position(i).limit(i + i2);
                internalNioBuffer.position(pooledByteBuf.offset);
                internalNioBuffer.put(duplicate);
            }
        }
    }

    public static final class HeapArena extends PoolArena<byte[]> {
        public HeapArena(PooledByteBufAllocator pooledByteBufAllocator, int i, int i2, int i3) {
            super(pooledByteBufAllocator, i, i2, i3, 0);
        }

        private static byte[] newByteArray(int i) {
            return PlatformDependent.allocateUninitializedArray(i);
        }

        public void destroyChunk(PoolChunk<byte[]> poolChunk) {
        }

        public boolean isDirect() {
            return false;
        }

        public PooledByteBuf<byte[]> newByteBuf(int i) {
            return PoolArena.HAS_UNSAFE ? PooledUnsafeHeapByteBuf.newUnsafeInstance(i) : PooledHeapByteBuf.newInstance(i);
        }

        public PoolChunk<byte[]> newChunk(int i, int i2, int i3, int i4) {
            return new PoolChunk(this, (Object) null, newByteArray(i4), i, i3, i4, i2);
        }

        public PoolChunk<byte[]> newUnpooledChunk(int i) {
            return new PoolChunk<>(this, (Object) null, newByteArray(i), i);
        }

        public void memoryCopy(byte[] bArr, int i, PooledByteBuf<byte[]> pooledByteBuf, int i2) {
            if (i2 != 0) {
                System.arraycopy(bArr, i, pooledByteBuf.memory, pooledByteBuf.offset, i2);
            }
        }
    }

    public enum SizeClass {
        Small,
        Normal
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PoolArena(io.netty.buffer.PooledByteBufAllocator r15, int r16, int r17, int r18, int r19) {
        /*
            r14 = this;
            r6 = r14
            r0 = r16
            r1 = r17
            r7 = r18
            r2 = r19
            r14.<init>(r0, r1, r7, r2)
            io.netty.util.internal.LongCounter r0 = io.netty.util.internal.PlatformDependent.newLongCounter()
            r6.allocationsSmall = r0
            io.netty.util.internal.LongCounter r0 = io.netty.util.internal.PlatformDependent.newLongCounter()
            r6.allocationsHuge = r0
            io.netty.util.internal.LongCounter r0 = io.netty.util.internal.PlatformDependent.newLongCounter()
            r6.activeBytesHuge = r0
            io.netty.util.internal.LongCounter r0 = io.netty.util.internal.PlatformDependent.newLongCounter()
            r6.deallocationsHuge = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r0.<init>()
            r6.numThreadCaches = r0
            java.util.concurrent.locks.ReentrantLock r0 = new java.util.concurrent.locks.ReentrantLock
            r0.<init>()
            r6.lock = r0
            r0 = r15
            r6.parent = r0
            r6.directMemoryCacheAlignment = r2
            int r0 = r6.nSubpages
            r6.numSmallSubpagePools = r0
            io.netty.buffer.PoolSubpage[] r0 = r14.newSubpagePoolArray(r0)
            r6.smallSubpagePools = r0
            r0 = 0
        L_0x0042:
            io.netty.buffer.PoolSubpage<T>[] r1 = r6.smallSubpagePools
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0050
            io.netty.buffer.PoolSubpage r2 = r14.newSubpagePoolHead()
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0042
        L_0x0050:
            io.netty.buffer.PoolChunkList r8 = new io.netty.buffer.PoolChunkList
            r3 = 100
            r4 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            r0 = r8
            r1 = r14
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5)
            r6.q100 = r8
            io.netty.buffer.PoolChunkList r9 = new io.netty.buffer.PoolChunkList
            r3 = 75
            r4 = 100
            r0 = r9
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r6.q075 = r9
            io.netty.buffer.PoolChunkList r10 = new io.netty.buffer.PoolChunkList
            r3 = 50
            r0 = r10
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r6.q050 = r10
            io.netty.buffer.PoolChunkList r11 = new io.netty.buffer.PoolChunkList
            r3 = 25
            r4 = 75
            r0 = r11
            r2 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r6.q025 = r11
            io.netty.buffer.PoolChunkList r12 = new io.netty.buffer.PoolChunkList
            r3 = 1
            r4 = 50
            r0 = r12
            r2 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r6.q000 = r12
            io.netty.buffer.PoolChunkList r13 = new io.netty.buffer.PoolChunkList
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 25
            r0 = r13
            r2 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.qInit = r13
            r8.prevList(r9)
            r9.prevList(r10)
            r10.prevList(r11)
            r11.prevList(r12)
            r0 = 0
            r12.prevList(r0)
            r13.prevList(r13)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 6
            r0.<init>(r1)
            r0.add(r13)
            r0.add(r12)
            r0.add(r11)
            r0.add(r10)
            r0.add(r9)
            r0.add(r8)
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r6.chunkListMetrics = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.PoolArena.<init>(io.netty.buffer.PooledByteBufAllocator, int, int, int, int):void");
    }

    private void allocateHuge(PooledByteBuf<T> pooledByteBuf, int i) {
        PoolChunk newUnpooledChunk = newUnpooledChunk(i);
        this.activeBytesHuge.add((long) newUnpooledChunk.chunkSize());
        pooledByteBuf.initUnpooled(newUnpooledChunk, i);
        this.allocationsHuge.increment();
    }

    private void allocateNormal(PooledByteBuf<T> pooledByteBuf, int i, int i2, PoolThreadCache poolThreadCache) {
        if (!this.q050.allocate(pooledByteBuf, i, i2, poolThreadCache) && !this.q025.allocate(pooledByteBuf, i, i2, poolThreadCache) && !this.q000.allocate(pooledByteBuf, i, i2, poolThreadCache) && !this.qInit.allocate(pooledByteBuf, i, i2, poolThreadCache) && !this.q075.allocate(pooledByteBuf, i, i2, poolThreadCache)) {
            PoolChunk newChunk = newChunk(this.pageSize, this.nPSizes, this.pageShifts, this.chunkSize);
            newChunk.allocate(pooledByteBuf, i, i2, poolThreadCache);
            this.qInit.add(newChunk);
        }
    }

    private static void appendPoolSubPages(StringBuilder sb, PoolSubpage<?>[] poolSubpageArr) {
        for (int i = 0; i < poolSubpageArr.length; i++) {
            PoolSubpage<T> poolSubpage = poolSubpageArr[i];
            if (poolSubpage.next != poolSubpage) {
                sb.append(StringUtil.NEWLINE);
                sb.append(i);
                sb.append(": ");
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                do {
                    sb.append(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
    }

    private void destroyPoolChunkLists(PoolChunkList<T>... poolChunkListArr) {
        for (PoolChunkList<T> destroy : poolChunkListArr) {
            destroy.destroy(this);
        }
    }

    private static void destroyPoolSubPages(PoolSubpage<?>[] poolSubpageArr) {
        for (PoolSubpage<?> destroy : poolSubpageArr) {
            destroy.destroy();
        }
    }

    private void incSmallAllocation() {
        this.allocationsSmall.increment();
    }

    private PoolSubpage<T>[] newSubpagePoolArray(int i) {
        return new PoolSubpage[i];
    }

    private PoolSubpage<T> newSubpagePoolHead() {
        PoolSubpage<T> poolSubpage = new PoolSubpage<>();
        poolSubpage.prev = poolSubpage;
        poolSubpage.next = poolSubpage;
        return poolSubpage;
    }

    private static SizeClass sizeClass(long j) {
        return PoolChunk.isSubpage(j) ? SizeClass.Small : SizeClass.Normal;
    }

    private static List<PoolSubpageMetric> subPageMetricList(PoolSubpage<?>[] poolSubpageArr) {
        ArrayList arrayList = new ArrayList();
        for (PoolSubpage<T> poolSubpage : poolSubpageArr) {
            PoolSubpage<T> poolSubpage2 = poolSubpage.next;
            if (poolSubpage2 != poolSubpage) {
                do {
                    arrayList.add(poolSubpage2);
                    poolSubpage2 = poolSubpage2.next;
                } while (poolSubpage2 != poolSubpage);
            }
        }
        return arrayList;
    }

    private void tcacheAllocateNormal(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        if (!poolThreadCache.allocateNormal(this, pooledByteBuf, i, i2)) {
            lock();
            try {
                allocateNormal(pooledByteBuf, i, i2, poolThreadCache);
                this.allocationsNormal++;
            } finally {
                unlock();
            }
        }
    }

    private void tcacheAllocateSmall(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i, int i2) {
        if (!poolThreadCache.allocateSmall(this, pooledByteBuf, i, i2)) {
            PoolSubpage<T> poolSubpage = this.smallSubpagePools[i2];
            poolSubpage.lock();
            try {
                PoolSubpage<T> poolSubpage2 = poolSubpage.next;
                boolean z = poolSubpage2 == poolSubpage;
                if (!z) {
                    poolSubpage2.chunk.initBufWithSubpage(pooledByteBuf, (ByteBuffer) null, poolSubpage2.allocate(), i, poolThreadCache);
                }
                if (z) {
                    lock();
                    try {
                        allocateNormal(pooledByteBuf, i, i2, poolThreadCache);
                    } finally {
                        unlock();
                    }
                }
                incSmallAllocation();
            } finally {
                poolSubpage.unlock();
            }
        }
    }

    public PooledByteBuf<T> allocate(PoolThreadCache poolThreadCache, int i, int i2) {
        PooledByteBuf<T> newByteBuf = newByteBuf(i2);
        allocate(poolThreadCache, newByteBuf, i);
        return newByteBuf;
    }

    public List<PoolChunkListMetric> chunkLists() {
        return this.chunkListMetrics;
    }

    public abstract void destroyChunk(PoolChunk<T> poolChunk);

    public final void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            destroyPoolSubPages(this.smallSubpagePools);
            destroyPoolChunkLists(this.qInit, this.q000, this.q025, this.q050, this.q075, this.q100);
        }
    }

    public PoolSubpage<T> findSubpagePoolHead(int i) {
        return this.smallSubpagePools[i];
    }

    public void free(PoolChunk<T> poolChunk, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        if (poolChunk.unpooled) {
            int chunkSize = poolChunk.chunkSize();
            destroyChunk(poolChunk);
            this.activeBytesHuge.add((long) (-chunkSize));
            this.deallocationsHuge.increment();
            return;
        }
        SizeClass sizeClass = sizeClass(j);
        if (poolThreadCache == null || !poolThreadCache.add(this, poolChunk, byteBuffer, j, i, sizeClass)) {
            freeChunk(poolChunk, j, i, sizeClass, byteBuffer, false);
        }
    }

    public void freeChunk(PoolChunk<T> poolChunk, long j, int i, SizeClass sizeClass, ByteBuffer byteBuffer, boolean z) {
        lock();
        if (!z) {
            try {
                int i2 = AnonymousClass1.$SwitchMap$io$netty$buffer$PoolArena$SizeClass[sizeClass.ordinal()];
                if (i2 == 1) {
                    this.deallocationsNormal++;
                } else if (i2 == 2) {
                    this.deallocationsSmall++;
                } else {
                    throw new Error();
                }
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        boolean z2 = !poolChunk.parent.free(poolChunk, j, i, byteBuffer);
        unlock();
        if (z2) {
            destroyChunk(poolChunk);
        }
    }

    public abstract boolean isDirect();

    public void lock() {
        this.lock.lock();
    }

    public abstract void memoryCopy(T t, int i, PooledByteBuf<T> pooledByteBuf, int i2);

    public abstract PooledByteBuf<T> newByteBuf(int i);

    public abstract PoolChunk<T> newChunk(int i, int i2, int i3, int i4);

    public abstract PoolChunk<T> newUnpooledChunk(int i);

    /* JADX INFO: finally extract failed */
    public long numActiveAllocations() {
        long value = (this.allocationsSmall.value() + this.allocationsHuge.value()) - this.deallocationsHuge.value();
        lock();
        try {
            long j = this.allocationsNormal;
            unlock();
            return Math.max(value + (j - (this.deallocationsSmall + this.deallocationsNormal)), 0);
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public long numActiveBytes() {
        long value = this.activeBytesHuge.value();
        lock();
        int i = 0;
        while (i < this.chunkListMetrics.size()) {
            try {
                for (PoolChunkMetric chunkSize : this.chunkListMetrics.get(i)) {
                    value += (long) chunkSize.chunkSize();
                }
                i++;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        unlock();
        return Math.max(0, value);
    }

    public long numActiveHugeAllocations() {
        return Math.max(numHugeAllocations() - numHugeDeallocations(), 0);
    }

    /* JADX INFO: finally extract failed */
    public long numActiveNormalAllocations() {
        lock();
        try {
            long j = this.allocationsNormal - this.deallocationsNormal;
            unlock();
            return Math.max(j, 0);
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public long numActiveSmallAllocations() {
        return Math.max(numSmallAllocations() - numSmallDeallocations(), 0);
    }

    public long numActiveTinyAllocations() {
        return 0;
    }

    /* JADX INFO: finally extract failed */
    public long numAllocations() {
        lock();
        try {
            long j = this.allocationsNormal;
            unlock();
            return this.allocationsSmall.value() + j + this.allocationsHuge.value();
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public int numChunkLists() {
        return this.chunkListMetrics.size();
    }

    /* JADX INFO: finally extract failed */
    public long numDeallocations() {
        lock();
        try {
            long j = this.deallocationsSmall + this.deallocationsNormal;
            unlock();
            return j + this.deallocationsHuge.value();
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public long numHugeAllocations() {
        return this.allocationsHuge.value();
    }

    public long numHugeDeallocations() {
        return this.deallocationsHuge.value();
    }

    public long numNormalAllocations() {
        lock();
        try {
            return this.allocationsNormal;
        } finally {
            unlock();
        }
    }

    public long numNormalDeallocations() {
        lock();
        try {
            return this.deallocationsNormal;
        } finally {
            unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public long numPinnedBytes() {
        long value = this.activeBytesHuge.value();
        lock();
        int i = 0;
        while (i < this.chunkListMetrics.size()) {
            try {
                for (PoolChunkMetric poolChunkMetric : this.chunkListMetrics.get(i)) {
                    value += (long) ((PoolChunk) poolChunkMetric).pinnedBytes();
                }
                i++;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }
        unlock();
        return Math.max(0, value);
    }

    public long numSmallAllocations() {
        return this.allocationsSmall.value();
    }

    public long numSmallDeallocations() {
        lock();
        try {
            return this.deallocationsSmall;
        } finally {
            unlock();
        }
    }

    public int numSmallSubpages() {
        return this.smallSubpagePools.length;
    }

    public int numThreadCaches() {
        return this.numThreadCaches.get();
    }

    public long numTinyAllocations() {
        return 0;
    }

    public long numTinyDeallocations() {
        return 0;
    }

    public int numTinySubpages() {
        return 0;
    }

    public void reallocate(PooledByteBuf<T> pooledByteBuf, int i, boolean z) {
        int i2 = pooledByteBuf.length;
        if (i2 != i) {
            PoolChunk<T> poolChunk = pooledByteBuf.chunk;
            ByteBuffer byteBuffer = pooledByteBuf.tmpNioBuf;
            long j = pooledByteBuf.handle;
            T t = pooledByteBuf.memory;
            int i3 = pooledByteBuf.offset;
            int i4 = pooledByteBuf.maxLength;
            allocate(this.parent.threadCache(), pooledByteBuf, i);
            if (i > i2) {
                i = i2;
            } else {
                pooledByteBuf.trimIndicesToCapacity(i);
            }
            memoryCopy(t, i3, pooledByteBuf, i);
            if (z) {
                free(poolChunk, byteBuffer, j, i4, pooledByteBuf.cache);
            }
        }
    }

    public List<PoolSubpageMetric> smallSubpages() {
        return subPageMetricList(this.smallSubpagePools);
    }

    public List<PoolSubpageMetric> tinySubpages() {
        return Collections.emptyList();
    }

    public String toString() {
        lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Chunk(s) at 0~25%:");
            String str = StringUtil.NEWLINE;
            sb.append(str);
            sb.append(this.qInit);
            sb.append(str);
            sb.append("Chunk(s) at 0~50%:");
            sb.append(str);
            sb.append(this.q000);
            sb.append(str);
            sb.append("Chunk(s) at 25~75%:");
            sb.append(str);
            sb.append(this.q025);
            sb.append(str);
            sb.append("Chunk(s) at 50~100%:");
            sb.append(str);
            sb.append(this.q050);
            sb.append(str);
            sb.append("Chunk(s) at 75~100%:");
            sb.append(str);
            sb.append(this.q075);
            sb.append(str);
            sb.append("Chunk(s) at 100%:");
            sb.append(str);
            sb.append(this.q100);
            sb.append(str);
            sb.append("small subpages:");
            appendPoolSubPages(sb, this.smallSubpagePools);
            sb.append(str);
            return sb.toString();
        } finally {
            unlock();
        }
    }

    public void unlock() {
        this.lock.unlock();
    }

    private void allocate(PoolThreadCache poolThreadCache, PooledByteBuf<T> pooledByteBuf, int i) {
        int size2SizeIdx = size2SizeIdx(i);
        if (size2SizeIdx <= this.smallMaxSizeIdx) {
            tcacheAllocateSmall(poolThreadCache, pooledByteBuf, i, size2SizeIdx);
        } else if (size2SizeIdx < this.nSizes) {
            tcacheAllocateNormal(poolThreadCache, pooledByteBuf, i, size2SizeIdx);
        } else {
            if (this.directMemoryCacheAlignment > 0) {
                i = normalizeSize(i);
            }
            allocateHuge(pooledByteBuf, i);
        }
    }
}
