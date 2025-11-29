package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2517a = new HashMap();
    public final WriteLockPool b = new WriteLockPool();

    public static class WriteLock {

        /* renamed from: a  reason: collision with root package name */
        public final Lock f2518a = new ReentrantLock();
        public int b;
    }

    public static class WriteLockPool {

        /* renamed from: a  reason: collision with root package name */
        public final Queue f2519a = new ArrayDeque();

        public WriteLock a() {
            WriteLock writeLock;
            synchronized (this.f2519a) {
                writeLock = (WriteLock) this.f2519a.poll();
            }
            return writeLock == null ? new WriteLock() : writeLock;
        }

        public void b(WriteLock writeLock) {
            synchronized (this.f2519a) {
                try {
                    if (this.f2519a.size() < 10) {
                        this.f2519a.offer(writeLock);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) this.f2517a.get(str);
                if (writeLock == null) {
                    writeLock = this.b.a();
                    this.f2517a.put(str, writeLock);
                }
                writeLock.b++;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        writeLock.f2518a.lock();
    }

    public void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) Preconditions.d(this.f2517a.get(str));
                int i = writeLock.b;
                if (i >= 1) {
                    int i2 = i - 1;
                    writeLock.b = i2;
                    if (i2 == 0) {
                        WriteLock writeLock2 = (WriteLock) this.f2517a.remove(str);
                        if (writeLock2.equals(writeLock)) {
                            this.b.b(writeLock2);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + writeLock2 + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.f2518a.unlock();
    }
}
