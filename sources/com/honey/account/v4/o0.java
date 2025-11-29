package com.honey.account.v4;

import com.upuphone.ar.transcribe.phone.activity.TranscribeStartActivity;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TranscribeStartActivity f5265a;

    public /* synthetic */ o0(TranscribeStartActivity transcribeStartActivity) {
        this.f5265a = transcribeStartActivity;
    }

    public final void run() {
        TranscribeStartActivity.notifyTranslationStop$lambda$15(this.f5265a);
    }
}
