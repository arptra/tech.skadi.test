package org.apache.tika.io;

import java.io.InputStream;

public class LookaheadInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f9656a;
    public InputStream b;
    public int c;
    public int d;
    public int e;

    public final void a() {
        InputStream inputStream;
        if (available() == 0) {
            int i = this.c;
            byte[] bArr = this.f9656a;
            if (i < bArr.length && (inputStream = this.b) != null) {
                int read = inputStream.read(bArr, i, bArr.length - i);
                if (read != -1) {
                    this.c += read;
                } else {
                    close();
                }
            }
        }
    }

    public int available() {
        return this.c - this.d;
    }

    public void close() {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.reset();
            this.b = null;
        }
    }

    public synchronized void mark(int i) {
        this.e = this.d;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        a();
        int i = this.c;
        int i2 = this.d;
        if (i <= i2) {
            return -1;
        }
        byte[] bArr = this.f9656a;
        this.d = i2 + 1;
        return bArr[i2] & 255;
    }

    public synchronized void reset() {
        this.d = this.e;
    }

    public long skip(long j) {
        a();
        long min = Math.min(j, (long) available());
        this.d = (int) (((long) this.d) + min);
        return min;
    }

    public int read(byte[] bArr, int i, int i2) {
        a();
        int i3 = this.c;
        int i4 = this.d;
        if (i3 <= i4) {
            return -1;
        }
        int min = Math.min(i2, i3 - i4);
        System.arraycopy(this.f9656a, this.d, bArr, i, min);
        this.d += min;
        return min;
    }
}
