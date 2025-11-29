package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public List f967a = new ArrayList();
    public long b = 0;
    public long[] c;
    public int d;
    public final NotifierCallback e;

    public static abstract class NotifierCallback<C, T, A> {
        public abstract void a(Object obj, Object obj2, int i, Object obj3);
    }

    public CallbackRegistry(NotifierCallback notifierCallback) {
        this.e = notifierCallback;
    }

    public synchronized void b(Object obj) {
        if (obj != null) {
            try {
                int lastIndexOf = this.f967a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    if (d(lastIndexOf)) {
                    }
                }
                this.f967a.add(obj);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new IllegalArgumentException("callback cannot be null");
        }
    }

    /* renamed from: c */
    public synchronized CallbackRegistry clone() {
        CallbackRegistry callbackRegistry;
        CloneNotSupportedException e2;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.b = 0;
                callbackRegistry.c = null;
                callbackRegistry.d = 0;
                callbackRegistry.f967a = new ArrayList();
                int size = this.f967a.size();
                for (int i = 0; i < size; i++) {
                    if (!d(i)) {
                        callbackRegistry.f967a.add(this.f967a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e3) {
                e2 = e3;
                e2.printStackTrace();
                return callbackRegistry;
            }
        } catch (CloneNotSupportedException e4) {
            CloneNotSupportedException cloneNotSupportedException = e4;
            callbackRegistry = null;
            e2 = cloneNotSupportedException;
            e2.printStackTrace();
            return callbackRegistry;
        }
        return callbackRegistry;
    }

    public final boolean d(int i) {
        int i2;
        if (i < 64) {
            return (this.b & (1 << i)) != 0;
        }
        long[] jArr = this.c;
        if (jArr == null || (i2 = (i / 64) - 1) >= jArr.length) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i2]) != 0;
    }

    public synchronized void e(Object obj, int i, Object obj2) {
        try {
            this.d++;
            h(obj, i, obj2);
            int i2 = this.d - 1;
            this.d = i2;
            if (i2 == 0) {
                long[] jArr = this.c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j = this.c[length];
                        if (j != 0) {
                            k((length + 1) * 64, j);
                            this.c[length] = 0;
                        }
                    }
                }
                long j2 = this.b;
                if (j2 != 0) {
                    k(0, j2);
                    this.b = 0;
                }
            }
        } finally {
        }
    }

    public final void f(Object obj, int i, Object obj2, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.e.a(this.f967a.get(i2), obj, i, obj2);
            }
            j2 <<= 1;
            i2++;
        }
    }

    public final void g(Object obj, int i, Object obj2) {
        f(obj, i, obj2, 0, Math.min(64, this.f967a.size()), this.b);
    }

    public final void h(Object obj, int i, Object obj2) {
        int size = this.f967a.size();
        long[] jArr = this.c;
        int length = jArr == null ? -1 : jArr.length - 1;
        i(obj, i, obj2, length);
        f(obj, i, obj2, (length + 2) * 64, size, 0);
    }

    public final void i(Object obj, int i, Object obj2, int i2) {
        if (i2 < 0) {
            g(obj, i, obj2);
            return;
        }
        long j = this.c[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.f967a.size(), i3 + 64);
        i(obj, i, obj2, i2 - 1);
        f(obj, i, obj2, i3, min, j);
    }

    public synchronized void j(Object obj) {
        try {
            if (this.d == 0) {
                this.f967a.remove(obj);
            } else {
                int lastIndexOf = this.f967a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    l(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = i + 63; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.f967a.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    public final void l(int i) {
        if (i < 64) {
            this.b = (1 << i) | this.b;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.c;
        if (jArr == null) {
            this.c = new long[(this.f967a.size() / 64)];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[(this.f967a.size() / 64)];
            long[] jArr3 = this.c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.c = jArr2;
        }
        long[] jArr4 = this.c;
        jArr4[i2] = (1 << (i % 64)) | jArr4[i2];
    }
}
