package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool implements ArrayPool {

    /* renamed from: a  reason: collision with root package name */
    public final GroupedLinkedMap f2508a = new GroupedLinkedMap();
    public final KeyPool b = new KeyPool();
    public final Map c = new HashMap();
    public final Map d = new HashMap();
    public final int e;
    public int f;

    public static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        public final KeyPool f2509a;
        public int b;
        public Class c;

        public Key(KeyPool keyPool) {
            this.f2509a = keyPool;
        }

        public void a() {
            this.f2509a.c(this);
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
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i, Class cls) {
            Key key = (Key) b();
            key.b(i, cls);
            return key;
        }
    }

    public LruArrayPool(int i) {
        this.e = i;
    }

    public synchronized void a(int i) {
        if (i >= 40) {
            try {
                b();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i >= 20 || i == 15) {
            g(this.e / 2);
        }
    }

    public synchronized void b() {
        g(0);
    }

    public synchronized Object c(int i, Class cls) {
        Integer num;
        try {
            num = (Integer) l(cls).ceilingKey(Integer.valueOf(i));
        } catch (Throwable th) {
            throw th;
        }
        return k(o(i, num) ? this.b.e(num.intValue(), cls) : this.b.e(i, cls), cls);
    }

    public synchronized Object d(int i, Class cls) {
        return k(this.b.e(i, cls), cls);
    }

    public final void e(int i, Class cls) {
        NavigableMap l = l(cls);
        Integer num = (Integer) l.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            l.remove(Integer.valueOf(i));
        } else {
            l.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    public final void f() {
        g(this.e);
    }

    public final void g(int i) {
        while (this.f > i) {
            Object f2 = this.f2508a.f();
            Preconditions.d(f2);
            ArrayAdapterInterface h = h(f2);
            this.f -= h.a(f2) * h.b();
            e(h.a(f2), f2.getClass());
            if (Log.isLoggable(h.getTag(), 2)) {
                Log.v(h.getTag(), "evicted: " + h.a(f2));
            }
        }
    }

    public final ArrayAdapterInterface h(Object obj) {
        return i(obj.getClass());
    }

    public final ArrayAdapterInterface i(Class cls) {
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

    public final Object j(Key key) {
        return this.f2508a.a(key);
    }

    public final Object k(Key key, Class cls) {
        ArrayAdapterInterface i = i(cls);
        Object j = j(key);
        if (j != null) {
            this.f -= i.a(j) * i.b();
            e(i.a(j), cls);
        }
        if (j != null) {
            return j;
        }
        if (Log.isLoggable(i.getTag(), 2)) {
            Log.v(i.getTag(), "Allocated " + key.b + " bytes");
        }
        return i.newArray(key.b);
    }

    public final NavigableMap l(Class cls) {
        NavigableMap navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean m() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    public final boolean n(int i) {
        return i <= this.e / 2;
    }

    public final boolean o(int i, Integer num) {
        return num != null && (m() || num.intValue() <= i * 8);
    }

    public synchronized void put(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayAdapterInterface i = i(cls);
        int a2 = i.a(obj);
        int b2 = i.b() * a2;
        if (n(b2)) {
            Key e2 = this.b.e(a2, cls);
            this.f2508a.d(e2, obj);
            NavigableMap l = l(cls);
            Integer num = (Integer) l.get(Integer.valueOf(e2.b));
            Integer valueOf = Integer.valueOf(e2.b);
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            l.put(valueOf, Integer.valueOf(i2));
            this.f += b2;
            f();
        }
    }
}
