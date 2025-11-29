package top.zibin.luban.io;

public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    public int b() {
        return 1;
    }

    /* renamed from: c */
    public int a(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: d */
    public byte[] newArray(int i) {
        return new byte[i];
    }

    public String getTag() {
        return "ByteArrayPool";
    }
}
