package com.honey.account.c;

import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class f implements LifecycleEventObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f3016a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ f(OnBackPressedDispatcher onBackPressedDispatcher, ComponentActivity componentActivity) {
        this.f3016a = onBackPressedDispatcher;
        this.b = componentActivity;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ComponentActivity.U(this.f3016a, this.b, lifecycleOwner, event);
    }
}
