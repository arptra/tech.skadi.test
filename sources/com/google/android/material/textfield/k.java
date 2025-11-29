package com.google.android.material.textfield;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

public final /* synthetic */ class k implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f9693a;

    public /* synthetic */ k(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f9693a = dropdownMenuEndIconDelegate;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.f9693a.lambda$new$2(z);
    }
}
