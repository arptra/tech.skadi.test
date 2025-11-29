package com.honey.account.h3;

import com.ucar.vehiclesdk.UCarAdapter;
import com.ucar.vehiclesdk.audio.UCarAudioManager;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UCarAdapter f4484a;
    public final /* synthetic */ UCarAudioManager.AudioPlayerControl b;

    public /* synthetic */ f(UCarAdapter uCarAdapter, UCarAudioManager.AudioPlayerControl audioPlayerControl) {
        this.f4484a = uCarAdapter;
        this.b = audioPlayerControl;
    }

    public final void run() {
        this.f4484a.i1(this.b);
    }
}
