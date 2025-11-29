package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.audio.UCarAudioManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4485a;
    public final /* synthetic */ UCarAudioManager.PlayerState b;
    public final /* synthetic */ UCarCommon.AudioType c;
    public final /* synthetic */ UCarCommon.AudioFormat d;

    public /* synthetic */ g(UCarAdapter uCarAdapter, UCarAudioManager.PlayerState playerState, UCarCommon.AudioType audioType, UCarCommon.AudioFormat audioFormat) {
        this.f4485a = uCarAdapter;
        this.b = playerState;
        this.c = audioType;
        this.d = audioFormat;
    }

    public final void run() {
        this.f4485a.s1(this.b, this.c, this.d);
    }
}
