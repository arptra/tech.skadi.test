package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class bv extends m implements Cloneable {
    static ArrayList<bu> f;
    static Map<String, String> g;

    /* renamed from: a  reason: collision with root package name */
    public byte f9577a = 0;
    public String b = "";
    public String c = "";
    public ArrayList<bu> d = null;
    public Map<String, String> e = null;

    public final void a(StringBuilder sb, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.f9577a, 0);
        String str = this.b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.d;
        if (arrayList != null) {
            lVar.a(arrayList, 3);
        }
        Map<String, String> map = this.e;
        if (map != null) {
            lVar.a(map, 4);
        }
    }

    public final void a(k kVar) {
        this.f9577a = kVar.a(this.f9577a, 0, true);
        this.b = kVar.b(1, false);
        this.c = kVar.b(2, false);
        if (f == null) {
            f = new ArrayList<>();
            f.add(new bu());
        }
        this.d = (ArrayList) kVar.a(f, 3, false);
        if (g == null) {
            HashMap hashMap = new HashMap();
            g = hashMap;
            hashMap.put("", "");
        }
        this.e = (Map) kVar.a(g, 4, false);
    }
}
