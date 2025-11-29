package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciMainActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class n0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5061a;

    public /* synthetic */ n0(Function1 function1) {
        this.f5061a = function1;
    }

    public final void onChanged(Object obj) {
        TiciMainActivity.t1(this.f5061a, obj);
    }
}
