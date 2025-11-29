package com.honey.account.y;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NavController f3142a;

    public /* synthetic */ a(NavController navController) {
        this.f3142a = navController;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.L(this.f3142a, lifecycleOwner, event);
    }
}
