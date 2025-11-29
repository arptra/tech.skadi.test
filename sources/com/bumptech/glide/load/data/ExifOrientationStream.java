package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class ExifOrientationStream extends FilterInputStream {
    public static final byte[] c;
    public static final int d;
    public static final int e;

    /* renamed from: a  reason: collision with root package name */
    public final byte f2457a;
    public int b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        c = bArr;
        int length = bArr.length;
        d = length;
        e = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.f2457a = (byte) i;
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int i;
        int i2;
        int i3 = this.b;
        if (i3 < 2 || i3 > (i2 = e)) {
            i = super.read();
        } else if (i3 == i2) {
            i = this.f2457a;
        } else {
            i = c[i3 - 2] & 255;
        }
        if (i != -1) {
            this.b++;
        }
        return i;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.b = (int) (((long) this.b) + skip);
        }
        return skip;
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.b;
        int i5 = e;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f2457a;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(c, this.b - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.b += i3;
        }
        return i3;
    }
}
