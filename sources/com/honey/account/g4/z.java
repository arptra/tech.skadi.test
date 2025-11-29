package com.honey.account.g4;

import com.upuphone.ar.navi.lite.fragment.SearchFragment;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f4462a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ z(SearchFragment searchFragment, boolean z) {
        this.f4462a = searchFragment;
        this.b = z;
    }

    public final void run() {
        this.f4462a.v3(this.b);
    }
}
