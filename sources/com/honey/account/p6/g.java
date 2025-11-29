package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.ISinkAudioListenerAdapter;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ISinkAudioListenerAdapter f5093a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(ISinkAudioListenerAdapter iSinkAudioListenerAdapter, int i) {
        this.f5093a = iSinkAudioListenerAdapter;
        this.b = i;
    }

    public final void run() {
        this.f5093a.lambda$adapt$0(this.b);
    }
}
