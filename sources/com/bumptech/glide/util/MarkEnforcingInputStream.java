package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public int f2747a = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public final long a(long j) {
        int i = this.f2747a;
        if (i == 0) {
            return -1;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : (long) i;
    }

    public int available() {
        int i = this.f2747a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    public final void b(long j) {
        int i = this.f2747a;
        if (i != Integer.MIN_VALUE && j != -1) {
            this.f2747a = (int) (((long) i) - j);
        }
    }

    public synchronized void mark(int i) {
        super.mark(i);
        this.f2747a = i;
    }

    public int read() {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public synchronized void reset() {
        super.reset();
        this.f2747a = Integer.MIN_VALUE;
    }

    public long skip(long j) {
        long a2 = a(j);
        if (a2 == -1) {
            return 0;
        }
        long skip = super.skip(a2);
        b(skip);
        return skip;
    }

    public int read(byte[] bArr, int i, int i2) {
        int a2 = (int) a((long) i2);
        if (a2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a2);
        b((long) read);
        return read;
    }
}
