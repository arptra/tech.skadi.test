package com.ucar.vehiclesdk.player;

import com.ucar.vehiclesdk.player.AudioPlayerMgr;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioPlayerMgr.AudioFocusChangeListener f5477a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(AudioPlayerMgr.AudioFocusChangeListener audioFocusChangeListener, int i) {
        this.f5477a = audioFocusChangeListener;
        this.b = i;
    }

    public final void run() {
        this.f5477a.f(this.b);
    }
}
