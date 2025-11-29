package com.honey.account.v;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f3119a;

    public /* synthetic */ d(FragmentActivity fragmentActivity) {
        this.f3119a = fragmentActivity;
    }

    public final void accept(Object obj) {
        this.f3119a.g0((Configuration) obj);
    }
}
