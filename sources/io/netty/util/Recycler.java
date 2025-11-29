package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class Recycler<T> {
    /* access modifiers changed from: private */
    public static final boolean BLOCKING_POOL;
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 4096;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final Handle<?> NOOP_HANDLE = new Handle<Object>() {
        public void recycle(Object obj) {
        }

        public String toString() {
            return "NOOP_HANDLE";
        }
    };
    private static final int RATIO;
    private static final InternalLogger logger;
    /* access modifiers changed from: private */
    public final int chunkSize;
    /* access modifiers changed from: private */
    public final int interval;
    /* access modifiers changed from: private */
    public final int maxCapacityPerThread;
    private final FastThreadLocal<LocalPool<T>> threadLocal;

    public static final class BlockingMessageQueue<T> implements MessagePassingQueue<T> {
        private final Queue<T> deque = new ArrayDeque();
        private final int maxCapacity;

        public BlockingMessageQueue(int i) {
            this.maxCapacity = i;
        }

        public int capacity() {
            return this.maxCapacity;
        }

        public synchronized void clear() {
            this.deque.clear();
        }

        public int drain(MessagePassingQueue.Consumer<T> consumer, int i) {
            throw new UnsupportedOperationException();
        }

        public int fill(MessagePassingQueue.Supplier<T> supplier, int i) {
            throw new UnsupportedOperationException();
        }

        public synchronized boolean isEmpty() {
            return this.deque.isEmpty();
        }

        public synchronized boolean offer(T t) {
            if (this.deque.size() == this.maxCapacity) {
                return false;
            }
            return this.deque.offer(t);
        }

        public synchronized T peek() {
            return this.deque.peek();
        }

        public synchronized T poll() {
            return this.deque.poll();
        }

        public boolean relaxedOffer(T t) {
            return offer(t);
        }

        public T relaxedPeek() {
            return peek();
        }

        public T relaxedPoll() {
            return poll();
        }

        public synchronized int size() {
            return this.deque.size();
        }

        public int drain(MessagePassingQueue.Consumer<T> consumer) {
            throw new UnsupportedOperationException();
        }

        public int fill(MessagePassingQueue.Supplier<T> supplier) {
            throw new UnsupportedOperationException();
        }

        public void drain(MessagePassingQueue.Consumer<T> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
            throw new UnsupportedOperationException();
        }

        public void fill(MessagePassingQueue.Supplier<T> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class DefaultHandle<T> implements Handle<T> {
        private static final int STATE_AVAILABLE = 1;
        private static final int STATE_CLAIMED = 0;
        private static final AtomicIntegerFieldUpdater<DefaultHandle<?>> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, "state");
        private final LocalPool<T> localPool;
        private volatile int state;
        private T value;

        public DefaultHandle(LocalPool<T> localPool2) {
            this.localPool = localPool2;
        }

        public boolean availableToClaim() {
            if (this.state != 1) {
                return false;
            }
            return STATE_UPDATER.compareAndSet(this, 1, 0);
        }

        public T get() {
            return this.value;
        }

        public void recycle(Object obj) {
            if (obj == this.value) {
                this.localPool.release(this);
                return;
            }
            throw new IllegalArgumentException("object does not belong to handle");
        }

        public void set(T t) {
            this.value = t;
        }

        public void toAvailable() {
            if (STATE_UPDATER.getAndSet(this, 1) == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }
    }

    public interface Handle<T> extends ObjectPool.Handle<T> {
    }

    public static final class LocalPool<T> {
        /* access modifiers changed from: private */
        public volatile MessagePassingQueue<DefaultHandle<T>> pooledHandles;
        private int ratioCounter;
        private final int ratioInterval;

        public LocalPool(int i, int i2, int i3) {
            this.ratioInterval = i2;
            if (Recycler.BLOCKING_POOL) {
                this.pooledHandles = new BlockingMessageQueue(i);
            } else {
                this.pooledHandles = (MessagePassingQueue) PlatformDependent.newMpscQueue(i3, i);
            }
            this.ratioCounter = i2;
        }

        public DefaultHandle<T> claim() {
            DefaultHandle<T> relaxedPoll;
            MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
            if (messagePassingQueue == null) {
                return null;
            }
            do {
                relaxedPoll = messagePassingQueue.relaxedPoll();
                if (relaxedPoll == null || relaxedPoll.availableToClaim()) {
                    return relaxedPoll;
                }
                relaxedPoll = messagePassingQueue.relaxedPoll();
                break;
            } while (relaxedPoll.availableToClaim());
            return relaxedPoll;
        }

        public DefaultHandle<T> newHandle() {
            int i = this.ratioCounter + 1;
            this.ratioCounter = i;
            if (i < this.ratioInterval) {
                return null;
            }
            this.ratioCounter = 0;
            return new DefaultHandle<>(this);
        }

        public void release(DefaultHandle<T> defaultHandle) {
            MessagePassingQueue<DefaultHandle<T>> messagePassingQueue = this.pooledHandles;
            defaultHandle.toAvailable();
            if (messagePassingQueue != null) {
                messagePassingQueue.relaxedOffer(defaultHandle);
            }
        }
    }

    static {
        InternalLogger instance = InternalLoggerFactory.getInstance((Class<?>) Recycler.class);
        logger = instance;
        int i = 4096;
        int i2 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 4096));
        if (i2 >= 0) {
            i = i2;
        }
        DEFAULT_MAX_CAPACITY_PER_THREAD = i;
        int i3 = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 32);
        DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = i3;
        int max = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        RATIO = max;
        boolean z = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        BLOCKING_POOL = z;
        if (!instance.isDebugEnabled()) {
            return;
        }
        if (i == 0) {
            instance.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
            instance.debug("-Dio.netty.recycler.ratio: disabled");
            instance.debug("-Dio.netty.recycler.chunkSize: disabled");
            instance.debug("-Dio.netty.recycler.blocking: disabled");
            return;
        }
        instance.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", (Object) Integer.valueOf(i));
        instance.debug("-Dio.netty.recycler.ratio: {}", (Object) Integer.valueOf(max));
        instance.debug("-Dio.netty.recycler.chunkSize: {}", (Object) Integer.valueOf(i3));
        instance.debug("-Dio.netty.recycler.blocking: {}", (Object) Boolean.valueOf(z));
    }

    public Recycler() {
        this(DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public final T get() {
        if (this.maxCapacityPerThread == 0) {
            return newObject(NOOP_HANDLE);
        }
        LocalPool localPool = this.threadLocal.get();
        DefaultHandle claim = localPool.claim();
        if (claim != null) {
            return claim.get();
        }
        DefaultHandle newHandle = localPool.newHandle();
        if (newHandle == null) {
            return newObject(NOOP_HANDLE);
        }
        T newObject = newObject(newHandle);
        newHandle.set(newObject);
        return newObject;
    }

    public abstract T newObject(Handle<T> handle);

    @Deprecated
    public final boolean recycle(T t, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        handle.recycle(t);
        return true;
    }

    public final int threadLocalSize() {
        return this.threadLocal.get().pooledHandles.size();
    }

    public Recycler(int i) {
        this(i, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i, int i2) {
        this(i, RATIO, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i, int i2, int i3, int i4) {
        this(i, i3, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int i, int i2, int i3, int i4, int i5) {
        this(i, i3, DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    public Recycler(int i, int i2, int i3) {
        this.threadLocal = new FastThreadLocal<LocalPool<T>>() {
            public LocalPool<T> initialValue() {
                return new LocalPool<>(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
            }

            public void onRemoval(LocalPool<T> localPool) throws Exception {
                super.onRemoval(localPool);
                MessagePassingQueue access$300 = localPool.pooledHandles;
                MessagePassingQueue unused = localPool.pooledHandles = null;
                access$300.clear();
            }
        };
        this.interval = Math.max(0, i2);
        if (i <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
            return;
        }
        int max = Math.max(4, i);
        this.maxCapacityPerThread = max;
        this.chunkSize = Math.max(2, Math.min(i3, max >> 1));
    }
}
