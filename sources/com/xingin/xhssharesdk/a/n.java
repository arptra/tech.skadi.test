package com.xingin.xhssharesdk.a;

import java.util.Iterator;
import java.util.Map;

public final class n extends o {

    public static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final Map.Entry f8141a;

        public a(Map.Entry entry) {
            this.f8141a = entry;
        }

        public final Object getKey() {
            return this.f8141a.getKey();
        }

        public final Object getValue() {
            n nVar = (n) this.f8141a.getValue();
            if (nVar == null) {
                return null;
            }
            return nVar.a();
        }

        public final Object setValue(Object obj) {
            if (obj instanceof r) {
                n nVar = (n) this.f8141a.getValue();
                r rVar = nVar.f8143a;
                nVar.b = null;
                nVar.f8143a = (r) obj;
                return rVar;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a  reason: collision with root package name */
        public final Iterator f8142a;

        public b(Iterator it) {
            this.f8142a = it;
        }

        public final boolean hasNext() {
            return this.f8142a.hasNext();
        }

        public final Object next() {
            Map.Entry entry = (Map.Entry) this.f8142a.next();
            return entry.getValue() instanceof n ? new a(entry) : entry;
        }

        public final void remove() {
            this.f8142a.remove();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.xingin.xhssharesdk.a.r a() {
        /*
            r2 = this;
            com.xingin.xhssharesdk.a.r r0 = r2.f8143a
            if (r0 == 0) goto L_0x0005
            goto L_0x001c
        L_0x0005:
            monitor-enter(r2)
            com.xingin.xhssharesdk.a.r r0 = r2.f8143a     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x000b
            goto L_0x001b
        L_0x000b:
            r0 = 0
            r2.f8143a = r0     // Catch:{ m -> 0x0015 }
            com.xingin.xhssharesdk.a.e$d r1 = com.xingin.xhssharesdk.a.e.b     // Catch:{ m -> 0x0015 }
            r2.b = r1     // Catch:{ m -> 0x0015 }
            goto L_0x001b
        L_0x0013:
            r0 = move-exception
            goto L_0x001f
        L_0x0015:
            r2.f8143a = r0     // Catch:{ all -> 0x0013 }
            com.xingin.xhssharesdk.a.e$d r0 = com.xingin.xhssharesdk.a.e.b     // Catch:{ all -> 0x0013 }
            r2.b = r0     // Catch:{ all -> 0x0013 }
        L_0x001b:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
        L_0x001c:
            com.xingin.xhssharesdk.a.r r2 = r2.f8143a
            return r2
        L_0x001f:
            monitor-exit(r2)     // Catch:{ all -> 0x0013 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.n.a():com.xingin.xhssharesdk.a.r");
    }

    public final boolean equals(Object obj) {
        return a().equals(obj);
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
