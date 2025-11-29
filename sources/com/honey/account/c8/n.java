package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.ScheduleDisplayAdapter;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocalScheduleModel f4219a;
    public final /* synthetic */ ScheduleDisplayAdapter b;

    public /* synthetic */ n(LocalScheduleModel localScheduleModel, ScheduleDisplayAdapter scheduleDisplayAdapter) {
        this.f4219a = localScheduleModel;
        this.b = scheduleDisplayAdapter;
    }

    public final void onClick(View view) {
        ScheduleDisplayAdapter.k(this.f4219a, this.b, view);
    }
}
