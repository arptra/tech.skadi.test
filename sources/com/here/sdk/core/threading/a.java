package com.here.sdk.core.threading;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MainThreadTaskRunner f9161a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(MainThreadTaskRunner mainThreadTaskRunner, Runnable runnable) {
        this.f9161a = mainThreadTaskRunner;
        this.b = runnable;
    }

    public final void run() {
        this.f9161a.lambda$new$0(this.b);
    }
}
