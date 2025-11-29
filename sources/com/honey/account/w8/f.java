package com.honey.account.w8;

import android.view.View;
import com.meizu.common.widget.Switch;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Switch f7645a;
    public final /* synthetic */ Function2 b;

    public /* synthetic */ f(Switch switchR, Function2 function2) {
        this.f7645a = switchR;
        this.b = function2;
    }

    public final void onClick(View view) {
        GlobalExtKt.k(this.f7645a, this.b, view);
    }
}
