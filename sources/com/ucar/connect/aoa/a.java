package com.ucar.connect.aoa;

import java.util.function.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AOAHostSetup f9629a;
    public final /* synthetic */ int b;
    public final /* synthetic */ byte[] c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(AOAHostSetup aOAHostSetup, int i, byte[] bArr, int i2) {
        this.f9629a = aOAHostSetup;
        this.b = i;
        this.c = bArr;
        this.d = i2;
    }

    public final Object get() {
        return this.f9629a.z(this.b, this.c, this.d);
    }
}
