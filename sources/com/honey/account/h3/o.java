package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4493a;
    public final /* synthetic */ String b;
    public final /* synthetic */ UCarCommon.MusicInfo c;

    public /* synthetic */ o(UCarAdapter uCarAdapter, String str, UCarCommon.MusicInfo musicInfo) {
        this.f4493a = uCarAdapter;
        this.b = str;
        this.c = musicInfo;
    }

    public final void run() {
        this.f4493a.u1(this.b, this.c);
    }
}
