package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

@Deprecated
public class ExceptionCatchingInputStream extends InputStream {
    public static final Queue c = Util.g(0);

    /* renamed from: a  reason: collision with root package name */
    public InputStream f2739a;
    public IOException b;

    public int available() {
        return this.f2739a.available();
    }

    public void close() {
        this.f2739a.close();
    }

    public void mark(int i) {
        this.f2739a.mark(i);
    }

    public boolean markSupported() {
        return this.f2739a.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f2739a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }

    public synchronized void reset() {
        this.f2739a.reset();
    }

    public long skip(long j) {
        try {
            return this.f2739a.skip(j);
        } catch (IOException e) {
            this.b = e;
            return 0;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f2739a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f2739a.read();
        } catch (IOException e) {
            this.b = e;
            return -1;
        }
    }
}
