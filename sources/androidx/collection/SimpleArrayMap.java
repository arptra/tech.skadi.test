package androidx.collection;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    public static Object[] d;
    public static int e;
    public static Object[] f;
    public static int g;

    /* renamed from: a  reason: collision with root package name */
    public int[] f463a;
    public Object[] b;
    public int c;

    public SimpleArrayMap() {
        this.f463a = ContainerHelpers.f453a;
        this.b = ContainerHelpers.c;
        this.c = 0;
    }

    public static int c(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void e(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (g < 10) {
                        objArr[0] = f;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f = objArr;
                        g++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (e < 10) {
                        objArr[0] = d;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        d = objArr;
                        e++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = f;
                    if (objArr != null) {
                        this.b = objArr;
                        f = (Object[]) objArr[0];
                        this.f463a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        g--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = d;
                    if (objArr2 != null) {
                        this.b = objArr2;
                        d = (Object[]) objArr2[0];
                        this.f463a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        e--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f463a = new int[i];
        this.b = new Object[(i << 1)];
    }

    public void clear() {
        int i = this.c;
        if (i > 0) {
            int[] iArr = this.f463a;
            Object[] objArr = this.b;
            this.f463a = ContainerHelpers.f453a;
            this.b = ContainerHelpers.c;
            this.c = 0;
            e(iArr, objArr, i);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return g(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public void d(int i) {
        int i2 = this.c;
        int[] iArr = this.f463a;
        if (iArr.length < i) {
            Object[] objArr = this.b;
            a(i);
            if (this.c > 0) {
                System.arraycopy(iArr, 0, this.f463a, 0, i2);
                System.arraycopy(objArr, 0, this.b, 0, i2 << 1);
            }
            e(iArr, objArr, i2);
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i = 0;
            while (i < this.c) {
                try {
                    Object j = j(i);
                    Object n = n(i);
                    Object obj2 = simpleArrayMap.get(j);
                    if (n == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(j)) {
                            return false;
                        }
                    } else if (!n.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.c) {
                try {
                    Object j2 = j(i2);
                    Object n2 = n(i2);
                    Object obj3 = map.get(j2);
                    if (n2 == null) {
                        if (obj3 != null || !map.containsKey(j2)) {
                            return false;
                        }
                    } else if (!n2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int c2 = c(this.f463a, i2, i);
        if (c2 < 0 || obj.equals(this.b[c2 << 1])) {
            return c2;
        }
        int i3 = c2 + 1;
        while (i3 < i2 && this.f463a[i3] == i) {
            if (obj.equals(this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = c2 - 1;
        while (i4 >= 0 && this.f463a[i4] == i) {
            if (obj.equals(this.b[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public int g(Object obj) {
        return obj == null ? h() : f(obj, obj.hashCode());
    }

    public Object get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public Object getOrDefault(Object obj, Object obj2) {
        int g2 = g(obj);
        return g2 >= 0 ? this.b[(g2 << 1) + 1] : obj2;
    }

    public int h() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int c2 = c(this.f463a, i, 0);
        if (c2 < 0 || this.b[c2 << 1] == null) {
            return c2;
        }
        int i2 = c2 + 1;
        while (i2 < i && this.f463a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = c2 - 1;
        while (i3 >= 0 && this.f463a[i3] == 0) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    public int hashCode() {
        int[] iArr = this.f463a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public int i(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public Object j(int i) {
        return this.b[i << 1];
    }

    public void k(SimpleArrayMap simpleArrayMap) {
        int i = simpleArrayMap.c;
        d(this.c + i);
        if (this.c != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.j(i2), simpleArrayMap.n(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f463a, 0, this.f463a, 0, i);
            System.arraycopy(simpleArrayMap.b, 0, this.b, 0, i << 1);
            this.c = i;
        }
    }

    public Object l(int i) {
        Object[] objArr = this.b;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.c;
        int i4 = 0;
        if (i3 <= 1) {
            e(this.f463a, objArr, i3);
            this.f463a = ContainerHelpers.f453a;
            this.b = ContainerHelpers.c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f463a;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i2, i8 << 1);
                }
                Object[] objArr3 = this.b;
                int i9 = i5 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                a(i6);
                if (i3 == this.c) {
                    if (i > 0) {
                        System.arraycopy(iArr, 0, this.f463a, 0, i);
                        System.arraycopy(objArr, 0, this.b, 0, i2);
                    }
                    if (i < i5) {
                        int i10 = i + 1;
                        int i11 = i5 - i;
                        System.arraycopy(iArr, i10, this.f463a, i, i11);
                        System.arraycopy(objArr, i10 << 1, this.b, i2, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i4 = i5;
        }
        if (i3 == this.c) {
            this.c = i4;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    public Object m(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object n(int i) {
        return this.b[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i;
        int i2;
        int i3 = this.c;
        if (obj == null) {
            i2 = h();
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            i2 = f(obj, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            Object[] objArr = this.b;
            Object obj3 = objArr[i4];
            objArr[i4] = obj2;
            return obj3;
        }
        int i5 = ~i2;
        int[] iArr = this.f463a;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            Object[] objArr2 = this.b;
            a(i6);
            if (i3 == this.c) {
                int[] iArr2 = this.f463a;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.b, 0, objArr2.length);
                }
                e(iArr, objArr2, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f463a;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.b;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.c - i5) << 1);
        }
        int i8 = this.c;
        if (i3 == i8) {
            int[] iArr4 = this.f463a;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr4 = this.b;
                int i9 = i5 << 1;
                objArr4[i9] = obj;
                objArr4[i9 + 1] = obj2;
                this.c = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return l(g2);
        }
        return null;
    }

    public Object replace(Object obj, Object obj2) {
        int g2 = g(obj);
        if (g2 >= 0) {
            return m(g2, obj2);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object j = j(i);
            if (j != this) {
                sb.append(j);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object n = n(i);
            if (n != this) {
                sb.append(n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int g2 = g(obj);
        if (g2 < 0) {
            return false;
        }
        Object n = n(g2);
        if (obj2 != n && (obj2 == null || !obj2.equals(n))) {
            return false;
        }
        l(g2);
        return true;
    }

    public boolean replace(Object obj, Object obj2, Object obj3) {
        int g2 = g(obj);
        if (g2 < 0) {
            return false;
        }
        Object n = n(g2);
        if (n != obj2 && (obj2 == null || !obj2.equals(n))) {
            return false;
        }
        m(g2, obj3);
        return true;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f463a = ContainerHelpers.f453a;
            this.b = ContainerHelpers.c;
        } else {
            a(i);
        }
        this.c = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            k(simpleArrayMap);
        }
    }
}
