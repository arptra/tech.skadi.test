package com.honey.account.d0;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f3046a;

    public /* synthetic */ a(SavedStateRegistry savedStateRegistry) {
        this.f3046a = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.d(this.f3046a, lifecycleOwner, event);
    }
}
