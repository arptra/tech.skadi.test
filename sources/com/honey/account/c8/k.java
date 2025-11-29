package com.honey.account.c8;

import android.view.View;
import com.upuphone.xr.sapp.adapter.ModelListAdapter;
import com.upuphone.xr.sapp.entity.ModelInfo;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ModelListAdapter f4216a;
    public final /* synthetic */ ModelInfo b;

    public /* synthetic */ k(ModelListAdapter modelListAdapter, ModelInfo modelInfo) {
        this.f4216a = modelListAdapter;
        this.b = modelInfo;
    }

    public final void onClick(View view) {
        ModelListAdapter.h(this.f4216a, this.b, view);
    }
}
