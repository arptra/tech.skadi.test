package javax.obex;

public final class PasswordAuthentication {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f3692a;
    public final byte[] b;

    public PasswordAuthentication(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            byte[] bArr3 = new byte[bArr.length];
            this.f3692a = bArr3;
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        }
        byte[] bArr4 = new byte[bArr2.length];
        this.b = bArr4;
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
    }

    public byte[] a() {
        return this.b;
    }

    public byte[] b() {
        return this.f3692a;
    }
}
