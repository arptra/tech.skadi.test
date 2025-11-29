package com.honey.account.c4;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.utils.ViewClickExtKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f4197a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ g(View view, Function1 function1) {
        this.f4197a = view;
        this.b = function1;
    }

    public final void onClick(View view) {
        ViewClickExtKt.clickJitter$lambda$0(this.f4197a, this.b, view);
    }
}
