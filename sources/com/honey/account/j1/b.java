package com.honey.account.j1;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f9773a;

    public /* synthetic */ b(View view) {
        this.f9773a = view;
    }

    public final void run() {
        ViewUtils.requestFocusAndShowKeyboard(this.f9773a, false);
    }
}
