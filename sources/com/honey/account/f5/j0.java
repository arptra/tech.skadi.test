package com.honey.account.f5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.fragment.SummaryFragment;

public final /* synthetic */ class j0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryFragment f4387a;

    public /* synthetic */ j0(SummaryFragment summaryFragment) {
        this.f4387a = summaryFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SummaryFragment.L0(this.f4387a, view, motionEvent);
    }
}
