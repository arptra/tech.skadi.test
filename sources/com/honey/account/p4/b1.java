package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciSettingActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5027a;

    public /* synthetic */ b1(Function1 function1) {
        this.f5027a = function1;
    }

    public final void onChanged(Object obj) {
        TiciSettingActivity.b1(this.f5027a, obj);
    }
}
