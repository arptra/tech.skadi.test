package com.android.vcard;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VCardProperty {

    /* renamed from: a  reason: collision with root package name */
    public String f2396a;
    public List b;
    public Map c = new HashMap();
    public String d;
    public List e;
    public byte[] f;

    public void a(String str) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.Collection} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.util.Map r0 = r1.c
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L_0x0021
            java.lang.String r0 = "TYPE"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0016
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            goto L_0x001b
        L_0x0016:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x001b:
            java.util.Map r1 = r1.c
            r1.put(r2, r0)
            goto L_0x002a
        L_0x0021:
            java.util.Map r1 = r1.c
            java.lang.Object r1 = r1.get(r2)
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
        L_0x002a:
            r0.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.vcard.VCardProperty.b(java.lang.String, java.lang.String):void");
    }

    public byte[] c() {
        return this.f;
    }

    public String d() {
        return this.f2396a;
    }

    public Map e() {
        return this.c;
    }

    public Collection f(String str) {
        return (Collection) this.c.get(str);
    }

    public String g() {
        return this.d;
    }

    public List h() {
        return this.e;
    }

    public void i(byte[] bArr) {
        this.f = bArr;
    }

    public void j(String str) {
        String str2 = this.f2396a;
        if (str2 != null) {
            Log.w("vCard", String.format("Property name is re-defined (existing: %s, requested: %s", new Object[]{str2, str}));
        }
        this.f2396a = str;
    }

    public void k(String str) {
        this.d = str;
    }

    public void l(List list) {
        this.e = list;
    }

    public void m(String... strArr) {
        this.e = Arrays.asList(strArr);
    }
}
