package com.xingin.xhssharesdk.a;

import com.xingin.xhssharesdk.a.b0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class g extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f8130a = Logger.getLogger(g.class.getName());
    public static final boolean b = a0.c;
    public static final long c = a0.d;

    public static abstract class a extends g {
        public final byte[] d;
        public final int e;
        public int f;

        public a() {
            super(0);
            int max = Math.max(4096, 20);
            this.d = new byte[max];
            this.e = max;
        }

        public final void B(long j) {
            if (g.b) {
                long j2 = g.c + ((long) this.f);
                long j3 = j2;
                while ((j & -128) != 0) {
                    a0.d(this.d, j3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                    j3 = 1 + j3;
                }
                a0.d(this.d, j3, (byte) ((int) j));
                this.f += (int) ((1 + j3) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr2[i2] = (byte) ((int) j);
        }

        public final void C(int i) {
            if (g.b) {
                long j = g.c + ((long) this.f);
                long j2 = j;
                while ((i & -128) != 0) {
                    a0.d(this.d, j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                    j2 = 1 + j2;
                }
                a0.d(this.d, j2, (byte) i);
                this.f += (int) ((1 + j2) - j);
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            bArr2[i3] = (byte) i;
        }
    }

    public static class b extends g {
        public final byte[] d;
        public final int e;
        public int f;

        public b(byte[] bArr, int i) {
            super(0);
            if (((bArr.length - i) | i) >= 0) {
                this.d = bArr;
                this.f = 0;
                this.e = i;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), 0, Integer.valueOf(i)}));
        }

        public final void A(int i) {
            if (g.b) {
                int i2 = this.e;
                int i3 = this.f;
                if (i2 - i3 >= 10) {
                    long j = g.c + ((long) i3);
                    while ((i & -128) != 0) {
                        a0.d(this.d, j, (byte) ((i & 127) | 128));
                        this.f++;
                        i >>>= 7;
                        j = 1 + j;
                    }
                    a0.d(this.d, j, (byte) i);
                    this.f++;
                    return;
                }
            }
            while ((i & -128) != 0) {
                byte[] bArr = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                bArr[i4] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            try {
                byte[] bArr2 = this.d;
                int i5 = this.f;
                this.f = i5 + 1;
                bArr2[i5] = (byte) i;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void a(byte[] bArr, int i, int i2) {
            u(bArr, i, i2);
        }

        public final void h() {
        }

        public final void i(byte b) {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void j(int i, int i2) {
            A(c0.a(i, 0));
            z(i2);
        }

        public final void k(int i, k kVar) {
            A(c0.a(i, 2));
            A(kVar.b());
            kVar.b(this);
        }

        public final void m(byte[] bArr, int i) {
            A(i);
            u(bArr, 0, i);
        }

        public final void o(int i, int i2) {
            A(c0.a(i, i2));
        }

        public final void p(int i, String str) {
            A(c0.a(i, 2));
            t(str);
        }

        public final void q(long j) {
            try {
                byte[] bArr = this.d;
                int i = this.f;
                bArr[i] = (byte) (((int) j) & 255);
                bArr[i + 1] = (byte) (((int) (j >> 8)) & 255);
                bArr[i + 2] = (byte) (((int) (j >> 16)) & 255);
                bArr[i + 3] = (byte) (((int) (j >> 24)) & 255);
                bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
                bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
                bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
                this.f = i + 8;
                bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void r(e eVar) {
            A(eVar.size());
            eVar.a((c) this);
        }

        public final void s(r rVar) {
            A(rVar.b());
            rVar.b(this);
        }

        public final void t(String str) {
            int i = this.f;
            try {
                int v = g.v(str.length() * 3);
                int v2 = g.v(str.length());
                if (v2 == v) {
                    int i2 = i + v2;
                    this.f = i2;
                    int a2 = b0.f8123a.a(str, this.d, i2, this.e - i2);
                    this.f = i;
                    A((a2 - i) - v2);
                    this.f = a2;
                    return;
                }
                A(b0.c(str));
                byte[] bArr = this.d;
                int i3 = this.f;
                this.f = b0.f8123a.a(str, bArr, i3, this.e - i3);
            } catch (b0.c e2) {
                this.f = i;
                l(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new c(e3);
            }
        }

        public final void u(byte[] bArr, int i, int i2) {
            try {
                System.arraycopy(bArr, i, this.d, this.f, i2);
                this.f += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), Integer.valueOf(i2)}), e2);
            }
        }

        public final void w(long j) {
            A(c0.a(8, 0));
            y(j);
        }

        public final void x(int i) {
            try {
                byte[] bArr = this.d;
                int i2 = this.f;
                bArr[i2] = (byte) (i & 255);
                bArr[i2 + 1] = (byte) ((i >> 8) & 255);
                bArr[i2 + 2] = (byte) ((i >> 16) & 255);
                this.f = i2 + 4;
                bArr[i2 + 3] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void y(long j) {
            if (g.b) {
                int i = this.e;
                int i2 = this.f;
                if (i - i2 >= 10) {
                    long j2 = g.c + ((long) i2);
                    while ((j & -128) != 0) {
                        a0.d(this.d, j2, (byte) ((((int) j) & 127) | 128));
                        this.f++;
                        j >>>= 7;
                        j2 = 1 + j2;
                    }
                    a0.d(this.d, j2, (byte) ((int) j));
                    this.f++;
                    return;
                }
            }
            while ((j & -128) != 0) {
                byte[] bArr = this.d;
                int i3 = this.f;
                this.f = i3 + 1;
                bArr[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            try {
                byte[] bArr2 = this.d;
                int i4 = this.f;
                this.f = i4 + 1;
                bArr2[i4] = (byte) ((int) j);
            } catch (IndexOutOfBoundsException e2) {
                throw new c(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f), Integer.valueOf(this.e), 1}), e2);
            }
        }

        public final void z(int i) {
            if (i >= 0) {
                A(i);
            } else {
                y((long) i);
            }
        }
    }

    public static class c extends IOException {
        public c(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }

        public c(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, indexOutOfBoundsException);
        }
    }

    public static final class d extends a {
        public final OutputStream g;

        public d(ByteArrayOutputStream byteArrayOutputStream) {
            this.g = byteArrayOutputStream;
        }

        public final void A(int i) {
            D(10);
            C(i);
        }

        public final void D(int i) {
            int i2 = this.e;
            int i3 = this.f;
            if (i2 - i3 < i) {
                this.g.write(this.d, 0, i3);
                this.f = 0;
            }
        }

        public final void a(byte[] bArr, int i, int i2) {
            u(bArr, i, i2);
        }

        public final void h() {
            int i = this.f;
            if (i > 0) {
                this.g.write(this.d, 0, i);
                this.f = 0;
            }
        }

        public final void i(byte b) {
            int i = this.f;
            if (i == this.e) {
                this.g.write(this.d, 0, i);
                this.f = 0;
            }
            byte[] bArr = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr[i2] = b;
        }

        public final void j(int i, int i2) {
            D(20);
            C(c0.a(i, 0));
            if (i2 >= 0) {
                C(i2);
            } else {
                B((long) i2);
            }
        }

        public final void k(int i, k kVar) {
            A(c0.a(i, 2));
            A(kVar.b());
            kVar.b(this);
        }

        public final void m(byte[] bArr, int i) {
            A(i);
            u(bArr, 0, i);
        }

        public final void o(int i, int i2) {
            A(c0.a(i, i2));
        }

        public final void p(int i, String str) {
            A(c0.a(i, 2));
            t(str);
        }

        public final void q(long j) {
            D(8);
            byte[] bArr = this.d;
            int i = this.f;
            bArr[i] = (byte) ((int) (j & 255));
            bArr[i + 1] = (byte) ((int) ((j >> 8) & 255));
            bArr[i + 2] = (byte) ((int) ((j >> 16) & 255));
            bArr[i + 3] = (byte) ((int) (255 & (j >> 24)));
            bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
            bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
            bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
            this.f = i + 8;
            bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
        }

        public final void r(e eVar) {
            A(eVar.size());
            eVar.a((c) this);
        }

        public final void s(r rVar) {
            A(rVar.b());
            rVar.b(this);
        }

        public final void t(String str) {
            int i;
            try {
                int length = str.length() * 3;
                int v = g.v(length);
                int i2 = v + length;
                int i3 = this.e;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int a2 = b0.f8123a.a(str, bArr, 0, length);
                    A(a2);
                    u(bArr, 0, a2);
                    return;
                }
                int i4 = this.f;
                if (i2 > i3 - i4) {
                    this.g.write(this.d, 0, i4);
                    this.f = 0;
                }
                int v2 = g.v(str.length());
                i = this.f;
                if (v2 == v) {
                    int i5 = i + v2;
                    this.f = i5;
                    int a3 = b0.f8123a.a(str, this.d, i5, this.e - i5);
                    this.f = i;
                    C((a3 - i) - v2);
                    this.f = a3;
                    return;
                }
                int c = b0.c(str);
                C(c);
                this.f = b0.f8123a.a(str, this.d, this.f, c);
            } catch (b0.c e) {
                this.f = i;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new c(e2);
            } catch (b0.c e3) {
                l(str, e3);
            }
        }

        public final void u(byte[] bArr, int i, int i2) {
            int i3 = this.e;
            int i4 = this.f;
            int i5 = i3 - i4;
            if (i5 >= i2) {
                System.arraycopy(bArr, i, this.d, i4, i2);
                this.f += i2;
                return;
            }
            System.arraycopy(bArr, i, this.d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            int i8 = this.e;
            this.f = i8;
            this.g.write(this.d, 0, i8);
            this.f = 0;
            if (i7 <= this.e) {
                System.arraycopy(bArr, i6, this.d, 0, i7);
                this.f = i7;
                return;
            }
            this.g.write(bArr, i6, i7);
        }

        public final void w(long j) {
            D(20);
            C(c0.a(8, 0));
            B(j);
        }

        public final void x(int i) {
            D(4);
            byte[] bArr = this.d;
            int i2 = this.f;
            bArr[i2] = (byte) (i & 255);
            bArr[i2 + 1] = (byte) ((i >> 8) & 255);
            bArr[i2 + 2] = (byte) ((i >> 16) & 255);
            this.f = i2 + 4;
            bArr[i2 + 3] = (byte) ((i >> 24) & 255);
        }

        public final void y(long j) {
            D(10);
            B(j);
        }

        public final void z(int i) {
            if (i >= 0) {
                A(i);
            } else {
                y((long) i);
            }
        }
    }

    public g() {
    }

    public static int b(int i) {
        if (i >= 0) {
            return v(i);
        }
        return 10;
    }

    public static int c(int i, String str) {
        return g(str) + n(i);
    }

    public static int d(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int e(e eVar) {
        int size = eVar.size();
        return v(size) + size;
    }

    public static int f(r rVar) {
        int b2 = rVar.b();
        return v(b2) + b2;
    }

    public static int g(String str) {
        int i;
        try {
            i = b0.c(str);
        } catch (b0.c unused) {
            i = str.getBytes(l.f8140a).length;
        }
        return v(i) + i;
    }

    public static int n(int i) {
        return v(c0.a(i, 0));
    }

    public static int v(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public abstract void A(int i);

    public abstract void h();

    public abstract void i(byte b2);

    public abstract void j(int i, int i2);

    public abstract void k(int i, k kVar);

    public final void l(String str, b0.c cVar) {
        f8130a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", cVar);
        byte[] bytes = str.getBytes(l.f8140a);
        try {
            A(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new c(e);
        } catch (c e2) {
            throw e2;
        }
    }

    public abstract void m(byte[] bArr, int i);

    public abstract void o(int i, int i2);

    public abstract void p(int i, String str);

    public abstract void q(long j);

    public abstract void r(e eVar);

    public abstract void s(r rVar);

    public abstract void t(String str);

    public abstract void u(byte[] bArr, int i, int i2);

    public abstract void w(long j);

    public abstract void x(int i);

    public abstract void y(long j);

    public abstract void z(int i);

    public /* synthetic */ g(int i) {
        this();
    }
}
