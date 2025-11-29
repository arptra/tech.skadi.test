package com.xingin.xhssharesdk.a;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

public abstract class e implements Iterable<Byte>, Serializable {
    public static final d b = new d(l.b);
    public static final b c;

    /* renamed from: a  reason: collision with root package name */
    public int f8128a = 0;

    public static final class a implements b {
        public final byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    public interface b {
        byte[] a(byte[] bArr, int i, int i2);
    }

    public static abstract class c extends e {
        public final Iterator iterator() {
            return new d(this);
        }
    }

    public static class d extends c {
        public final byte[] d;

        public d(byte[] bArr) {
            this.d = bArr;
        }

        public byte a(int i) {
            return this.d[i];
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e) || size() != ((e) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof d)) {
                return obj.equals(this);
            }
            d dVar = (d) obj;
            int i = this.f8128a;
            int i2 = dVar.f8128a;
            if (i != 0 && i2 != 0 && i != i2) {
                return false;
            }
            int size = size();
            if (size > dVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (size <= dVar.size()) {
                byte[] bArr = this.d;
                byte[] bArr2 = dVar.d;
                int a2 = a() + size;
                int a3 = a();
                int a4 = dVar.a();
                while (a3 < a2) {
                    if (bArr[a3] != bArr2[a4]) {
                        return false;
                    }
                    a3++;
                    a4++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + dVar.size());
            }
        }

        public int size() {
            return this.d.length;
        }

        public int a() {
            return 0;
        }

        public final void a(c cVar) {
            cVar.a(this.d, a(), size());
        }

        public final int a(int i, int i2) {
            byte[] bArr = this.d;
            int a2 = a();
            Charset charset = l.f8140a;
            for (int i3 = a2; i3 < a2 + i2; i3++) {
                i = (i * 31) + bArr[i3];
            }
            return i;
        }
    }

    /* renamed from: com.xingin.xhssharesdk.a.e$e  reason: collision with other inner class name */
    public static final class C0029e implements b {
        public final byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    static {
        b bVar;
        try {
            Class.forName("android.content.Context");
            bVar = new C0029e();
        } catch (ClassNotFoundException unused) {
            bVar = new a();
        }
        c = bVar;
    }

    public static d a(String str) {
        return new d(str.getBytes(l.f8140a));
    }

    public abstract byte a(int i);

    public abstract int a(int i, int i2);

    public abstract void a(c cVar);

    public final int hashCode() {
        int i = this.f8128a;
        if (i == 0) {
            int size = size();
            i = a(size, size);
            if (i == 0) {
                i = 1;
            }
            this.f8128a = i;
        }
        return i;
    }

    public Iterator iterator() {
        return new d(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }
}
