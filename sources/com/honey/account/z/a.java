package com.honey.account.z;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.fragment.DialogFragmentNavigator;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DialogFragmentNavigator f3143a;

    public /* synthetic */ a(DialogFragmentNavigator dialogFragmentNavigator) {
        this.f3143a = dialogFragmentNavigator;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        DialogFragmentNavigator.p(this.f3143a, lifecycleOwner, event);
    }
}
