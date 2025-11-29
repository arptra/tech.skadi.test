package com.honey.account.x3;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordSummaryFragment;

public final /* synthetic */ class e implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordSummaryFragment f5297a;

    public /* synthetic */ e(FastRecordSummaryFragment fastRecordSummaryFragment) {
        this.f5297a = fastRecordSummaryFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return FastRecordSummaryFragment.viewTouchListener$lambda$7(this.f5297a, view, motionEvent);
    }
}
