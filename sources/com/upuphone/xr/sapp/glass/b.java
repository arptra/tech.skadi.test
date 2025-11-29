package com.upuphone.xr.sapp.glass;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatActivity f7072a;

    public /* synthetic */ b(AppCompatActivity appCompatActivity) {
        this.f7072a = appCompatActivity;
    }

    public final void onClick(View view) {
        GlassScreenShotHelper$handleScreenShotResult$1.invokeSuspend$lambda$1(this.f7072a, view);
    }
}
