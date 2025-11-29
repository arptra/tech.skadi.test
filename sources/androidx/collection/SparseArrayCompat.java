package androidx.collection;

public class SparseArrayCompat<E> implements Cloneable {
    public static final Object e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public boolean f464a;
    public int[] b;
    public Object[] c;
    public int d;

    public SparseArrayCompat() {
        this(10);
    }

    public void b(int i, Object obj) {
        int i2 = this.d;
        if (i2 == 0 || i > this.b[i2 - 1]) {
            if (this.f464a && i2 >= this.b.length) {
                f();
            }
            int i3 = this.d;
            if (i3 >= this.b.length) {
                int e2 = ContainerHelpers.e(i3 + 1);
                int[] iArr = new int[e2];
                Object[] objArr = new Object[e2];
                int[] iArr2 = this.b;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.c;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.b = iArr;
                this.c = objArr;
            }
            this.b[i3] = i;
            this.c[i3] = obj;
            this.d = i3 + 1;
            return;
        }
        m(i, obj);
    }

    public void c() {
        int i = this.d;
        Object[] objArr = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.d = 0;
        this.f464a = false;
    }

    /* renamed from: d */
    public SparseArrayCompat clone() {
        try {
            SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.b = (int[]) this.b.clone();
            sparseArrayCompat.c = (Object[]) this.c.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean e(Object obj) {
        return j(obj) >= 0;
    }

    public final void f() {
        int i = this.d;
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != e) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f464a = false;
        this.d = i2;
    }

    public Object g(int i) {
        return h(i, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r2 = r2.c[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(int r3, java.lang.Object r4) {
        /*
            r2 = this;
            int[] r0 = r2.b
            int r1 = r2.d
            int r3 = androidx.collection.ContainerHelpers.a(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r2 = r2.c
            r2 = r2[r3]
            java.lang.Object r3 = e
            if (r2 != r3) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r2
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.h(int, java.lang.Object):java.lang.Object");
    }

    public int i(int i) {
        if (this.f464a) {
            f();
        }
        return ContainerHelpers.a(this.b, this.d, i);
    }

    public int j(Object obj) {
        if (this.f464a) {
            f();
        }
        for (int i = 0; i < this.d; i++) {
            if (this.c[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public boolean k() {
        return p() == 0;
    }

    public int l(int i) {
        if (this.f464a) {
            f();
        }
        return this.b[i];
    }

    public void m(int i, Object obj) {
        int a2 = ContainerHelpers.a(this.b, this.d, i);
        if (a2 >= 0) {
            this.c[a2] = obj;
            return;
        }
        int i2 = ~a2;
        int i3 = this.d;
        if (i2 < i3) {
            Object[] objArr = this.c;
            if (objArr[i2] == e) {
                this.b[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f464a && i3 >= this.b.length) {
            f();
            i2 = ~ContainerHelpers.a(this.b, this.d, i);
        }
        int i4 = this.d;
        if (i4 >= this.b.length) {
            int e2 = ContainerHelpers.e(i4 + 1);
            int[] iArr = new int[e2];
            Object[] objArr2 = new Object[e2];
            int[] iArr2 = this.b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.b = iArr;
            this.c = objArr2;
        }
        int i5 = this.d;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.b;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.c;
            System.arraycopy(objArr4, i2, objArr4, i6, this.d - i2);
        }
        this.b[i2] = i;
        this.c[i2] = obj;
        this.d++;
    }

    public void n(int i) {
        Object[] objArr = this.c;
        Object obj = objArr[i];
        Object obj2 = e;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f464a = true;
        }
    }

    public Object o(int i, Object obj) {
        int i2 = i(i);
        if (i2 < 0) {
            return null;
        }
        Object[] objArr = this.c;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public int p() {
        if (this.f464a) {
            f();
        }
        return this.d;
    }

    public Object q(int i) {
        if (this.f464a) {
            f();
        }
        return this.c[i];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(l(i));
            sb.append('=');
            Object q = q(i);
            if (q != this) {
                sb.append(q);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public SparseArrayCompat(int i) {
        this.f464a = false;
        if (i == 0) {
            this.b = ContainerHelpers.f453a;
            this.c = ContainerHelpers.c;
            return;
        }
        int e2 = ContainerHelpers.e(i);
        this.b = new int[e2];
        this.c = new Object[e2];
    }
}
