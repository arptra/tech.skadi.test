package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.ScheduleColoAdapter;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduleColoAdapter f4217a;
    public final /* synthetic */ int b;

    public /* synthetic */ l(ScheduleColoAdapter scheduleColoAdapter, int i) {
        this.f4217a = scheduleColoAdapter;
        this.b = i;
    }

    public final void onClick(View view) {
        ScheduleColoAdapter.k(this.f4217a, this.b, view);
    }
}
