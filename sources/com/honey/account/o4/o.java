package com.honey.account.o4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.navi.lite.view.NaviTopView;

public final /* synthetic */ class o implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviTopView f4981a;

    public /* synthetic */ o(NaviTopView naviTopView) {
        this.f4981a = naviTopView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f4981a.y(view, motionEvent);
    }
}
