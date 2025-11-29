package com.honey.account.c8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.adapter.StandbyWidgetRecyclerviewAdapter;

public final /* synthetic */ class r implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyWidgetRecyclerviewAdapter f4223a;
    public final /* synthetic */ int b;

    public /* synthetic */ r(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, int i) {
        this.f4223a = standbyWidgetRecyclerviewAdapter;
        this.b = i;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        StandbyWidgetRecyclerviewAdapter.r(this.f4223a, this.b, compoundButton, z);
    }
}
