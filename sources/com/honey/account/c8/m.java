package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.ScheduleDisplayAdapter;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocalScheduleModel f4218a;
    public final /* synthetic */ ScheduleDisplayAdapter b;
    public final /* synthetic */ int c;

    public /* synthetic */ m(LocalScheduleModel localScheduleModel, ScheduleDisplayAdapter scheduleDisplayAdapter, int i) {
        this.f4218a = localScheduleModel;
        this.b = scheduleDisplayAdapter;
        this.c = i;
    }

    public final void onClick(View view) {
        ScheduleDisplayAdapter.j(this.f4218a, this.b, this.c, view);
    }
}
