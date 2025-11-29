package com.honey.account.g;

import androidx.appcompat.widget.Toolbar;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Toolbar f3052a;

    public /* synthetic */ b(Toolbar toolbar) {
        this.f3052a = toolbar;
    }

    public final void run() {
        this.f3052a.invalidateMenu();
    }
}
