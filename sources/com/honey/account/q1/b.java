package com.honey.account.q1;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;

public final /* synthetic */ class b implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SideSheetBehavior f9797a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(SideSheetBehavior sideSheetBehavior, int i) {
        this.f9797a = sideSheetBehavior;
        this.b = i;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f9797a.lambda$createAccessibilityViewCommandForState$2(this.b, view, commandArguments);
    }
}
