package com.honey.account.w;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f3131a;
    public final /* synthetic */ Violation b;

    public /* synthetic */ a(FragmentStrictMode.Policy policy, Violation violation) {
        this.f3131a = policy;
        this.b = violation;
    }

    public final void run() {
        FragmentStrictMode.e(this.f3131a, this.b);
    }
}
