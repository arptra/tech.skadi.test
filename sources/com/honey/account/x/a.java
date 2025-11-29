package com.honey.account.x;

import androidx.lifecycle.DispatchQueue;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DispatchQueue f3135a;
    public final /* synthetic */ Runnable b;

    public /* synthetic */ a(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f3135a = dispatchQueue;
        this.b = runnable;
    }

    public final void run() {
        DispatchQueue.d(this.f3135a, this.b);
    }
}
