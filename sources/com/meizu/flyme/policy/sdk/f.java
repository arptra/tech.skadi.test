package com.meizu.flyme.policy.sdk;

import android.content.Context;
import android.view.View;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f3200a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ f(Context context, boolean z, String str, String str2) {
        this.f3200a = context;
        this.b = z;
        this.c = str;
        this.d = str2;
    }

    public final void onClick(View view) {
        PolicyManager.m3showReGrantTwoPolicyDialog$lambda5(this.f3200a, this.b, this.c, this.d, view);
    }
}
