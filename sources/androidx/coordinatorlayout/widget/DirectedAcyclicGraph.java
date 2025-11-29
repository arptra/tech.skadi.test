package androidx.coordinatorlayout.widget;

import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Pools.Pool f630a = new Pools.SimplePool(10);
    public final SimpleArrayMap b = new SimpleArrayMap();
    public final ArrayList c = new ArrayList();
    public final HashSet d = new HashSet();

    public void a(Object obj, Object obj2) {
        if (!this.b.containsKey(obj) || !this.b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (!this.b.containsKey(obj)) {
            this.b.put(obj, (Object) null);
        }
    }

    public void c() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.b.n(i);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.b.clear();
    }

    public boolean d(Object obj) {
        return this.b.containsKey(obj);
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (!arrayList.contains(obj)) {
            if (!hashSet.contains(obj)) {
                hashSet.add(obj);
                ArrayList arrayList2 = (ArrayList) this.b.get(obj);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        e(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(obj);
                arrayList.add(obj);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    public final ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f630a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public List g(Object obj) {
        return (List) this.b.get(obj);
    }

    public List h(Object obj) {
        int size = this.b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList2 = (ArrayList) this.b.n(i);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.b.j(i));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.c.clear();
        this.d.clear();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            e(this.b.j(i), this.c, this.d);
        }
        return this.c;
    }

    public boolean j(Object obj) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.b.n(i);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList arrayList) {
        arrayList.clear();
        this.f630a.a(arrayList);
    }
}
