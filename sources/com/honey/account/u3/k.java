package com.honey.account.u3;

import android.view.MotionEvent;
import android.view.View;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordHistoryDetailActivity;

public final /* synthetic */ class k implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FastRecordHistoryDetailActivity f5182a;

    public /* synthetic */ k(FastRecordHistoryDetailActivity fastRecordHistoryDetailActivity) {
        this.f5182a = fastRecordHistoryDetailActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return FastRecordHistoryDetailActivity.initRecordView$lambda$6(this.f5182a, view, motionEvent);
    }
}
