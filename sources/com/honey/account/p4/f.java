package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciFileSearchActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class f implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5037a;

    public /* synthetic */ f(Function1 function1) {
        this.f5037a = function1;
    }

    public final void onChanged(Object obj) {
        TiciFileSearchActivity.J0(this.f5037a, obj);
    }
}
