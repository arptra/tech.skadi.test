package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import java.util.List;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4483a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;
    public final /* synthetic */ UCarCommon.AppListState d;

    public /* synthetic */ e(UCarAdapter uCarAdapter, String str, List list, UCarCommon.AppListState appListState) {
        this.f4483a = uCarAdapter;
        this.b = str;
        this.c = list;
        this.d = appListState;
    }

    public final void run() {
        this.f4483a.j1(this.b, this.c, this.d);
    }
}
