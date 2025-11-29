package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciFileSearchActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5034a;

    public /* synthetic */ e(Function1 function1) {
        this.f5034a = function1;
    }

    public final void onChanged(Object obj) {
        TiciFileSearchActivity.I0(this.f5034a, obj);
    }
}
