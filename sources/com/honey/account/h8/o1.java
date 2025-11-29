package com.honey.account.h8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.fragment.ControlFragment;

public final /* synthetic */ class o1 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ControlFragment f4704a;

    public /* synthetic */ o1(ControlFragment controlFragment) {
        this.f4704a = controlFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return ControlFragment.X0(this.f4704a, view, motionEvent);
    }
}
