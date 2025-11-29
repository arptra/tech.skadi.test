package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2745a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;
    public long d;

    public static final class Entry<Y> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f2746a;
        public final int b;

        public Entry(Object obj, int i) {
            this.f2746a = obj;
            this.b = i;
        }
    }

    public LruCache(long j) {
        this.b = j;
        this.c = j;
    }

    public void b() {
        m(0);
    }

    public synchronized long c() {
        return this.d;
    }

    public final void g() {
        m(this.c);
    }

    public synchronized long getMaxSize() {
        return this.c;
    }

    public synchronized Object h(Object obj) {
        Entry entry;
        entry = (Entry) this.f2745a.get(obj);
        return entry != null ? entry.f2746a : null;
    }

    public int i(Object obj) {
        return 1;
    }

    public void j(Object obj, Object obj2) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004b, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object k(java.lang.Object r8, java.lang.Object r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.i(r9)     // Catch:{ all -> 0x0012 }
            long r1 = (long) r0     // Catch:{ all -> 0x0012 }
            long r3 = r7.c     // Catch:{ all -> 0x0012 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 0
            if (r3 < 0) goto L_0x0014
            r7.j(r8, r9)     // Catch:{ all -> 0x0012 }
            monitor-exit(r7)
            return r4
        L_0x0012:
            r8 = move-exception
            goto L_0x004c
        L_0x0014:
            if (r9 == 0) goto L_0x001b
            long r5 = r7.d     // Catch:{ all -> 0x0012 }
            long r5 = r5 + r1
            r7.d = r5     // Catch:{ all -> 0x0012 }
        L_0x001b:
            java.util.Map r1 = r7.f2745a     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0021
            r2 = r4
            goto L_0x0026
        L_0x0021:
            com.bumptech.glide.util.LruCache$Entry r2 = new com.bumptech.glide.util.LruCache$Entry     // Catch:{ all -> 0x0012 }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x0012 }
        L_0x0026:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x0012 }
            com.bumptech.glide.util.LruCache$Entry r0 = (com.bumptech.glide.util.LruCache.Entry) r0     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0043
            long r1 = r7.d     // Catch:{ all -> 0x0012 }
            int r3 = r0.b     // Catch:{ all -> 0x0012 }
            long r5 = (long) r3     // Catch:{ all -> 0x0012 }
            long r1 = r1 - r5
            r7.d = r1     // Catch:{ all -> 0x0012 }
            java.lang.Object r1 = r0.f2746a     // Catch:{ all -> 0x0012 }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0043
            java.lang.Object r9 = r0.f2746a     // Catch:{ all -> 0x0012 }
            r7.j(r8, r9)     // Catch:{ all -> 0x0012 }
        L_0x0043:
            r7.g()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x004a
            java.lang.Object r4 = r0.f2746a     // Catch:{ all -> 0x0012 }
        L_0x004a:
            monitor-exit(r7)
            return r4
        L_0x004c:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.LruCache.k(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public synchronized Object l(Object obj) {
        Entry entry = (Entry) this.f2745a.remove(obj);
        if (entry == null) {
            return null;
        }
        this.d -= (long) entry.b;
        return entry.f2746a;
    }

    public synchronized void m(long j) {
        while (this.d > j) {
            Iterator it = this.f2745a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Entry entry2 = (Entry) entry.getValue();
            this.d -= (long) entry2.b;
            Object key = entry.getKey();
            it.remove();
            j(key, entry2.f2746a);
        }
    }
}
