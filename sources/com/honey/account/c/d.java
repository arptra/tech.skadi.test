package com.honey.account.c;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class d implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f3014a;

    public /* synthetic */ d(ComponentActivity componentActivity) {
        this.f3014a = componentActivity;
    }

    public final Bundle saveState() {
        return ComponentActivity.Q(this.f3014a);
    }
}
