package io.netty.resolver.dns;

import com.honey.account.i.a;
import io.netty.channel.EventLoop;
import io.netty.util.internal.PlatformDependent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

abstract class Cache<E> {
    /* access modifiers changed from: private */
    public static final ScheduledFuture<?> CANCELLED = new ScheduledFuture<Object>() {
        public boolean cancel(boolean z) {
            return false;
        }

        public Object get() {
            throw new UnsupportedOperationException();
        }

        public long getDelay(TimeUnit timeUnit) {
            return Long.MIN_VALUE;
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isDone() {
            return true;
        }

        public int compareTo(Delayed delayed) {
            throw new UnsupportedOperationException();
        }

        public Object get(long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }
    };
    /* access modifiers changed from: private */
    public static final AtomicReferenceFieldUpdater<Entries, ScheduledFuture> FUTURE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(Entries.class, ScheduledFuture.class, "expirationFuture");
    static final int MAX_SUPPORTED_TTL_SECS = ((int) TimeUnit.DAYS.toSeconds(730));
    /* access modifiers changed from: private */
    public final ConcurrentMap<String, Cache<E>.Entries> resolveCache = PlatformDependent.newConcurrentHashMap();

    public final class Entries extends AtomicReference<List<E>> implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        volatile ScheduledFuture<?> expirationFuture;
        private final String hostname;

        public Entries(String str) {
            super(Collections.emptyList());
            this.hostname = str;
        }

        private void scheduleCacheExpirationIfNeeded(int i, EventLoop eventLoop) {
            while (true) {
                ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.get(this);
                if (scheduledFuture == null || scheduledFuture.getDelay(TimeUnit.SECONDS) > ((long) i)) {
                    io.netty.util.concurrent.ScheduledFuture<?> schedule = eventLoop.schedule((Runnable) this, (long) i, TimeUnit.SECONDS);
                    if (!a.a(Cache.FUTURE_UPDATER, this, scheduledFuture, schedule)) {
                        schedule.cancel(true);
                    } else if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public void add(E e, int i, EventLoop eventLoop) {
            Object obj;
            if (!Cache.this.shouldReplaceAll(e)) {
                while (true) {
                    List list = (List) get();
                    if (!list.isEmpty()) {
                        int i2 = 0;
                        if (!Cache.this.shouldReplaceAll(list.get(0))) {
                            ArrayList arrayList = new ArrayList(list.size() + 1);
                            while (true) {
                                obj = list.get(i2);
                                if (Cache.this.equals(e, obj)) {
                                    arrayList.add(e);
                                    while (true) {
                                        i2++;
                                        if (i2 >= list.size()) {
                                            break;
                                        }
                                        arrayList.add(list.get(i2));
                                    }
                                } else {
                                    arrayList.add(obj);
                                    i2++;
                                    if (i2 >= list.size()) {
                                        obj = null;
                                        break;
                                    }
                                }
                            }
                            if (obj == null) {
                                arrayList.add(e);
                            }
                            Cache.this.sortEntries(this.hostname, arrayList);
                            if (compareAndSet(list, Collections.unmodifiableList(arrayList))) {
                                scheduleCacheExpirationIfNeeded(i, eventLoop);
                                return;
                            }
                        } else if (compareAndSet(list, Collections.singletonList(e))) {
                            scheduleCacheExpirationIfNeeded(i, eventLoop);
                            return;
                        }
                    } else if (compareAndSet(list, Collections.singletonList(e))) {
                        scheduleCacheExpirationIfNeeded(i, eventLoop);
                        return;
                    }
                }
            } else {
                set(Collections.singletonList(e));
                scheduleCacheExpirationIfNeeded(i, eventLoop);
            }
        }

        public boolean clearAndCancel() {
            if (((List) getAndSet(Collections.emptyList())).isEmpty()) {
                return false;
            }
            ScheduledFuture scheduledFuture = (ScheduledFuture) Cache.FUTURE_UPDATER.getAndSet(this, Cache.CANCELLED);
            if (scheduledFuture == null) {
                return true;
            }
            scheduledFuture.cancel(false);
            return true;
        }

        public void run() {
            Cache.this.resolveCache.remove(this.hostname, this);
            clearAndCancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = new io.netty.resolver.dns.Cache.Entries(r1, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cache(java.lang.String r2, E r3, int r4, io.netty.channel.EventLoop r5) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentMap<java.lang.String, io.netty.resolver.dns.Cache<E>$Entries> r0 = r1.resolveCache
            java.lang.Object r0 = r0.get(r2)
            io.netty.resolver.dns.Cache$Entries r0 = (io.netty.resolver.dns.Cache.Entries) r0
            if (r0 != 0) goto L_0x001a
            io.netty.resolver.dns.Cache$Entries r0 = new io.netty.resolver.dns.Cache$Entries
            r0.<init>(r2)
            java.util.concurrent.ConcurrentMap<java.lang.String, io.netty.resolver.dns.Cache<E>$Entries> r1 = r1.resolveCache
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            io.netty.resolver.dns.Cache$Entries r1 = (io.netty.resolver.dns.Cache.Entries) r1
            if (r1 == 0) goto L_0x001a
            r0 = r1
        L_0x001a:
            r0.add(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.Cache.cache(java.lang.String, java.lang.Object, int, io.netty.channel.EventLoop):void");
    }

    public final void clear() {
        while (!this.resolveCache.isEmpty()) {
            Iterator<Map.Entry<String, Cache<E>.Entries>> it = this.resolveCache.entrySet().iterator();
            while (it.hasNext()) {
                it.remove();
                ((Entries) it.next().getValue()).clearAndCancel();
            }
        }
    }

    public abstract boolean equals(E e, E e2);

    public final List<? extends E> get(String str) {
        Entries entries = this.resolveCache.get(str);
        if (entries == null) {
            return null;
        }
        return (List) entries.get();
    }

    public abstract boolean shouldReplaceAll(E e);

    public final int size() {
        return this.resolveCache.size();
    }

    public void sortEntries(String str, List<E> list) {
    }

    public final boolean clear(String str) {
        Entries remove = this.resolveCache.remove(str);
        return remove != null && remove.clearAndCancel();
    }
}
