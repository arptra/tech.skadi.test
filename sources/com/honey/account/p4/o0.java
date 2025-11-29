package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciMainActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class o0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5063a;

    public /* synthetic */ o0(Function1 function1) {
        this.f5063a = function1;
    }

    public final void onChanged(Object obj) {
        TiciMainActivity.n1(this.f5063a, obj);
    }
}
