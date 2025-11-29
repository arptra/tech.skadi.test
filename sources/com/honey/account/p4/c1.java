package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciSettingActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5030a;

    public /* synthetic */ c1(Function1 function1) {
        this.f5030a = function1;
    }

    public final void onChanged(Object obj) {
        TiciSettingActivity.c1(this.f5030a, obj);
    }
}
