package org.mozilla.universalchardet.prober.sequence;

public abstract class SequenceModel {

    /* renamed from: a  reason: collision with root package name */
    public short[] f3439a;
    public byte[] b;
    public float c;
    public boolean d;
    public String e;

    public SequenceModel(short[] sArr, byte[] bArr, float f, boolean z, String str) {
        this.f3439a = (short[]) sArr.clone();
        this.b = (byte[]) bArr.clone();
        this.c = f;
        this.d = z;
        this.e = str;
    }

    public String a() {
        return this.e;
    }

    public short b(byte b2) {
        return this.f3439a[b2 & 255];
    }

    public byte c(int i) {
        return this.b[i];
    }

    public float d() {
        return this.c;
    }
}
