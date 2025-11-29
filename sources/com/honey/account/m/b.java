package com.honey.account.m;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f3070a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(ResourcesCompat.FontCallback fontCallback, int i) {
        this.f3070a = fontCallback;
        this.b = i;
    }

    public final void run() {
        this.f3070a.c(this.b);
    }
}
