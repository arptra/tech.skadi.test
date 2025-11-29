package com.honey.account.h8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.fragment.TouchpadFragment;

public final /* synthetic */ class v9 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TouchpadFragment f4791a;

    public /* synthetic */ v9(TouchpadFragment touchpadFragment) {
        this.f4791a = touchpadFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TouchpadFragment.Y0(this.f4791a, view, motionEvent);
    }
}
