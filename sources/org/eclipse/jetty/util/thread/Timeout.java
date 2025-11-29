package org.eclipse.jetty.util.thread;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

public class Timeout {
    private static final Logger LOG = Log.getLogger((Class<?>) Timeout.class);
    private long _duration;
    private Task _head;
    /* access modifiers changed from: private */
    public Object _lock;
    /* access modifiers changed from: private */
    public volatile long _now = System.currentTimeMillis();

    public static class Task {
        long _delay;
        boolean _expired = false;
        Task _next = this;
        Task _prev = this;
        Timeout _timeout;
        long _timestamp = 0;

        /* access modifiers changed from: private */
        public void link(Task task) {
            Task task2 = this._next;
            task2._prev = task;
            this._next = task;
            task._next = task2;
            this._next._prev = this;
        }

        /* access modifiers changed from: private */
        public void unlink() {
            Task task = this._next;
            task._prev = this._prev;
            this._prev._next = task;
            this._prev = this;
            this._next = this;
            this._expired = false;
        }

        public void cancel() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                synchronized (timeout._lock) {
                    unlink();
                    this._timestamp = 0;
                }
            }
        }

        public void expire() {
        }

        public void expired() {
        }

        public long getAge() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                long access$200 = timeout._now;
                if (access$200 != 0) {
                    long j = this._timestamp;
                    if (j != 0) {
                        return access$200 - j;
                    }
                }
            }
            return 0;
        }

        public long getTimestamp() {
            return this._timestamp;
        }

        public boolean isExpired() {
            return this._expired;
        }

        public boolean isScheduled() {
            return this._next != this;
        }

        public void reschedule() {
            Timeout timeout = this._timeout;
            if (timeout != null) {
                timeout.schedule(this, this._delay);
            }
        }

        public void schedule(Timeout timeout) {
            timeout.schedule(this);
        }

        public void schedule(Timeout timeout, long j) {
            timeout.schedule(this, j);
        }
    }

    public Timeout() {
        Task task = new Task();
        this._head = task;
        this._lock = new Object();
        task._timeout = this;
    }

    public void cancelAll() {
        synchronized (this._lock) {
            Task task = this._head;
            task._prev = task;
            task._next = task;
        }
    }

    public Task expired() {
        synchronized (this._lock) {
            try {
                long j = this._now - this._duration;
                Task task = this._head;
                Task task2 = task._next;
                if (task2 == task) {
                    return null;
                }
                if (task2._timestamp > j) {
                    return null;
                }
                task2.unlink();
                task2._expired = true;
                return task2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long getDuration() {
        return this._duration;
    }

    public long getNow() {
        return this._now;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTimeToNext() {
        /*
            r5 = this;
            java.lang.Object r0 = r5._lock
            monitor-enter(r0)
            org.eclipse.jetty.util.thread.Timeout$Task r1 = r5._head     // Catch:{ all -> 0x000d }
            org.eclipse.jetty.util.thread.Timeout$Task r2 = r1._next     // Catch:{ all -> 0x000d }
            if (r2 != r1) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            r0 = -1
            return r0
        L_0x000d:
            r5 = move-exception
            goto L_0x0020
        L_0x000f:
            long r3 = r5._duration     // Catch:{ all -> 0x000d }
            long r1 = r2._timestamp     // Catch:{ all -> 0x000d }
            long r3 = r3 + r1
            long r1 = r5._now     // Catch:{ all -> 0x000d }
            long r3 = r3 - r1
            r1 = 0
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x001e
            r3 = r1
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            return r3
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x000d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.Timeout.getTimeToNext():long");
    }

    public boolean isEmpty() {
        boolean z;
        synchronized (this._lock) {
            Task task = this._head;
            z = task._next == task;
        }
        return z;
    }

    public void schedule(Task task) {
        schedule(task, 0);
    }

    public void setDuration(long j) {
        this._duration = j;
    }

    public long setNow() {
        long currentTimeMillis = System.currentTimeMillis();
        this._now = currentTimeMillis;
        return currentTimeMillis;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r4.expired();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tick() {
        /*
            r7 = this;
            long r0 = r7._now
            long r2 = r7._duration
            long r0 = r0 - r2
        L_0x0005:
            java.lang.Object r2 = r7._lock     // Catch:{ all -> 0x0023 }
            monitor-enter(r2)     // Catch:{ all -> 0x0023 }
            org.eclipse.jetty.util.thread.Timeout$Task r3 = r7._head     // Catch:{ all -> 0x0025 }
            org.eclipse.jetty.util.thread.Timeout$Task r4 = r3._next     // Catch:{ all -> 0x0025 }
            if (r4 == r3) goto L_0x0027
            long r5 = r4._timestamp     // Catch:{ all -> 0x0025 }
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            r4.unlink()     // Catch:{ all -> 0x0025 }
            r3 = 1
            r4._expired = r3     // Catch:{ all -> 0x0025 }
            r4.expire()     // Catch:{ all -> 0x0025 }
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            r4.expired()     // Catch:{ all -> 0x0023 }
            goto L_0x0005
        L_0x0023:
            r2 = move-exception
            goto L_0x002b
        L_0x0025:
            r3 = move-exception
            goto L_0x0029
        L_0x0027:
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            return
        L_0x0029:
            monitor-exit(r2)     // Catch:{ all -> 0x0025 }
            throw r3     // Catch:{ all -> 0x0023 }
        L_0x002b:
            org.eclipse.jetty.util.log.Logger r3 = LOG
            java.lang.String r4 = "EXCEPTION "
            r3.warn((java.lang.String) r4, (java.lang.Throwable) r2)
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.Timeout.tick():void");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        for (Task task = this._head._next; task != this._head; task = task._next) {
            stringBuffer.append("-->");
            stringBuffer.append(task);
        }
        return stringBuffer.toString();
    }

    public void schedule(Task task, long j) {
        synchronized (this._lock) {
            try {
                if (task._timestamp != 0) {
                    task.unlink();
                    task._timestamp = 0;
                }
                task._timeout = this;
                task._expired = false;
                task._delay = j;
                task._timestamp = this._now + j;
                Task task2 = this._head._prev;
                while (true) {
                    if (task2 == this._head) {
                        break;
                    } else if (task2._timestamp <= task._timestamp) {
                        break;
                    } else {
                        task2 = task2._prev;
                    }
                }
                task2.link(task);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setNow(long j) {
        this._now = j;
    }

    public Timeout(Object obj) {
        Task task = new Task();
        this._head = task;
        this._lock = obj;
        task._timeout = this;
    }

    public void tick(long j) {
        this._now = j;
        tick();
    }
}
