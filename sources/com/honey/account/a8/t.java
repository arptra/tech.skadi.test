package com.honey.account.a8;

import android.content.DialogInterface;
import com.upuphone.xr.sapp.ImportScheduleActivity;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;

public final /* synthetic */ class t implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SubscribeType f4174a;
    public final /* synthetic */ ImportScheduleActivity b;

    public /* synthetic */ t(SubscribeType subscribeType, ImportScheduleActivity importScheduleActivity) {
        this.f4174a = subscribeType;
        this.b = importScheduleActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ImportScheduleActivity.C0(this.f4174a, this.b, dialogInterface, i);
    }
}
