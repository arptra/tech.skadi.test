package com.honey.account.n7;

import com.upuphone.xr.account.interfaces.XJPasswordListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XJPasswordListener f4965a;

    public /* synthetic */ a(XJPasswordListener xJPasswordListener) {
        this.f4965a = xJPasswordListener;
    }

    public final Object invoke(Object obj) {
        return this.f4965a.onSuccess((Boolean) obj);
    }
}
