package com.honey.account.w8;

import android.view.View;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7647a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ h(View view, Function1 function1) {
        this.f7647a = view;
        this.b = function1;
    }

    public final void onClick(View view) {
        GlobalExtKt.e(this.f7647a, this.b, view);
    }
}
