package com.honey.account.v;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class c implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f3118a;

    public /* synthetic */ c(FragmentActivity fragmentActivity) {
        this.f3118a = fragmentActivity;
    }

    public final Bundle saveState() {
        return this.f3118a.e0();
    }
}
