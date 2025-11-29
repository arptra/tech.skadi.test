package com.honey.account.u3;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class e0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5166a;

    public /* synthetic */ e0(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5166a = fastRecordHistoryDetailActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return FastRecordHistoryDetailActivity.globalLayoutListener$lambda$2(this.f5166a, view, motionEvent);
    }
}
