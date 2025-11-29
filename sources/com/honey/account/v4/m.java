package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeDetailActivity;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeDetailActivity f5261a;
    public final /* synthetic */ int b;

    public /* synthetic */ m(TranscribeDetailActivity transcribeDetailActivity, int i) {
        this.f5261a = transcribeDetailActivity;
        this.b = i;
    }

    public final void run() {
        TranscribeDetailActivity.adjustSoftInputHeight$lambda$1$lambda$0(this.f5261a, this.b);
    }
}
