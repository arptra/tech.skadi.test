package org.mozilla.universalchardet;

import java.io.InputStream;

public class EncodingDetectorInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public InputStream f3430a;
    public final UniversalDetector b;

    public int available() {
        return this.f3430a.available();
    }

    public void close() {
        this.f3430a.close();
    }

    public void mark(int i) {
        this.f3430a.mark(i);
    }

    public boolean markSupported() {
        return this.f3430a.markSupported();
    }

    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) >= 0) {
            return bArr[0];
        }
        return -1;
    }

    public void reset() {
        this.f3430a.reset();
    }

    public long skip(long j) {
        if (this.b.h()) {
            return this.f3430a.skip(j);
        }
        int i = 0;
        long j2 = -1;
        for (long j3 = 0; j3 < j && i >= 0; j3++) {
            i = this.f3430a.read();
            j2++;
        }
        return j2;
    }

    public int read(byte[] bArr, int i, int i2) {
        int read = this.f3430a.read(bArr, i, i2);
        if (!this.b.h() && read > 0) {
            this.b.g(bArr, i, read);
        }
        if (read == -1) {
            this.b.a();
        }
        return read;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
