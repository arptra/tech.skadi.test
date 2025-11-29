package com.honey.account.v;

import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f3124a;

    public /* synthetic */ i(FragmentManager fragmentManager) {
        this.f3124a = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f3124a.f1((MultiWindowModeChangedInfo) obj);
    }
}
