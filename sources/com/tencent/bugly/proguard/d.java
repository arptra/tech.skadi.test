package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Set;

public class d extends c {
    protected HashMap<String, byte[]> e = null;
    k f = new k();
    private HashMap<String, Object> g = new HashMap<>();

    private void c(String str, Object obj) {
        this.g.put(str, obj);
    }

    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.e = new HashMap<>();
    }

    public <T> void a(String str, T t) {
        if (this.e == null) {
            super.a(str, t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            l lVar = new l();
            lVar.a(this.c);
            lVar.a((Object) t, 0);
            this.e.put(str, n.a(lVar.f9584a));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T b(java.lang.String r6, T r7) throws com.tencent.bugly.proguard.b {
        /*
            r5 = this;
            java.util.HashMap<java.lang.String, byte[]> r0 = r5.e
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0046
            boolean r0 = r0.containsKey(r6)
            if (r0 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r5.g
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.g
            java.lang.Object r5 = r5.get(r6)
            return r5
        L_0x001d:
            java.util.HashMap<java.lang.String, byte[]> r0 = r5.e
            java.lang.Object r0 = r0.get(r6)
            byte[] r0 = (byte[]) r0
            com.tencent.bugly.proguard.k r2 = r5.f     // Catch:{ Exception -> 0x003d }
            r2.a((byte[]) r0)     // Catch:{ Exception -> 0x003d }
            com.tencent.bugly.proguard.k r0 = r5.f     // Catch:{ Exception -> 0x003d }
            java.lang.String r2 = r5.c     // Catch:{ Exception -> 0x003d }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x003d }
            com.tencent.bugly.proguard.k r0 = r5.f     // Catch:{ Exception -> 0x003d }
            java.lang.Object r7 = r0.a(r7, (int) r3, (boolean) r1)     // Catch:{ Exception -> 0x003d }
            if (r7 == 0) goto L_0x003f
            r5.c(r6, r7)     // Catch:{ Exception -> 0x003d }
            goto L_0x003f
        L_0x003d:
            r5 = move-exception
            goto L_0x0040
        L_0x003f:
            return r7
        L_0x0040:
            com.tencent.bugly.proguard.b r6 = new com.tencent.bugly.proguard.b
            r6.<init>(r5)
            throw r6
        L_0x0046:
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> r0 = r5.f9578a
            boolean r0 = r0.containsKey(r6)
            if (r0 != 0) goto L_0x004f
            return r2
        L_0x004f:
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r5.g
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x005e
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r5.g
            java.lang.Object r5 = r5.get(r6)
            return r5
        L_0x005e:
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> r0 = r5.f9578a
            java.lang.Object r0 = r0.get(r6)
            java.util.HashMap r0 = (java.util.HashMap) r0
            byte[] r2 = new byte[r3]
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0086
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r0.getKey()
            java.lang.Object r0 = r0.getValue()
            r2 = r0
            byte[] r2 = (byte[]) r2
        L_0x0086:
            com.tencent.bugly.proguard.k r0 = r5.f     // Catch:{ Exception -> 0x009c }
            r0.a((byte[]) r2)     // Catch:{ Exception -> 0x009c }
            com.tencent.bugly.proguard.k r0 = r5.f     // Catch:{ Exception -> 0x009c }
            java.lang.String r2 = r5.c     // Catch:{ Exception -> 0x009c }
            r0.a((java.lang.String) r2)     // Catch:{ Exception -> 0x009c }
            com.tencent.bugly.proguard.k r0 = r5.f     // Catch:{ Exception -> 0x009c }
            java.lang.Object r7 = r0.a(r7, (int) r3, (boolean) r1)     // Catch:{ Exception -> 0x009c }
            r5.c(r6, r7)     // Catch:{ Exception -> 0x009c }
            return r7
        L_0x009c:
            r5 = move-exception
            com.tencent.bugly.proguard.b r6 = new com.tencent.bugly.proguard.b
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.d.b(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public byte[] a() {
        if (this.e == null) {
            return super.a();
        }
        l lVar = new l(0);
        lVar.a(this.c);
        lVar.a(this.e, 0);
        return n.a(lVar.f9584a);
    }

    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f.a(bArr);
            this.f.a(this.c);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.e = this.f.a(hashMap, 0, false);
        }
    }
}
