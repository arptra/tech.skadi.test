package com.honey.account.e1;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;

public final /* synthetic */ class c implements AccessibilityViewCommand {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomSheetDragHandleView f9722a;

    public /* synthetic */ c(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.f9722a = bottomSheetDragHandleView;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f9722a.lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }
}
