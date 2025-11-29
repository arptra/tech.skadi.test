package androidx.emoji2.text.flatbuffer;

public class ArrayReadWriteBuf implements ReadWriteBuf {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f1220a;
    public int b;

    public ArrayReadWriteBuf(byte[] bArr, int i) {
        this.f1220a = bArr;
        this.b = i;
    }

    public String a(int i, int i2) {
        return Utf8Safe.b(this.f1220a, i, i2);
    }

    public byte get(int i) {
        return this.f1220a[i];
    }

    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    public int getInt(int i) {
        byte[] bArr = this.f1220a;
        return (bArr[i] & 255) | (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public long getLong(int i) {
        byte[] bArr = this.f1220a;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32);
        int i2 = i + 6;
        return (((long) bArr[i + 7]) << 56) | j | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i2]) & 255) << 48);
    }

    public short getShort(int i) {
        byte[] bArr = this.f1220a;
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }
}
