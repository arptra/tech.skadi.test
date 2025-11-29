package top.zibin.luban.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamWrap extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f3588a;
    public int b;
    public int c;
    public int d;
    public int e;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561759L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public BufferedInputStreamWrap(InputStream inputStream) {
        this(inputStream, 65536);
    }

    public static IOException b() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i;
        int i2 = this.d;
        if (i2 == -1 || this.e - i2 >= (i = this.c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.d = -1;
                this.e = 0;
                this.b = read;
            }
            return read;
        }
        if (i2 == 0 && i > bArr.length && this.b == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i) {
                i = length;
            }
            byte[] c2 = ArrayPoolProvide.d().c(i);
            System.arraycopy(bArr, 0, c2, 0, bArr.length);
            this.f3588a = c2;
            ArrayPoolProvide.d().g(bArr);
            bArr = c2;
        } else if (i2 > 0) {
            System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
        }
        int i3 = this.e - this.d;
        this.e = i3;
        this.d = 0;
        this.b = 0;
        int read2 = inputStream.read(bArr, i3, bArr.length - i3);
        int i4 = this.e;
        if (read2 > 0) {
            i4 += read2;
        }
        this.b = i4;
        return read2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int available() {
        /*
            r3 = this;
            monitor-enter(r3)
            java.io.InputStream r0 = r3.in     // Catch:{ all -> 0x0016 }
            byte[] r1 = r3.f3588a     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0018
            if (r0 != 0) goto L_0x000a
            goto L_0x0018
        L_0x000a:
            int r1 = r3.b     // Catch:{ all -> 0x0016 }
            int r2 = r3.e     // Catch:{ all -> 0x0016 }
            int r1 = r1 - r2
            int r0 = r0.available()     // Catch:{ all -> 0x0016 }
            int r1 = r1 + r0
            monitor-exit(r3)
            return r1
        L_0x0016:
            r0 = move-exception
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            r3 = 0
            return r3
        L_0x001b:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.io.BufferedInputStreamWrap.available():int");
    }

    public void close() {
        if (this.f3588a != null) {
            ArrayPoolProvide.d().g(this.f3588a);
            this.f3588a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i) {
        this.c = Math.max(this.c, i);
        this.d = this.e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x001a=Splitter:B:12:0x001a, B:28:0x003b=Splitter:B:28:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f3588a     // Catch:{ all -> 0x0018 }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r2 = r5.e     // Catch:{ all -> 0x0018 }
            int r3 = r5.b     // Catch:{ all -> 0x0018 }
            r4 = -1
            if (r2 < r3) goto L_0x001a
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x0018 }
            if (r1 != r4) goto L_0x001a
            monitor-exit(r5)
            return r4
        L_0x0018:
            r0 = move-exception
            goto L_0x0040
        L_0x001a:
            byte[] r1 = r5.f3588a     // Catch:{ all -> 0x0018 }
            if (r0 == r1) goto L_0x0028
            byte[] r0 = r5.f3588a     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0023
            goto L_0x0028
        L_0x0023:
            java.io.IOException r0 = b()     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0028:
            int r1 = r5.b     // Catch:{ all -> 0x0018 }
            int r2 = r5.e     // Catch:{ all -> 0x0018 }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r2 + 1
            r5.e = r1     // Catch:{ all -> 0x0018 }
            byte r0 = r0[r2]     // Catch:{ all -> 0x0018 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0039:
            monitor-exit(r5)
            return r4
        L_0x003b:
            java.io.IOException r0 = b()     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0040:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.io.BufferedInputStreamWrap.read():int");
    }

    public synchronized void reset() {
        if (this.f3588a != null) {
            int i = this.d;
            if (-1 != i) {
                this.e = i;
            } else {
                throw new InvalidMarkException("Mark has been invalidated, pos: " + this.e + " markLimit: " + this.c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public synchronized long skip(long j) {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f3588a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i = this.b;
                int i2 = this.e;
                if (((long) (i - i2)) >= j) {
                    this.e = (int) (((long) i2) + j);
                    return j;
                }
                long j2 = ((long) i) - ((long) i2);
                this.e = i;
                if (this.d == -1 || j > ((long) this.c)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    int i3 = this.b;
                    int i4 = this.e;
                    if (((long) (i3 - i4)) >= j - j2) {
                        this.e = (int) ((((long) i4) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) i3)) - ((long) i4);
                    this.e = i3;
                    return j3;
                }
            } else {
                throw b();
            }
        } else {
            throw b();
        }
    }

    public BufferedInputStreamWrap(InputStream inputStream, int i) {
        super(inputStream);
        this.d = -1;
        this.f3588a = ArrayPoolProvide.d().c(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r6, int r7, int r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f3588a     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x008d
            if (r8 != 0) goto L_0x000a
            monitor-exit(r5)
            r5 = 0
            return r5
        L_0x000a:
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0088
            int r2 = r5.e     // Catch:{ all -> 0x0030 }
            int r3 = r5.b     // Catch:{ all -> 0x0030 }
            if (r2 >= r3) goto L_0x0034
            int r3 = r3 - r2
            int r2 = java.lang.Math.min(r3, r8)     // Catch:{ all -> 0x0030 }
            int r3 = r5.e     // Catch:{ all -> 0x0030 }
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ all -> 0x0030 }
            int r3 = r5.e     // Catch:{ all -> 0x0030 }
            int r3 = r3 + r2
            r5.e = r3     // Catch:{ all -> 0x0030 }
            if (r2 == r8) goto L_0x0032
            int r3 = r1.available()     // Catch:{ all -> 0x0030 }
            if (r3 != 0) goto L_0x002c
            goto L_0x0032
        L_0x002c:
            int r7 = r7 + r2
            int r2 = r8 - r2
            goto L_0x0035
        L_0x0030:
            r6 = move-exception
            goto L_0x0092
        L_0x0032:
            monitor-exit(r5)
            return r2
        L_0x0034:
            r2 = r8
        L_0x0035:
            int r3 = r5.d     // Catch:{ all -> 0x0030 }
            r4 = -1
            if (r3 != r4) goto L_0x004a
            int r3 = r0.length     // Catch:{ all -> 0x0030 }
            if (r2 < r3) goto L_0x004a
            int r3 = r1.read(r6, r7, r2)     // Catch:{ all -> 0x0030 }
            if (r3 != r4) goto L_0x0078
            if (r2 != r8) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            int r4 = r8 - r2
        L_0x0048:
            monitor-exit(r5)
            return r4
        L_0x004a:
            int r3 = r5.a(r1, r0)     // Catch:{ all -> 0x0030 }
            if (r3 != r4) goto L_0x0057
            if (r2 != r8) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            int r4 = r8 - r2
        L_0x0055:
            monitor-exit(r5)
            return r4
        L_0x0057:
            byte[] r3 = r5.f3588a     // Catch:{ all -> 0x0030 }
            if (r0 == r3) goto L_0x0065
            byte[] r0 = r5.f3588a     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            java.io.IOException r6 = b()     // Catch:{ all -> 0x0030 }
            throw r6     // Catch:{ all -> 0x0030 }
        L_0x0065:
            int r3 = r5.b     // Catch:{ all -> 0x0030 }
            int r4 = r5.e     // Catch:{ all -> 0x0030 }
            int r3 = r3 - r4
            int r3 = java.lang.Math.min(r3, r2)     // Catch:{ all -> 0x0030 }
            int r4 = r5.e     // Catch:{ all -> 0x0030 }
            java.lang.System.arraycopy(r0, r4, r6, r7, r3)     // Catch:{ all -> 0x0030 }
            int r4 = r5.e     // Catch:{ all -> 0x0030 }
            int r4 = r4 + r3
            r5.e = r4     // Catch:{ all -> 0x0030 }
        L_0x0078:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x007d
            monitor-exit(r5)
            return r8
        L_0x007d:
            int r4 = r1.available()     // Catch:{ all -> 0x0030 }
            if (r4 != 0) goto L_0x0086
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x0086:
            int r7 = r7 + r3
            goto L_0x0035
        L_0x0088:
            java.io.IOException r6 = b()     // Catch:{ all -> 0x0030 }
            throw r6     // Catch:{ all -> 0x0030 }
        L_0x008d:
            java.io.IOException r6 = b()     // Catch:{ all -> 0x0030 }
            throw r6     // Catch:{ all -> 0x0030 }
        L_0x0092:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.io.BufferedInputStreamWrap.read(byte[], int, int):int");
    }
}
