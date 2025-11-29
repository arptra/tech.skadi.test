package com.honey.account.p6;

import com.upuphone.runasone.uupcast.api.ISinkAudioListenerAdapter;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ISinkAudioListenerAdapter f5094a;
    public final /* synthetic */ int b;

    public /* synthetic */ h(ISinkAudioListenerAdapter iSinkAudioListenerAdapter, int i) {
        this.f5094a = iSinkAudioListenerAdapter;
        this.b = i;
    }

    public final void run() {
        this.f5094a.lambda$adapt$1(this.b);
    }
}
