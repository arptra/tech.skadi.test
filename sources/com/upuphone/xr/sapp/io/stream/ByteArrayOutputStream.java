package com.upuphone.xr.sapp.io.stream;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ByteArrayOutputStream extends OutputStream {
    public static final byte[] f = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final List f7102a;
    public int b;
    public int c;
    public byte[] d;
    public int e;

    public ByteArrayOutputStream() {
        this(1024);
    }

    public final void a(int i) {
        if (this.b < this.f7102a.size() - 1) {
            this.c += this.d.length;
            int i2 = this.b + 1;
            this.b = i2;
            this.d = (byte[]) this.f7102a.get(i2);
            return;
        }
        byte[] bArr = this.d;
        if (bArr == null) {
            this.c = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.c);
            this.c += this.d.length;
        }
        this.b++;
        byte[] bArr2 = new byte[i];
        this.d = bArr2;
        this.f7102a.add(bArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] b() {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.e     // Catch:{ all -> 0x0009 }
            if (r0 != 0) goto L_0x000b
            byte[] r0 = f     // Catch:{ all -> 0x0009 }
            monitor-exit(r7)
            return r0
        L_0x0009:
            r0 = move-exception
            goto L_0x002f
        L_0x000b:
            byte[] r1 = new byte[r0]     // Catch:{ all -> 0x0009 }
            java.util.List r2 = r7.f7102a     // Catch:{ all -> 0x0009 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0009 }
            r3 = 0
            r4 = r3
        L_0x0015:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x002d
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0009 }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x0009 }
            int r6 = r5.length     // Catch:{ all -> 0x0009 }
            int r6 = java.lang.Math.min(r6, r0)     // Catch:{ all -> 0x0009 }
            java.lang.System.arraycopy(r5, r3, r1, r4, r6)     // Catch:{ all -> 0x0009 }
            int r4 = r4 + r6
            int r0 = r0 - r6
            if (r0 != 0) goto L_0x0015
        L_0x002d:
            monitor-exit(r7)
            return r1
        L_0x002f:
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.io.stream.ByteArrayOutputStream.b():byte[]");
    }

    public void close() {
    }

    public String toString() {
        return new String(b());
    }

    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                try {
                    int i4 = this.e;
                    int i5 = i4 + i2;
                    int i6 = i4 - this.c;
                    while (i2 > 0) {
                        int min = Math.min(i2, this.d.length - i6);
                        System.arraycopy(bArr, i3 - i2, this.d, i6, min);
                        i2 -= min;
                        if (i2 > 0) {
                            a(i5);
                            i6 = 0;
                        }
                    }
                    this.e = i5;
                } finally {
                }
            }
        }
    }

    public ByteArrayOutputStream(int i) {
        this.f7102a = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                a(i);
            }
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    public synchronized void write(int i) {
        try {
            int i2 = this.e;
            int i3 = i2 - this.c;
            if (i3 == this.d.length) {
                a(i2 + 1);
                i3 = 0;
            }
            this.d[i3] = (byte) i;
            this.e++;
        } catch (Throwable th) {
            throw th;
        }
    }
}
