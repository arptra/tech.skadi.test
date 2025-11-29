package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i > 0) {
            this.maxSize = i;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final int a(Object obj, Object obj2) {
        int sizeOf = sizeOf(obj, obj2);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    @Nullable
    public V create(@NonNull K k) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public void entryRemoved(boolean z, @NonNull K k, @NonNull V v, @Nullable V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r0 = create(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r0 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.createCount++;
        r1 = r4.map.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r1 == null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        r4.map.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r4.size += a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0044, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r1 == null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        entryRemoved(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        trimToSize(r4.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        throw r5;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(@androidx.annotation.NonNull K r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0056
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0013 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0015
            int r5 = r4.hitCount     // Catch:{ all -> 0x0013 }
            int r5 = r5 + 1
            r4.hitCount = r5     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)     // Catch:{ all -> 0x0013 }
            return r0
        L_0x0013:
            r5 = move-exception
            goto L_0x0054
        L_0x0015:
            int r0 = r4.missCount     // Catch:{ all -> 0x0013 }
            int r0 = r0 + 1
            r4.missCount = r0     // Catch:{ all -> 0x0013 }
            monitor-exit(r4)     // Catch:{ all -> 0x0013 }
            java.lang.Object r0 = r4.create(r5)
            if (r0 != 0) goto L_0x0024
            r4 = 0
            return r4
        L_0x0024:
            monitor-enter(r4)
            int r1 = r4.createCount     // Catch:{ all -> 0x0039 }
            int r1 = r1 + 1
            r4.createCount = r1     // Catch:{ all -> 0x0039 }
            java.util.LinkedHashMap<K, V> r1 = r4.map     // Catch:{ all -> 0x0039 }
            java.lang.Object r1 = r1.put(r5, r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x003b
            java.util.LinkedHashMap<K, V> r2 = r4.map     // Catch:{ all -> 0x0039 }
            r2.put(r5, r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r5 = move-exception
            goto L_0x0052
        L_0x003b:
            int r2 = r4.size     // Catch:{ all -> 0x0039 }
            int r3 = r4.a(r5, r0)     // Catch:{ all -> 0x0039 }
            int r2 = r2 + r3
            r4.size = r2     // Catch:{ all -> 0x0039 }
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x004c
            r2 = 0
            r4.entryRemoved(r2, r5, r0, r1)
            return r1
        L_0x004c:
            int r5 = r4.maxSize
            r4.trimToSize(r5)
            return r0
        L_0x0052:
            monitor-exit(r4)     // Catch:{ all -> 0x0039 }
            throw r5
        L_0x0054:
            monitor-exit(r4)     // Catch:{ all -> 0x0013 }
            throw r5
        L_0x0056:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r5 = "key == null"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    @Nullable
    public final V put(@NonNull K k, @NonNull V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.putCount++;
                this.size += a(k, v);
                put = this.map.put(k, v);
                if (put != null) {
                    this.size -= a(k, put);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    @Nullable
    public final V remove(@NonNull K k) {
        V remove;
        if (k != null) {
            synchronized (this) {
                try {
                    remove = this.map.remove(k);
                    if (remove != null) {
                        this.size -= a(k, remove);
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (remove != null) {
                entryRemoved(false, k, remove, (V) null);
            }
            return remove;
        }
        throw new NullPointerException("key == null");
    }

    public void resize(int i) {
        if (i > 0) {
            synchronized (this) {
                this.maxSize = i;
            }
            trimToSize(i);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        return this.size;
    }

    public int sizeOf(@NonNull K k, @NonNull V v) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.hitCount;
            i2 = this.missCount + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            int r0 = r4.size     // Catch:{ all -> 0x0012 }
            if (r0 < 0) goto L_0x0055
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            int r0 = r4.size     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0055
            goto L_0x0014
        L_0x0012:
            r5 = move-exception
            goto L_0x0074
        L_0x0014:
            int r0 = r4.size     // Catch:{ all -> 0x0012 }
            if (r0 <= r5) goto L_0x0053
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0053
        L_0x0021:
            java.util.LinkedHashMap<K, V> r0 = r4.map     // Catch:{ all -> 0x0012 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0012 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0012 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0012 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0012 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0012 }
            java.util.LinkedHashMap<K, V> r2 = r4.map     // Catch:{ all -> 0x0012 }
            r2.remove(r1)     // Catch:{ all -> 0x0012 }
            int r2 = r4.size     // Catch:{ all -> 0x0012 }
            int r3 = r4.a(r1, r0)     // Catch:{ all -> 0x0012 }
            int r2 = r2 - r3
            r4.size = r2     // Catch:{ all -> 0x0012 }
            int r2 = r4.evictionCount     // Catch:{ all -> 0x0012 }
            r3 = 1
            int r2 = r2 + r3
            r4.evictionCount = r2     // Catch:{ all -> 0x0012 }
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            r2 = 0
            r4.entryRemoved(r3, r1, r0, r2)
            goto L_0x0000
        L_0x0053:
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            return
        L_0x0055:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r0.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.Class r1 = r4.getClass()     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x0012 }
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch:{ all -> 0x0012 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0012 }
            r5.<init>(r0)     // Catch:{ all -> 0x0012 }
            throw r5     // Catch:{ all -> 0x0012 }
        L_0x0074:
            monitor-exit(r4)     // Catch:{ all -> 0x0012 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}
