package com.honey.account.w;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3132a;
    public final /* synthetic */ Violation b;

    public /* synthetic */ b(String str, Violation violation) {
        this.f3132a = str;
        this.b = violation;
    }

    public final void run() {
        FragmentStrictMode.f(this.f3132a, this.b);
    }
}
