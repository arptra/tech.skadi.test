package com.honey.account.u4;

import com.upuphone.ar.transcribe.audio.AudioAiManager;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioAiManager f5225a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ a(AudioAiManager audioAiManager, byte[] bArr, int i, int i2) {
        this.f5225a = audioAiManager;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    public final void run() {
        AudioAiManager.n(this.f5225a, this.b, this.c, this.d);
    }
}
