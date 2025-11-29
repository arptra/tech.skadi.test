package com.honey.account.h8;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.xr.sapp.fragment.OpinionFeedbackFragment;

public final /* synthetic */ class o7 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpinionFeedbackFragment f4710a;

    public /* synthetic */ o7(OpinionFeedbackFragment opinionFeedbackFragment) {
        this.f4710a = opinionFeedbackFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return OpinionFeedbackFragment.M0(this.f4710a, view, motionEvent);
    }
}
