package com.honey.account.q;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class l implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f3078a;
    public final /* synthetic */ MenuProvider b;

    public /* synthetic */ l(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.f3078a = menuHostHelper;
        this.b = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f3078a.f(this.b, lifecycleOwner, event);
    }
}
