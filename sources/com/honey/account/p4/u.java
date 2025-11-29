package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class u implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5073a;

    public /* synthetic */ u(Function1 function1) {
        this.f5073a = function1;
    }

    public final void onChanged(Object obj) {
        TiciHistoryActivity.k1(this.f5073a, obj);
    }
}
