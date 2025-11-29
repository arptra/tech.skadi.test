package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciMainActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class h0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5044a;

    public /* synthetic */ h0(Function1 function1) {
        this.f5044a = function1;
    }

    public final void onChanged(Object obj) {
        TiciMainActivity.r1(this.f5044a, obj);
    }
}
