package com.honey.account.q1;

import com.google.android.material.sidesheet.SideSheetBehavior;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f9796a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(SideSheetBehavior sideSheetBehavior, int i) {
        this.f9796a = sideSheetBehavior;
        this.b = i;
    }

    public final void run() {
        this.f9796a.lambda$setState$0(this.b);
    }
}
