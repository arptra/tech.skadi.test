package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;

public abstract class CharsetProber {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3435a = true;

    public enum ProbingState {
        DETECTING,
        FOUND_IT,
        NOT_ME
    }

    public ByteBuffer a(byte[] bArr, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (b == 62) {
                z = false;
            } else if (b == 60) {
                z = true;
            }
            if (h(b) && i(b)) {
                if (i > i4 && !z) {
                    allocate.put(bArr, i4, i - i4);
                    allocate.put((byte) 32);
                }
                i4 = i + 1;
            }
            i++;
        }
        if (!z && i > i4) {
            allocate.put(bArr, i4, i - i4);
        }
        return allocate;
    }

    public ByteBuffer b(byte[] bArr, int i, int i2) {
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        int i3 = i2 + i;
        int i4 = i;
        boolean z = false;
        while (i < i3) {
            byte b = bArr[i];
            if (!h(b)) {
                z = true;
            } else if (i(b)) {
                if (!z || i <= i4) {
                    i4 = i + 1;
                } else {
                    allocate.put(bArr, i4, i - i4);
                    allocate.put((byte) 32);
                    i4 = i + 1;
                    z = false;
                }
            }
            i++;
        }
        if (z && i > i4) {
            allocate.put(bArr, i4, i - i4);
        }
        return allocate;
    }

    public abstract String c();

    public abstract float d();

    public abstract ProbingState e();

    public abstract ProbingState f(byte[] bArr, int i, int i2);

    public boolean g() {
        return this.f3435a;
    }

    public final boolean h(byte b) {
        return (b & 128) == 0;
    }

    public final boolean i(byte b) {
        byte b2 = b & 255;
        return b2 < 65 || (b2 > 90 && b2 < 97) || b2 > 122;
    }

    public abstract void j();

    public void k(boolean z) {
        this.f3435a = z;
    }
}
