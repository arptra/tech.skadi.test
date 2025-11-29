package com.honey.account.p4;

import androidx.lifecycle.Observer;
import com.upuphone.ar.tici.phone.TiciImportFileActivity;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b0 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5026a;

    public /* synthetic */ b0(Function1 function1) {
        this.f5026a = function1;
    }

    public final void onChanged(Object obj) {
        TiciImportFileActivity.K0(this.f5026a, obj);
    }
}
