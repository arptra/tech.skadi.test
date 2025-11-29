package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciAppViewModel;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5031a;

    public /* synthetic */ d(Function1 function1) {
        this.f5031a = function1;
    }

    public final void onChanged(Object obj) {
        TiciAppViewModel.e0(this.f5031a, obj);
    }
}
