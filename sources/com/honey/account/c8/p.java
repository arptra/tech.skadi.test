package com.honey.account.c8;

import android.widget.CompoundButton;
import com.upuphone.xr.sapp.adapter.StandbyWidgetRecyclerviewAdapter;

public final /* synthetic */ class p implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyWidgetRecyclerviewAdapter f4221a;
    public final /* synthetic */ int b;

    public /* synthetic */ p(StandbyWidgetRecyclerviewAdapter standbyWidgetRecyclerviewAdapter, int i) {
        this.f4221a = standbyWidgetRecyclerviewAdapter;
        this.b = i;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        StandbyWidgetRecyclerviewAdapter.p(this.f4221a, this.b, compoundButton, z);
    }
}
