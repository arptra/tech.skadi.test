package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public final class ExceptionPassthroughInputStream extends InputStream {
    public static final Queue c = Util.g(0);

    /* renamed from: a  reason: collision with root package name */
    public InputStream f2740a;
    public IOException b;

    public static ExceptionPassthroughInputStream b(InputStream inputStream) {
        ExceptionPassthroughInputStream exceptionPassthroughInputStream;
        Queue queue = c;
        synchronized (queue) {
            exceptionPassthroughInputStream = (ExceptionPassthroughInputStream) queue.poll();
        }
        if (exceptionPassthroughInputStream == null) {
            exceptionPassthroughInputStream = new ExceptionPassthroughInputStream();
        }
        exceptionPassthroughInputStream.c(inputStream);
        return exceptionPassthroughInputStream;
    }

    public IOException a() {
        return this.b;
    }

    public int available() {
        return this.f2740a.available();
    }

    public void c(InputStream inputStream) {
        this.f2740a = inputStream;
    }

    public void close() {
        this.f2740a.close();
    }

    public void mark(int i) {
        this.f2740a.mark(i);
    }

    public boolean markSupported() {
        return this.f2740a.markSupported();
    }

    public int read() {
        try {
            return this.f2740a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public void release() {
        this.b = null;
        this.f2740a = null;
        Queue queue = c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() {
        this.f2740a.reset();
    }

    public long skip(long j) {
        try {
            return this.f2740a.skip(j);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.f2740a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f2740a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
