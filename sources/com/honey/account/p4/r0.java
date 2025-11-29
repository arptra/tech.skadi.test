package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciMainActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class r0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5068a;

    public /* synthetic */ r0(Function1 function1) {
        this.f5068a = function1;
    }

    public final void onChanged(Object obj) {
        TiciMainActivity.q1(this.f5068a, obj);
    }
}
