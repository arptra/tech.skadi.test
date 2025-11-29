package io.netty.buffer;

import io.netty.buffer.PoolArena;
import io.netty.util.NettyRuntime;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

public class PooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CACHE_NOT_USED = 0;
    public static final PooledByteBufAllocator DEFAULT = new PooledByteBufAllocator(PlatformDependent.directBufferPreferred());
    /* access modifiers changed from: private */
    public static final int DEFAULT_CACHE_TRIM_INTERVAL;
    /* access modifiers changed from: private */
    public static final long DEFAULT_CACHE_TRIM_INTERVAL_MILLIS;
    private static final int DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT;
    static final int DEFAULT_MAX_CACHED_BUFFER_CAPACITY;
    static final int DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK;
    private static final int DEFAULT_MAX_ORDER;
    private static final int DEFAULT_NORMAL_CACHE_SIZE;
    private static final int DEFAULT_NUM_DIRECT_ARENA;
    private static final int DEFAULT_NUM_HEAP_ARENA;
    private static final int DEFAULT_PAGE_SIZE;
    private static final int DEFAULT_SMALL_CACHE_SIZE;
    private static final boolean DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    private static final int MAX_CHUNK_SIZE = 1073741824;
    private static final int MIN_PAGE_SIZE = 4096;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PooledByteBufAllocator.class);
    private final int chunkSize;
    private final List<PoolArenaMetric> directArenaMetrics;
    /* access modifiers changed from: private */
    public final PoolArena<ByteBuffer>[] directArenas;
    private final List<PoolArenaMetric> heapArenaMetrics;
    /* access modifiers changed from: private */
    public final PoolArena<byte[]>[] heapArenas;
    private final PooledByteBufAllocatorMetric metric;
    /* access modifiers changed from: private */
    public final int normalCacheSize;
    /* access modifiers changed from: private */
    public final int smallCacheSize;
    private final PoolThreadLocalCache threadCache;
    /* access modifiers changed from: private */
    public final Runnable trimTask;

    public final class PoolThreadLocalCache extends FastThreadLocal<PoolThreadCache> {
        private final boolean useCacheForAllThreads;

        public PoolThreadLocalCache(boolean z) {
            this.useCacheForAllThreads = z;
        }

        private <T> PoolArena<T> leastUsedArena(PoolArena<T>[] poolArenaArr) {
            if (poolArenaArr == null || poolArenaArr.length == 0) {
                return null;
            }
            PoolArena<T> poolArena = poolArenaArr[0];
            if (poolArena.numThreadCaches.get() == 0) {
                return poolArena;
            }
            for (int i = 1; i < poolArenaArr.length; i++) {
                PoolArena<T> poolArena2 = poolArenaArr[i];
                if (poolArena2.numThreadCaches.get() < poolArena.numThreadCaches.get()) {
                    poolArena = poolArena2;
                }
            }
            return poolArena;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0070, code lost:
            return r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized io.netty.buffer.PoolThreadCache initialValue() {
            /*
                r11 = this;
                monitor-enter(r11)
                io.netty.buffer.PooledByteBufAllocator r0 = io.netty.buffer.PooledByteBufAllocator.this     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PoolArena[] r0 = r0.heapArenas     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PoolArena r2 = r11.leastUsedArena(r0)     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PooledByteBufAllocator r0 = io.netty.buffer.PooledByteBufAllocator.this     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PoolArena[] r0 = r0.directArenas     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PoolArena r3 = r11.leastUsedArena(r0)     // Catch:{ all -> 0x0034 }
                java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0034 }
                io.netty.util.concurrent.EventExecutor r8 = io.netty.util.internal.ThreadExecutorMap.currentExecutor()     // Catch:{ all -> 0x0034 }
                boolean r1 = r11.useCacheForAllThreads     // Catch:{ all -> 0x0034 }
                if (r1 != 0) goto L_0x0036
                boolean r0 = r0 instanceof io.netty.util.concurrent.FastThreadLocalThread     // Catch:{ all -> 0x0034 }
                if (r0 != 0) goto L_0x0036
                if (r8 == 0) goto L_0x0028
                goto L_0x0036
            L_0x0028:
                io.netty.buffer.PoolThreadCache r0 = new io.netty.buffer.PoolThreadCache     // Catch:{ all -> 0x0034 }
                r6 = 0
                r7 = 0
                r4 = 0
                r5 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
                monitor-exit(r11)
                return r0
            L_0x0034:
                r0 = move-exception
                goto L_0x0071
            L_0x0036:
                io.netty.buffer.PoolThreadCache r0 = new io.netty.buffer.PoolThreadCache     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PooledByteBufAllocator r1 = io.netty.buffer.PooledByteBufAllocator.this     // Catch:{ all -> 0x0034 }
                int r4 = r1.smallCacheSize     // Catch:{ all -> 0x0034 }
                io.netty.buffer.PooledByteBufAllocator r1 = io.netty.buffer.PooledByteBufAllocator.this     // Catch:{ all -> 0x0034 }
                int r5 = r1.normalCacheSize     // Catch:{ all -> 0x0034 }
                int r6 = io.netty.buffer.PooledByteBufAllocator.DEFAULT_MAX_CACHED_BUFFER_CAPACITY     // Catch:{ all -> 0x0034 }
                int r7 = io.netty.buffer.PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL     // Catch:{ all -> 0x0034 }
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0034 }
                long r1 = io.netty.buffer.PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS     // Catch:{ all -> 0x0034 }
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 <= 0) goto L_0x006f
                if (r8 == 0) goto L_0x006f
                io.netty.buffer.PooledByteBufAllocator r1 = io.netty.buffer.PooledByteBufAllocator.this     // Catch:{ all -> 0x0034 }
                java.lang.Runnable r5 = r1.trimTask     // Catch:{ all -> 0x0034 }
                long r6 = io.netty.buffer.PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS     // Catch:{ all -> 0x0034 }
                long r1 = io.netty.buffer.PooledByteBufAllocator.DEFAULT_CACHE_TRIM_INTERVAL_MILLIS     // Catch:{ all -> 0x0034 }
                java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0034 }
                r4 = r8
                r8 = r1
                r4.scheduleAtFixedRate(r5, r6, r8, r10)     // Catch:{ all -> 0x0034 }
            L_0x006f:
                monitor-exit(r11)
                return r0
            L_0x0071:
                monitor-exit(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.buffer.PooledByteBufAllocator.PoolThreadLocalCache.initialValue():io.netty.buffer.PoolThreadCache");
        }

        public void onRemoval(PoolThreadCache poolThreadCache) {
            poolThreadCache.free(false);
        }
    }

    static {
        Object obj;
        int i = SystemPropertyUtil.getInt("io.netty.allocator.directMemoryCacheAlignment", 0);
        int i2 = SystemPropertyUtil.getInt("io.netty.allocator.pageSize", 8192);
        Object obj2 = null;
        try {
            validateAndCalculatePageShifts(i2, i);
            obj = null;
        } catch (Throwable th) {
            obj = th;
            i = 0;
            i2 = 8192;
        }
        DEFAULT_PAGE_SIZE = i2;
        DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT = i;
        int i3 = 9;
        int i4 = SystemPropertyUtil.getInt("io.netty.allocator.maxOrder", 9);
        try {
            validateAndCalculateChunkSize(i2, i4);
            i3 = i4;
        } catch (Throwable th2) {
            obj2 = th2;
        }
        DEFAULT_MAX_ORDER = i3;
        Runtime runtime = Runtime.getRuntime();
        int i5 = DEFAULT_PAGE_SIZE;
        long availableProcessors = (long) (NettyRuntime.availableProcessors() * 2);
        long j = (long) (i5 << i3);
        int max = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numHeapArenas", (int) Math.min(availableProcessors, ((runtime.maxMemory() / j) / 2) / 3)));
        DEFAULT_NUM_HEAP_ARENA = max;
        int max2 = Math.max(0, SystemPropertyUtil.getInt("io.netty.allocator.numDirectArenas", (int) Math.min(availableProcessors, ((PlatformDependent.maxDirectMemory() / j) / 2) / 3)));
        DEFAULT_NUM_DIRECT_ARENA = max2;
        int i6 = SystemPropertyUtil.getInt("io.netty.allocator.smallCacheSize", 256);
        DEFAULT_SMALL_CACHE_SIZE = i6;
        int i7 = SystemPropertyUtil.getInt("io.netty.allocator.normalCacheSize", 64);
        DEFAULT_NORMAL_CACHE_SIZE = i7;
        int i8 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedBufferCapacity", 32768);
        DEFAULT_MAX_CACHED_BUFFER_CAPACITY = i8;
        int i9 = SystemPropertyUtil.getInt("io.netty.allocator.cacheTrimInterval", 8192);
        DEFAULT_CACHE_TRIM_INTERVAL = i9;
        if (SystemPropertyUtil.contains("io.netty.allocation.cacheTrimIntervalMillis")) {
            logger.warn("-Dio.netty.allocation.cacheTrimIntervalMillis is deprecated, use -Dio.netty.allocator.cacheTrimIntervalMillis");
            if (SystemPropertyUtil.contains("io.netty.allocator.cacheTrimIntervalMillis")) {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0);
            } else {
                DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocation.cacheTrimIntervalMillis", 0);
            }
        } else {
            DEFAULT_CACHE_TRIM_INTERVAL_MILLIS = SystemPropertyUtil.getLong("io.netty.allocator.cacheTrimIntervalMillis", 0);
        }
        boolean z = SystemPropertyUtil.getBoolean("io.netty.allocator.useCacheForAllThreads", false);
        DEFAULT_USE_CACHE_FOR_ALL_THREADS = z;
        int i10 = SystemPropertyUtil.getInt("io.netty.allocator.maxCachedByteBuffersPerChunk", 1023);
        DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK = i10;
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("-Dio.netty.allocator.numHeapArenas: {}", (Object) Integer.valueOf(max));
            internalLogger.debug("-Dio.netty.allocator.numDirectArenas: {}", (Object) Integer.valueOf(max2));
            if (obj == null) {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", (Object) Integer.valueOf(i5));
            } else {
                internalLogger.debug("-Dio.netty.allocator.pageSize: {}", Integer.valueOf(i5), obj);
            }
            if (obj2 == null) {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", (Object) Integer.valueOf(i3));
            } else {
                internalLogger.debug("-Dio.netty.allocator.maxOrder: {}", Integer.valueOf(i3), obj2);
            }
            internalLogger.debug("-Dio.netty.allocator.chunkSize: {}", (Object) Integer.valueOf(i5 << i3));
            internalLogger.debug("-Dio.netty.allocator.smallCacheSize: {}", (Object) Integer.valueOf(i6));
            internalLogger.debug("-Dio.netty.allocator.normalCacheSize: {}", (Object) Integer.valueOf(i7));
            internalLogger.debug("-Dio.netty.allocator.maxCachedBufferCapacity: {}", (Object) Integer.valueOf(i8));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimInterval: {}", (Object) Integer.valueOf(i9));
            internalLogger.debug("-Dio.netty.allocator.cacheTrimIntervalMillis: {}", (Object) Long.valueOf(DEFAULT_CACHE_TRIM_INTERVAL_MILLIS));
            internalLogger.debug("-Dio.netty.allocator.useCacheForAllThreads: {}", (Object) Boolean.valueOf(z));
            internalLogger.debug("-Dio.netty.allocator.maxCachedByteBuffersPerChunk: {}", (Object) Integer.valueOf(i10));
        }
    }

    public PooledByteBufAllocator() {
        this(false);
    }

    public static int defaultMaxOrder() {
        return DEFAULT_MAX_ORDER;
    }

    public static int defaultNormalCacheSize() {
        return DEFAULT_NORMAL_CACHE_SIZE;
    }

    public static int defaultNumDirectArena() {
        return DEFAULT_NUM_DIRECT_ARENA;
    }

    public static int defaultNumHeapArena() {
        return DEFAULT_NUM_HEAP_ARENA;
    }

    public static int defaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static boolean defaultPreferDirect() {
        return PlatformDependent.directBufferPreferred();
    }

    public static int defaultSmallCacheSize() {
        return DEFAULT_SMALL_CACHE_SIZE;
    }

    @Deprecated
    public static int defaultTinyCacheSize() {
        return 0;
    }

    public static boolean defaultUseCacheForAllThreads() {
        return DEFAULT_USE_CACHE_FOR_ALL_THREADS;
    }

    public static boolean isDirectMemoryCacheAlignmentSupported() {
        return PlatformDependent.hasUnsafe();
    }

    private static <T> PoolArena<T>[] newArenaArray(int i) {
        return new PoolArena[i];
    }

    private static long pinnedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1;
        }
        long j = 0;
        for (PoolArena<?> numPinnedBytes : poolArenaArr) {
            j += numPinnedBytes.numPinnedBytes();
            if (j < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
        }
        return j;
    }

    private static long usedMemory(PoolArena<?>[] poolArenaArr) {
        if (poolArenaArr == null) {
            return -1;
        }
        long j = 0;
        for (PoolArena<?> numActiveBytes : poolArenaArr) {
            j += numActiveBytes.numActiveBytes();
            if (j < 0) {
                return LongCompanionObject.MAX_VALUE;
            }
        }
        return j;
    }

    private static int validateAndCalculateChunkSize(int i, int i2) {
        if (i2 <= 14) {
            int i3 = i;
            int i4 = i2;
            while (i4 > 0) {
                if (i3 <= 536870912) {
                    i3 <<= 1;
                    i4--;
                } else {
                    throw new IllegalArgumentException(String.format("pageSize (%d) << maxOrder (%d) must not exceed %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), 1073741824}));
                }
            }
            return i3;
        }
        throw new IllegalArgumentException("maxOrder: " + i2 + " (expected: 0-14)");
    }

    private static int validateAndCalculatePageShifts(int i, int i2) {
        if (i < 4096) {
            throw new IllegalArgumentException("pageSize: " + i + " (expected: " + 4096 + ')');
        } else if (((i - 1) & i) != 0) {
            throw new IllegalArgumentException("pageSize: " + i + " (expected: power of 2)");
        } else if (i >= i2) {
            return 31 - Integer.numberOfLeadingZeros(i);
        } else {
            throw new IllegalArgumentException("Alignment cannot be greater than page size. Alignment: " + i2 + ", page size: " + i + '.');
        }
    }

    @Deprecated
    public final int chunkSize() {
        return this.chunkSize;
    }

    @Deprecated
    public List<PoolArenaMetric> directArenas() {
        return this.directArenaMetrics;
    }

    public String dumpStats() {
        PoolArena<byte[]>[] poolArenaArr = this.heapArenas;
        int length = poolArenaArr == null ? 0 : poolArenaArr.length;
        StringBuilder sb = new StringBuilder(512);
        sb.append(length);
        sb.append(" heap arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length > 0) {
            for (PoolArena<byte[]> append : this.heapArenas) {
                sb.append(append);
            }
        }
        PoolArena<ByteBuffer>[] poolArenaArr2 = this.directArenas;
        int length2 = poolArenaArr2 == null ? 0 : poolArenaArr2.length;
        sb.append(length2);
        sb.append(" direct arena(s):");
        sb.append(StringUtil.NEWLINE);
        if (length2 > 0) {
            for (PoolArena<ByteBuffer> append2 : this.directArenas) {
                sb.append(append2);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public void freeThreadLocalCache() {
        this.threadCache.remove();
    }

    @Deprecated
    public boolean hasThreadLocalCache() {
        return this.threadCache.isSet();
    }

    @Deprecated
    public List<PoolArenaMetric> heapArenas() {
        return this.heapArenaMetrics;
    }

    public boolean isDirectBufferPooled() {
        return this.directArenas != null;
    }

    public ByteBuf newDirectBuffer(int i, int i2) {
        PoolThreadCache poolThreadCache = (PoolThreadCache) this.threadCache.get();
        PoolArena poolArena = poolThreadCache.directArena;
        return AbstractByteBufAllocator.toLeakAwareBuffer(poolArena != null ? poolArena.allocate(poolThreadCache, i, i2) : PlatformDependent.hasUnsafe() ? UnsafeByteBufUtil.newUnsafeDirectByteBuf(this, i, i2) : new UnpooledDirectByteBuf((ByteBufAllocator) this, i, i2));
    }

    public ByteBuf newHeapBuffer(int i, int i2) {
        AbstractByteBuf abstractByteBuf;
        PoolThreadCache poolThreadCache = (PoolThreadCache) this.threadCache.get();
        PoolArena<byte[]> poolArena = poolThreadCache.heapArena;
        if (poolArena != null) {
            abstractByteBuf = poolArena.allocate(poolThreadCache, i, i2);
        } else {
            abstractByteBuf = PlatformDependent.hasUnsafe() ? new UnpooledUnsafeHeapByteBuf(this, i, i2) : new UnpooledHeapByteBuf((ByteBufAllocator) this, i, i2);
        }
        return AbstractByteBufAllocator.toLeakAwareBuffer((ByteBuf) abstractByteBuf);
    }

    @Deprecated
    public int normalCacheSize() {
        return this.normalCacheSize;
    }

    @Deprecated
    public int numDirectArenas() {
        return this.directArenaMetrics.size();
    }

    @Deprecated
    public int numHeapArenas() {
        return this.heapArenaMetrics.size();
    }

    @Deprecated
    public int numThreadLocalCaches() {
        PoolArena[] poolArenaArr = this.heapArenas;
        if (poolArenaArr == null) {
            poolArenaArr = this.directArenas;
        }
        if (poolArenaArr == null) {
            return 0;
        }
        int i = 0;
        for (PoolArena poolArena : poolArenaArr) {
            i += poolArena.numThreadCaches.get();
        }
        return i;
    }

    public final long pinnedDirectMemory() {
        return pinnedMemory(this.directArenas);
    }

    public final long pinnedHeapMemory() {
        return pinnedMemory(this.heapArenas);
    }

    @Deprecated
    public int smallCacheSize() {
        return this.smallCacheSize;
    }

    public final PoolThreadCache threadCache() {
        return (PoolThreadCache) this.threadCache.get();
    }

    @Deprecated
    public int tinyCacheSize() {
        return 0;
    }

    public boolean trimCurrentThreadCache() {
        PoolThreadCache poolThreadCache = (PoolThreadCache) this.threadCache.getIfExists();
        if (poolThreadCache == null) {
            return false;
        }
        poolThreadCache.trim();
        return true;
    }

    public final long usedDirectMemory() {
        return usedMemory(this.directArenas);
    }

    public final long usedHeapMemory() {
        return usedMemory(this.heapArenas);
    }

    public PooledByteBufAllocator(boolean z) {
        this(z, DEFAULT_NUM_HEAP_ARENA, DEFAULT_NUM_DIRECT_ARENA, DEFAULT_PAGE_SIZE, DEFAULT_MAX_ORDER);
    }

    public PooledByteBufAllocatorMetric metric() {
        return this.metric;
    }

    public PooledByteBufAllocator(int i, int i2, int i3, int i4) {
        this(false, i, i2, i3, i4);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4) {
        this(z, i, i2, i3, i4, 0, DEFAULT_SMALL_CACHE_SIZE, DEFAULT_NORMAL_CACHE_SIZE);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this(z, i, i2, i3, i4, i6, i7, DEFAULT_USE_CACHE_FOR_ALL_THREADS, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2) {
        this(z, i, i2, i3, i4, i6, i7, z2);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        this(z, i, i2, i3, i4, i5, i6, z2, DEFAULT_DIRECT_MEMORY_CACHE_ALIGNMENT);
    }

    @Deprecated
    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, int i8) {
        this(z, i, i2, i3, i4, i6, i7, z2, i8);
    }

    public PooledByteBufAllocator(boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2, int i7) {
        super(z);
        this.trimTask = new Runnable() {
            public void run() {
                PooledByteBufAllocator.this.trimCurrentThreadCache();
            }
        };
        this.threadCache = new PoolThreadLocalCache(z2);
        this.smallCacheSize = i5;
        this.normalCacheSize = i6;
        if (i7 != 0) {
            if (PlatformDependent.hasAlignDirectByteBuffer()) {
                i3 = (int) PlatformDependent.align((long) i3, i7);
            } else {
                throw new UnsupportedOperationException("Buffer alignment is not supported. Either Unsafe or ByteBuffer.alignSlice() must be available.");
            }
        }
        int i8 = i3;
        this.chunkSize = validateAndCalculateChunkSize(i8, i4);
        ObjectUtil.checkPositiveOrZero(i, "nHeapArena");
        ObjectUtil.checkPositiveOrZero(i2, "nDirectArena");
        ObjectUtil.checkPositiveOrZero(i7, "directMemoryCacheAlignment");
        if (i7 > 0 && !isDirectMemoryCacheAlignmentSupported()) {
            throw new IllegalArgumentException("directMemoryCacheAlignment is not supported");
        } else if (((-i7) & i7) == i7) {
            int validateAndCalculatePageShifts = validateAndCalculatePageShifts(i8, i7);
            if (i > 0) {
                PoolArena<byte[]>[] newArenaArray = newArenaArray(i);
                this.heapArenas = newArenaArray;
                ArrayList arrayList = new ArrayList(newArenaArray.length);
                for (int i9 = 0; i9 < this.heapArenas.length; i9++) {
                    PoolArena.HeapArena heapArena = new PoolArena.HeapArena(this, i8, validateAndCalculatePageShifts, this.chunkSize);
                    this.heapArenas[i9] = heapArena;
                    arrayList.add(heapArena);
                }
                this.heapArenaMetrics = Collections.unmodifiableList(arrayList);
            } else {
                this.heapArenas = null;
                this.heapArenaMetrics = Collections.emptyList();
            }
            if (i2 > 0) {
                PoolArena<ByteBuffer>[] newArenaArray2 = newArenaArray(i2);
                this.directArenas = newArenaArray2;
                ArrayList arrayList2 = new ArrayList(newArenaArray2.length);
                for (int i10 = 0; i10 < this.directArenas.length; i10++) {
                    PoolArena.DirectArena directArena = new PoolArena.DirectArena(this, i8, validateAndCalculatePageShifts, this.chunkSize, i7);
                    this.directArenas[i10] = directArena;
                    arrayList2.add(directArena);
                }
                this.directArenaMetrics = Collections.unmodifiableList(arrayList2);
            } else {
                this.directArenas = null;
                this.directArenaMetrics = Collections.emptyList();
            }
            this.metric = new PooledByteBufAllocatorMetric(this);
        } else {
            throw new IllegalArgumentException("directMemoryCacheAlignment: " + i7 + " (expected: power of two)");
        }
    }
}
