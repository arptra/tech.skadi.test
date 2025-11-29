package com.honey.account.ib;

import android.view.View;
import io.flutter.util.ViewUtils;

public final /* synthetic */ class a implements ViewUtils.ViewVisitor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class[] f7448a;

    public /* synthetic */ a(Class[] clsArr) {
        this.f7448a = clsArr;
    }

    public final boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1(this.f7448a, view);
    }
}
