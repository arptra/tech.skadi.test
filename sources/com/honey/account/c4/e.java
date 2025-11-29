package com.honey.account.c4;

import android.view.View;
import com.upuphone.ar.fastrecord.phone.utils.ViewClickExtKt;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4195a;

    public /* synthetic */ e(Function1 function1) {
        this.f4195a = function1;
    }

    public final boolean onLongClick(View view) {
        return ViewClickExtKt.clickJitterLong$lambda$1(this.f4195a, view);
    }
}
