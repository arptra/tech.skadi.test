package com.geetest.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class aa extends Observable {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2901a = new ArrayList();

    public void a() {
        Iterator it = this.f2901a.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).a();
        }
    }

    public synchronized void b(ab abVar) {
        if (abVar != null) {
            if (!this.f2901a.contains(abVar)) {
                this.f2901a.add(abVar);
            }
        }
    }

    public void c(String str, String str2) {
        Iterator it = this.f2901a.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).b(str, str2);
        }
    }

    public void d(boolean z, String str) {
        Iterator it = this.f2901a.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).c(z, str);
        }
    }

    public void e() {
        Iterator it = this.f2901a.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).d();
        }
    }
}
