package com.honey.account.q;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f3080a;

    public /* synthetic */ t(ViewConfiguration viewConfiguration) {
        this.f3080a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f3080a.getScaledMaximumFlingVelocity());
    }
}
