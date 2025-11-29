package androidx.constraintlayout.core;

final class Pools {

    public interface Pool<T> {
        boolean a(Object obj);

        Object acquire();

        void b(Object[] objArr, int i);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        public final Object[] f481a;
        public int b;

        public SimplePool(int i) {
            if (i > 0) {
                this.f481a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public boolean a(Object obj) {
            int i = this.b;
            Object[] objArr = this.f481a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = obj;
            this.b = i + 1;
            return true;
        }

        public Object acquire() {
            int i = this.b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f481a;
            Object obj = objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return obj;
        }

        public void b(Object[] objArr, int i) {
            if (i > objArr.length) {
                i = objArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                int i3 = this.b;
                Object[] objArr2 = this.f481a;
                if (i3 < objArr2.length) {
                    objArr2[i3] = obj;
                    this.b = i3 + 1;
                }
            }
        }
    }
}
