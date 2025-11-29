package com.geetest.sdk.views;

import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.geetest.sdk.z;

public class CoverFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public z f2974a;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        z zVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            z zVar2 = this.f2974a;
            if (zVar2 != null) {
                zVar2.a(motionEvent);
                throw null;
            }
        } else if (action == 1 && (zVar = this.f2974a) != null) {
            zVar.b(motionEvent);
            throw null;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
