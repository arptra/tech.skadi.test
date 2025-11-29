package org.apache.tika.io;

import java.io.InputStream;

public class BoundedInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final long f9654a;
    public final InputStream b;
    public long c;

    public BoundedInputStream(long j, InputStream inputStream) {
        this.f9654a = j;
        this.b = inputStream;
    }

    public boolean a() {
        return this.c >= this.f9654a;
    }

    public void mark(int i) {
        this.b.mark(i);
    }

    public int read() {
        long j = this.f9654a;
        if (j >= 0 && this.c >= j) {
            return -1;
        }
        int read = this.b.read();
        this.c++;
        return read;
    }

    public void reset() {
        this.b.reset();
        this.c = 0;
    }

    public long skip(long j) {
        long j2 = this.f9654a;
        if (j2 >= 0) {
            j = Math.min(j, j2 - this.c);
        }
        long skip = this.b.skip(j);
        this.c += skip;
        return skip;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        long j = this.f9654a;
        if (j >= 0 && this.c >= j) {
            return -1;
        }
        int read = this.b.read(bArr, i, (int) (j >= 0 ? Math.min((long) i2, j - this.c) : (long) i2));
        if (read == -1) {
            return -1;
        }
        this.c += (long) read;
        return read;
    }
}
