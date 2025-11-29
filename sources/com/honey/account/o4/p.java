package com.honey.account.o4;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.navi.lite.view.NaviTopView;

public final /* synthetic */ class p implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NaviTopView f4982a;

    public /* synthetic */ p(NaviTopView naviTopView) {
        this.f4982a = naviTopView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f4982a.z(view, motionEvent);
    }
}
