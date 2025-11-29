package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciHistoryActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class t implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5071a;

    public /* synthetic */ t(Function1 function1) {
        this.f5071a = function1;
    }

    public final void onChanged(Object obj) {
        TiciHistoryActivity.j1(this.f5071a, obj);
    }
}
