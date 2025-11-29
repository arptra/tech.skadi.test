package com.honey.account.v;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class k implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentManager f3126a;

    public /* synthetic */ k(FragmentManager fragmentManager) {
        this.f3126a = fragmentManager;
    }

    public final Bundle saveState() {
        return this.f3126a.b1();
    }
}
