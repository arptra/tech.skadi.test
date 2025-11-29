package io.netty.buffer;

import java.util.concurrent.locks.ReentrantLock;

final class PoolSubpage<T> implements PoolSubpageMetric {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final long[] bitmap;
    private int bitmapLength;
    final PoolChunk<T> chunk;
    boolean doNotDestroy;
    final int elemSize;
    private final ReentrantLock lock;
    private int maxNumElems;
    PoolSubpage<T> next;
    private int nextAvail;
    private int numAvail;
    private final int pageShifts;
    PoolSubpage<T> prev;
    private final int runOffset;
    private final int runSize;

    public PoolSubpage() {
        this.lock = new ReentrantLock();
        this.chunk = null;
        this.pageShifts = -1;
        this.runOffset = -1;
        this.elemSize = -1;
        this.runSize = -1;
        this.bitmap = null;
    }

    private void addToPool(PoolSubpage<T> poolSubpage) {
        this.prev = poolSubpage;
        PoolSubpage<T> poolSubpage2 = poolSubpage.next;
        this.next = poolSubpage2;
        poolSubpage2.prev = this;
        poolSubpage.next = this;
    }

    private int findNextAvail() {
        long[] jArr = this.bitmap;
        int i = this.bitmapLength;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if ((~j) != 0) {
                return findNextAvail0(i2, j);
            }
        }
        return -1;
    }

    private int findNextAvail0(int i, long j) {
        int i2 = this.maxNumElems;
        int i3 = i << 6;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((1 & j) == 0) {
                int i5 = i3 | i4;
                if (i5 < i2) {
                    return i5;
                }
                return -1;
            }
            j >>>= 1;
        }
        return -1;
    }

    private int getNextAvail() {
        int i = this.nextAvail;
        if (i < 0) {
            return findNextAvail();
        }
        this.nextAvail = -1;
        return i;
    }

    private void removeFromPool() {
        PoolSubpage<T> poolSubpage = this.prev;
        poolSubpage.next = this.next;
        this.next.prev = poolSubpage;
        this.next = null;
        this.prev = null;
    }

    private void setNextAvail(int i) {
        this.nextAvail = i;
    }

    private long toHandle(int i) {
        int i2 = this.runSize >> this.pageShifts;
        return ((long) i) | (((long) this.runOffset) << 49) | (((long) i2) << 34) | 12884901888L;
    }

    public long allocate() {
        if (this.numAvail == 0 || !this.doNotDestroy) {
            return -1;
        }
        int nextAvail2 = getNextAvail();
        int i = nextAvail2 >>> 6;
        long[] jArr = this.bitmap;
        jArr[i] = jArr[i] | (1 << (nextAvail2 & 63));
        int i2 = this.numAvail - 1;
        this.numAvail = i2;
        if (i2 == 0) {
            removeFromPool();
        }
        return toHandle(nextAvail2);
    }

    public void destroy() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk != null) {
            poolChunk.destroy();
        }
    }

    public int elementSize() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return -1;
        }
        poolChunk.arena.lock();
        try {
            return this.elemSize;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    public boolean free(PoolSubpage<T> poolSubpage, int i) {
        if (this.elemSize == 0) {
            return true;
        }
        int i2 = i >>> 6;
        long[] jArr = this.bitmap;
        jArr[i2] = jArr[i2] ^ (1 << (i & 63));
        setNextAvail(i);
        int i3 = this.numAvail;
        this.numAvail = i3 + 1;
        if (i3 == 0) {
            addToPool(poolSubpage);
            if (this.maxNumElems > 1) {
                return true;
            }
        }
        if (this.numAvail != this.maxNumElems || this.prev == this.next) {
            return true;
        }
        this.doNotDestroy = false;
        removeFromPool();
        return false;
    }

    public void lock() {
        this.lock.lock();
    }

    public int maxNumElements() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.maxNumElems;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    public int numAvailable() {
        PoolChunk<T> poolChunk = this.chunk;
        if (poolChunk == null) {
            return 0;
        }
        poolChunk.arena.lock();
        try {
            return this.numAvail;
        } finally {
            this.chunk.arena.unlock();
        }
    }

    public int pageSize() {
        return 1 << this.pageShifts;
    }

    /* JADX INFO: finally extract failed */
    public String toString() {
        int i;
        int i2;
        PoolChunk<T> poolChunk = this.chunk;
        int i3 = -1;
        boolean z = true;
        int i4 = 0;
        if (poolChunk == null) {
            i = 0;
        } else {
            poolChunk.arena.lock();
            try {
                if (!this.doNotDestroy) {
                    i = -1;
                    z = false;
                    i2 = -1;
                } else {
                    i3 = this.maxNumElems;
                    i = this.numAvail;
                    i2 = this.elemSize;
                }
                this.chunk.arena.unlock();
                int i5 = i2;
                i4 = i3;
                i3 = i5;
            } catch (Throwable th) {
                this.chunk.arena.unlock();
                throw th;
            }
        }
        if (!z) {
            return "(" + this.runOffset + ": not in use)";
        }
        return "(" + this.runOffset + ": " + (i4 - i) + '/' + i4 + ", offset: " + this.runOffset + ", length: " + this.runSize + ", elemSize: " + i3 + ')';
    }

    public void unlock() {
        this.lock.unlock();
    }

    public PoolSubpage(PoolSubpage<T> poolSubpage, PoolChunk<T> poolChunk, int i, int i2, int i3, int i4) {
        this.lock = new ReentrantLock();
        this.chunk = poolChunk;
        this.pageShifts = i;
        this.runOffset = i2;
        this.runSize = i3;
        this.elemSize = i4;
        this.bitmap = new long[(i3 >>> 10)];
        this.doNotDestroy = true;
        if (i4 != 0) {
            int i5 = i3 / i4;
            this.numAvail = i5;
            this.maxNumElems = i5;
            this.nextAvail = 0;
            int i6 = i5 >>> 6;
            this.bitmapLength = i6;
            if ((i5 & 63) != 0) {
                this.bitmapLength = i6 + 1;
            }
            for (int i7 = 0; i7 < this.bitmapLength; i7++) {
                this.bitmap[i7] = 0;
            }
        }
        addToPool(poolSubpage);
    }
}
