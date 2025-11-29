package com.honey.account.q;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class k implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MenuHostHelper f3077a;
    public final /* synthetic */ Lifecycle.State b;
    public final /* synthetic */ MenuProvider c;

    public /* synthetic */ k(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.f3077a = menuHostHelper;
        this.b = state;
        this.c = menuProvider;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f3077a.g(this.b, this.c, lifecycleOwner, event);
    }
}
