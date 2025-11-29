package com.honey.account.f5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.fragment.SummaryFragment;

public final /* synthetic */ class i0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryFragment f4385a;

    public /* synthetic */ i0(SummaryFragment summaryFragment) {
        this.f4385a = summaryFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SummaryFragment.K0(this.f4385a, view, motionEvent);
    }
}
