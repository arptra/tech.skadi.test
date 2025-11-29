package com.honey.account.x;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

public final /* synthetic */ class e implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f3138a;

    public /* synthetic */ e(SavedStateHandle savedStateHandle) {
        this.f3138a = savedStateHandle;
    }

    public final Bundle saveState() {
        return SavedStateHandle.h(this.f3138a);
    }
}
