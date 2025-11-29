package com.honey.account.z7;

import com.upuphone.xr.interconnect.common.IAppDockMenuClickListener;
import com.upuphone.xr.interconnect.remote.AppManagerImpl;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppManagerImpl f5349a;
    public final /* synthetic */ int b;
    public final /* synthetic */ IAppDockMenuClickListener c;

    public /* synthetic */ a(AppManagerImpl appManagerImpl, int i, IAppDockMenuClickListener iAppDockMenuClickListener) {
        this.f5349a = appManagerImpl;
        this.b = i;
        this.c = iAppDockMenuClickListener;
    }

    public final Object invoke(Object obj) {
        return this.f5349a.lambda$registerMenuClickListener$0(this.b, this.c, (String) obj);
    }
}
