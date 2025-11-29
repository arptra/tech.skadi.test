package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    public static final ProtobufArrayList d;
    public Object[] b;
    public int c;

    static {
        ProtobufArrayList protobufArrayList = new ProtobufArrayList(new Object[0], 0);
        d = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    public ProtobufArrayList(Object[] objArr, int i) {
        this.b = objArr;
        this.c = i;
    }

    public static Object[] b(int i) {
        return new Object[i];
    }

    public static ProtobufArrayList c() {
        return d;
    }

    private void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private String e(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public boolean add(Object obj) {
        a();
        int i = this.c;
        Object[] objArr = this.b;
        if (i == objArr.length) {
            this.b = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }

    /* renamed from: f */
    public ProtobufArrayList mutableCopyWithCapacity(int i) {
        if (i >= this.c) {
            return new ProtobufArrayList(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public Object get(int i) {
        d(i);
        return this.b[i];
    }

    public Object remove(int i) {
        a();
        d(i);
        Object[] objArr = this.b;
        Object obj = objArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return obj;
    }

    public Object set(int i, Object obj) {
        a();
        d(i);
        Object[] objArr = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    public int size() {
        return this.c;
    }

    public void add(int i, Object obj) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        Object[] objArr = this.b;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] b2 = b(((i2 * 3) / 2) + 1);
            System.arraycopy(this.b, 0, b2, 0, i);
            System.arraycopy(this.b, i, b2, i + 1, this.c - i);
            this.b = b2;
        }
        this.b[i] = obj;
        this.c++;
        this.modCount++;
    }
}
