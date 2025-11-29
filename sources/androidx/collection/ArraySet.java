package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    public static final int[] e = new int[0];
    public static final Object[] f = new Object[0];
    public static Object[] g;
    public static int h;
    public static Object[] i;
    public static int j;

    /* renamed from: a  reason: collision with root package name */
    public int[] f452a;
    public Object[] b;
    public int c;
    public MapCollections d;

    public ArraySet() {
        this(0);
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                try {
                    if (j < 10) {
                        objArr[0] = i;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        i = objArr;
                        j++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                try {
                    if (h < 10) {
                        objArr[0] = g;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        g = objArr;
                        h++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr = i;
                    if (objArr != null) {
                        this.b = objArr;
                        i = (Object[]) objArr[0];
                        this.f452a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        j--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 == 4) {
            synchronized (ArraySet.class) {
                try {
                    Object[] objArr2 = g;
                    if (objArr2 != null) {
                        this.b = objArr2;
                        g = (Object[]) objArr2[0];
                        this.f452a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        h--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.f452a = new int[i2];
        this.b = new Object[i2];
    }

    public boolean add(Object obj) {
        int i2;
        int i3;
        if (obj == null) {
            i3 = f();
            i2 = 0;
        } else {
            int hashCode = obj.hashCode();
            i2 = hashCode;
            i3 = e(obj, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.c;
        int[] iArr = this.f452a;
        if (i5 >= iArr.length) {
            int i6 = 8;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.b;
            a(i6);
            int[] iArr2 = this.f452a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.b, 0, objArr.length);
            }
            c(iArr, objArr, this.c);
        }
        int i7 = this.c;
        if (i4 < i7) {
            int[] iArr3 = this.f452a;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.b;
            System.arraycopy(objArr2, i4, objArr2, i8, this.c - i4);
        }
        this.f452a[i4] = i2;
        this.b[i4] = obj;
        this.c++;
        return true;
    }

    public boolean addAll(Collection collection) {
        b(this.c + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void b(int i2) {
        int[] iArr = this.f452a;
        if (iArr.length < i2) {
            Object[] objArr = this.b;
            a(i2);
            int i3 = this.c;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f452a, 0, i3);
                System.arraycopy(objArr, 0, this.b, 0, this.c);
            }
            c(iArr, objArr, this.c);
        }
    }

    public void clear() {
        int i2 = this.c;
        if (i2 != 0) {
            c(this.f452a, this.b, i2);
            this.f452a = e;
            this.b = f;
            this.c = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final MapCollections d() {
        if (this.d == null) {
            this.d = new MapCollections<E, E>() {
                public void a() {
                    ArraySet.this.clear();
                }

                public Object b(int i, int i2) {
                    return ArraySet.this.b[i];
                }

                public Map c() {
                    throw new UnsupportedOperationException("not a map");
                }

                public int d() {
                    return ArraySet.this.c;
                }

                public int e(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public int f(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                public void g(Object obj, Object obj2) {
                    ArraySet.this.add(obj);
                }

                public void h(int i) {
                    ArraySet.this.h(i);
                }

                public Object i(int i, Object obj) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.d;
    }

    public final int e(Object obj, int i2) {
        int i3 = this.c;
        if (i3 == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.f452a, i3, i2);
        if (a2 < 0 || obj.equals(this.b[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f452a[i4] == i2) {
            if (obj.equals(this.b[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f452a[i5] == i2) {
            if (obj.equals(this.b[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.c) {
                try {
                    if (!set.contains(i(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.f452a, i2, 0);
        if (a2 < 0 || this.b[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f452a[i3] == 0) {
            if (this.b[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f452a[i4] == 0) {
            if (this.b[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public Object h(int i2) {
        Object[] objArr = this.b;
        Object obj = objArr[i2];
        int i3 = this.c;
        if (i3 <= 1) {
            c(this.f452a, objArr, i3);
            this.f452a = e;
            this.b = f;
            this.c = 0;
        } else {
            int[] iArr = this.f452a;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.c = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.c - i2);
                }
                this.b[this.c] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                a(i4);
                this.c--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f452a, 0, i2);
                    System.arraycopy(objArr, 0, this.b, 0, i2);
                }
                int i7 = this.c;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.f452a, i2, i7 - i2);
                    System.arraycopy(objArr, i8, this.b, i2, this.c - i2);
                }
            }
        }
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.f452a;
        int i2 = this.c;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public Object i(int i2) {
        return this.b[i2];
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public Iterator iterator() {
        return d().m().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        h(indexOf);
        return true;
    }

    public boolean removeAll(Collection collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i2 = this.c - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.b[i2])) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.c;
    }

    public Object[] toArray() {
        int i2 = this.c;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.b, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.c; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public ArraySet(int i2) {
        if (i2 == 0) {
            this.f452a = e;
            this.b = f;
        } else {
            a(i2);
        }
        this.c = 0;
    }

    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.c);
        }
        System.arraycopy(this.b, 0, objArr, 0, this.c);
        int length = objArr.length;
        int i2 = this.c;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
