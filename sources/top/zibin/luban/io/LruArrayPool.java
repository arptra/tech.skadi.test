package top.zibin.luban.io;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public final GroupedLinkedMap f3591a = new GroupedLinkedMap();
    public final KeyPool b = new KeyPool();
    public final Map c = new HashMap();
    public final Map d = new HashMap();
    public final int e;
    public int f;

    public static final class Key implements PoolAble {

        /* renamed from: a  reason: collision with root package name */
        public final KeyPool f3592a;
        public int b;
        public Class c;

        public Key(KeyPool keyPool) {
            this.f3592a = keyPool;
        }

        public void a() {
            this.f3592a.d(this);
        }

        public void b(int i, Class cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.b == key.b && this.c == key.c;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }
    }

    public static final class KeyPool extends BaseKeyPool<Key> {
        /* renamed from: e */
        public Key a() {
            return new Key(this);
        }

        public Key f(int i, Class cls) {
            Key key = (Key) c();
            key.b(i, cls);
            return key;
        }
    }

    public LruArrayPool(int i) {
        this.e = i;
    }

    public synchronized void a() {
        d(0);
    }

    public final void b(int i, Class cls) {
        NavigableMap j = j(cls);
        Integer num = (Integer) j.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            j.remove(Integer.valueOf(i));
        } else {
            j.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void c() {
        d(this.e);
    }

    public final void d(int i) {
        while (this.f > i) {
            Object f2 = this.f3591a.f();
            ArrayAdapterInterface f3 = f(f2);
            this.f -= f3.a(f2) * f3.b();
            b(f3.a(f2), f2.getClass());
            if (Log.isLoggable(f3.getTag(), 2)) {
                Log.v(f3.getTag(), "evicted: " + f3.a(f2));
            }
        }
    }

    public synchronized Object e(int i, Class cls) {
        Integer num;
        try {
            num = (Integer) j(cls).ceilingKey(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
        return i(m(i, num) ? this.b.f(num.intValue(), cls) : this.b.f(i, cls), cls);
    }

    public final ArrayAdapterInterface f(Object obj) {
        return g(obj.getClass());
    }

    public final ArrayAdapterInterface g(Class cls) {
        ArrayAdapterInterface arrayAdapterInterface = (ArrayAdapterInterface) this.d.get(cls);
        if (arrayAdapterInterface == null) {
            if (cls.equals(int[].class)) {
                arrayAdapterInterface = new IntegerArrayAdapter();
            } else if (cls.equals(byte[].class)) {
                arrayAdapterInterface = new ByteArrayAdapter();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.d.put(cls, arrayAdapterInterface);
        }
        return arrayAdapterInterface;
    }

    public final Object h(Key key) {
        return this.f3591a.a(key);
    }

    public final Object i(Key key, Class cls) {
        ArrayAdapterInterface g = g(cls);
        Object h = h(key);
        if (h != null) {
            this.f -= g.a(h) * g.b();
            b(g.a(h), cls);
        }
        if (h != null) {
            return h;
        }
        if (Log.isLoggable(g.getTag(), 2)) {
            Log.v(g.getTag(), "Allocated " + key.b + " bytes");
        }
        return g.newArray(key.b);
    }

    public final NavigableMap j(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean k() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    public final boolean l(int i) {
        return i <= this.e / 2;
    }

    public final boolean m(int i, Integer num) {
        return num != null && (k() || num.intValue() <= i * 8);
    }

    public synchronized void n(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayAdapterInterface g = g(cls);
        int a2 = g.a(obj);
        int b2 = g.b() * a2;
        if (l(b2)) {
            Key f2 = this.b.f(a2, cls);
            this.f3591a.d(f2, obj);
            NavigableMap j = j(cls);
            Integer num = (Integer) j.get(Integer.valueOf(f2.b));
            Integer valueOf = Integer.valueOf(f2.b);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            j.put(valueOf, Integer.valueOf(i));
            this.f += b2;
            c();
        }
    }
}
