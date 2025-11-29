package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class g implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f9689a;

    public /* synthetic */ g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f9689a = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f9689a.lambda$setUpDropdownShowHideBehavior$4(view, motionEvent);
    }
}
