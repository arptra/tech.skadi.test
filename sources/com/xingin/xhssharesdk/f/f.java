package com.xingin.xhssharesdk.f;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8179a;
    public int b;
    public String c;
    public String d;
    public Throwable e;

    public static f a(int i, Throwable th) {
        f fVar = new f();
        fVar.f8179a = i >= 200 && i < 300;
        fVar.b = i;
        fVar.c = th.getMessage();
        fVar.d = th.getClass().getSimpleName();
        fVar.e = th;
        return fVar;
    }

    public final String toString() {
        return "UploadResult{success=" + this.f8179a + ", code=" + this.b + ", errorMessage='" + this.c + "', errorName='" + this.d + "', throwable=" + this.e + '}';
    }
}
