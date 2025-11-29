package com.honey.account.h8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.fragment.EditScheduleFragment;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;

public final /* synthetic */ class b2 implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocalScheduleModel f4544a;

    public /* synthetic */ b2(LocalScheduleModel localScheduleModel) {
        this.f4544a = localScheduleModel;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditScheduleFragment.G0(this.f4544a, compoundButton, z);
    }
}
