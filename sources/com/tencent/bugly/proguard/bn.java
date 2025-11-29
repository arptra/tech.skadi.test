package com.tencent.bugly.proguard;

public final class bn extends m implements Cloneable {
    static byte[] d;

    /* renamed from: a  reason: collision with root package name */
    public byte f9569a;
    public String b;
    public byte[] c;

    public bn() {
        this.f9569a = 0;
        this.b = "";
        this.c = null;
    }

    public final void a(StringBuilder sb, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.f9569a, 0);
        lVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    public bn(byte b2, String str, byte[] bArr) {
        this.f9569a = b2;
        this.b = str;
        this.c = bArr;
    }

    public final void a(k kVar) {
        this.f9569a = kVar.a(this.f9569a, 0, true);
        this.b = kVar.b(1, true);
        if (d == null) {
            byte[] bArr = new byte[1];
            d = bArr;
            bArr[0] = 0;
        }
        this.c = kVar.c(2, false);
    }
}
