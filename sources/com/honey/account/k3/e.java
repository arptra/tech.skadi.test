package com.honey.account.k3;

import com.ucar.vehiclesdk.player.AudioPlayerMgr;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr f4900a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ e(AudioPlayerMgr audioPlayerMgr, boolean z) {
        this.f4900a = audioPlayerMgr;
        this.b = z;
    }

    public final void run() {
        this.f4900a.B(this.b);
    }
}
