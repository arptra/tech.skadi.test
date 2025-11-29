package com.honey.account.v;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentManager;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f3122a;

    public /* synthetic */ g(FragmentManager fragmentManager) {
        this.f3122a = fragmentManager;
    }

    public final void accept(Object obj) {
        this.f3122a.d1((Configuration) obj);
    }
}
