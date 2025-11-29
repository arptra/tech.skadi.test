package org.apache.commons.io.input;

import java.io.InputStream;
import java.util.Objects;

public class UnsynchronizedByteArrayInputStream extends InputStream {
    public static final int END_OF_STREAM = -1;
    private final byte[] data;
    private final int eod;
    private int markedOffset;
    private int offset;

    public UnsynchronizedByteArrayInputStream(byte[] bArr) {
        Objects.requireNonNull(bArr, "data");
        this.data = bArr;
        this.offset = 0;
        this.eod = bArr.length;
        this.markedOffset = 0;
    }

    public int available() {
        int i = this.offset;
        int i2 = this.eod;
        if (i < i2) {
            return i2 - i;
        }
        return 0;
    }

    public void mark(int i) {
        this.markedOffset = this.offset;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        int i = this.offset;
        if (i >= this.eod) {
            return -1;
        }
        byte[] bArr = this.data;
        this.offset = i + 1;
        return bArr[i] & 255;
    }

    public void reset() {
        this.offset = this.markedOffset;
    }

    public long skip(long j) {
        if (j >= 0) {
            int i = this.eod;
            int i2 = this.offset;
            long j2 = (long) (i - i2);
            if (j >= j2) {
                j = j2;
            }
            this.offset = (int) (((long) i2) + j);
            return j;
        }
        throw new IllegalArgumentException("Skipping backward is not supported");
    }

    public int read(byte[] bArr) {
        Objects.requireNonNull(bArr, "dest");
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "dest");
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = this.offset;
        int i4 = this.eod;
        if (i3 >= i4) {
            return -1;
        }
        int i5 = i4 - i3;
        if (i2 >= i5) {
            i2 = i5;
        }
        if (i2 <= 0) {
            return 0;
        }
        System.arraycopy(this.data, i3, bArr, i, i2);
        this.offset += i2;
        return i2;
    }

    public UnsynchronizedByteArrayInputStream(byte[] bArr, int i) {
        Objects.requireNonNull(bArr, "data");
        if (i >= 0) {
            this.data = bArr;
            int min = Math.min(i, bArr.length > 0 ? bArr.length : i);
            this.offset = min;
            this.eod = bArr.length;
            this.markedOffset = min;
            return;
        }
        throw new IllegalArgumentException("offset cannot be negative");
    }

    public UnsynchronizedByteArrayInputStream(byte[] bArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        } else if (i2 >= 0) {
            Objects.requireNonNull(bArr, "data");
            this.data = bArr;
            int min = Math.min(i, bArr.length > 0 ? bArr.length : i);
            this.offset = min;
            this.eod = Math.min(min + i2, bArr.length);
            this.markedOffset = this.offset;
        } else {
            throw new IllegalArgumentException("length cannot be negative");
        }
    }
}
