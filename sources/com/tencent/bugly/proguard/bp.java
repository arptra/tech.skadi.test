package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class bp extends m implements Cloneable {
    static ArrayList<bo> b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<bo> f9571a = null;

    public final void a(StringBuilder sb, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.f9571a, 0);
    }

    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new bo());
        }
        this.f9571a = (ArrayList) kVar.a(b, 0, true);
    }
}
