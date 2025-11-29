package com.upuphone.xr.sapp.utils;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowManger f7939a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(GenericWindowManger genericWindowManger, int i) {
        this.f7939a = genericWindowManger;
        this.b = i;
    }

    public final void run() {
        GenericWindowManger$dismissGenericWindow$1.invokeSuspend$lambda$2(this.f7939a, this.b);
    }
}
