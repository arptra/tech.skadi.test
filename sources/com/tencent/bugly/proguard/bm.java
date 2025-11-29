package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class bm extends m implements Cloneable {
    static ArrayList<String> c;

    /* renamed from: a  reason: collision with root package name */
    public String f9568a = "";
    public ArrayList<String> b = null;

    public final void a(StringBuilder sb, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.f9568a, 0);
        ArrayList<String> arrayList = this.b;
        if (arrayList != null) {
            lVar.a(arrayList, 1);
        }
    }

    public final void a(k kVar) {
        this.f9568a = kVar.b(0, true);
        if (c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            c = arrayList;
            arrayList.add("");
        }
        this.b = (ArrayList) kVar.a(c, 1, false);
    }
}
