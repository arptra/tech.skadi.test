package zmq.util;

import java.util.Arrays;
import zmq.Msg;

public class Blob {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3669a;

    public Blob(byte[] bArr) {
        this.f3669a = bArr;
    }

    public static Blob a(Msg msg) {
        return c(msg.c(), true);
    }

    public static Blob b(byte[] bArr) {
        return c(bArr, false);
    }

    public static Blob c(byte[] bArr, boolean z) {
        if (!z) {
            return new Blob(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return new Blob(bArr2);
    }

    public byte[] d() {
        return this.f3669a;
    }

    public int e() {
        return this.f3669a.length;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Blob) {
            return Arrays.equals(this.f3669a, ((Blob) obj).f3669a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3669a);
    }
}
