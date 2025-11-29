package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

final class PoolChunk<T> implements PoolChunkMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BITMAP_IDX_BIT_LENGTH = 32;
    private static final int INUSED_BIT_LENGTH = 1;
    static final int IS_SUBPAGE_SHIFT = 32;
    static final int IS_USED_SHIFT = 33;
    static final int RUN_OFFSET_SHIFT = 49;
    private static final int SIZE_BIT_LENGTH = 15;
    static final int SIZE_SHIFT = 34;
    private static final int SUBPAGE_BIT_LENGTH = 1;
    final PoolArena<T> arena;
    final Object base;
    private final Deque<ByteBuffer> cachedNioBuffers;
    private final int chunkSize;
    int freeBytes;
    final T memory;
    PoolChunk<T> next;
    private final int pageShifts;
    private final int pageSize;
    PoolChunkList<T> parent;
    private final LongCounter pinnedBytes = PlatformDependent.newLongCounter();
    PoolChunk<T> prev;
    private final LongPriorityQueue[] runsAvail;
    private final ReentrantLock runsAvailLock;
    private final LongLongHashMap runsAvailMap;
    private final PoolSubpage<T>[] subpages;
    final boolean unpooled = true;

    public PoolChunk(PoolArena<T> poolArena, Object obj, T t, int i, int i2, int i3, int i4) {
        this.arena = poolArena;
        this.base = obj;
        this.memory = t;
        this.pageSize = i;
        this.pageShifts = i2;
        this.chunkSize = i3;
        this.freeBytes = i3;
        this.runsAvail = newRunsAvailqueueArray(i4);
        this.runsAvailLock = new ReentrantLock();
        this.runsAvailMap = new LongLongHashMap(-1);
        int i5 = i3 >> i2;
        this.subpages = new PoolSubpage[i5];
        insertAvailRun(0, i5, ((long) i5) << 34);
        this.cachedNioBuffers = new ArrayDeque(8);
    }

    private long allocateRun(int i) {
        int i2 = i >> this.pageShifts;
        int pages2pageIdx = this.arena.pages2pageIdx(i2);
        this.runsAvailLock.lock();
        try {
            int runFirstBestFit = runFirstBestFit(pages2pageIdx);
            if (runFirstBestFit == -1) {
                this.runsAvailLock.unlock();
                return -1;
            }
            LongPriorityQueue longPriorityQueue = this.runsAvail[runFirstBestFit];
            long poll = longPriorityQueue.poll();
            removeAvailRun(longPriorityQueue, poll);
            if (poll != -1) {
                poll = splitLargeRun(poll, i2);
            }
            this.freeBytes -= runSize(this.pageShifts, poll);
            this.runsAvailLock.unlock();
            return poll;
        } catch (Throwable th) {
            this.runsAvailLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    private long allocateSubpage(int i) {
        PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(i);
        findSubpagePoolHead.lock();
        try {
            long allocateRun = allocateRun(calculateRunSize(i));
            if (allocateRun < 0) {
                findSubpagePoolHead.unlock();
                return -1;
            }
            int runOffset = runOffset(allocateRun);
            int sizeIdx2size = this.arena.sizeIdx2size(i);
            int i2 = this.pageShifts;
            PoolSubpage<T> poolSubpage = new PoolSubpage<>(findSubpagePoolHead, this, i2, runOffset, runSize(i2, allocateRun), sizeIdx2size);
            this.subpages[runOffset] = poolSubpage;
            long allocate = poolSubpage.allocate();
            findSubpagePoolHead.unlock();
            return allocate;
        } catch (Throwable th) {
            findSubpagePoolHead.unlock();
            throw th;
        }
    }

    public static int bitmapIdx(long j) {
        return (int) j;
    }

    private int calculateRunSize(int i) {
        int i2;
        int i3 = 1 << (this.pageShifts - 4);
        int sizeIdx2size = this.arena.sizeIdx2size(i);
        int i4 = 0;
        do {
            i4 += this.pageSize;
            i2 = i4 / sizeIdx2size;
            if (i2 >= i3 || i4 == i2 * sizeIdx2size) {
            }
            i4 += this.pageSize;
            i2 = i4 / sizeIdx2size;
            break;
        } while (i4 == i2 * sizeIdx2size);
        while (i2 > i3) {
            i4 -= this.pageSize;
            i2 = i4 / sizeIdx2size;
        }
        return i4;
    }

    private long collapseNext(long j) {
        while (true) {
            int runOffset = runOffset(j);
            int runPages = runPages(j);
            int i = runOffset + runPages;
            long availRunByOffset = getAvailRunByOffset(i);
            if (availRunByOffset == -1) {
                return j;
            }
            int runOffset2 = runOffset(availRunByOffset);
            int runPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j || i != runOffset2) {
                return j;
            }
            removeAvailRun(availRunByOffset);
            j = toRunHandle(runOffset, runPages + runPages2, 0);
        }
        return j;
    }

    private long collapsePast(long j) {
        while (true) {
            int runOffset = runOffset(j);
            int runPages = runPages(j);
            long availRunByOffset = getAvailRunByOffset(runOffset - 1);
            if (availRunByOffset == -1) {
                return j;
            }
            int runOffset2 = runOffset(availRunByOffset);
            int runPages2 = runPages(availRunByOffset);
            if (availRunByOffset == j || runOffset2 + runPages2 != runOffset) {
                return j;
            }
            removeAvailRun(availRunByOffset);
            j = toRunHandle(runOffset2, runPages2 + runPages, 0);
        }
        return j;
    }

    private long collapseRuns(long j) {
        return collapseNext(collapsePast(j));
    }

    private long getAvailRunByOffset(int i) {
        return this.runsAvailMap.get((long) i);
    }

    private void insertAvailRun(int i, int i2, long j) {
        this.runsAvail[this.arena.pages2pageIdxFloor(i2)].offer(j);
        insertAvailRun0(i, j);
        if (i2 > 1) {
            insertAvailRun0(lastPage(i, i2), j);
        }
    }

    private void insertAvailRun0(int i, long j) {
        this.runsAvailMap.put((long) i, j);
    }

    public static boolean isRun(long j) {
        return !isSubpage(j);
    }

    public static boolean isSubpage(long j) {
        return ((j >> 32) & 1) == 1;
    }

    public static boolean isUsed(long j) {
        return ((j >> 33) & 1) == 1;
    }

    private static int lastPage(int i, int i2) {
        return (i + i2) - 1;
    }

    private static LongPriorityQueue[] newRunsAvailqueueArray(int i) {
        LongPriorityQueue[] longPriorityQueueArr = new LongPriorityQueue[i];
        for (int i2 = 0; i2 < i; i2++) {
            longPriorityQueueArr[i2] = new LongPriorityQueue();
        }
        return longPriorityQueueArr;
    }

    private void removeAvailRun(long j) {
        removeAvailRun(this.runsAvail[this.arena.pages2pageIdxFloor(runPages(j))], j);
    }

    private int runFirstBestFit(int i) {
        if (this.freeBytes == this.chunkSize) {
            return this.arena.nPSizes - 1;
        }
        while (i < this.arena.nPSizes) {
            LongPriorityQueue longPriorityQueue = this.runsAvail[i];
            if (longPriorityQueue != null && !longPriorityQueue.isEmpty()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int runOffset(long j) {
        return (int) (j >> 49);
    }

    public static int runPages(long j) {
        return (int) ((j >> 34) & 32767);
    }

    public static int runSize(int i, long j) {
        return runPages(j) << i;
    }

    private long splitLargeRun(long j, int i) {
        int runPages = runPages(j) - i;
        if (runPages <= 0) {
            return j | 8589934592L;
        }
        int runOffset = runOffset(j);
        int i2 = runOffset + i;
        insertAvailRun(i2, runPages, toRunHandle(i2, runPages, 0));
        return toRunHandle(runOffset, i, 1);
    }

    private static long toRunHandle(int i, int i2, int i3) {
        return (((long) i2) << 34) | (((long) i) << 49) | (((long) i3) << 33);
    }

    public boolean allocate(PooledByteBuf<T> pooledByteBuf, int i, int i2, PoolThreadCache poolThreadCache) {
        long allocateRun;
        PoolArena<T> poolArena = this.arena;
        if (i2 <= poolArena.smallMaxSizeIdx) {
            allocateRun = allocateSubpage(i2);
            if (allocateRun < 0) {
                return false;
            }
        } else {
            allocateRun = allocateRun(poolArena.sizeIdx2size(i2));
            if (allocateRun < 0) {
                return false;
            }
        }
        long j = allocateRun;
        Deque<ByteBuffer> deque = this.cachedNioBuffers;
        initBuf(pooledByteBuf, deque != null ? deque.pollLast() : null, j, i, poolThreadCache);
        return true;
    }

    public int chunkSize() {
        return this.chunkSize;
    }

    public void decrementPinnedMemory(int i) {
        this.pinnedBytes.add((long) (-i));
    }

    public void destroy() {
        this.arena.destroyChunk(this);
    }

    public void free(long j, int i, ByteBuffer byteBuffer) {
        Deque<ByteBuffer> deque;
        int runSize = runSize(this.pageShifts, j);
        if (isSubpage(j)) {
            PoolSubpage<T> findSubpagePoolHead = this.arena.findSubpagePoolHead(this.arena.size2SizeIdx(i));
            int runOffset = runOffset(j);
            PoolSubpage<T> poolSubpage = this.subpages[runOffset];
            findSubpagePoolHead.lock();
            try {
                if (!poolSubpage.free(findSubpagePoolHead, bitmapIdx(j))) {
                    this.subpages[runOffset] = null;
                    findSubpagePoolHead.unlock();
                } else {
                    return;
                }
            } finally {
                findSubpagePoolHead.unlock();
            }
        }
        this.runsAvailLock.lock();
        try {
            long collapseRuns = collapseRuns(j) & -12884901889L;
            insertAvailRun(runOffset(collapseRuns), runPages(collapseRuns), collapseRuns);
            this.freeBytes += runSize;
            if (byteBuffer != null && (deque = this.cachedNioBuffers) != null && deque.size() < PooledByteBufAllocator.DEFAULT_MAX_CACHED_BYTEBUFFERS_PER_CHUNK) {
                this.cachedNioBuffers.offer(byteBuffer);
            }
        } finally {
            this.runsAvailLock.unlock();
        }
    }

    public int freeBytes() {
        this.arena.lock();
        try {
            return this.freeBytes;
        } finally {
            this.arena.unlock();
        }
    }

    public void incrementPinnedMemory(int i) {
        this.pinnedBytes.add((long) i);
    }

    public void initBuf(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        if (isSubpage(j)) {
            initBufWithSubpage(pooledByteBuf, byteBuffer, j, i, poolThreadCache);
            return;
        }
        PooledByteBuf<T> pooledByteBuf2 = pooledByteBuf;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i2 = i;
        pooledByteBuf2.init(this, byteBuffer2, j2, runOffset(j) << this.pageShifts, i2, runSize(this.pageShifts, j), this.arena.parent.threadCache());
    }

    public void initBufWithSubpage(PooledByteBuf<T> pooledByteBuf, ByteBuffer byteBuffer, long j, int i, PoolThreadCache poolThreadCache) {
        int runOffset = runOffset(j);
        int bitmapIdx = bitmapIdx(j);
        int i2 = this.subpages[runOffset].elemSize;
        pooledByteBuf.init(this, byteBuffer, j, (runOffset << this.pageShifts) + (bitmapIdx * i2), i, i2, poolThreadCache);
    }

    public int pinnedBytes() {
        return (int) this.pinnedBytes.value();
    }

    /* JADX INFO: finally extract failed */
    public String toString() {
        this.arena.lock();
        try {
            int i = this.freeBytes;
            this.arena.unlock();
            return "Chunk(" + Integer.toHexString(System.identityHashCode(this)) + ": " + usage(i) + "%, " + (this.chunkSize - i) + '/' + this.chunkSize + ')';
        } catch (Throwable th) {
            this.arena.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public int usage() {
        this.arena.lock();
        try {
            int i = this.freeBytes;
            this.arena.unlock();
            return usage(i);
        } catch (Throwable th) {
            this.arena.unlock();
            throw th;
        }
    }

    private void removeAvailRun(LongPriorityQueue longPriorityQueue, long j) {
        longPriorityQueue.remove(j);
        int runOffset = runOffset(j);
        int runPages = runPages(j);
        this.runsAvailMap.remove((long) runOffset);
        if (runPages > 1) {
            this.runsAvailMap.remove((long) lastPage(runOffset, runPages));
        }
    }

    private int usage(int i) {
        if (i == 0) {
            return 100;
        }
        int i2 = (int) ((((long) i) * 100) / ((long) this.chunkSize));
        if (i2 == 0) {
            return 99;
        }
        return 100 - i2;
    }

    public PoolChunk(PoolArena<T> poolArena, Object obj, T t, int i) {
        this.arena = poolArena;
        this.base = obj;
        this.memory = t;
        this.pageSize = 0;
        this.pageShifts = 0;
        this.runsAvailMap = null;
        this.runsAvail = null;
        this.runsAvailLock = null;
        this.subpages = null;
        this.chunkSize = i;
        this.cachedNioBuffers = null;
    }
}
