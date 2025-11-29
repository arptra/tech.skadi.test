package org.apache.tika.io;

import java.io.FilterInputStream;

public class TailStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9658a;
    public final int b;
    public byte[] c;
    public long d;
    public long e;
    public int f;
    public int g;

    public final void a(byte[] bArr, int i, int i2) {
        if (i2 >= this.b) {
            d(bArr, i, i2);
        } else {
            c(bArr, i, i2);
        }
        this.d += (long) i2;
    }

    public final void b(byte b2) {
        byte[] bArr = this.f9658a;
        int i = this.f;
        int i2 = i + 1;
        this.f = i2;
        bArr[i] = b2;
        if (i2 >= this.b) {
            this.f = 0;
        }
        this.d++;
    }

    public final void c(byte[] bArr, int i, int i2) {
        int min = Math.min(this.b - this.f, i2);
        System.arraycopy(bArr, i, this.f9658a, this.f, min);
        System.arraycopy(bArr, i + min, this.f9658a, 0, i2 - min);
        this.f = (this.f + i2) % this.b;
    }

    public final void d(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        int i4 = this.b;
        System.arraycopy(bArr, i3 - i4, this.f9658a, 0, i4);
        this.f = 0;
    }

    public void mark(int i) {
        int i2 = this.b;
        byte[] bArr = new byte[i2];
        this.c = bArr;
        System.arraycopy(this.f9658a, 0, bArr, 0, i2);
        this.g = this.f;
        this.e = this.d;
    }

    public int read() {
        int read = super.read();
        if (read != -1) {
            b((byte) read);
        }
        return read;
    }

    public void reset() {
        byte[] bArr = this.c;
        if (bArr != null) {
            System.arraycopy(bArr, 0, this.f9658a, 0, this.b);
            this.f = this.g;
            this.d = this.e;
        }
    }

    public long skip(long j) {
        int min = (int) Math.min(j, 4096);
        byte[] bArr = new byte[min];
        long j2 = 0;
        int i = 0;
        while (j2 < j && i != -1) {
            i = read(bArr, 0, (int) Math.min((long) min, j - j2));
            if (i != -1) {
                j2 += (long) i;
            }
        }
        if (i >= 0 || j2 != 0) {
            return j2;
        }
        return -1;
    }

    public int read(byte[] bArr) {
        int read = super.read(bArr);
        if (read > 0) {
            a(bArr, 0, read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read > 0) {
            a(bArr, i, read);
        }
        return read;
    }
}
