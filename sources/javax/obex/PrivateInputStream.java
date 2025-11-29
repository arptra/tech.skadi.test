package javax.obex;

import java.io.IOException;
import java.io.InputStream;

public final class PrivateInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public BaseStream f3693a;
    public byte[] b = new byte[0];
    public int c = 0;
    public boolean d = true;

    public PrivateInputStream(BaseStream baseStream) {
        this.f3693a = baseStream;
    }

    public final void a() {
        this.f3693a.a();
        if (!this.d) {
            throw new IOException("Input stream is closed");
        }
    }

    public synchronized int available() {
        a();
        return this.b.length - this.c;
    }

    public synchronized void b(byte[] bArr, int i) {
        byte[] bArr2 = this.b;
        int length = bArr2.length;
        int i2 = this.c;
        byte[] bArr3 = new byte[((bArr.length - i) + (length - i2))];
        System.arraycopy(bArr2, i2, bArr3, 0, bArr2.length - i2);
        System.arraycopy(bArr, i, bArr3, this.b.length - this.c, bArr.length - i);
        this.b = bArr3;
        this.c = 0;
        notifyAll();
    }

    public void close() {
        this.d = false;
        this.f3693a.c(true);
    }

    public synchronized int read() {
        a();
        do {
            byte[] bArr = this.b;
            int length = bArr.length;
            int i = this.c;
            if (length != i) {
                this.c = i + 1;
                return bArr[i] & 255;
            }
        } while (this.f3693a.b(true, true));
        return -1;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r5, int r6, int r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0056
            r0 = r6 | r7
            if (r0 < 0) goto L_0x004e
            int r0 = r5.length     // Catch:{ all -> 0x003b }
            int r0 = r0 - r6
            if (r7 > r0) goto L_0x004e
            r4.a()     // Catch:{ all -> 0x003b }
            byte[] r0 = r4.b     // Catch:{ all -> 0x003b }
            int r0 = r0.length     // Catch:{ all -> 0x003b }
            int r1 = r4.c     // Catch:{ all -> 0x003b }
            int r0 = r0 - r1
            r1 = 0
        L_0x0015:
            if (r0 > r7) goto L_0x003d
            byte[] r2 = r4.b     // Catch:{ all -> 0x003b }
            int r3 = r4.c     // Catch:{ all -> 0x003b }
            java.lang.System.arraycopy(r2, r3, r5, r6, r0)     // Catch:{ all -> 0x003b }
            int r2 = r4.c     // Catch:{ all -> 0x003b }
            int r2 = r2 + r0
            r4.c = r2     // Catch:{ all -> 0x003b }
            int r6 = r6 + r0
            int r1 = r1 + r0
            int r7 = r7 - r0
            javax.obex.BaseStream r0 = r4.f3693a     // Catch:{ all -> 0x003b }
            r2 = 1
            boolean r0 = r0.b(r2, r2)     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0034
            if (r1 != 0) goto L_0x0032
            r1 = -1
        L_0x0032:
            monitor-exit(r4)
            return r1
        L_0x0034:
            byte[] r0 = r4.b     // Catch:{ all -> 0x003b }
            int r0 = r0.length     // Catch:{ all -> 0x003b }
            int r2 = r4.c     // Catch:{ all -> 0x003b }
            int r0 = r0 - r2
            goto L_0x0015
        L_0x003b:
            r5 = move-exception
            goto L_0x005e
        L_0x003d:
            if (r7 <= 0) goto L_0x004c
            byte[] r0 = r4.b     // Catch:{ all -> 0x003b }
            int r2 = r4.c     // Catch:{ all -> 0x003b }
            java.lang.System.arraycopy(r0, r2, r5, r6, r7)     // Catch:{ all -> 0x003b }
            int r5 = r4.c     // Catch:{ all -> 0x003b }
            int r5 = r5 + r7
            r4.c = r5     // Catch:{ all -> 0x003b }
            int r1 = r1 + r7
        L_0x004c:
            monitor-exit(r4)
            return r1
        L_0x004e:
            java.lang.ArrayIndexOutOfBoundsException r5 = new java.lang.ArrayIndexOutOfBoundsException     // Catch:{ all -> 0x003b }
            java.lang.String r6 = "index outof bound"
            r5.<init>(r6)     // Catch:{ all -> 0x003b }
            throw r5     // Catch:{ all -> 0x003b }
        L_0x0056:
            java.io.IOException r5 = new java.io.IOException     // Catch:{ all -> 0x003b }
            java.lang.String r6 = "buffer is null"
            r5.<init>(r6)     // Catch:{ all -> 0x003b }
            throw r5     // Catch:{ all -> 0x003b }
        L_0x005e:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.obex.PrivateInputStream.read(byte[], int, int):int");
    }
}
