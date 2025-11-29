package com.honey.account.f5;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.translation.phone.fragment.SummaryFragment;

public final /* synthetic */ class k0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SummaryFragment f4389a;

    public /* synthetic */ k0(SummaryFragment summaryFragment) {
        this.f4389a = summaryFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return SummaryFragment.M0(this.f4389a, view, motionEvent);
    }
}
