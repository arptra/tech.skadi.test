package com.honey.account.k3;

import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.player.AudioPlayerMgr;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr f4896a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(AudioPlayerMgr audioPlayerMgr, int i) {
        this.f4896a = audioPlayerMgr;
        this.b = i;
    }

    public final void accept(Object obj) {
        this.f4896a.A(this.b, (UCarCommon.AudioType) obj);
    }
}
