package com.honey.account.k3;

import com.ucar.vehiclesdk.UCarCommon;
import com.ucar.vehiclesdk.audio.UCarAudioManager;
import com.ucar.vehiclesdk.player.AudioPlayerMgr;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr f4902a;
    public final /* synthetic */ UCarCommon.AudioFormat b;
    public final /* synthetic */ UCarCommon.AudioType c;
    public final /* synthetic */ UCarAudioManager.PlayerState d;
    public final /* synthetic */ UCarCommon.AudioAttributes e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ g(AudioPlayerMgr audioPlayerMgr, UCarCommon.AudioFormat audioFormat, UCarCommon.AudioType audioType, UCarAudioManager.PlayerState playerState, UCarCommon.AudioAttributes audioAttributes, boolean z) {
        this.f4902a = audioPlayerMgr;
        this.b = audioFormat;
        this.c = audioType;
        this.d = playerState;
        this.e = audioAttributes;
        this.f = z;
    }

    public final void run() {
        this.f4902a.z(this.b, this.c, this.d, this.e, this.f);
    }
}
