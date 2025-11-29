package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final long f2738a;
    public int b;

    public ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.f2738a = j;
    }

    public static InputStream b(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    public final int a(int i) {
        if (i >= 0) {
            this.b += i;
        } else if (this.f2738a - ((long) this.b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f2738a + ", but read: " + this.b);
        }
        return i;
    }

    public synchronized int available() {
        return (int) Math.max(this.f2738a - ((long) this.b), (long) this.in.available());
    }

    public synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }
}
