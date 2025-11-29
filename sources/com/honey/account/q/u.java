package com.honey.account.q;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

public final /* synthetic */ class u implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f3081a;

    public /* synthetic */ u(ViewConfiguration viewConfiguration) {
        this.f3081a = viewConfiguration;
    }

    public final Object get() {
        return Integer.valueOf(this.f3081a.getScaledMinimumFlingVelocity());
    }
}
