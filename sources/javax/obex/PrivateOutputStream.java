package javax.obex;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class PrivateOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public BaseStream f3694a;
    public ByteArrayOutputStream b;
    public boolean c;
    public int d;

    public final void a() {
        this.f3694a.a();
        if (!this.c) {
            throw new IOException("Output stream is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] b(int r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.io.ByteArrayOutputStream r0 = r4.b     // Catch:{ all -> 0x0025 }
            int r0 = r0.size()     // Catch:{ all -> 0x0025 }
            if (r0 <= 0) goto L_0x0029
            java.io.ByteArrayOutputStream r0 = r4.b     // Catch:{ all -> 0x0025 }
            byte[] r0 = r0.toByteArray()     // Catch:{ all -> 0x0025 }
            java.io.ByteArrayOutputStream r1 = r4.b     // Catch:{ all -> 0x0025 }
            r1.reset()     // Catch:{ all -> 0x0025 }
            byte[] r1 = new byte[r5]     // Catch:{ all -> 0x0025 }
            r2 = 0
            java.lang.System.arraycopy(r0, r2, r1, r2, r5)     // Catch:{ all -> 0x0025 }
            int r2 = r0.length     // Catch:{ all -> 0x0025 }
            if (r2 == r5) goto L_0x0027
            java.io.ByteArrayOutputStream r2 = r4.b     // Catch:{ all -> 0x0025 }
            int r3 = r0.length     // Catch:{ all -> 0x0025 }
            int r3 = r3 - r5
            r2.write(r0, r5, r3)     // Catch:{ all -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            r5 = move-exception
            goto L_0x002c
        L_0x0027:
            monitor-exit(r4)
            return r1
        L_0x0029:
            monitor-exit(r4)
            r4 = 0
            return r4
        L_0x002c:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.PrivateOutputStream.b(int):byte[]");
    }

    public int c() {
        return this.b.size();
    }

    public void close() {
        this.c = false;
        this.f3694a.c(false);
    }

    public boolean isClosed() {
        return !this.c;
    }

    public synchronized void write(int i) {
        a();
        this.f3694a.d();
        this.b.write(i);
        if (this.b.size() == this.d) {
            this.f3694a.b(true, false);
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            if ((i | i2) >= 0) {
                try {
                    if (i2 <= bArr.length - i) {
                        a();
                        this.f3694a.d();
                        while (true) {
                            int size = this.b.size() + i2;
                            int i3 = this.d;
                            if (size < i3) {
                                break;
                            }
                            int size2 = i3 - this.b.size();
                            this.b.write(bArr, i, size2);
                            i += size2;
                            i2 -= size2;
                            this.f3694a.b(true, false);
                        }
                        if (i2 > 0) {
                            this.b.write(bArr, i, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            throw new IndexOutOfBoundsException("index outof bound");
        }
        throw new IOException("buffer is null");
    }
}
