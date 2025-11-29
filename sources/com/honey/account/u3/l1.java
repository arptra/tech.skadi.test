package com.honey.account.u3;

import android.view.View;
import android.view.ViewTreeObserver;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordTagScheduleDialog;

public final /* synthetic */ class l1 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f5187a;
    public final /* synthetic */ FastRecordTagScheduleDialog b;

    public /* synthetic */ l1(View view, FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        this.f5187a = view;
        this.b = fastRecordTagScheduleDialog;
    }

    public final void onGlobalLayout() {
        FastRecordTagScheduleDialog.checkInputSoftMenu$lambda$9(this.f5187a, this.b);
    }
}
