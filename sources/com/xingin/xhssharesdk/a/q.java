package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.l;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class q<K, V> extends LinkedHashMap<K, V> {
    public static final q b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f8146a = true;

    static {
        q qVar = new q(Collections.emptyMap());
        b = qVar;
        qVar.f8146a = false;
    }

    public q() {
    }

    public static <K, V> q<K, V> a() {
        return b;
    }

    public final void b() {
        if (!this.f8146a) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        b();
        clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x005e
            java.util.Map r6 = (java.util.Map) r6
            r0 = 1
            if (r5 != r6) goto L_0x000b
            goto L_0x005a
        L_0x000b:
            int r2 = r5.size()
            int r3 = r6.size()
            if (r2 == r3) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x001e:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x005a
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r3 = r6.containsKey(r3)
            if (r3 != 0) goto L_0x0035
            goto L_0x0058
        L_0x0035:
            java.lang.Object r3 = r2.getValue()
            java.lang.Object r2 = r2.getKey()
            java.lang.Object r2 = r6.get(r2)
            boolean r4 = r3 instanceof byte[]
            if (r4 == 0) goto L_0x0052
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L_0x0052
            byte[] r3 = (byte[]) r3
            byte[] r2 = (byte[]) r2
            boolean r2 = java.util.Arrays.equals(r3, r2)
            goto L_0x0056
        L_0x0052:
            boolean r2 = r3.equals(r2)
        L_0x0056:
            if (r2 != 0) goto L_0x001e
        L_0x0058:
            r5 = r1
            goto L_0x005b
        L_0x005a:
            r5 = r0
        L_0x005b:
            if (r5 == 0) goto L_0x005e
            r1 = r0
        L_0x005e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xingin.xhssharesdk.a.q.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            if (key instanceof byte[]) {
                Charset charset = l.f8140a;
                i = r5;
                for (byte b2 : (byte[]) key) {
                    i = (i * 31) + b2;
                }
                if (i == 0) {
                    i = 1;
                }
            } else if (!(key instanceof l.a)) {
                i = key.hashCode();
            } else {
                throw new UnsupportedOperationException();
            }
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Charset charset2 = l.f8140a;
                i2 = r4;
                for (byte b3 : (byte[]) value) {
                    i2 = (i2 * 31) + b3;
                }
                if (i2 == 0) {
                    i2 = 1;
                }
            } else if (!(value instanceof l.a)) {
                i2 = value.hashCode();
            } else {
                throw new UnsupportedOperationException();
            }
            i3 += i ^ i2;
        }
        return i3;
    }

    public final V put(K k, V v) {
        b();
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        b();
        super.putAll(map);
    }

    public final V remove(Object obj) {
        b();
        return super.remove(obj);
    }

    public q(Map<K, V> map) {
        super(map);
    }

    public final void a(q<K, V> qVar) {
        b();
        if (!qVar.isEmpty()) {
            b();
            super.putAll(qVar);
        }
    }
}
