package com.honey.account.k3;

import com.ucar.vehiclesdk.audio.UCarAudioManager;
import com.ucar.vehiclesdk.player.AudioPlayerMgr;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr f4898a;
    public final /* synthetic */ UCarAudioManager.AudioPlayerControl b;

    public /* synthetic */ c(AudioPlayerMgr audioPlayerMgr, UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        this.f4898a = audioPlayerMgr;
        this.b = audioPlayerControl;
    }

    public final void run() {
        this.f4898a.D(this.b);
    }
}
