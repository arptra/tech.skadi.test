package com.honey.account.n4;

import android.app.Activity;
import android.view.View;
import com.upuphone.ar.navi.lite.util.LocationUtil;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f4957a;

    public /* synthetic */ c(Activity activity) {
        this.f4957a = activity;
    }

    public final void onClick(View view) {
        LocationUtil.m(this.f4957a);
    }
}
