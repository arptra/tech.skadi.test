package top.zibin.luban.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import top.zibin.luban.io.PoolAble;

class GroupedLinkedMap<K extends PoolAble, V> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedEntry f3589a = new LinkedEntry();
    public final Map b = new HashMap();

    public static class LinkedEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final Object f3590a;
        public List b;
        public LinkedEntry c;
        public LinkedEntry d;

        public LinkedEntry() {
            this((Object) null);
        }

        public void a(Object obj) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(obj);
        }

        public Object b() {
            int c2 = c();
            if (c2 > 0) {
                return this.b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public LinkedEntry(Object obj) {
            this.d = this;
            this.c = this;
            this.f3590a = obj;
        }
    }

    public static void e(LinkedEntry linkedEntry) {
        LinkedEntry linkedEntry2 = linkedEntry.d;
        linkedEntry2.c = linkedEntry.c;
        linkedEntry.c.d = linkedEntry2;
    }

    public static void g(LinkedEntry linkedEntry) {
        linkedEntry.c.d = linkedEntry;
        linkedEntry.d.c = linkedEntry;
    }

    public Object a(PoolAble poolAble) {
        LinkedEntry linkedEntry = (LinkedEntry) this.b.get(poolAble);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolAble);
            this.b.put(poolAble, linkedEntry);
        } else {
            poolAble.a();
        }
        b(linkedEntry);
        return linkedEntry.b();
    }

    public final void b(LinkedEntry linkedEntry) {
        e(linkedEntry);
        LinkedEntry linkedEntry2 = this.f3589a;
        linkedEntry.d = linkedEntry2;
        linkedEntry.c = linkedEntry2.c;
        g(linkedEntry);
    }

    public final void c(LinkedEntry linkedEntry) {
        e(linkedEntry);
        LinkedEntry linkedEntry2 = this.f3589a;
        linkedEntry.d = linkedEntry2.d;
        linkedEntry.c = linkedEntry2;
        g(linkedEntry);
    }

    public void d(PoolAble poolAble, Object obj) {
        LinkedEntry linkedEntry = (LinkedEntry) this.b.get(poolAble);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(poolAble);
            c(linkedEntry);
            this.b.put(poolAble, linkedEntry);
        } else {
            poolAble.a();
        }
        linkedEntry.a(obj);
    }

    public Object f() {
        for (LinkedEntry linkedEntry = this.f3589a.d; !linkedEntry.equals(this.f3589a); linkedEntry = linkedEntry.d) {
            Object b2 = linkedEntry.b();
            if (b2 != null) {
                return b2;
            }
            e(linkedEntry);
            this.b.remove(linkedEntry.f3590a);
            ((PoolAble) linkedEntry.f3590a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedEntry = this.f3589a.c;
        boolean z = false;
        while (!linkedEntry.equals(this.f3589a)) {
            sb.append('{');
            sb.append(linkedEntry.f3590a);
            sb.append(':');
            sb.append(linkedEntry.c());
            sb.append("}, ");
            linkedEntry = linkedEntry.c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
