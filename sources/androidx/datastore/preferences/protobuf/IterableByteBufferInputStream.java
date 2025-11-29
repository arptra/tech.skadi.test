package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public Iterator f1105a;
    public ByteBuffer b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public byte[] g;
    public int h;
    public long i;

    public final boolean a() {
        this.d++;
        if (!this.f1105a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f1105a.next();
        this.b = byteBuffer;
        this.e = byteBuffer.position();
        if (this.b.hasArray()) {
            this.f = true;
            this.g = this.b.array();
            this.h = this.b.arrayOffset();
        } else {
            this.f = false;
            this.i = UnsafeUtil.i(this.b);
            this.g = null;
        }
        return true;
    }

    public final void b(int i2) {
        int i3 = this.e + i2;
        this.e = i3;
        if (i3 == this.b.limit()) {
            a();
        }
    }

    public int read() {
        if (this.d == this.c) {
            return -1;
        }
        if (this.f) {
            byte b2 = this.g[this.e + this.h] & 255;
            b(1);
            return b2;
        }
        byte v = UnsafeUtil.v(((long) this.e) + this.i) & 255;
        b(1);
        return v;
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (this.d == this.c) {
            return -1;
        }
        int limit = this.b.limit();
        int i4 = this.e;
        int i5 = limit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.f) {
            System.arraycopy(this.g, i4 + this.h, bArr, i2, i3);
            b(i3);
        } else {
            int position = this.b.position();
            this.b.position(this.e);
            this.b.get(bArr, i2, i3);
            this.b.position(position);
            b(i3);
        }
        return i3;
    }
}
