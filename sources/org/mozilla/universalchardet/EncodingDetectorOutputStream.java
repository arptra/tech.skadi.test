package org.mozilla.universalchardet;

import java.io.OutputStream;

public class EncodingDetectorOutputStream extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public OutputStream f3431a;
    public final UniversalDetector b;

    public void close() {
        this.f3431a.close();
        this.b.a();
    }

    public void flush() {
        this.f3431a.flush();
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f3431a.write(bArr, i, i2);
        if (!this.b.h()) {
            this.b.g(bArr, i, i2);
        }
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(int i) {
        write(new byte[]{(byte) i});
    }
}
