package com.honey.account.ua;

import flyme.support.v7.app.palette.ColorPickWindowHelper;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ColorPickWindowHelper f7623a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ a(ColorPickWindowHelper colorPickWindowHelper, int[] iArr) {
        this.f7623a = colorPickWindowHelper;
        this.b = iArr;
    }

    public final void run() {
        this.f7623a.lambda$showColorPickWindow$0(this.b);
    }
}
