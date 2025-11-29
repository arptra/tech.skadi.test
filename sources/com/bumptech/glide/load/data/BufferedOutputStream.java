package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final OutputStream f2454a;
    public byte[] b;
    public ArrayPool c;
    public int d;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    public final void a() {
        int i = this.d;
        if (i > 0) {
            this.f2454a.write(this.b, 0, i);
            this.d = 0;
        }
    }

    public final void b() {
        if (this.d == this.b.length) {
            a();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() {
        try {
            flush();
            this.f2454a.close();
            release();
        } catch (Throwable th) {
            this.f2454a.close();
            throw th;
        }
    }

    public void flush() {
        a();
        this.f2454a.flush();
    }

    public final void release() {
        byte[] bArr = this.b;
        if (bArr != null) {
            this.c.put(bArr);
            this.b = null;
        }
    }

    public void write(int i) {
        byte[] bArr = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.f2454a = outputStream;
        this.c = arrayPool;
        this.b = (byte[]) arrayPool.c(i, byte[].class);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.d;
            if (i6 != 0 || i4 < this.b.length) {
                int min = Math.min(i4, this.b.length - i6);
                System.arraycopy(bArr, i5, this.b, this.d, min);
                this.d += min;
                i3 += min;
                b();
            } else {
                this.f2454a.write(bArr, i5, i4);
                return;
            }
        } while (i3 < i2);
    }
}
