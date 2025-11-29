package com.honey.account.c4;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.utils.ViewClickExtKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4196a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ f(View view, Function1 function1) {
        this.f4196a = view;
        this.b = function1;
    }

    public final void onClick(View view) {
        ViewClickExtKt.recyclerClickJitter$lambda$2(this.f4196a, this.b, view);
    }
}
