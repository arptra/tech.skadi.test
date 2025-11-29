package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciAppViewModel;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5025a;

    public /* synthetic */ b(Function1 function1) {
        this.f5025a = function1;
    }

    public final void onChanged(Object obj) {
        TiciAppViewModel.b0(this.f5025a, obj);
    }
}
