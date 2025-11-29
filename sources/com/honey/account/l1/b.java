package com.honey.account.l1;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f9776a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ b(View view, boolean z) {
        this.f9776a = view;
        this.b = z;
    }

    public final void run() {
        ViewUtils.showKeyboard(this.f9776a, this.b);
    }
}
